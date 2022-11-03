package com.example.commons.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IntradayPersonalData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate refDate;
    private String instrumentId;
    private String securityDescription;
    private LocalTime time;
    private Double price;
    private int priceClose;
    private int priceOpen;
    private String priceLow;
    private String priceHigh;
    private int volume;

/*
    public static DailyPersonalData buildFromDto(DailyPersonalDataDTO dailyPersonalDataDTO) {
        DailyPersonalData dailyPersonalData = new DailyPersonalData();
        dailyPersonalData.setId(dailyPersonalDataDTO.getId());
        dailyPersonalData.setRefDate(dailyPersonalDataDTO.getRefDate());
        dailyPersonalData.setInstrumentId(dailyPersonalDataDTO.getInstrumentId());
        dailyPersonalData.setSecurityDescription(dailyPersonalDataDTO.getSecurityDescription());
        dailyPersonalData.setTime(dailyPersonalDataDTO.getTime());
        dailyPersonalData.setPrice(dailyPersonalDataDTO.getTime());
        return dailyPersonalData;
    }
 */

}
