package com.example.commons.equity.model.dto.input;

import java.time.LocalDate;

public record PersonalDataFutureDTO(
        String ticker,
        String isin,
        String description,
        String currency,
        LocalDate maturity) {

}
