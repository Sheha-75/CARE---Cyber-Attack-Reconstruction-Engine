package com.care.case_management;

import com.care.case_management.enums.CaseStatus;
import com.care.case_management.enums.Severity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvestigationCaseRepository
        extends JpaRepository<InvestigationCase, Long> {

    List<InvestigationCase> findByTitleContainingIgnoreCase(String keyword);

    List<InvestigationCase> findByStatus(CaseStatus status);

    List<InvestigationCase> findBySeverity(Severity severity);

}