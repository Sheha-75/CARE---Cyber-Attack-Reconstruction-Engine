package com.care.common.sequence;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Year;

@Component
@RequiredArgsConstructor
public class CaseNumberGenerator {

    private final CaseSequenceRepository repository;

    @Transactional
    public String generateCaseNumber() {

        CaseSequence sequence = repository.findById(1L)
                .orElseGet(() -> {

                    CaseSequence newSequence = new CaseSequence();
                    newSequence.setId(1L);
                    newSequence.setNextValue(1L);

                    return repository.save(newSequence);
                });

        long current = sequence.getNextValue();

        sequence.setNextValue(current + 1);

        repository.save(sequence);

        return String.format(
                "CARE-%d-%06d",
                Year.now().getValue(),
                current
        );
    }
}