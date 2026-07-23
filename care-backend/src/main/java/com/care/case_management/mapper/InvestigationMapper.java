package com.care.case_management.mapper;

import com.care.case_management.InvestigationCase;
import com.care.case_management.dto.CreateInvestigationRequest;
import com.care.case_management.dto.InvestigationResponse;
import com.care.case_management.dto.UpdateInvestigationRequest;
import org.springframework.stereotype.Component;

@Component
public class InvestigationMapper {

    public InvestigationCase toEntity(CreateInvestigationRequest request) {

        InvestigationCase investigation = new InvestigationCase();

        investigation.setTitle(request.getTitle());
        investigation.setDescription(request.getDescription());
        investigation.setSeverity(request.getSeverity());
        investigation.setPriority(request.getPriority());
        investigation.setStatus(request.getStatus());
        investigation.setAssignedInvestigator(request.getAssignedInvestigator());
        investigation.setIncidentSource(request.getIncidentSource());
        investigation.setAffectedSystem(request.getAffectedSystem());
        investigation.setIncidentOccurredAt(request.getIncidentOccurredAt());
        investigation.setDetectedAt(request.getDetectedAt());

        return investigation;
    }

    public InvestigationResponse toResponse(InvestigationCase investigation) {

        InvestigationResponse response = new InvestigationResponse();

        response.setId(investigation.getId());
        response.setCaseNumber(investigation.getCaseNumber());
        response.setTitle(investigation.getTitle());
        response.setDescription(investigation.getDescription());
        response.setSeverity(investigation.getSeverity());
        response.setPriority(investigation.getPriority());
        response.setStatus(investigation.getStatus());
        response.setAssignedInvestigator(investigation.getAssignedInvestigator());
        response.setIncidentSource(investigation.getIncidentSource());
        response.setAffectedSystem(investigation.getAffectedSystem());
        response.setIncidentOccurredAt(investigation.getIncidentOccurredAt());
        response.setDetectedAt(investigation.getDetectedAt());
        response.setCreatedAt(investigation.getCreatedAt());
        response.setUpdatedAt(investigation.getUpdatedAt());

        return response;
    }

    public void updateEntity(UpdateInvestigationRequest request,
                             InvestigationCase investigation) {

        investigation.setTitle(request.getTitle());
        investigation.setDescription(request.getDescription());
        investigation.setSeverity(request.getSeverity());
        investigation.setPriority(request.getPriority());
        investigation.setStatus(request.getStatus());
        investigation.setAssignedInvestigator(request.getAssignedInvestigator());
        investigation.setIncidentSource(request.getIncidentSource());
        investigation.setAffectedSystem(request.getAffectedSystem());
        investigation.setIncidentOccurredAt(request.getIncidentOccurredAt());
        investigation.setDetectedAt(request.getDetectedAt());
    }
}