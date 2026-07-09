package com.care.case_management.dto;

import com.care.case_management.CaseStatus;
import com.care.case_management.Severity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CaseResponse {

    private Long id;

    private String caseNumber;

    private String title;

    private String description;

    private Severity severity;

    private CaseStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}