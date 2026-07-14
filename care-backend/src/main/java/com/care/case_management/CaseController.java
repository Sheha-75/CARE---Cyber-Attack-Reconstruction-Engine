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
    public InvestigationCase createCase(

            @RequestBody InvestigationCase investigationCase

    ) {

        return caseService.createCase(
                investigationCase
        );

    }

    @GetMapping
    public List<InvestigationCase> getAllCases() {

        return caseService.getAllCases();

    }

    @GetMapping("/{id}")
    public InvestigationCase getCaseById(

            @PathVariable Long id

    ) {

        return caseService.getCaseById(id);

    }
}