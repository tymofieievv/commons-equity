package com.example.commons.equity.persistence.serializers;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateSerializer implements JsonSerializer<LocalDate> {
    @Override
    public JsonElement serialize(LocalDate localDate, Type type, JsonSerializationContext jsonSerializationContext) {

        return new JsonPrimitive(localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}
