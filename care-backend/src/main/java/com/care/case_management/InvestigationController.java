package com.care.case_management;

import com.care.case_management.dto.CreateInvestigationRequest;
import com.care.case_management.dto.InvestigationResponse;
import com.care.case_management.dto.UpdateInvestigationRequest;
import com.care.case_management.service.InvestigationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/investigations")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class InvestigationController {

    private final InvestigationService investigationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InvestigationResponse createInvestigation(
            @Valid @RequestBody CreateInvestigationRequest request) {

        return investigationService.createInvestigation(request);
    }

    @GetMapping
    public List<InvestigationResponse> getAllInvestigations() {

        return investigationService.getAllInvestigations();
    }

    @GetMapping("/{id}")
    public InvestigationResponse getInvestigationById(
            @PathVariable Long id) {

        return investigationService.getInvestigationById(id);
    }

    @PutMapping("/{id}")
    public InvestigationResponse updateInvestigation(
            @PathVariable Long id,
            @Valid @RequestBody UpdateInvestigationRequest request) {

        return investigationService.updateInvestigation(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInvestigation(
            @PathVariable Long id) {

        investigationService.deleteInvestigation(id);
    }
}