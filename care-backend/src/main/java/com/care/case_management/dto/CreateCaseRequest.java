package com.care.case_management.dto;

import com.care.case_management.Severity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCaseRequest {

    private String title;

    private String description;

    private Severity severity;

}