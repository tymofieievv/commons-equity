package com.example.commons.equity.model.dto.output;

import java.time.LocalDate;
import java.time.LocalTime;

public record StrategyPerformanceDTO(
        LocalTime timestamp,
        LocalDate tradeDate,
        Double sharp,
        Double sortino,
        Double maxdrawdown,
        Double pL
) {
}
