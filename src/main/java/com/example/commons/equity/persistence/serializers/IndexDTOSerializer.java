package com.example.commons.equity.persistence.serializers;

import com.example.commons.equity.model.dto.input.IndexDTO;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

public class IndexDTOSerializer implements JsonSerializer<IndexDTO> {

    @Override
    public JsonElement serialize(IndexDTO indexDTO, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("TIMESTAMP", jsonSerializationContext.serialize(indexDTO.getTimestamp(), LocalDateTime.class));
        jsonObject.add("PRICE", jsonSerializationContext.serialize(indexDTO.getPriceOpen(), Double.class));
        jsonObject.add("INSTRUMENT_ID", jsonSerializationContext.serialize(indexDTO.getInstrumentId(), String.class));
        jsonObject.add("PRICE_CLOSED", jsonSerializationContext.serialize(indexDTO.getPriceClosed(), Double.class));
        jsonObject.add("PRICE_LOW", jsonSerializationContext.serialize(indexDTO.getPriceHigh(), Double.class));
        jsonObject.add("PRICE HIGH", jsonSerializationContext.serialize(indexDTO.getPriceLow(), Double.class));
        return jsonObject;
    }
}
