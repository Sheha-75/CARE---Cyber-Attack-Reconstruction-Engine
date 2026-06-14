package com.care.timeline;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimelineEventRepository
        extends JpaRepository<TimelineEvent, Long> {

    List<TimelineEvent> findByInvestigationCaseIdOrderByEventTimeAsc(
            Long caseId
    );

    List<TimelineEvent> findByInvestigationCaseId(
            Long caseId
    );
}