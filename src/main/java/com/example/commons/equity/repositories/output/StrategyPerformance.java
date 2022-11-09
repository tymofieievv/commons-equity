package com.example.commons.equity.repositories.output;

import com.example.commons.equity.model.dto.output.StrategyPerformanceDTO;
import com.example.commons.equity.model.entity.output.StrategyPerformance;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
interface StrategyPerformanceRepository extends JpaRepository<StrategyPerformance, Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalTime timestamp;
    private LocalDate tradeDate;
    private Double sharp;
    private Double sortino;
    private Double maxdrawdown;
    private Double pL;

    private StrategyPerformance buildFromDTO(StrategyPerformanceDTO strategyPerformanceDTO){

        StrategyPerformance strategyPerformance = new StrategyPerformance();

        strategyPerformance.setTimestamp(strategyPerformanceDTO.timestamp());
        strategyPerformance.setTradeDate(strategyPerformanceDTO.tradeDate());
        strategyPerformance.setSharp(strategyPerformanceDTO.sharp());
        strategyPerformance.setSortino(strategyPerformanceDTO.sortino());
        strategyPerformance.setMaxdrawdown(strategyPerformanceDTO.maxdrawdown());
        strategyPerformance.setPL(strategyPerformanceDTO.pL());

        return strategyPerformance;
    }
}
