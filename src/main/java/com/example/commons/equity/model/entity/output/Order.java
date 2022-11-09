package com.example.commons.equity.model.entity.output;

import com.example.commons.equity.model.enums.Operations;
import com.example.commons.equity.model.dto.output.OrderDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime timestamp;
    private LocalDate tradeDate;
    private String underlying;
    private Long idSignal;
    private Long idOrder;
    private Integer theoreticalPosition;
    private Integer position;
    private Double executedPrice;
    String status;
    private Double deltaPrice;
    private String tickerFuture;
    @Enumerated(EnumType.STRING)
    private Operations operations;
    private Integer quantity;
    private Double theoreticalPrice;


}
