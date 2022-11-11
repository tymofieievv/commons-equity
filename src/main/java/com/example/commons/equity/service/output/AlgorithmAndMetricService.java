package com.example.commons.equity.service.output;

import com.example.commons.equity.model.entity.output.AlgorithmAndMetric;
import com.example.commons.equity.model.entity.output.StrategyPerformance;
import com.example.commons.equity.repositories.output.AlgorithmAndMetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlgorithmAndMetricService {

    private final AlgorithmAndMetricRepository algorithmAndMetricRepository;

    @Autowired

    public AlgorithmAndMetricService(AlgorithmAndMetricRepository algorithmAndMetricRepository) {
        this.algorithmAndMetricRepository = algorithmAndMetricRepository;
    }

    public List<AlgorithmAndMetric> findAll() {
        return algorithmAndMetricRepository.findAll();
    }

    public AlgorithmAndMetric save(AlgorithmAndMetric algorithmAndMetric) {
        return algorithmAndMetricRepository.save(algorithmAndMetric);
    }
}
