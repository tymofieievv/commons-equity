package com.example.commons.equity.model.dto.input;

import com.example.commons.equity.model.entity.input.PersonalDataFuture;

import java.time.LocalDate;

public record PersonalDataFutureDTO(
        String ticker,
        String isin,
        String underlyingId,
        String ric,
        String description,
        String currency,
        LocalDate maturity) {
    public PersonalDataFuture toEntity() {

        PersonalDataFuture personalDataFuture = new PersonalDataFuture();

        personalDataFuture.setIsin(this.isin);
        personalDataFuture.setUnderlyingId(this.underlyingId);
        personalDataFuture.setDescription(this.description);
        personalDataFuture.setTicker(this.ticker);
        personalDataFuture.setDescription(this.description);
        personalDataFuture.setCurrency(this.currency);
        personalDataFuture.setMaturity(this.maturity);

        return personalDataFuture;

    }


}
