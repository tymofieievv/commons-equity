package com.example.commons.equity.model.dto.output;

import com.example.commons.equity.model.entity.output.Signal;
import com.example.commons.equity.model.enums.Operation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SignalDTO {
    private Long signalId;
    private LocalDateTime timestamp;
    private LocalDate tradeDate;
    private String underlying;
    private String tickerFuture;
    private Operation buySell;
    private Integer quantity;
    private Double theoreticalPrice;

    public Signal toEntity() {

        Signal signal = new Signal();

        signal.setIdSignal(this.signalId);
        signal.setBuySell(this.buySell);
        signal.setQuantity(this.quantity);
        signal.setTimestamp(this.timestamp);
        signal.setTickerFuture(this.tickerFuture);
        signal.setTheoreticalPrice(this.theoreticalPrice);
        signal.setTradeDate(this.tradeDate);
        signal.setUnderlying(this.underlying);

        return signal;
    }
}
