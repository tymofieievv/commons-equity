package com.example.commons.equity.model.entity.input;

import com.example.commons.equity.model.dto.input.DailyFutureDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity(name = "REF0_API_FUTURE_DAILY")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DailyFuture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate refDate;
    private String ric;
    private Double priceClose;
    private Double priceLow;
    private Double priceOpen;
    private Double priceHigh;
    private Integer volume;

    public DailyFutureDTO toDTO() {
        return new DailyFutureDTO(

                this.getRefDate(),
                this.getRic(),
                this.getPriceClose(),
                this.getPriceLow(),
                this.getPriceOpen(),
                this.getPriceHigh(),
                this.getVolume()
        );
    }

}
