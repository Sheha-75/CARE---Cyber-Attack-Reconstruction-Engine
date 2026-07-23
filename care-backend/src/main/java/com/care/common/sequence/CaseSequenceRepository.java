package com.care.common.sequence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseSequenceRepository
        extends JpaRepository<CaseSequence, Long> {
}