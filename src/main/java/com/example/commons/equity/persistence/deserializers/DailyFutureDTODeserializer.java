package com.example.commons.equity.persistence.deserializers;

import com.example.commons.equity.model.dto.input.DailyFutureDTO;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

public class DailyFutureDTODeserializer implements JsonDeserializer<DailyFutureDTO> {

    @Override
    public DailyFutureDTO deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonElement refDate = ((JsonObject) jsonElement).get("REF_DATE");
        JsonElement isin = ((JsonObject) jsonElement).get("ISIN");
        JsonElement ticker = ((JsonObject) jsonElement).get("TICKER");
        JsonElement priceClose = ((JsonObject) jsonElement).get("PRICE_CLOSE");
        JsonElement priceLow = ((JsonObject) jsonElement).get("PRICE_LOW");
        JsonElement priceHigh = ((JsonObject) jsonElement).get("PRICE_HIGH");
        JsonElement priceOpen = ((JsonObject) jsonElement).get("PRICE_OPEN");
        JsonElement volume = ((JsonObject) jsonElement).get("VOLUME");

        return new DailyFutureDTO(
                jsonDeserializationContext.deserialize(refDate, LocalDate.class),
                jsonDeserializationContext.deserialize(isin, String.class),
                jsonDeserializationContext.deserialize(ticker, String.class),
                jsonDeserializationContext.deserialize(priceClose, Double.class),
                jsonDeserializationContext.deserialize(priceLow, Double.class),
                jsonDeserializationContext.deserialize(priceOpen, Double.class),
                jsonDeserializationContext.deserialize(priceHigh, Double.class),
                jsonDeserializationContext.deserialize(volume, Integer.class)
        );
    }
}
