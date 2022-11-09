package com.example.commons.equity.repositories.input;

import com.example.commons.equity.model.dto.input.IndexDTO;
import com.example.commons.equity.model.entity.input.Index;
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


interface IndexRepository extends JpaRepository<Index, Long> {

}
