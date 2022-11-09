package com.example.commons.equity.persistence.serializers;

import com.example.commons.equity.model.dto.output.StrategyPerformanceDTO;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

public class StrategyPerformanceDTOSerializer implements JsonSerializer<StrategyPerformanceDTO> {
    @Override
    public JsonElement serialize(StrategyPerformanceDTO strategyPerformanceDTO, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject jsonObject = new JsonObject();

        jsonObject.add("TIMESTAMP",jsonSerializationContext.serialize(strategyPerformanceDTO.timestamp(), LocalDateTime.class));
        jsonObject.add("TRADE DATE",jsonSerializationContext.serialize(strategyPerformanceDTO.tradeDate(),LocalDateTime.class));
        jsonObject.add("SHARP",jsonSerializationContext.serialize(strategyPerformanceDTO.sharp(),Double.class));
        jsonObject.add("SORTINO",jsonSerializationContext.serialize(strategyPerformanceDTO.sortino(),Double.class));
        jsonObject.add("MAXDRAWDOWN",jsonSerializationContext.serialize(strategyPerformanceDTO.maxdrawdown(),Double.class));
        jsonObject.add("P&L",jsonSerializationContext.serialize(strategyPerformanceDTO.pL(),Double.class));

        return jsonObject;
    }
}
