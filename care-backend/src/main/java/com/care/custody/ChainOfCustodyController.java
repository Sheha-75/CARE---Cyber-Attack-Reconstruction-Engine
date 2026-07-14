package com.care.custody;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/custody")
@RequiredArgsConstructor
public class ChainOfCustodyController {

    private final ChainOfCustodyService custodyService;

    @GetMapping("/{evidenceId}")
    public ResponseEntity<List<ChainOfCustody>> getHistory(
            @PathVariable Long evidenceId
    ) {

        return ResponseEntity.ok(
                custodyService.getHistory(evidenceId)
        );
    }
}