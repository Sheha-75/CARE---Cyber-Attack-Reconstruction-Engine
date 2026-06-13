package com.care.case_management;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CaseService {

    private final CaseRepository caseRepository;

    public Case createCase(Case investigationCase) {

        investigationCase.setStatus(CaseStatus.OPEN);

        return caseRepository.save(investigationCase);
    }

    public List<Case> getAllCases() {

        return caseRepository.findAll();
    }

    public Case getCaseById(Long id) {

        return caseRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Case not found"));
    }
}