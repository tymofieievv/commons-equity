package com.example.commons.equity.persistence.serializers;

import com.example.commons.equity.model.dto.output.OrderDTO;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

public class OrderDTOSerializer implements JsonSerializer<OrderDTO> {
    @Override
    public JsonElement serialize(OrderDTO orderDTO, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject jsonObject = new JsonObject();

        //jsonObject.add("ID ORDER",jsonSerializationContext.serialize(orderDTO.getIdOrder(),Long.class));
        jsonObject.add("ID SIGNAL",jsonSerializationContext.serialize(orderDTO.getIdSignal(),Long.class));
        jsonObject.add("TIMESTAMP",jsonSerializationContext.serialize(orderDTO.getTimestamp(), LocalDateTime.class));
        jsonObject.add("TRADEDATE",jsonSerializationContext.serialize(orderDTO.getTradeDate(),LocalDateTime.class));
        jsonObject.add("UNDERLYING",jsonSerializationContext.serialize(orderDTO.getUnderlying(),String.class));
        jsonObject.add("PORTFOLIO_ID",jsonSerializationContext.serialize(orderDTO.getPortfolioId(),String.class));
        jsonObject.add("TICKER FUTURE",jsonSerializationContext.serialize(orderDTO.getTickerFuture(),String.class));
        jsonObject.add("STATUS",jsonSerializationContext.serialize(orderDTO.getStatus(),String.class));
        jsonObject.add("BUY/SELL",jsonSerializationContext.serialize(orderDTO.getBuySell(),String.class));
        jsonObject.add("THEORETICAL QUANTITY",jsonSerializationContext.serialize(orderDTO.getTheoreticalQuantity(),Integer.class));
        jsonObject.add("QUANTITY",jsonSerializationContext.serialize(orderDTO.getQuantity(),Integer.class));
        jsonObject.add("THEORETICAL POSITION",jsonSerializationContext.serialize(orderDTO.getTheoreticalPosition(),Integer.class));
        jsonObject.add("LIVE POSITION",jsonSerializationContext.serialize(orderDTO.getLivePosition(),Integer.class));
        jsonObject.add("THEORETICAL PRICE",jsonSerializationContext.serialize(orderDTO.getTheoreticalPrice(),Double.class));
        jsonObject.add("PREZZO EFFETTIVO",jsonSerializationContext.serialize(orderDTO.getExecutedPrice(),Double.class));
        jsonObject.add("DELTA PREZZO",jsonSerializationContext.serialize(orderDTO.getDeltaPrice(),Double.class));

        return jsonObject;
    }
}
