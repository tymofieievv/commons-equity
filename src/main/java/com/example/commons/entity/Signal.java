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
public class Signal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime timestamp;
    private LocalDate tradedate;
    private String underlying;
    private String idSignal;
    private String ticketFuture;
    @Enumerated(EnumType.STRING)
    private Operations operations;
    private int quantity;
    private int theoreticalPrice;


}
