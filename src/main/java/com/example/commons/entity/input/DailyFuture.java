package com.example.commons.entity.input;

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

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DailyFuture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate refDate;
    private String isin;
    private String ticker;
    private Double priceClose;
    private Double priceLow;
    private Double priceOpen;
    private Double priceHigh;
    private Integer volume;

    public DailyFuture buildFromDTO(DailyFutureDTO dailyFutureDTO) {

        DailyFuture dailyFuture = new DailyFuture();

        dailyFuture.setRefDate(dailyFutureDTO.refDate());
        dailyFuture.setIsin(dailyFutureDTO.isin());
        dailyFuture.setTicker(dailyFutureDTO.ticker());
        dailyFuture.setPriceClose(dailyFutureDTO.priceClose());
        dailyFuture.setPriceLow(dailyFutureDTO.priceLow());
        dailyFuture.setPriceHigh(dailyFutureDTO.priceHigh());
        dailyFuture.setPriceOpen(dailyFutureDTO.priceOpen());
        dailyFuture.setPriceClose(dailyFutureDTO.priceLow());
        dailyFuture.setVolume(dailyFutureDTO.volume());

        return dailyFuture;
    }
}
