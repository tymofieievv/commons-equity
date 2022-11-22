package com.example.commons.equity.persistence.serializers;

import com.example.commons.equity.model.dto.output.SignalDTO;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SignalDTOSerializer implements JsonSerializer<SignalDTO> {
    @Override
    public JsonElement serialize(SignalDTO signalDTO, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject jsonObject = new JsonObject();

        //jsonObject.add("ID SIGNAL",jsonSerializationContext.serialize(signalDTO.getSignalId(),Long.class));
        jsonObject.add("TIMESTAMP",jsonSerializationContext.serialize(signalDTO.getTimestamp(), LocalDateTime.class));
        jsonObject.add("TRADEDATE",jsonSerializationContext.serialize(signalDTO.getTradeDate(), LocalDate.class));
        jsonObject.add("UNDERLYING",jsonSerializationContext.serialize(signalDTO.getUnderlying(),String.class));
        jsonObject.add("TICKER FUTURE",jsonSerializationContext.serialize(signalDTO.getTickerFuture(),String.class));
        jsonObject.add("BUY/SELL",jsonSerializationContext.serialize(signalDTO.getBuySell(),String.class));
        jsonObject.add("QUANTITY",jsonSerializationContext.serialize(signalDTO.getQuantity(),Integer.class));
        jsonObject.add("THEORETICAL PRICE",jsonSerializationContext.serialize(signalDTO.getTheoreticalPrice(),Double.class));

        return jsonObject;
    }
}
