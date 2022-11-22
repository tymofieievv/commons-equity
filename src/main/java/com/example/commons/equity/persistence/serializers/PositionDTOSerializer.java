package com.example.commons.equity.persistence.serializers;

import com.example.commons.equity.model.dto.input.PositionDTO;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.LocalDate;

public class PositionDTOSerializer implements JsonSerializer<PositionDTO> {
    @Override
    public JsonElement serialize(PositionDTO positionDTO, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject jsonObject = new JsonObject();

        jsonObject.add("REF_DATE", jsonSerializationContext.serialize(positionDTO.getRefDate(), LocalDate.class));
        jsonObject.add("PORTFOLIO_ID", jsonSerializationContext.serialize(positionDTO.getPortfolioId(), String.class));
        jsonObject.add("INSTRUMENT_ID", jsonSerializationContext.serialize(positionDTO.getInstrumentId(), String.class));
        jsonObject.add("POSITION_ID", jsonSerializationContext.serialize(positionDTO.getPositionId(), String.class));
        jsonObject.add("FAMILY", jsonSerializationContext.serialize(positionDTO.getFamily(), String.class));
        jsonObject.add("GROUP", jsonSerializationContext.serialize(positionDTO.getGroup(), String.class));
        jsonObject.add("TYPE", jsonSerializationContext.serialize(positionDTO.getType(), String.class));
        jsonObject.add("CURRENCY", jsonSerializationContext.serialize(positionDTO.getCurrency(), String.class));
        jsonObject.add("POSITION", jsonSerializationContext.serialize(positionDTO.getPosition(), Integer.class));
        jsonObject.add("ENTITY", jsonSerializationContext.serialize(positionDTO.getEntity(), String.class));
        jsonObject.add("DIVISION", jsonSerializationContext.serialize(positionDTO.getDivision(), String.class));
        jsonObject.add("MARKET_NAME", jsonSerializationContext.serialize(positionDTO.getMarketName(), String.class));

        return jsonObject;
    }
}
