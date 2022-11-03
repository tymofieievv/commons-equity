package com.example.commons.equity.model.dto.output;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record Order(
        Long idSignal,
        LocalDateTime timestamp,
        LocalDate tradeDate,
        String underlying,
        String tickerFuture,
        String buySell,
        Integer quantity,
        Double theoreticalPrice,
        Double prezzoEseguito,
        Double deltaPrezzo
) {
}
