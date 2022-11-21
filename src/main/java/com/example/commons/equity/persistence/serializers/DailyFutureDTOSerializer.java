package com.example.commons.equity.persistence.serializers;

import com.example.commons.equity.model.dto.input.DailyFutureDTO;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

public class DailyFutureDTOSerializer implements JsonSerializer<DailyFutureDTO> {
    @Override
    public JsonElement serialize(DailyFutureDTO dailyFutureDTO, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject jsonObject = new JsonObject();

        jsonObject.add("REF_DATE", jsonSerializationContext.serialize(dailyFutureDTO.refDate(), LocalDate.class));
        jsonObject.add("RIC", jsonSerializationContext.serialize(dailyFutureDTO.ric(), String.class));
        jsonObject.add("PRICE_CLOSE", jsonSerializationContext.serialize(dailyFutureDTO.priceClose(), Double.class));
        jsonObject.add("PRICE_LOW", jsonSerializationContext.serialize(dailyFutureDTO.priceLow(), Double.class));
        jsonObject.add("PRICE_HIGH", jsonSerializationContext.serialize(dailyFutureDTO.priceOpen(), Double.class));
        jsonObject.add("PRICE_OPEN", jsonSerializationContext.serialize(dailyFutureDTO.priceHigh(), Double.class));
        jsonObject.add("VOLUME", jsonSerializationContext.serialize(dailyFutureDTO.volume(), Integer.class));

        return jsonObject;

    }
}