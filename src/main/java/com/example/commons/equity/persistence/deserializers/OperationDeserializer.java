package com.example.commons.equity.persistence.deserializers;

import com.example.commons.equity.model.enums.Operation;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;

public class OperationDeserializer implements JsonDeserializer<Operation> {
    @Override
    public Operation deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        String jsonString = json.getAsString();
        if (StringUtils.isBlank(jsonString)) {
            throw new IllegalArgumentException("Operation is Blank.");
        } else {
            Operation operation = null;
            switch (jsonString) {
                case "B":
                    operation = Operation.BUY;
                    break;
                case "S":
                    operation = Operation.SELL;
                    break;
                case "N":
                    operation = Operation.NEUTRAL;
                    break;
                default:
                    throw new IllegalArgumentException(String.format("Argument %s not valid.", jsonString));
            }
            ;
            return operation;
        }

    }
}
