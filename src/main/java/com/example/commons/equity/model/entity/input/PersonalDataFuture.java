package com.example.commons.equity.model.entity.input;

import com.example.commons.equity.model.dto.input.PersonalDataFutureDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity(name = "SSL0_IXP_FUTURE_ANAGRAPHIC")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonalDataFuture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isin;
    private String underlyingId;
    private String ric;
    private String ticker;
    private String description;
    private String currency;
    private LocalDate maturity;

    public PersonalDataFutureDTO toDTO() {
        return new PersonalDataFutureDTO(
                this.getTicker(),
                this.getIsin(),
                this.getUnderlyingId(),
                this.getDescription(),
                this.getDescription(),
                this.getCurrency(),
                this.getMaturity()
        );
    }


}
