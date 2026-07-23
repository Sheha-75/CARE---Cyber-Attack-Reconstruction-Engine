package com.care.case_management;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestigationCaseRepository
        extends JpaRepository<InvestigationCase, Long> {
}