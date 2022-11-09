package com.example.commons.entity.output;

import com.example.commons.enums.Operations;
import com.example.commons.equity.model.dto.output.SignalDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name="VIS10_API_SIGNAL")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Signal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime timestamp;
    private LocalDate tradeDate;
    private String underlying;
    private Long idSignal;
    private String ticketFuture;
    @Enumerated(EnumType.STRING)
    private Operations operations;
    private Integer quantity;
    private Double theoreticalPrice;

//    public Signal buildFromDTO(SignalDTO signalDTO) {
//        Signal signal = new Signal();
//
//        signal.setIdSignal(signalDTO.signalId());
//        //signal.setOperations(signalDTO.buySell());
//        signal.setQuantity(signalDTO.quantity());
//        signal.setTimestamp(signalDTO.timestamp());
//        signal.setTicketFuture(signalDTO.tickerFuture());
//        signal.setTheoreticalPrice(signalDTO.theoreticalPrice());
//        signal.setTradeDate(signalDTO.tradeDate());
//        signal.setUnderlying(signalDTO.underlying());
//
//        return signal;
//    }


}