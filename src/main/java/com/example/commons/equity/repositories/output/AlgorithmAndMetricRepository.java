package com.example.commons.equity.repositories.output;

import com.example.commons.equity.model.entity.output.AlgorithmAndMetric;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AlgorithmAndMetricRepository extends JpaRepository<AlgorithmAndMetric, Long> {

}
