package com.example.commons.equity.model.dto.output;

import com.example.commons.equity.model.entity.output.StrategyPerformance;

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

    private StrategyPerformance toEntity() {

        StrategyPerformance strategyPerformance = new StrategyPerformance();

        strategyPerformance.setTimestamp(this.timestamp());
        strategyPerformance.setTradeDate(this.tradeDate());
        strategyPerformance.setSharp(this.sharp());
        strategyPerformance.setSortino(this.sortino());
        strategyPerformance.setMaxdrawdown(this.maxdrawdown());
        strategyPerformance.setPL(this.pL());

        return strategyPerformance;
    }
}
