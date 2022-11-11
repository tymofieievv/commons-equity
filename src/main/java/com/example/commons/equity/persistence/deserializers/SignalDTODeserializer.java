package com.example.commons.equity.persistence.deserializers;

import com.example.commons.equity.model.dto.output.SignalDTO;
import com.example.commons.equity.model.enums.Operation;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SignalDTODeserializer implements JsonDeserializer<SignalDTO> {
    @Override
    public SignalDTO deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonElement timestamp = ((JsonObject) jsonElement).get("TIMESTAMP");
        JsonElement tradeDate = ((JsonObject) jsonElement).get("TRADEDATE");
        JsonElement underlying = ((JsonObject) jsonElement).get("UNDERLYING");
        JsonElement idSignal = ((JsonObject) jsonElement).get("ID SIGNAL");
        JsonElement tickerFuture = ((JsonObject) jsonElement).get("TICKER FUTURE");
        JsonElement buySell = ((JsonObject) jsonElement).get("BUY/SELL");
        JsonElement quantity = ((JsonObject) jsonElement).get("QUANTITY");
        JsonElement theoreticalPrice = ((JsonObject) jsonElement).get("THEORETICAL PRICE");


        return new SignalDTO(
                jsonDeserializationContext.deserialize(idSignal, Long.class),
                jsonDeserializationContext.deserialize(timestamp, LocalDateTime.class),
                jsonDeserializationContext.deserialize(tradeDate, LocalDate.class),
                jsonDeserializationContext.deserialize(underlying, String.class),
                jsonDeserializationContext.deserialize(tickerFuture, String.class),
                jsonDeserializationContext.deserialize(buySell, Operation.class),
                jsonDeserializationContext.deserialize(quantity, Integer.class),
                jsonDeserializationContext.deserialize(theoreticalPrice, Double.class)
        );
    }
}
