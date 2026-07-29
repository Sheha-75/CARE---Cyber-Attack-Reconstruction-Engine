package com.care.case_management;

import com.care.case_management.enums.CaseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CaseService {

    private final CaseRepository caseRepository;

    public InvestigationCase createCase(
            InvestigationCase investigationCase) {

        System.out.println("========== CASE SERVICE ==========");

        investigationCase.setStatus(CaseStatus.OPEN);

        InvestigationCase savedCase =
                caseRepository.save(investigationCase);

        System.out.println(savedCase.getId());

        return savedCase;
    }

    public List<InvestigationCase> getAllCases() {
        return caseRepository.findAll();
    }

    public InvestigationCase getCaseById(Long id) {

        return caseRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Case not found"));
    }
}