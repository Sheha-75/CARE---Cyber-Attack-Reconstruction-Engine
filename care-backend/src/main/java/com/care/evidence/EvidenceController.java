package com.care.evidence;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/evidence")
@RequiredArgsConstructor
public class EvidenceController {

    private final EvidenceService evidenceService;

    @PostMapping("/upload")
    public Evidence uploadEvidence(

            @RequestParam Long caseId,

            @RequestParam MultipartFile file

    ) throws IOException {

        return evidenceService.uploadEvidence(
                caseId,
                file
        );
    }

    @GetMapping("/case/{caseId}")
    public List<Evidence> getEvidenceByCase(

            @PathVariable Long caseId

    ) {

        return evidenceService.getEvidenceByCase(
                caseId
        );
    }

    @GetMapping("/verify/{evidenceId}")
    public EvidenceVerificationResponse verifyEvidence(

            @PathVariable Long evidenceId

    ) {

        return evidenceService.verifyEvidence(
                evidenceId
        );
    }
}