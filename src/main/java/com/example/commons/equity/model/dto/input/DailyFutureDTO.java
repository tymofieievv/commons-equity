package com.example.commons.equity.model.dto.input;

import com.example.commons.equity.model.entity.input.DailyFuture;

import java.time.LocalDate;

public record DailyFutureDTO(LocalDate refDate,

                             String ric,
                             Double priceClose,
                             Double priceLow,
                             Double priceOpen,
                             Double priceHigh,
                             Integer volume) {
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
