package com.care.summary;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/summary")
@RequiredArgsConstructor
public class SummaryController {

    private final SummaryService summaryService;

    @GetMapping("/case/{caseId}")
    public CaseSummaryResponse getSummary(
            @PathVariable Long caseId
    ) {

        return summaryService.generateSummary(
                caseId
        );
    }
}