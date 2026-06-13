package com.care.custody;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChainOfCustodyRepository
        extends JpaRepository<ChainOfCustody, Long> {

    List<ChainOfCustody> findByEvidenceId(Long evidenceId);
}