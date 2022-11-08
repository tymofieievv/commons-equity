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

        jsonObject.add("REF_DATE", jsonSerializationContext.serialize(positionDTO.refDate(), LocalDate.class));
        jsonObject.add("PORTFOLIO_ID", jsonSerializationContext.serialize(positionDTO.portfolioId(), String.class));
        jsonObject.add("INSTRUMENT_ID", jsonSerializationContext.serialize(positionDTO.instrumentId(), String.class));
        jsonObject.add("POSITION_ID", jsonSerializationContext.serialize(positionDTO.positionId(), String.class));
        jsonObject.add("FAMILY", jsonSerializationContext.serialize(positionDTO.family(), String.class));
        jsonObject.add("GROUP", jsonSerializationContext.serialize(positionDTO.group(), String.class));
        jsonObject.add("TYPE", jsonSerializationContext.serialize(positionDTO.type(), String.class));
        jsonObject.add("CURRENCY", jsonSerializationContext.serialize(positionDTO.currency(), String.class));
        jsonObject.add("POSITION", jsonSerializationContext.serialize(positionDTO.position(), Integer.class));
        jsonObject.add("ENTITY", jsonSerializationContext.serialize(positionDTO.entity(), String.class));
        jsonObject.add("DIVISION", jsonSerializationContext.serialize(positionDTO.division(), String.class));
        jsonObject.add("MARKET_NAME", jsonSerializationContext.serialize(positionDTO.marketName(), String.class));

        return jsonObject;
    }
}
