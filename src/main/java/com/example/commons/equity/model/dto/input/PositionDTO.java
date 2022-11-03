package com.example.commons.equity.model.dto.input;

import java.time.LocalDate;

public record PositionDTO(LocalDate refDate,
                          String portfolioId,
                          String instrumentId,
                          String family,
                          String group,
                          String type,
                          String currency,
                          Integer quantity,
                          String entity,
                          String division,
                          String marketName
) {
}
