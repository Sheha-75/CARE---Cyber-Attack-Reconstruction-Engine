package com.care.parser;

import com.care.timeline.TimelineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;

@Service
@RequiredArgsConstructor
public class LogParserService {

    private final TimelineService timelineService;

    public void parseLogFile(
            Long caseId,
            String filePath
    ) {

        try (
                BufferedReader reader =
                        new BufferedReader(
                                new FileReader(filePath)
                        )
        ) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.toLowerCase().contains("login")) {

                    timelineService.addEvent(
                            caseId,
                            "LOGIN_EVENT",
                            line
                    );
                }

                if (line.toLowerCase().contains("failed")) {

                    timelineService.addEvent(
                            caseId,
                            "FAILED_LOGIN",
                            line
                    );
                }

                if (line.toLowerCase().contains("malware")) {

                    timelineService.addEvent(
                            caseId,
                            "MALWARE_ALERT",
                            line
                    );
                }
            }

        } catch (Exception e) {

            throw new RuntimeException(
                    "Failed to parse log file"
            );
        }
    }
}