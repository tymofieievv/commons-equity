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
import java.time.LocalDate;

@Entity(name="SSL0_IXP_POSITION")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate refDate;
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

//    public Position buildFromDTO(PositionDTO positionDTO){
//        Position position = new Position();
//        position.setRefDate(positionDTO.refDate());
//        position.setPortfolioId(positionDTO.portfolioId());
//        position.setInstrumentId(positionDTO.instrumentId());
//        position.setFamily(positionDTO.family());
//        position.setGroup(positionDTO.group());
//        position.setType(positionDTO.type());
//        position.setCurrency(positionDTO.currency());
//        position.setQuantity(positionDTO.quantity());
//        position.setEntity(positionDTO.entity());
//        position.setDivision(positionDTO.division());
//        position.setMarketName(positionDTO.marketName());
//
//
//        return position;
//    }
}
