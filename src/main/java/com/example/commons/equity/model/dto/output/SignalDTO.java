package com.example.commons.equity.model.dto.output;

import com.example.commons.equity.model.entity.output.Signal;
import com.example.commons.equity.model.enums.Operation;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record SignalDTO(
        Long signalId,
        LocalDateTime timestamp,
        LocalDate tradeDate,
        String underlying,
        String tickerFuture,
        Operation buySell,
        Integer quantity,
        Double theoreticalPrice
) {
    public Signal toEntity() {

        Signal signal = new Signal();

        signal.setIdSignal(this.signalId());
        signal.setBuySell(this.buySell());
        signal.setQuantity(this.quantity());
        signal.setTimestamp(this.timestamp());
        signal.setTickerFuture(this.tickerFuture());
        signal.setTheoreticalPrice(this.theoreticalPrice());
        signal.setTradeDate(this.tradeDate());
        signal.setUnderlying(this.underlying());

        return signal;
    }
}
