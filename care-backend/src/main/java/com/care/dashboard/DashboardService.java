package com.care.dashboard;

import com.care.case_management.CaseRepository;
import com.care.evidence.EvidenceRepository;
import com.care.timeline.TimelineEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.care.case_management.CaseStatus;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final CaseRepository caseRepository;

    private final EvidenceRepository evidenceRepository;

    private final TimelineEventRepository timelineRepository;

    public DashboardResponse getStats() {

        long totalCases =
                caseRepository.count();

        long openCases =
                caseRepository.findAll()
                        .stream()
                        .filter(c ->
                                c.getStatus() == CaseStatus.OPEN
                        )
                        .count();

        long totalEvidence =
                evidenceRepository.count();

        long totalTimelineEvents =
                timelineRepository.count();

        return new DashboardResponse(
                totalCases,
                openCases,
                totalEvidence,
                totalTimelineEvents
        );
    }
}