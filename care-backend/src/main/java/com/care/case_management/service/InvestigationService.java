package com.care.case_management.service;

import com.care.case_management.dto.CreateInvestigationRequest;
import com.care.case_management.dto.InvestigationResponse;
import com.care.case_management.dto.UpdateInvestigationRequest;

import java.util.List;

public interface InvestigationService {

    InvestigationResponse createInvestigation(CreateInvestigationRequest request);

    InvestigationResponse getInvestigationById(Long id);

    List<InvestigationResponse> getAllInvestigations();

    InvestigationResponse updateInvestigation(
            Long id,
            UpdateInvestigationRequest request
    );

    void deleteInvestigation(Long id);
}