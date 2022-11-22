package com.example.commons.equity.model.dto.output;

import com.example.commons.equity.model.entity.output.Order;
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
public class OrderDTO {
    private Long idOrder;
    private Long idSignal;
    private LocalDateTime timestamp;
    private LocalDate tradeDate;
    private String underlying;
    private String portfolioId;
    private String tickerFuture;
    private String status;
    private Operation buySell;
    private Integer theoreticalQuantity;
    private Integer quantity;
    private Integer theoreticalPosition;
    private Integer livePosition;
    private Double theoreticalPrice;
    private Double executedPrice;
    private Double deltaPrice;

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
        order.setOperation(this.buySell);
        order.setLivePosition(this.livePosition);
        order.setTheoreticalPrice(this.theoreticalPrice);
        order.setTheoreticalQuantity(this.theoreticalQuantity);
        order.setTheoreticalPosition(this.theoreticalPosition);
        order.setExecutedPrice(this.deltaPrice);
        order.setDeltaPrice(this.executedPrice);

        return order;
    }
}
