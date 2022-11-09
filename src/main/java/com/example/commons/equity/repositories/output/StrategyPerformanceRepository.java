package com.example.commons.equity.repositories.output;

import com.example.commons.equity.model.entity.output.StrategyPerformance;
import org.springframework.data.jpa.repository.JpaRepository;

interface StrategyPerformanceRepository extends JpaRepository<StrategyPerformance, Long> {

}
