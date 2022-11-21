package com.example.commons.equity.persistence.deserializers;

import com.example.commons.equity.model.dto.input.PersonalDataFutureDTO;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

public class PersonalDataFutureDTODeserializer implements JsonDeserializer<PersonalDataFutureDTO> {

    @Override
    public PersonalDataFutureDTO deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonElement isin = ((JsonObject) jsonElement).get("ISIN");
        JsonElement ticker = ((JsonObject) jsonElement).get("TICKER");
        JsonElement underlyingId = ((JsonObject) jsonElement).get("UNDERLYING ID");
        JsonElement ric = ((JsonObject) jsonElement).get("RIC");
        JsonElement description = ((JsonObject) jsonElement).get("DESCRIPTION");
        JsonElement currency = ((JsonObject) jsonElement).get("CURRENCY");
        JsonElement maturity = ((JsonObject) jsonElement).get("MATURITY");

        return new PersonalDataFutureDTO(
                jsonDeserializationContext.deserialize(ticker, String.class),
                jsonDeserializationContext.deserialize(isin, String.class),
                jsonDeserializationContext.deserialize(underlyingId, String.class),
                jsonDeserializationContext.deserialize(ric,String.class),
                jsonDeserializationContext.deserialize(description, String.class),
                jsonDeserializationContext.deserialize(currency, String.class),
                jsonDeserializationContext.deserialize(maturity, LocalDate.class)
        );
    }
}
