package com.example.commons.equity.persistence.deserializers;

import com.example.commons.equity.model.dto.input.FutureDTO;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalTime;

public class FutureDTODeserializer implements JsonDeserializer<FutureDTO> {
    @Override
    public FutureDTO deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonElement refDate = ((JsonObject) jsonElement).get("REF_DATE");
        JsonElement isin = ((JsonObject) jsonElement).get("ISIN");
        JsonElement ticker = ((JsonObject) jsonElement).get("TICKER");
        JsonElement underlyingId = ((JsonObject) jsonElement).get("UNDERLYING_ID");
        JsonElement underlyingDescription = ((JsonObject) jsonElement).get("UNDERLYING_DESCRIPTION");
        JsonElement time = ((JsonObject) jsonElement).get("TIME");
        JsonElement priceClose = ((JsonObject) jsonElement).get("PRICE_CLOSE");
        JsonElement priceLow = ((JsonObject) jsonElement).get("PRICE_LOW");
        JsonElement priceHigh = ((JsonObject) jsonElement).get("PRICE_HIGH");
        JsonElement priceOpen = ((JsonObject) jsonElement).get("PRICE_OPEN");
        JsonElement volume = ((JsonObject) jsonElement).get("VOLUME");

        return new FutureDTO(
                jsonDeserializationContext.deserialize(refDate, LocalDate.class),
                jsonDeserializationContext.deserialize(isin, String.class),
                jsonDeserializationContext.deserialize(ticker, String.class),
                jsonDeserializationContext.deserialize(underlyingId, String.class),
                jsonDeserializationContext.deserialize(underlyingDescription, String.class),
                jsonDeserializationContext.deserialize(time, LocalTime.class),
                jsonDeserializationContext.deserialize(priceClose, Double.class),
                jsonDeserializationContext.deserialize(priceLow, Double.class),
                jsonDeserializationContext.deserialize(priceHigh, Double.class),
                jsonDeserializationContext.deserialize(priceOpen, Double.class),
                jsonDeserializationContext.deserialize(volume, Integer.class));
    }
}
