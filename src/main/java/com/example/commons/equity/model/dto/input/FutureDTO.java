package com.example.commons.equity.model.dto.input;

import com.example.commons.equity.model.entity.input.Future;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class FutureDTO {
    private LocalDate refDate;
    private String isin;
    private String ticker;
    private String underlyingId;
    private String underlyingDescription;
    private LocalTime time;
    private Double priceClose;
    private Double priceOpen;
    private Double priceLow;
    private Double priceHigh;
    private Integer volume;


    public Future toEntity() {
        Future future = new Future();

        future.setRefDate(this.refDate);
        future.setIsin(this.isin);
        future.setTicker(this.ticker);
        future.setUnderlyingId(this.underlyingId);
        future.setUnderlyingDescription(this.underlyingDescription);
        future.setTime(this.time);
        future.setPriceClose(this.priceClose);
        future.setPriceOpen(this.priceOpen);
        future.setPriceClose(this.priceClose);
        future.setPriceLow(this.priceLow);
        future.setPriceHigh(this.priceHigh);
        future.setVolume(this.volume);

        return future;
    }
}
