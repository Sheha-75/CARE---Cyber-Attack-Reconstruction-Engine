package com.care.evidence;

import com.care.case_management.CaseRepository;
import com.care.case_management.InvestigationCase;
import com.care.custody.ChainOfCustodyService;
import com.care.parser.LogParserService;
import com.care.timeline.TimelineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EvidenceService {

    private final EvidenceRepository evidenceRepository;
    private final CaseRepository caseRepository;
    private final ChainOfCustodyService custodyService;
    private final TimelineService timelineService;
    private final LogParserService logParserService;

    public Evidence uploadEvidence(
            Long caseId,
            MultipartFile file
    ) throws IOException {

        InvestigationCase investigationCase =
                caseRepository.findById(caseId)
                        .orElseThrow(() ->
                                new RuntimeException("Case not found"));

        Path uploadPath = Paths.get("uploads");

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String originalFileName = file.getOriginalFilename();

        String storedFileName =
                System.currentTimeMillis() + "_" + originalFileName;

        Path destination =
                uploadPath.resolve(storedFileName);

        Files.copy(
                file.getInputStream(),
                destination,
                StandardCopyOption.REPLACE_EXISTING
        );

        String hash;

        try {

            hash = HashUtil.calculateSHA256(
                    destination.toFile()
            );

        } catch (Exception e) {

            throw new RuntimeException(
                    "Failed to calculate SHA-256 hash"
            );
        }

        Evidence evidence = new Evidence();

        evidence.setOriginalFileName(originalFileName);
        evidence.setStoredFileName(storedFileName);
        evidence.setFileType(getFileExtension(originalFileName));
        evidence.setFileSize(file.getSize());
        evidence.setStoragePath(destination.toAbsolutePath().toString());
        evidence.setSha256Hash(hash);
        evidence.setUploadedAt(LocalDateTime.now());
        evidence.setUploadedBy("test@gmail.com");
        evidence.setInvestigation(investigationCase);

        Evidence savedEvidence =
                evidenceRepository.save(evidence);

        custodyService.logAction(
                savedEvidence.getId(),
                "UPLOADED",
                "test@gmail.com"
        );

        timelineService.addEvent(
                caseId,
                "EVIDENCE_UPLOAD",
                "Evidence uploaded: " + originalFileName
        );

        if (evidence.getFileType().equalsIgnoreCase("log")
                || evidence.getFileType().equalsIgnoreCase("txt")) {

            logParserService.parseLogFile(
                    caseId,
                    evidence.getStoragePath()
            );
        }

        return savedEvidence;
    }

    public List<Evidence> getEvidenceByCase(Long caseId) {

        return evidenceRepository.findByInvestigationId(caseId);

    }

    public EvidenceVerificationResponse verifyEvidence(Long evidenceId) {

        Evidence evidence =
                evidenceRepository.findById(evidenceId)
                        .orElseThrow(() ->
                                new RuntimeException("Evidence not found"));

        try {

            String currentHash =
                    HashUtil.calculateSHA256(
                            new File(
                                    evidence.getStoragePath()
                            )
                    );

            if (currentHash.equals(
                    evidence.getSha256Hash())) {

                custodyService.logAction(
                        evidence.getId(),
                        "VERIFIED",
                        "test@gmail.com"
                );

                timelineService.addEvent(
                        evidence.getInvestigation().getId(),
                        "EVIDENCE_VERIFIED",
                        "Evidence verified: "
                                + evidence.getOriginalFileName()
                );

                return new EvidenceVerificationResponse(
                        "VALID",
                        "Evidence integrity verified successfully"
                );
            }

            return new EvidenceVerificationResponse(
                    "TAMPERED",
                    "Evidence has been modified"
            );

        } catch (Exception e) {

            throw new RuntimeException(
                    "Verification failed"
            );
        }
    }

    private String getFileExtension(String fileName) {

        int index = fileName.lastIndexOf(".");

        if (index > 0) {
            return fileName.substring(index + 1);
        }

        return "unknown";
    }
}