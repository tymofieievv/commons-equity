package com.example.commons.equity.model.dto.input;

import com.example.commons.equity.model.entity.input.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PositionDTO {
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


    public Position toEntity() {
        Position position = new Position();

        position.setRefDate(this.refDate);
        position.setPortfolioId(this.portfolioId);
        position.setInstrumentId(this.instrumentId);
        position.setFamily(this.family);
        position.setGroup(this.group);
        position.setType(this.type);
        position.setCurrency(this.currency);
        position.setPosition(this.position);
        position.setPositionId(this.positionId);
        position.setEntity(this.entity);
        position.setDivision(this.division);
        position.setMarketName(this.marketName);

        return position;
    }
}
