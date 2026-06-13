package com.care.timeline;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timeline")
@RequiredArgsConstructor
public class TimelineController {

    private final TimelineService timelineService;

    @PostMapping("/{caseId}")
    public TimelineEvent createEvent(

            @PathVariable Long caseId,

            @RequestParam String eventType,

            @RequestParam String description

    ) {

        return timelineService.addEvent(
                caseId,
                eventType,
                description
        );
    }

    @GetMapping("/{caseId}")
    public List<TimelineEvent> getTimeline(

            @PathVariable Long caseId

    ) {

        return timelineService.getTimeline(
                caseId
        );
    }
}