package com.example.commons.equity.model.dto.input;

import java.time.LocalDate;

public record DailyFutureDTO(LocalDate refDate,
                             String isin,
                             String ticker,
                             String underlyingId,
                             String underlyingDescription,
                             Double priceClose,
                             Double priceLow,
                             Double priceOpen,
                             Double priceHigh,
                             Integer volume) {
}
