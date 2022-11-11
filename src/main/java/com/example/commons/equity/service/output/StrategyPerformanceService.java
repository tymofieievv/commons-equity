package com.example.commons.equity.service.output;

import com.example.commons.equity.model.entity.output.StrategyPerformance;
import com.example.commons.equity.repositories.output.StrategyPerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StrategyPerformanceService {

    private final StrategyPerformanceRepository strategyPerformanceRepository;

    @Autowired

    public StrategyPerformanceService(StrategyPerformanceRepository strategyPerformanceRepository) {
        this.strategyPerformanceRepository = strategyPerformanceRepository;
    }

    public List<StrategyPerformance> findAll() {
        return strategyPerformanceRepository.findAll();
    }

    public StrategyPerformance save(StrategyPerformance strategyPerformance) {
        return strategyPerformanceRepository.save(strategyPerformance);
    }
}
