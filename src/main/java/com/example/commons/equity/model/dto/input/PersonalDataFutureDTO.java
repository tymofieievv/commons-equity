package com.example.commons.equity.model.dto.input;

import com.example.commons.equity.model.entity.input.PersonalDataFuture;

import java.time.LocalDate;

public record PersonalDataFutureDTO(
        String ticker,
        String isin,
        String description,
        String currency,
        LocalDate maturity) {
    public PersonalDataFuture toEntity() {

        PersonalDataFuture personalDataFuture = new PersonalDataFuture();

        personalDataFuture.setIsin(this.isin);
        personalDataFuture.setTicker(this.ticker);
        personalDataFuture.setDescription(this.description);
        personalDataFuture.setCurrency(this.currency);
        personalDataFuture.setMaturity(this.maturity);

        return personalDataFuture;

    }


}
