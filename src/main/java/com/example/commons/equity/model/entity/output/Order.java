package com.example.commons.equity.model.entity.output;

import com.example.commons.equity.model.dto.output.OrderDTO;
import com.example.commons.equity.model.enums.Operations;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "VIS10_API_ORDER")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime timestamp;
    private LocalDate tradeDate;
    private String underlying;
    private Long idSignal;
    private Long idOrder;
    private String portfolioId;
    private Integer theoreticalPosition;
    private Integer theoreticalQuantity;
    private Double executedPrice;
    private String status;
    private Double deltaPrice;
    private String tickerFuture;
    @Enumerated(EnumType.STRING)
    private Operations buysell;
    private Integer quantity;
    private Integer livePosition;
    private Double theoreticalPrice;

    public OrderDTO toDto() {
        return new OrderDTO(
                this.getIdOrder(),
                this.getIdSignal(),
                this.getTimestamp(),
                this.getTradeDate(),
                this.getUnderlying(),
                this.getPortfolioId(),
                this.getTickerFuture(),
                this.getStatus(),
                this.getBuysell().name(),
                this.getTheoreticalQuantity(),
                this.getQuantity(),
                this.getTheoreticalPosition(),
                this.getLivePosition(),
                this.getTheoreticalPrice(),
                this.getExecutedPrice(),
                this.getDeltaPrice()
        );
    }
}
