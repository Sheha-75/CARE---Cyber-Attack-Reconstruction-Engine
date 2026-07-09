package com.care.case_management.dto;

import com.care.case_management.CaseStatus;
import com.care.case_management.Severity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCaseRequest {

    private String title;

    private String description;

    private Severity severity;

    private CaseStatus status;

}