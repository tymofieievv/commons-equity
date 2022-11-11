package com.example.commons.equity.model.dto.output;

import com.example.commons.equity.model.entity.output.Signal;
import com.example.commons.equity.model.enums.Operations;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record SignalDTO(
        Long signalId,
        LocalDate timestamp,
        LocalDateTime tradeDate,
        String underlying,
        String tickerFuture,
        String buySell,
        Integer quantity,
        Double theoreticalPrice
) {
    public Signal toEntity() {

        Signal signal = new Signal();

        signal.setIdSignal(this.signalId());
        signal.setBuySell(Operations.valueOf(this.buySell()));
        signal.setQuantity(this.quantity());
        signal.setTimestamp(this.timestamp());
        signal.setTickerFuture(this.tickerFuture());
        signal.setTheoreticalPrice(this.theoreticalPrice());
        signal.setTradeDate(this.tradeDate());
        signal.setUnderlying(this.underlying());

        return signal;
    }
}
