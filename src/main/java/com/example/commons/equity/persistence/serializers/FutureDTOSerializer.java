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

        jsonObject.add("RIC", jsonSerializationContext.serialize(futureDTO.ric(),String.class));
        jsonObject.add("REF_DATE", jsonSerializationContext.serialize(futureDTO.refDate(), LocalDate.class));
        jsonObject.add("TIME", jsonSerializationContext.serialize(futureDTO.time(), LocalTime.class));
        jsonObject.add("PRICE_CLOSE", jsonSerializationContext.serialize(futureDTO.priceClose(), Double.class));
        jsonObject.add("PRICE_LOW", jsonSerializationContext.serialize(futureDTO.priceLow(), Double.class));
        jsonObject.add("PRICE_HIGH", jsonSerializationContext.serialize(futureDTO.priceOpen(), Double.class));
        jsonObject.add("PRICE_OPEN", jsonSerializationContext.serialize(futureDTO.priceHigh(), Double.class));
        jsonObject.add("VOLUME", jsonSerializationContext.serialize(futureDTO.volume(), Integer.class));

        return jsonObject;
    }
}
