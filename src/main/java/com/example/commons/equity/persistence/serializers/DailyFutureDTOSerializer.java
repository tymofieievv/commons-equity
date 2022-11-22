package com.example.commons.equity.persistence.serializers;

import com.example.commons.equity.model.dto.input.DailyFutureDTO;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

public class DailyFutureDTOSerializer implements JsonSerializer<DailyFutureDTO> {
    @Override
    public JsonElement serialize(DailyFutureDTO dailyFutureDTO, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject jsonObject = new JsonObject();

        jsonObject.add("REF_DATE", jsonSerializationContext.serialize(dailyFutureDTO.getRefDate(), LocalDate.class));
        jsonObject.add("RIC", jsonSerializationContext.serialize(dailyFutureDTO.getRic(), String.class));
        jsonObject.add("PRICE_CLOSE", jsonSerializationContext.serialize(dailyFutureDTO.getPriceClose(), Double.class));
        jsonObject.add("PRICE_LOW", jsonSerializationContext.serialize(dailyFutureDTO.getPriceLow(), Double.class));
        jsonObject.add("PRICE_HIGH", jsonSerializationContext.serialize(dailyFutureDTO.getPriceOpen(), Double.class));
        jsonObject.add("PRICE_OPEN", jsonSerializationContext.serialize(dailyFutureDTO.getPriceHigh(), Double.class));
        jsonObject.add("VOLUME", jsonSerializationContext.serialize(dailyFutureDTO.getVolume(), Integer.class));

        return jsonObject;

    }
}