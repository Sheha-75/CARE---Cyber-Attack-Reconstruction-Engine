package com.care.case_management.dto;

import com.care.case_management.enums.Severity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCaseRequest {

    @NotBlank(message = "Case title is required")
    private String title;

    @NotBlank(message = "Case description is required")
    private String description;

    @NotNull(message = "Severity is required")
    private Severity severity;

}