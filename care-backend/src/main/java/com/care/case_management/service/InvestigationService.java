package com.care.case_management.service;

import com.care.case_management.dto.CreateInvestigationRequest;
import com.care.case_management.dto.InvestigationResponse;
import com.care.case_management.dto.UpdateInvestigationRequest;
import com.care.case_management.enums.CaseStatus;
import com.care.case_management.enums.Severity;

import java.util.List;

public interface InvestigationService {

    InvestigationResponse createInvestigation(CreateInvestigationRequest request);

    InvestigationResponse getInvestigationById(Long id);

    List<InvestigationResponse> getAllInvestigations();
    List<InvestigationResponse> searchByTitle(String keyword);

    List<InvestigationResponse> searchByStatus(CaseStatus status);

    List<InvestigationResponse> searchBySeverity(Severity severity);

    InvestigationResponse updateInvestigation(
            Long id,
            UpdateInvestigationRequest request
    );

    void deleteInvestigation(Long id);
}