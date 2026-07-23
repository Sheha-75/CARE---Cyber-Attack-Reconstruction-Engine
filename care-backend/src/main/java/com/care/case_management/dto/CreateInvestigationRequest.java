package com.care.case_management.dto;

import com.care.case_management.enums.CaseStatus;
import com.care.case_management.enums.Priority;
import com.care.case_management.enums.Severity;
import lombok.Getter;
import lombok.Setter;
import com.care.common.validation.ValidationMessages;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateInvestigationRequest {


    @NotBlank(message = ValidationMessages.TITLE_REQUIRED)
    private String title;

    @NotBlank(message = ValidationMessages.DESCRIPTION_REQUIRED)
    private String description;

    @NotNull(message = ValidationMessages.SEVERITY_REQUIRED)
    private Severity severity;

    @NotNull(message = ValidationMessages.PRIORITY_REQUIRED)
    private Priority priority;

    @NotNull(message = ValidationMessages.STATUS_REQUIRED)
    private CaseStatus status;

    @NotBlank(message = ValidationMessages.INVESTIGATOR_REQUIRED)
    private String assignedInvestigator;

    @NotBlank(message = ValidationMessages.INCIDENT_SOURCE_REQUIRED)
    private String incidentSource;

    @NotBlank(message = ValidationMessages.AFFECTED_SYSTEM_REQUIRED)
    private String affectedSystem;

    @NotNull(message = ValidationMessages.INCIDENT_DATE_REQUIRED)
    private LocalDateTime incidentOccurredAt;

    @NotNull(message = ValidationMessages.DETECTED_DATE_REQUIRED)
    private LocalDateTime detectedAt;

}