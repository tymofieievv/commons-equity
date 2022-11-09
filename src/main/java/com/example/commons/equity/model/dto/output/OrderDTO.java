package com.example.commons.equity.model.dto.output;

import com.example.commons.equity.model.entity.output.Order;
import com.example.commons.equity.model.enums.Operations;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record OrderDTO(
        Long idOrder,
        Long idSignal,
        LocalDateTime timestamp,
        LocalDate tradeDate,
        String underlying,
        String portfolioId,
        String tickerFuture,
        String status,
        String buySell,
        Integer theoreticalQuantity,
        Integer quantity,
        Integer theoreticalPosition,
        Integer livePosition,
        Double theoreticalPrice,
        Double prezzoEseguito,
        Double deltaPrezzo
) {

    public Order toEntity() {

        Order order = new Order();

        order.setIdOrder(this.idOrder);
        order.setIdSignal(this.idSignal);
        order.setPortfolioId(this.portfolioId);
        order.setTimestamp(this.timestamp);
        order.setTradeDate(this.tradeDate);
        order.setUnderlying(this.underlying);
        order.setTickerFuture(this.tickerFuture);
        order.setQuantity(this.quantity);
        order.setStatus(this.status);
        order.setBuysell(Operations.valueOf(this.buySell));
        order.setLivePosition(this.livePosition);
        order.setTheoreticalPrice(this.theoreticalPrice);
        order.setTheoreticalQuantity(this.theoreticalQuantity);
        order.setTheoreticalPosition(this.theoreticalPosition);
        order.setExecutedPrice(this.prezzoEseguito);
        order.setDeltaPrice(this.deltaPrezzo);

        return order;
    }
}
