package com.care.case_management.dto;

import com.care.case_management.enums.CaseStatus;
import com.care.case_management.enums.Priority;
import com.care.case_management.enums.Severity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class InvestigationResponse {

    private Long id;

    private String caseNumber;

    private String title;

    private String description;

    private Severity severity;

    private Priority priority;

    private CaseStatus status;

    private String assignedInvestigator;

    private String incidentSource;

    private String affectedSystem;

    private LocalDateTime incidentOccurredAt;

    private LocalDateTime detectedAt;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}