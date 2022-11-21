package com.example.commons.equity.persistence.serializers;

import com.example.commons.equity.model.dto.input.FutureDTO;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalTime;

public class FutureDTOSerializer implements JsonSerializer<FutureDTO> {
    @Override
    public JsonElement serialize(FutureDTO futureDTO, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject jsonObject = new JsonObject();

        jsonObject.add("REF_DATE", jsonSerializationContext.serialize(futureDTO.getRefDate(), LocalDate.class));
        jsonObject.add("ISIN", jsonSerializationContext.serialize(futureDTO.getIsin(), String.class));
        jsonObject.add("TICKER", jsonSerializationContext.serialize(futureDTO.getTicker(), String.class));
        jsonObject.add("UNDERLYING_ID", jsonSerializationContext.serialize(futureDTO.getUnderlyingId(), String.class));
        jsonObject.add("UNDERLYING_DESCRIPTION", jsonSerializationContext.serialize(futureDTO.getUnderlyingDescription(), String.class));
        jsonObject.add("TIME", jsonSerializationContext.serialize(futureDTO.getTime(), LocalTime.class));
        jsonObject.add("PRICE_CLOSE", jsonSerializationContext.serialize(futureDTO.getPriceClose(), Double.class));
        jsonObject.add("PRICE_LOW", jsonSerializationContext.serialize(futureDTO.getPriceLow(), Double.class));
        jsonObject.add("PRICE_HIGH", jsonSerializationContext.serialize(futureDTO.getPriceOpen(), Double.class));
        jsonObject.add("PRICE_OPEN", jsonSerializationContext.serialize(futureDTO.getPriceHigh(), Double.class));
        jsonObject.add("VOLUME", jsonSerializationContext.serialize(futureDTO.getVolume(), Integer.class));

        return jsonObject;
    }
}
