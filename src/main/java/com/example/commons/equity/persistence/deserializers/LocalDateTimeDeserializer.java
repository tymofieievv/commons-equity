package com.example.commons.equity.persistence.deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import org.springframework.boot.json.JsonParseException;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeDeserializer implements JsonDeserializer<LocalDateTime> {
    @Override
    public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        return LocalDateTime.parse(json.getAsString(),
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
}