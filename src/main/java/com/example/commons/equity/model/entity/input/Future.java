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
    private String isin;
    private String ticker;
    private LocalTime time;
    private String underlyingId;
    private String underlyingDescription;
    private Double priceClose;
    private Double priceOpen;
    private Double priceLow;
    private Double priceHigh;
    private Integer volume;

    public FutureDTO toDTO() {
        return new FutureDTO(
                this.getRefDate(),
                this.getIsin(),
                this.getTicker(),
                this.getUnderlyingId(),
                this.getUnderlyingDescription(),
                this.getTime(),
                this.getPriceClose(),
                this.getPriceOpen(),
                this.getPriceLow(),
                this.getPriceHigh(),
                this.getVolume()
        );
    }

}
