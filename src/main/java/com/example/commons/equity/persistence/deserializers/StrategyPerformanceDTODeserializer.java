package com.example.commons.equity.persistence.deserializers;

import com.example.commons.equity.model.dto.output.OrderDTO;
import com.example.commons.equity.model.dto.output.StrategyPerformanceDTO;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

public class StrategyPerformanceDTODeserializer implements JsonDeserializer<StrategyPerformanceDTO> {
    @Override
    public StrategyPerformanceDTO deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonElement timestamp = ((JsonObject) jsonElement).get("TIMESTAMP");
        JsonElement tradeDate = ((JsonObject) jsonElement).get("TRADE DATE");
        JsonElement sharp = ((JsonObject) jsonElement).get("SHARP");
        JsonElement sortino = ((JsonObject) jsonElement).get("SORTINO");
        JsonElement maxdrawdown = ((JsonObject) jsonElement).get("MAXDRAWDOWN");
        JsonElement pL = ((JsonObject) jsonElement).get("P&L");

        return new StrategyPerformanceDTO(
                jsonDeserializationContext.deserialize(timestamp, LocalDateTime.class),
                jsonDeserializationContext.deserialize(tradeDate, LocalDateTime.class),
                jsonDeserializationContext.deserialize(sharp, Double.class),
                jsonDeserializationContext.deserialize(sortino, Double.class),
                jsonDeserializationContext.deserialize(maxdrawdown, Double.class),
                jsonDeserializationContext.deserialize(pL, Double.class)
        );
    }
}
