package com.example.commons.equity.model.dto.input;

import java.time.LocalDateTime;

public record PositionDTO(LocalDateTime refDate,
                          String portfolioId,
                          String instrumentId,
                          String positionId,
                          String family,
                          String group,
                          String type,
                          String currency,
                          Integer position,
                          String entity,
                          String division,
                          String marketName
) {
}
