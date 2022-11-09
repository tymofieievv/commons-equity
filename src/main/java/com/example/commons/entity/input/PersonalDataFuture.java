package com.example.commons.entity.input;

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

@Entity(name="SSL0_IXP_FUTURE_ANAGRAPHIC")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonalDataFuture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isin;
    private String ticker;
    private String description;
    private String currency;
    private LocalDate maturity;

//    public PersonalDataFuture buildFromDto(PersonalDataFutureDTO dailyPersonalDataDTO) {
//
//        PersonalDataFuture personalDataFuture = new PersonalDataFuture();
//        personalDataFuture.setIsin(dailyPersonalDataDTO.isin());
//        personalDataFuture.setDescription(dailyPersonalDataDTO.description());
//        personalDataFuture.setCurrency(dailyPersonalDataDTO.currency());
//        personalDataFuture.setMaturity(dailyPersonalDataDTO.maturity());
//        return personalDataFuture;
//
//    }


}
