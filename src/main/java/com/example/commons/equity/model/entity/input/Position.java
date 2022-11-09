package com.example.commons.equity.model.entity.input;

import com.example.commons.equity.model.dto.input.PositionDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "SSL0_IXP_POSITION")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime refDate;
    private String portfolioId;
    private String instrumentId;
    private String positionId;
    private String family;
    private String group;
    private String type;
    private String currency;
    private Integer position;
    private String entity;
    private String division;
    private String marketName;

    public PositionDTO toDTO() {
        return new PositionDTO(
                this.getRefDate(),
                this.getPortfolioId(),
                this.getInstrumentId(),
                this.getPositionId(),
                this.getFamily(),
                this.getGroup(),
                this.getType(),
                this.getCurrency(),
                this.getPosition(),
                this.getEntity(),
                this.getDivision(),
                this.getMarketName()
        );
    }


}
