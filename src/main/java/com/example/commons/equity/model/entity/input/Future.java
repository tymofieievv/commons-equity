package com.example.commons.equity.model.entity.input;

import com.example.commons.equity.model.dto.input.FutureDTO;
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

@Entity(name = "REF0_KAFKA_FUTURE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Future {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate refDate;
    private LocalTime time;
    private String ric;
    private Double priceClose;
    private Double priceOpen;
    private Double priceLow;
    private Double priceHigh;
    private Integer volume;

    public FutureDTO toDTO() {
        return new FutureDTO(
                this.getRefDate(),
                this.getRic(),
                this.getTime(),
                this.getPriceClose(),
                this.getPriceOpen(),
                this.getPriceLow(),
                this.getPriceHigh(),
                this.getVolume()
        );
    }

}
