package com.example.commons.equity.model.dto.input;

import com.example.commons.equity.model.entity.input.Index;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IndexDTO {

    private LocalDate refDate;
    private LocalTime time;
    private Double price;
    private String instrumentId;
    private String securityDescription;

    public Index toEntity() {

        Index index = new Index();
        index.setRefDate(this.refDate);
        index.setTime(this.time);
        index.setPrice(this.price);
        index.setInstrumentId(this.instrumentId);
        index.setSecurityDescription(this.securityDescription);

        return index;
    }
}
