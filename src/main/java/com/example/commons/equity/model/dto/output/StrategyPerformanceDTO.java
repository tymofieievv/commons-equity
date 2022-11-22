package com.example.commons.equity.model.dto.output;

import com.example.commons.equity.model.entity.output.StrategyPerformance;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StrategyPerformanceDTO {
    private LocalTime timestamp;
    private LocalDate tradeDate;
    private Double sharp;
    private Double sortino;
    private Double maxdrawdown;
    private Double pL;


    public StrategyPerformance toEntity() {

        StrategyPerformance strategyPerformance = new StrategyPerformance();

        strategyPerformance.setTimestamp(this.timestamp);
        strategyPerformance.setTradeDate(this.tradeDate);
        strategyPerformance.setSharp(this.sharp);
        strategyPerformance.setSortino(this.sortino);
        strategyPerformance.setMaxdrawdown(this.maxdrawdown);
        strategyPerformance.setPL(this.pL);

        return strategyPerformance;
    }
}
