package com.example.commons.equity.model.dto.input;

import com.example.commons.equity.model.entity.input.Index;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IndexDTO {
    private LocalDateTime timestamp;
    private Double priceOpen;
    private String instrumentId;
    private Double priceLow;
    private Double priceHigh;
    private Double priceClosed;

    public Index toEntity() {

        Index index = new Index();
        index.setTimestamp(this.timestamp);
        index.setPriceOpen(this.priceOpen);
        index.setInstrumentId(this.instrumentId);
        index.setPriceHigh(this.priceHigh);
        index.setPriceLow(this.priceLow);
        index.setPriceClose(this.priceClosed);

        return index;
    }
}
