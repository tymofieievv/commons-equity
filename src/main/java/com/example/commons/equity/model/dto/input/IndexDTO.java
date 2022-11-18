package com.example.commons.equity.model.dto.input;

import com.example.commons.equity.model.entity.input.Index;

import java.time.LocalDate;
import java.time.LocalTime;

public record IndexDTO(LocalDate refDate,
                       LocalTime time,
                       Double price,
                       String instrumentId,
                       Double priceLow,
                       Double priceHigh,
                       Double priceClosed) {
    public Index toEntity() {

        Index index = new Index();
        index.setRefDate(this.refDate);
        index.setTime(this.time);
        index.setPrice(this.price);
        index.setInstrumentId(this.instrumentId);
        index.setPriceHigh(this.priceHigh);
        index.setPriceLow(this.priceLow);
        index.setPriceClosed(this.priceClosed);

        return index;
    }
}
