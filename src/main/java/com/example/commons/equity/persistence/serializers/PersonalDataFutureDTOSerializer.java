package com.example.commons.equity.persistence.serializers;

import com.example.commons.equity.model.dto.input.PersonalDataFutureDTO;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

public class PersonalDataFutureDTOSerializer implements JsonSerializer<PersonalDataFutureDTO> {
    @Override
    public JsonElement serialize(PersonalDataFutureDTO personalDataFutureDTO, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject jsonObject = new JsonObject();

        jsonObject.add("TICKER", jsonSerializationContext.serialize(personalDataFutureDTO.ticker(),String.class));
        jsonObject.add("ISIN", jsonSerializationContext.serialize(personalDataFutureDTO.isin(),String.class));
        jsonObject.add("UNDERLYING_ID", jsonSerializationContext.serialize(personalDataFutureDTO.isin(),String.class));
        jsonObject.add("RIC", jsonSerializationContext.serialize(personalDataFutureDTO.isin(),String.class));
        jsonObject.add("DESCRIPTION", jsonSerializationContext.serialize(personalDataFutureDTO.description(),String.class));
        jsonObject.add("CURRENCY", jsonSerializationContext.serialize(personalDataFutureDTO.currency(),String.class));
        jsonObject.add("MATURITY", jsonSerializationContext.serialize(personalDataFutureDTO.maturity(), LocalDate.class));

        return jsonObject;
    }
}
