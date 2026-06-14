package com.care.dashboard;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DashboardResponse {

    private long totalCases;

    private long openCases;

    private long totalEvidence;

    private long totalTimelineEvents;
}