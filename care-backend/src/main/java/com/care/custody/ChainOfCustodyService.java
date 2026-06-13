package com.care.custody;

import com.care.evidence.Evidence;
import com.care.evidence.EvidenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChainOfCustodyService {

    private final ChainOfCustodyRepository custodyRepository;
    private final EvidenceRepository evidenceRepository;

    public void logAction(
            Long evidenceId,
            String action,
            String performedBy
    ) {

        Evidence evidence =
                evidenceRepository.findById(evidenceId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Evidence not found"
                                ));

        ChainOfCustody record =
                new ChainOfCustody();

        record.setAction(action);

        record.setPerformedBy(
                performedBy
        );

        record.setTimestamp(
                LocalDateTime.now()
        );

        record.setEvidence(
                evidence
        );

        custodyRepository.save(
                record
        );
    }

    public List<ChainOfCustody> getHistory(
            Long evidenceId
    ) {

        return custodyRepository
                .findByEvidenceId(
                        evidenceId
                );
    }
}