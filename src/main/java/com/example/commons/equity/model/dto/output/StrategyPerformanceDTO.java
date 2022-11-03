package com.example.commons.equity.model.dto.output;

import java.time.LocalDate;
import java.time.LocalTime;

public record StrategyPerformanceDTO(
        Long idOrder,
        Long idSignal,
        LocalTime timestamp,
        LocalDate tradeDate,
        Double sharp,
        Double sortino,
        Double maxdrawdown,
        Double pL
) {
}
