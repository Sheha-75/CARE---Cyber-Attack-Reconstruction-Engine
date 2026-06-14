package com.care.summary;

import com.care.timeline.TimelineEvent;
import com.care.timeline.TimelineEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SummaryService {

    private final TimelineEventRepository timelineRepository;

    public CaseSummaryResponse generateSummary(
            Long caseId
    ) {

        List<TimelineEvent> events =
                timelineRepository
                        .findByInvestigationCaseId(caseId);

        int failedLogins = 0;
        int malwareEvents = 0;

        for (TimelineEvent event : events) {

            String description =
                    event.getDescription().toLowerCase();

            if (description.contains("failed")) {
                failedLogins++;
            }

            if (description.contains("malware")) {
                malwareEvents++;
            }
        }

        String riskLevel = "LOW";

        if (failedLogins >= 3 || malwareEvents > 0) {
            riskLevel = "HIGH";
        }
        else if (failedLogins > 0) {
            riskLevel = "MEDIUM";
        }

        String summary =
                "Detected "
                        + failedLogins
                        + " failed login attempts and "
                        + malwareEvents
                        + " malware-related events.";

        List<String> recommendations =
                new ArrayList<>();

        recommendations.add(
                "Review timeline events"
        );

        if (failedLogins > 0) {
            recommendations.add(
                    "Reset affected credentials"
            );
        }

        if (malwareEvents > 0) {
            recommendations.add(
                    "Perform malware investigation"
            );

            recommendations.add(
                    "Isolate affected system"
            );
        }

        return new CaseSummaryResponse(
                caseId,
                riskLevel,
                summary,
                recommendations
        );
    }
}