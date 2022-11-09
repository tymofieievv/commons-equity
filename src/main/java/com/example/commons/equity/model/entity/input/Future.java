package com.example.commons.equity.model.entity.input;

import com.example.commons.equity.model.dto.input.FutureDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Future {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate refDate;
    private String isin;
    private String ticker;
    private LocalTime time;
    private String underlyingId;
    private String underlyingDescription;
    private double price;
    private Double priceClose;
    private Double priceOpen;
    private Double priceLow;
    private Double priceHigh;
    private Integer volume;

    public Future buildFromDTO(FutureDTO futureDTO) {
        Future future = new Future();

        future.setRefDate(futureDTO.refDate());
        future.setIsin(futureDTO.isin());
        future.setTicker(futureDTO.ticker());
        future.setUnderlyingId(futureDTO.underlyingId());
        future.setUnderlyingDescription(futureDTO.underlyingDescription());
        future.setPrice(futureDTO.price());
        future.setTime(futureDTO.time());
        future.setPriceClose(futureDTO.priceClose());
        future.setPriceOpen(futureDTO.priceOpen());
        future.setPriceClose(futureDTO.priceClose());
        future.setPriceLow(futureDTO.priceLow());
        future.setPriceHigh(futureDTO.priceHigh());
        future.setVolume(futureDTO.volume());

        return future;
    }

}
