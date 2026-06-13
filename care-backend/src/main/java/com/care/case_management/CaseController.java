package com.care.case_management;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cases")
@RequiredArgsConstructor
public class CaseController {

    private final CaseService caseService;

    @PostMapping
    public Case createCase(
            @RequestBody Case investigationCase
    ) {

        return caseService.createCase(
                investigationCase
        );
    }

    @GetMapping
    public List<Case> getAllCases() {

        return caseService.getAllCases();
    }

    @GetMapping("/{id}")
    public Case getCaseById(
            @PathVariable Long id
    ) {

        return caseService.getCaseById(id);
    }
}