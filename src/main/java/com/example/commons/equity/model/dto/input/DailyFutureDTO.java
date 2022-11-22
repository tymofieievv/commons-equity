package com.example.commons.equity.model.dto.input;

import com.example.commons.equity.model.entity.input.DailyFuture;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DailyFutureDTO {
    private LocalDate refDate;
    private String ric;
    private Double priceClose;
    private Double priceLow;
    private Double priceOpen;
    private Double priceHigh;
    private Integer volume;


    public DailyFuture toEntity() {

        DailyFuture dailyFuture = new DailyFuture();

        dailyFuture.setRefDate(this.refDate);
        dailyFuture.setRic(this.ric);
        dailyFuture.setPriceClose(this.priceClose);
        dailyFuture.setPriceLow(this.priceLow);
        dailyFuture.setPriceHigh(this.priceHigh);
        dailyFuture.setPriceOpen(this.priceOpen);
        dailyFuture.setVolume(this.volume);

        return dailyFuture;
    }
}
