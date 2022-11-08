package com.example.commons.equity.persistence.serializers;

import com.example.commons.equity.model.dto.input.IndexDTO;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalTime;

public class IndexDTOSerializer implements JsonSerializer<IndexDTO> {

    @Override
    public JsonElement serialize(IndexDTO indexDTO, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject jsonObject = new JsonObject();

        jsonObject.add("REF_DATE", jsonSerializationContext.serialize(indexDTO.refDate(), LocalDate.class));
        jsonObject.add("TIME", jsonSerializationContext.serialize(indexDTO.time(), LocalTime.class));
        jsonObject.add("PRICE", jsonSerializationContext.serialize(indexDTO.price(), Double.class));
        jsonObject.add("INSTRUMENT_ID", jsonSerializationContext.serialize(indexDTO.instrumentId(), String.class));
        jsonObject.add("SECURITY_DESCRIPTION", jsonSerializationContext.serialize(indexDTO.securityDescription(), String.class));
        jsonObject.add("UNDERLYING", jsonSerializationContext.serialize(indexDTO.underlying(), String.class));

        return jsonObject;
    }
}
