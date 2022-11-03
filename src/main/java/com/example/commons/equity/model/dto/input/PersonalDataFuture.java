package com.example.commons.equity.model.dto.input;

import java.time.LocalDate;

public record PersonalDataFuture(
        String ticker,
        String isin,
        String description,
        String currency,
        LocalDate maturity) {

}
