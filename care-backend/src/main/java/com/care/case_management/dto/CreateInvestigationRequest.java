package com.care.case_management.dto;

import com.care.case_management.enums.CaseStatus;
import com.care.case_management.enums.Severity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateInvestigationRequest {

    private String caseNumber;

    private String title;

    private String description;

    private Severity severity;

    private CaseStatus status;

}