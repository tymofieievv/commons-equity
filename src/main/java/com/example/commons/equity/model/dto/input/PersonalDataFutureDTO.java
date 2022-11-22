package com.example.commons.equity.model.dto.input;

import com.example.commons.equity.model.entity.input.PersonalDataFuture;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonalDataFutureDTO {
    private String ticker;
    private String isin;
    private String underlyingId;
    private String ric;
    private String description;
    private String currency;
    private LocalDate maturity;

    public PersonalDataFuture toEntity() {

        PersonalDataFuture personalDataFuture = new PersonalDataFuture();

        personalDataFuture.setIsin(this.isin);
        personalDataFuture.setUnderlyingId(this.underlyingId);
        personalDataFuture.setRic(this.ric);
        personalDataFuture.setDescription(this.description);
        personalDataFuture.setTicker(this.ticker);
        personalDataFuture.setDescription(this.description);
        personalDataFuture.setCurrency(this.currency);
        personalDataFuture.setMaturity(this.maturity);

        return personalDataFuture;

    }


}
