package com.example.commons.equity.persistence.deserializers;

import com.example.commons.equity.model.dto.input.IndexDTO;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalTime;

public class IndexDTODeserializer implements JsonDeserializer<IndexDTO> {
    @Override
    public IndexDTO deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonElement refDate = ((JsonObject) jsonElement).get("REF_DATE");
        JsonElement price = ((JsonObject) jsonElement).get("PRICE");
        JsonElement underlying = ((JsonObject) jsonElement).get("UNDERLYING");
        JsonElement instrument_id = ((JsonObject) jsonElement).get("INSTRUMENT_ID");
        JsonElement securityDescription = ((JsonObject) jsonElement).get("SECURITY_DESCRIPTION");
        JsonElement time = ((JsonObject) jsonElement).get("TIME");

        return new IndexDTO(
                jsonDeserializationContext.deserialize(refDate, LocalDate.class),
                jsonDeserializationContext.deserialize(time, LocalTime.class),
                jsonDeserializationContext.deserialize(price, Double.class),
                jsonDeserializationContext.deserialize(instrument_id, String.class),
                jsonDeserializationContext.deserialize(securityDescription, String.class)
        );
    }
}
