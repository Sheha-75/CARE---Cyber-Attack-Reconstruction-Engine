package com.care.custody;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/custody")
@RequiredArgsConstructor
public class ChainOfCustodyController {

    private final ChainOfCustodyService custodyService;

    @GetMapping("/{evidenceId}")
    public List<ChainOfCustody> getHistory(

            @PathVariable Long evidenceId

    ) {

        return custodyService.getHistory(
                evidenceId
        );
    }
}