package com.example.commons.equity.model.dto.output;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record OrderDTO(
        Long idOrder,
        Long idSignal,
        LocalDateTime timestamp,
        LocalDate tradeDate,
        String underlying,
        String portfolioId,
        String tickerFuture,
        String status,
        String buySell,
        Integer theoreticalQuantity,
        Integer quantity,
        Integer theoreticalPosition,
        Integer livePosition,
        Double theoreticalPrice,
        Double prezzoEseguito,
        Double deltaPrezzo
) {
}
