package com.care.timeline;

import com.care.case_management.CaseRepository;
import com.care.case_management.InvestigationCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TimelineService {

    private final TimelineEventRepository timelineRepository;
    private final CaseRepository caseRepository;

    public TimelineEvent addEvent(
            Long caseId,
            String eventType,
            String description
    ) {

        InvestigationCase investigationCase =
                caseRepository.findById(caseId)
                        .orElseThrow(() ->
                                new RuntimeException("Case not found"));

        TimelineEvent event = new TimelineEvent();

        event.setEventTime(LocalDateTime.now());
        event.setEventType(eventType);
        event.setDescription(description);
        event.setInvestigationCase(investigationCase);

        return timelineRepository.save(event);
    }

    public List<TimelineEvent> getTimeline(Long caseId) {

        return timelineRepository
                .findByInvestigationCaseIdOrderByEventTimeAsc(caseId);

    }
}