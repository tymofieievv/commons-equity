package com.example.commons.equity.model.entity.output;

import com.example.commons.equity.model.dto.output.StrategyPerformanceDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;
@Entity(name="VIS10_API_STRATEGY_PERFORMANCE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StrategyPerformance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalTime timestamp;
    private LocalDate tradeDate;
    private Double sharp;
    private Double sortino;
    private Double maxdrawdown;
    private Double pL;

//    private StrategyPerformance buildFromDTO(StrategyPerformanceDTO strategyPerformanceDTO){
//
//        StrategyPerformance strategyPerformance = new StrategyPerformance();
//
//        strategyPerformance.setTimestamp(strategyPerformanceDTO.timestamp());
//        strategyPerformance.setTradeDate(strategyPerformanceDTO.tradeDate());
//        strategyPerformance.setSharp(strategyPerformanceDTO.sharp());
//        strategyPerformance.setSortino(strategyPerformanceDTO.sortino());
//        strategyPerformance.setMaxdrawdown(strategyPerformanceDTO.maxdrawdown());
//        strategyPerformance.setPL(strategyPerformanceDTO.pL());
//
//        return strategyPerformance;
//    }
}
