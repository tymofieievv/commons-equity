package com.example.commons.equity.persistence.deserializers;

import com.example.commons.equity.model.dto.output.OrderDTO;
import com.example.commons.equity.model.enums.Operation;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrderDTODeserializer implements JsonDeserializer<OrderDTO> {
    @Override
    public OrderDTO deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonElement timestamp = ((JsonObject) jsonElement).get("TIMESTAMP");
        JsonElement tradeDate = ((JsonObject) jsonElement).get("TRADEDATE");
        JsonElement underlying = ((JsonObject) jsonElement).get("UNDERLYING");
        JsonElement portfolioId = ((JsonObject) jsonElement).get("PORTFOLIO_ID");
        JsonElement idSignal = ((JsonObject) jsonElement).get("ID SIGNAL");
        JsonElement idOrder = ((JsonObject) jsonElement).get("ID ORDER");
        JsonElement tickerFuture = ((JsonObject) jsonElement).get("TICKER FUTURE");
        JsonElement status = ((JsonObject) jsonElement).get("STATUS");
        JsonElement buySell = ((JsonObject) jsonElement).get("BUY/SELL");
        JsonElement theoreticalQuantity = ((JsonObject) jsonElement).get("THEORETICAL_QUANTITY");
        JsonElement quantity = ((JsonObject) jsonElement).get("QUANTITY");
        JsonElement theoreticalPosition = ((JsonObject) jsonElement).get("THEORETICAL POSITION");
        JsonElement position = ((JsonObject) jsonElement).get("LIVE_POSITION");
        JsonElement theoreticalPrice = ((JsonObject) jsonElement).get("THEORETICAL PRICE");
        JsonElement executedPrice = ((JsonObject) jsonElement).get("EXECUTED PRICE");
        JsonElement deltaPrice = ((JsonObject) jsonElement).get("DELTA PRICE");

        return new OrderDTO(
                jsonDeserializationContext.deserialize(idOrder, Long.class),
                jsonDeserializationContext.deserialize(idSignal, Long.class),
                jsonDeserializationContext.deserialize(timestamp, LocalDateTime.class),
                jsonDeserializationContext.deserialize(tradeDate, LocalDate.class),
                jsonDeserializationContext.deserialize(underlying, String.class),
                jsonDeserializationContext.deserialize(portfolioId, String.class),
                jsonDeserializationContext.deserialize(tickerFuture, String.class),
                jsonDeserializationContext.deserialize(status, String.class),
                jsonDeserializationContext.deserialize(buySell, Operation.class),
                jsonDeserializationContext.deserialize(theoreticalQuantity, Integer.class),
                jsonDeserializationContext.deserialize(quantity, Integer.class),
                jsonDeserializationContext.deserialize(theoreticalPosition, Integer.class),
                jsonDeserializationContext.deserialize(position, Integer.class),
                jsonDeserializationContext.deserialize(theoreticalPrice, Double.class),
                jsonDeserializationContext.deserialize(executedPrice, Double.class),
                jsonDeserializationContext.deserialize(deltaPrice, Double.class)
        );
    }
}
