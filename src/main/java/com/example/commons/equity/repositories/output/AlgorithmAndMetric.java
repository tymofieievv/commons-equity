package com.example.commons.equity.repositories.output;

import com.example.commons.equity.model.dto.output.AlgorithmAndMetricDTO;
import com.example.commons.equity.model.entity.output.AlgorithmAndMetric;
import com.example.commons.equity.model.enums.Operations;
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
import java.time.LocalDateTime;


interface AlgorithmAndMetricRepository extends JpaRepository<AlgorithmAndMetric, Long> {

}
