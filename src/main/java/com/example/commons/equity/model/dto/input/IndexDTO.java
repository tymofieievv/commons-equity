package com.example.commons.equity.model.dto.input;

import java.time.LocalDate;
import java.time.LocalTime;

public record IndexDTO(LocalDate refDate,
                       LocalTime time,
                       Double price,
                       String instrumentId,
                       String securityDescription,
                       String underlying) {
}
