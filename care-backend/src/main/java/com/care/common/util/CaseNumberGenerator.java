package com.care.common.util;

import org.springframework.stereotype.Component;

import java.time.Year;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class CaseNumberGenerator {

    private final AtomicLong sequence = new AtomicLong(1);

    public String generate() {

        return String.format(
                "CARE-%d-%06d",
                Year.now().getValue(),
                sequence.getAndIncrement()
        );
    }
}