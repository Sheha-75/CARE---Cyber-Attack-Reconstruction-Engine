package com.care.timeline;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timeline")
@RequiredArgsConstructor
public class TimelineController {

    private final TimelineService timelineService;

    @PostMapping("/{caseId}")
    public ResponseEntity<TimelineEvent> createEvent(
            @PathVariable Long caseId,
            @RequestParam String eventType,
            @RequestParam String description
    ) {

        return ResponseEntity.ok(
                timelineService.addEvent(
                        caseId,
                        eventType,
                        description
                )
        );
    }

    @GetMapping("/{caseId}")
    public ResponseEntity<List<TimelineEvent>> getTimeline(
            @PathVariable Long caseId
    ) {

        return ResponseEntity.ok(
                timelineService.getTimeline(caseId)
        );
    }
}