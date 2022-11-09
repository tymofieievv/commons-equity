package com.example.commons.equity.model.dto.input;

import java.time.LocalDate;
import java.time.LocalTime;

public record FutureDTO(LocalDate refDate,
                        String isin,
                        String ticker,
                        String underlyingId,
                        String underlyingDescription,
                        LocalTime time,
                        Double priceClose,
                        Double priceOpen,
                        Double priceLow,
                        Double priceHigh,
                        Integer volume) {
}
