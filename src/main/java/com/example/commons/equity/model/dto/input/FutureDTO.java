package com.example.commons.equity.model.dto.input;

import com.example.commons.equity.model.entity.input.Future;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FutureDTO {
    private String ric;
    private LocalDateTime timestamp;
    private Double priceClose;
    private Double priceOpen;
    private Double priceLow;
    private Double priceHigh;
    private Integer volume;


    public Future toEntity() {
        Future future = new Future();

        future.setRic(this.ric);
        future.setTimestamp(this.timestamp);
        future.setPriceClose(this.priceClose);
        future.setPriceOpen(this.priceOpen);
        future.setPriceClose(this.priceClose);
        future.setPriceLow(this.priceLow);
        future.setPriceHigh(this.priceHigh);
        future.setVolume(this.volume);

        return future;
    }
}
