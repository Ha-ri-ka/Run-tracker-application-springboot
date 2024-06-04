package com.start.runnerApplication.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(
        Integer Id,
        @NotEmpty //title can never be empty
        String title,
        LocalDateTime started,
        LocalDateTime ended,
        @Positive //validation "constraints"s
        Integer distance,
        Location location
) {
    //we need to validate the data that user enters, cant just accept anything that user sends as valid.
    public Run{
        if(!started.isBefore(ended))
        {
            throw new IllegalArgumentException("Start time of run must be before end time.");
        }
    }
}
