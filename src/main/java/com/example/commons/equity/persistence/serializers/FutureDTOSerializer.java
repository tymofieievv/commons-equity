package com.example.commons.equity.persistence.serializers;

import com.example.commons.equity.model.dto.input.FutureDTO;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

public class FutureDTOSerializer implements JsonSerializer<FutureDTO> {
    @Override
    public JsonElement serialize(FutureDTO futureDTO, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject jsonObject = new JsonObject();

        jsonObject.add("RIC", jsonSerializationContext.serialize(futureDTO.getRic(), String.class));
        jsonObject.add("TIMESTAMP", jsonSerializationContext.serialize(futureDTO.getTimestamp(), LocalDateTime.class));
        jsonObject.add("PRICE_CLOSE", jsonSerializationContext.serialize(futureDTO.getPriceClose(), Double.class));
        jsonObject.add("PRICE_LOW", jsonSerializationContext.serialize(futureDTO.getPriceLow(), Double.class));
        jsonObject.add("PRICE_HIGH", jsonSerializationContext.serialize(futureDTO.getPriceOpen(), Double.class));
        jsonObject.add("PRICE_OPEN", jsonSerializationContext.serialize(futureDTO.getPriceHigh(), Double.class));
        jsonObject.add("VOLUME", jsonSerializationContext.serialize(futureDTO.getVolume(), Integer.class));

        return jsonObject;
    }
}
