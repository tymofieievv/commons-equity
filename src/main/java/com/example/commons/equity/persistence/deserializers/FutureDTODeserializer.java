package com.example.commons.equity.persistence.deserializers;

import com.example.commons.equity.model.dto.input.FutureDTO;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class FutureDTODeserializer implements JsonDeserializer<FutureDTO> {
    @Override
    public FutureDTO deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonElement ric = ((JsonObject) jsonElement).get("RIC");
        JsonElement timestamp = ((JsonObject) jsonElement).get("TIMESTAMP");
        JsonElement priceClose = ((JsonObject) jsonElement).get("PRICE_CLOSE");
        JsonElement priceLow = ((JsonObject) jsonElement).get("PRICE_LOW");
        JsonElement priceHigh = ((JsonObject) jsonElement).get("PRICE_HIGH");
        JsonElement priceOpen = ((JsonObject) jsonElement).get("PRICE_OPEN");
        JsonElement volume = ((JsonObject) jsonElement).get("VOLUME");

        return new FutureDTO(
                jsonDeserializationContext.deserialize(ric, String.class),
                jsonDeserializationContext.deserialize(timestamp, LocalDateTime.class),
                jsonDeserializationContext.deserialize(priceClose, Double.class),
                jsonDeserializationContext.deserialize(priceLow, Double.class),
                jsonDeserializationContext.deserialize(priceHigh, Double.class),
                jsonDeserializationContext.deserialize(priceOpen, Double.class),
                jsonDeserializationContext.deserialize(volume, Integer.class));
    }
}
