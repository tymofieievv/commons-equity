package com.example.commons.equity.model.dto.input;

import java.time.LocalDateTime;

public record PositionDTO(LocalDateTime refDate,
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
