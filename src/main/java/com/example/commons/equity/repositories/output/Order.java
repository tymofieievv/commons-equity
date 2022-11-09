package com.example.commons.equity.repositories.output;

import com.example.commons.equity.model.dto.output.OrderDTO;
import com.example.commons.equity.model.entity.output.Order;
import com.example.commons.equity.model.enums.Operations;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


interface OrderRepository extends JpaRepository<Order, Long> {


}
