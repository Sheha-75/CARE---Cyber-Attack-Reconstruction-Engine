package com.care.case_management;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CaseRepository
        extends JpaRepository<InvestigationCase, Long> {

    Optional<InvestigationCase> findByCaseNumber(
            String caseNumber
    );

}