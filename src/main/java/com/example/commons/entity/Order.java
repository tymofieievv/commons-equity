package com.example.commons.entity;

import com.example.commons.enumerated.Operations;
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
    private LocalDate tradedate;
    private String underlying;
    private String idSignal;
    private String idOrder;
    private int theoricalPosition;
    private int position;
    private int executedPrice;
    private int deltaPrice;
    private String tickerFuture;
    @Enumerated(EnumType.STRING)
    private Operations operations;
    private int quantity;
    private int theoreticalPrice;
}