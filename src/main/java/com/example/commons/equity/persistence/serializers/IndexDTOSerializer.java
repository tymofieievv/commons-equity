package com.example.commons.equity.persistence.serializers;

import com.example.commons.equity.model.dto.input.IndexDTO;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalTime;

public class IndexDTOSerializer implements JsonSerializer<IndexDTO> {

    @Override
    public JsonElement serialize(IndexDTO indexDTO, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject jsonObject = new JsonObject();

        jsonObject.add("REF_DATE", jsonSerializationContext.serialize(indexDTO.getRefDate(), LocalDate.class));
        jsonObject.add("TIME", jsonSerializationContext.serialize(indexDTO.getTime(), LocalTime.class));
        jsonObject.add("PRICE", jsonSerializationContext.serialize(indexDTO.getPrice(), Double.class));
        jsonObject.add("INSTRUMENT_ID", jsonSerializationContext.serialize(indexDTO.getInstrumentId(), String.class));
        jsonObject.add("SECURITY_DESCRIPTION", jsonSerializationContext.serialize(indexDTO.getSecurityDescription(), String.class));

        return jsonObject;
    }
}
