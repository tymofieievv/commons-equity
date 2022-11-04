package com.example.commons.equity.model.dto.output;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record OrderDTO(
        Long idOrder,
        Long idSignal,
        LocalDateTime timestamp,
        LocalDate tradeDate,
        String underlying,
        String tickerFuture,
        String status,
        String buySell,
        Integer position,
        Double theoreticalPrice,
        Integer theoreticalPosition,
        Double prezzoEseguito,
        Double deltaPrezzo
) {
}
