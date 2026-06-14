package com.care.summary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CaseSummaryResponse {

    private Long caseId;

    private String riskLevel;

    private String summary;

    private List<String> recommendations;
}