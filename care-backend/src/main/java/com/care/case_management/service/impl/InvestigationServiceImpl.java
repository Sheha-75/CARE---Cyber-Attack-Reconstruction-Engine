package com.care.case_management.service.impl;

import com.care.case_management.InvestigationCase;
import com.care.case_management.InvestigationCaseRepository;
import com.care.case_management.dto.CreateInvestigationRequest;
import com.care.case_management.dto.InvestigationResponse;
import com.care.case_management.dto.UpdateInvestigationRequest;
import com.care.case_management.mapper.InvestigationMapper;
import com.care.case_management.service.InvestigationService;
import com.care.common.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InvestigationServiceImpl implements InvestigationService {

    private final InvestigationCaseRepository repository;

    private final InvestigationMapper mapper;

    @Override
    public InvestigationResponse createInvestigation(CreateInvestigationRequest request) {

        log.info("Creating Investigation : {}", request.getCaseNumber());

        InvestigationCase investigation =
                mapper.toEntity(request);

        InvestigationCase saved =
                repository.save(investigation);

        return mapper.toResponse(saved);
    }

    @Override
    public InvestigationResponse getInvestigationById(Long id) {

        InvestigationCase investigation =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Investigation not found : " + id));

        return mapper.toResponse(investigation);
    }

    @Override
    public List<InvestigationResponse> getAllInvestigations() {

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public InvestigationResponse updateInvestigation(
            Long id,
            UpdateInvestigationRequest request) {

        InvestigationCase investigation =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Investigation not found : " + id));

        mapper.updateEntity(request, investigation);

        InvestigationCase updated =
                repository.save(investigation);

        return mapper.toResponse(updated);
    }

    @Override
    public void deleteInvestigation(Long id) {

        InvestigationCase investigation =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Investigation not found : " + id));

        repository.delete(investigation);

        log.info("Investigation Deleted : {}", id);
    }
}