package com.care.evidence;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/evidence")
@RequiredArgsConstructor
public class EvidenceController {

    private final EvidenceService evidenceService;

    @PostMapping("/upload/{caseId}")
    public ResponseEntity<Evidence> uploadEvidence(
            @PathVariable Long caseId,
            @RequestParam("file") MultipartFile file
    ) throws IOException {

        return ResponseEntity.ok(
                evidenceService.uploadEvidence(caseId, file)
        );
    }

    @GetMapping("/case/{caseId}")
    public ResponseEntity<List<Evidence>> getEvidenceByCase(
            @PathVariable Long caseId
    ) {

        return ResponseEntity.ok(
                evidenceService.getEvidenceByCase(caseId)
        );
    }

    @GetMapping("/verify/{evidenceId}")
    public ResponseEntity<EvidenceVerificationResponse> verifyEvidence(
            @PathVariable Long evidenceId
    ) {

        return ResponseEntity.ok(
                evidenceService.verifyEvidence(evidenceId)
        );
    }
}