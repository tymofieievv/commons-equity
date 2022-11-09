package com.example.commons.equity.model.entity.output;

import com.example.commons.equity.model.enums.Operations;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name="VIS10_API_ORDER")
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
    private Operations operations;
    private Integer quantity;
    private Integer livePosition;
    private Double theoreticalPrice;
//
//    public OrderDTO buildFromDto(Order order){
//
//        OrderDTO orderDTO = new OrderDTO(
//                order.getIdOrder(),
//                order.getIdSignal(),
//                order.getTimestamp(),
//                order.getTradeDate(),
//                order.getUnderlying(),
//                order.getTickerFuture(),
//                order.getStatus(),
//                order.getOperations().toString(),
//                order.getPosition(),
//                order.getTheoreticalPrice(),
//                order.getTheoreticalPosition(),
//                order.getExecutedPrice(),
//                order.getDeltaPrice()
//        );
//
//        return orderDTO;
//    }
}
