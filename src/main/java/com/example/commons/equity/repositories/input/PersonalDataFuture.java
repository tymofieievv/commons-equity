package com.example.commons.equity.repositories.input;

import com.example.commons.equity.model.dto.input.PersonalDataFutureDTO;
import com.example.commons.equity.model.entity.input.PersonalDataFuture;
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


interface PersonalDataFutureRepository extends JpaRepository<PersonalDataFuture, Long> {


}
