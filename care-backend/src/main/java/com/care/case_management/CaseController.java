package com.care.case_management;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cases")
@RequiredArgsConstructor
public class CaseController {

    private final CaseService caseService;

    @PostMapping
    public ResponseEntity<?> createCase(
            @RequestBody InvestigationCase investigationCase) {

        System.out.println("========== CREATE CASE API CALLED ==========");

        InvestigationCase savedCase =
                caseService.createCase(investigationCase);

        System.out.println("========== CASE CREATED ==========");

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedCase);
    }

    @GetMapping
    public ResponseEntity<List<InvestigationCase>> getAllCases() {
        return ResponseEntity.ok(caseService.getAllCases());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvestigationCase> getCaseById(
            @PathVariable Long id) {

        return ResponseEntity.ok(caseService.getCaseById(id));
    }
}