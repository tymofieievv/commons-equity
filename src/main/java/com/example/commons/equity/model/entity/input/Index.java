package com.example.commons.equity.model.entity.input;

import com.example.commons.equity.model.dto.input.IndexDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "REF0_KAFKA_INDEX")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Index {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime timestamp;
    private String instrumentId;
    private Double priceHigh;
    private Double priceLow;
    private Double priceClose;
    private Double priceOpen;

    public IndexDTO toDTO() {
        return new IndexDTO(
                this.getTimestamp(),
                this.getPriceOpen(),
                this.getInstrumentId(),
                this.getPriceLow(),
                this.getPriceHigh(),
                this.getPriceClose()
        );
    }


}
