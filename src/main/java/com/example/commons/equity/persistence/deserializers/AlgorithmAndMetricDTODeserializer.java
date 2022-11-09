package com.example.commons.equity.persistence.deserializers;

import com.example.commons.equity.model.dto.output.AlgorithmAndMetricDTO;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AlgorithmAndMetricDTODeserializer implements JsonDeserializer<AlgorithmAndMetricDTO> {
    @Override
    public AlgorithmAndMetricDTO deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonElement time = ((JsonObject) jsonElement).get("Time");
        JsonElement price = ((JsonObject) jsonElement).get("Price");
        JsonElement buySell = ((JsonObject) jsonElement).get("BuySell");
        JsonElement quantity = ((JsonObject) jsonElement).get("Quantity");
        JsonElement position = ((JsonObject) jsonElement).get("Position");
        JsonElement avgPrice = ((JsonObject) jsonElement).get("avgPrice");
        JsonElement posPLTminus = ((JsonObject) jsonElement).get("posPL_tminus");
        JsonElement posPLTplus = ((JsonObject) jsonElement).get("posPL_tplus");
        JsonElement consolidatedPL = ((JsonObject) jsonElement).get("consolidatedPL");
        JsonElement totRunningPL = ((JsonObject) jsonElement).get("totRunningPL");
        JsonElement posInversion = ((JsonObject) jsonElement).get("posInversion");
        JsonElement rollOverTrade = ((JsonObject) jsonElement).get("rollOverTrade");
        JsonElement rolloverData = ((JsonObject) jsonElement).get("rolloverData");
        JsonElement drawdown = ((JsonObject) jsonElement).get("drawdown");
        JsonElement avgdd = ((JsonObject) jsonElement).get("avgdd");
        JsonElement stddd = ((JsonObject) jsonElement).get("stddd");
        JsonElement ddownLim = ((JsonObject) jsonElement).get("ddownLim");
        JsonElement ddPass = ((JsonObject) jsonElement).get("ddPass");
        JsonElement buySellNoDD = ((JsonObject) jsonElement).get("BuySell_noDD");
        JsonElement positionNoDD = ((JsonObject) jsonElement).get("Position_noDD");
        JsonElement avgPriceNoDD = ((JsonObject) jsonElement).get("avgPrice_noDD");
        JsonElement posPLTminusNoDD = ((JsonObject) jsonElement).get("posPL_tminus_noDD");
        JsonElement posPLTplusNoDD = ((JsonObject) jsonElement).get("posPL_tplus_noDD");
        JsonElement consolidatedPLNoDD = ((JsonObject) jsonElement).get("consolidatedPL_noDD");
        JsonElement totRunningPLNoDD = ((JsonObject) jsonElement).get("totRunningPL_noDD");
        JsonElement posInversionNoDD = ((JsonObject) jsonElement).get("posInversion_noDD");
        JsonElement cumPL = ((JsonObject) jsonElement).get("cumPL");
        JsonElement dPL = ((JsonObject) jsonElement).get("dPL");
        JsonElement prezzoEseguito = ((JsonObject) jsonElement).get("Executed Price");
        JsonElement deltaPrezzo = ((JsonObject) jsonElement).get("Delta Price");

        return new AlgorithmAndMetricDTO(
                jsonDeserializationContext.deserialize(time, LocalDateTime.class),
                jsonDeserializationContext.deserialize(price, Double.class),
                jsonDeserializationContext.deserialize(buySell, String.class),
                jsonDeserializationContext.deserialize(quantity, Integer.class),
                jsonDeserializationContext.deserialize(position, Integer.class),
                jsonDeserializationContext.deserialize(avgPrice, Double.class),
                jsonDeserializationContext.deserialize(posPLTminus, Double.class),
                jsonDeserializationContext.deserialize(posPLTplus, Double.class),
                jsonDeserializationContext.deserialize(consolidatedPL, Double.class),
                jsonDeserializationContext.deserialize(totRunningPL, Double.class),
                jsonDeserializationContext.deserialize(posInversion, Boolean.class),
                jsonDeserializationContext.deserialize(rollOverTrade, Boolean.class),
                jsonDeserializationContext.deserialize(rolloverData, LocalDate.class),
                jsonDeserializationContext.deserialize(drawdown, Double.class),
                jsonDeserializationContext.deserialize(avgdd, Double.class),
                jsonDeserializationContext.deserialize(stddd, Double.class),
                jsonDeserializationContext.deserialize(ddownLim, Double.class),
                jsonDeserializationContext.deserialize(ddPass, Boolean.class),
                jsonDeserializationContext.deserialize(buySellNoDD, String.class),
                jsonDeserializationContext.deserialize(positionNoDD, Integer.class),
                jsonDeserializationContext.deserialize(avgPriceNoDD, Double.class),
                jsonDeserializationContext.deserialize(posPLTminusNoDD, Double.class),
                jsonDeserializationContext.deserialize(posPLTplusNoDD, Double.class),
                jsonDeserializationContext.deserialize(consolidatedPLNoDD, Double.class),
                jsonDeserializationContext.deserialize(totRunningPLNoDD, Double.class),
                jsonDeserializationContext.deserialize(posInversionNoDD, Boolean.class),
                jsonDeserializationContext.deserialize(cumPL, Double.class),
                jsonDeserializationContext.deserialize(dPL, Double.class),
                jsonDeserializationContext.deserialize(prezzoEseguito, Double.class),
                jsonDeserializationContext.deserialize(deltaPrezzo, Double.class)
        );
    }
}
