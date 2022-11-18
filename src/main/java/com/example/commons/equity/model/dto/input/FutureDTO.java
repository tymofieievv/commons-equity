package com.example.commons.equity.model.dto.input;

import com.example.commons.equity.model.entity.input.Future;

import java.time.LocalDate;
import java.time.LocalTime;

public record FutureDTO(
        LocalDate refDate,
        String ric,
        LocalTime time,
        Double priceClose,
        Double priceOpen,
        Double priceLow,
        Double priceHigh,
        Integer volume) {

    public Future toEntity() {
        Future future = new Future();

        future.setRefDate(this.refDate);
        future.setRic(this.ric);
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
