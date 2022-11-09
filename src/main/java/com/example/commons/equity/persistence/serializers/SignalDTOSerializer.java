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

        //jsonObject.add("ID SIGNAL",jsonSerializationContext.serialize(signalDTO.signalId(),Long.class));
        jsonObject.add("TIMESTAMP",jsonSerializationContext.serialize(signalDTO.timestamp(), LocalDateTime.class));
        jsonObject.add("TRADEDATE",jsonSerializationContext.serialize(signalDTO.tradeDate(), LocalDate.class));
        jsonObject.add("UNDERLYING",jsonSerializationContext.serialize(signalDTO.underlying(),String.class));
        jsonObject.add("TICKER FUTURE",jsonSerializationContext.serialize(signalDTO.tickerFuture(),String.class));
        jsonObject.add("BUY/SELL",jsonSerializationContext.serialize(signalDTO.buySell(),String.class));
        jsonObject.add("QUANTITY",jsonSerializationContext.serialize(signalDTO.quantity(),Integer.class));
        jsonObject.add("THEORETICAL PRICE",jsonSerializationContext.serialize(signalDTO.theoreticalPrice(),Double.class));

        return jsonObject;
    }
}
