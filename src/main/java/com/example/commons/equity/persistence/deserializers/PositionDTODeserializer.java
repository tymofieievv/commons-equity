package com.example.commons.equity.persistence.deserializers;

import com.example.commons.equity.model.dto.input.PositionDTO;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

public class PositionDTODeserializer implements JsonDeserializer<PositionDTO> {
    @Override
    public PositionDTO deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonElement refDate = ((JsonObject) jsonElement).get("REF_DATE");
        JsonElement portfolioId = ((JsonObject) jsonElement).get("PORTFOLIO_ID");
        JsonElement instrumentId = ((JsonObject) jsonElement).get("INSTRUMENT_ID");
        JsonElement family = ((JsonObject) jsonElement).get("FAMILY");
        JsonElement group = ((JsonObject) jsonElement).get("GROUP");
        JsonElement typeJsonElement = ((JsonObject) jsonElement).get("TYPE");
        JsonElement currency = ((JsonObject) jsonElement).get("CURRENCY");
        JsonElement quantity = ((JsonObject) jsonElement).get("QUANTITY");
        JsonElement entity = ((JsonObject) jsonElement).get("ENTITY");
        JsonElement division = ((JsonObject) jsonElement).get("DIVISION");
        JsonElement marketName = ((JsonObject) jsonElement).get("MARKET_NAME");


        return new PositionDTO(
                jsonDeserializationContext.deserialize(refDate, LocalDateTime.class),
                jsonDeserializationContext.deserialize(portfolioId, String.class),
                jsonDeserializationContext.deserialize(instrumentId, String.class),
                jsonDeserializationContext.deserialize(family, String.class),
                jsonDeserializationContext.deserialize(group, String.class),
                jsonDeserializationContext.deserialize(typeJsonElement, String.class),
                jsonDeserializationContext.deserialize(currency, String.class),
                jsonDeserializationContext.deserialize(quantity, Integer.class),
                jsonDeserializationContext.deserialize(entity, String.class),
                jsonDeserializationContext.deserialize(division, String.class),
                jsonDeserializationContext.deserialize(marketName, String.class)
        );
    }
}
