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

        //jsonObject.add("ID ORDER",jsonSerializationContext.serialize(orderDTO.idOrder(),Long.class));
        jsonObject.add("ID SIGNAL",jsonSerializationContext.serialize(orderDTO.idSignal(),Long.class));
        jsonObject.add("TIMESTAMP",jsonSerializationContext.serialize(orderDTO.timestamp(), LocalDateTime.class));
        jsonObject.add("TRADEDATE",jsonSerializationContext.serialize(orderDTO.tradeDate(),LocalDateTime.class));
        jsonObject.add("UNDERLYING",jsonSerializationContext.serialize(orderDTO.underlying(),String.class));
        //jsonObject.add("PORTFOLIO_ID",jsonSerializationContext.serialize(orderDTO.idPortfolio(),String.class));
        jsonObject.add("TICKER FUTURE",jsonSerializationContext.serialize(orderDTO.tickerFuture(),String.class));
        jsonObject.add("STATUS",jsonSerializationContext.serialize(orderDTO.status(),String.class));
        jsonObject.add("BUY/SELL",jsonSerializationContext.serialize(orderDTO.buySell(),String.class));
        //jsonObject.add("THEORETICAL QUANTITY",jsonSerializationContext.serialize(orderDTO,Integer.class));
        //jsonObject.add("QUANTITY",jsonSerializationContext.serialize(orderDTO,Integer.class));
        jsonObject.add("THEORETICAL POSITION",jsonSerializationContext.serialize(orderDTO.theoreticalPosition(),Integer.class));
        //jsonObject.add("LIVE POSITION",jsonSerializationContext.serialize(orderDTO,Integer.class));
        jsonObject.add("THEORETICAL PRICE",jsonSerializationContext.serialize(orderDTO.theoreticalPrice(),Double.class));
        jsonObject.add("PREZZO EFFETTIVO",jsonSerializationContext.serialize(orderDTO.prezzoEseguito(),Double.class));
        jsonObject.add("DELTA PREZZO",jsonSerializationContext.serialize(orderDTO.deltaPrezzo(),Double.class));

        return jsonObject;
    }
}
