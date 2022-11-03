package com.example.commons.entity.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HistoricalFuture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String refDate;
    private String isin;
    private String ticker;
    private LocalTime time;
    private String underlyingId;
    private String underlyingDescription;
    private String priceClose;
    private String priceOpen;
    private String priceLow;
    private String priceHigh;
    private String volume;
}
