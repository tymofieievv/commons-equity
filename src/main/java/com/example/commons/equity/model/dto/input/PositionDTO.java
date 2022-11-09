package com.example.commons.equity.model.dto.input;

import com.example.commons.equity.model.entity.input.Position;

import java.time.LocalDateTime;

public record PositionDTO(LocalDateTime refDate,
                          String portfolioId,
                          String instrumentId,
                          String positionId,
                          String family,
                          String group,
                          String type,
                          String currency,
                          Integer position,
                          String entity,
                          String division,
                          String marketName
) {
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
