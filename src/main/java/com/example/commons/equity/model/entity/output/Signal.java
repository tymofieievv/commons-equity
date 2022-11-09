package com.example.commons.equity.model.entity.output;

import com.example.commons.equity.model.dto.output.SignalDTO;
import com.example.commons.equity.model.enums.Operations;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "VIS10_API_SIGNAL")
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

    public SignalDTO toDTO() {
        return new SignalDTO(
                this.getIdSignal(),
                this.getTimestamp(),
                this.getTradeDate(),
                this.getUnderlying(),
                this.getTicketFuture(),
                this.operations.name(),
                this.getQuantity(),
                this.getTheoreticalPrice()
        );
    }


}
