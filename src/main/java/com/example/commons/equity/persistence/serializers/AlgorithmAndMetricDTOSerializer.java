package com.example.commons.equity.persistence.serializers;

import com.example.commons.equity.model.dto.output.AlgorithmAndMetricDTO;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AlgorithmAndMetricDTOSerializer implements JsonSerializer<AlgorithmAndMetricDTO> {
    @Override
    public JsonElement serialize(AlgorithmAndMetricDTO algorithmAndMetricDTO, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject jsonObject = new JsonObject();

        jsonObject.add("Time", jsonSerializationContext.serialize(algorithmAndMetricDTO.getTime(), LocalDateTime.class));
        jsonObject.add("Price", jsonSerializationContext.serialize(algorithmAndMetricDTO.getPrice(),Double.class));
        jsonObject.add("BuySell", jsonSerializationContext.serialize(algorithmAndMetricDTO.getBuySell(),String.class));
        jsonObject.add("Quantity", jsonSerializationContext.serialize(algorithmAndMetricDTO.getQuantity(),Integer.class));
        jsonObject.add("Position", jsonSerializationContext.serialize(algorithmAndMetricDTO.getPosition(),Integer.class));
        jsonObject.add("avgPrice", jsonSerializationContext.serialize(algorithmAndMetricDTO.getAvgprice(),Double.class));
        jsonObject.add("posPL_tminus", jsonSerializationContext.serialize(algorithmAndMetricDTO.getPosplTminus(),Double.class));
        jsonObject.add("posPL_tplus", jsonSerializationContext.serialize(algorithmAndMetricDTO.getPosplTplus(),Double.class));
        jsonObject.add("consolidatedPL", jsonSerializationContext.serialize(algorithmAndMetricDTO.getConsolidatedpl(),Double.class));
        jsonObject.add("totRunningPL", jsonSerializationContext.serialize(algorithmAndMetricDTO.getTotrunningpl(),Double.class));
        jsonObject.add("posInversion", jsonSerializationContext.serialize(algorithmAndMetricDTO.getPosinversion(),Boolean.class));
        jsonObject.add("rollOverTrade", jsonSerializationContext.serialize(algorithmAndMetricDTO.getRollovertrade(),Boolean.class));
        jsonObject.add("rolloverData", jsonSerializationContext.serialize(algorithmAndMetricDTO.getRolloverdata(), LocalDate.class));
        jsonObject.add("drawdown", jsonSerializationContext.serialize(algorithmAndMetricDTO.getDrawdown(),Double.class));
        jsonObject.add("avgdd", jsonSerializationContext.serialize(algorithmAndMetricDTO.getAvgdd(),Double.class));
        jsonObject.add("stddd", jsonSerializationContext.serialize(algorithmAndMetricDTO.getStddd(),Double.class));
        jsonObject.add("ddownLim", jsonSerializationContext.serialize(algorithmAndMetricDTO.getDdownlim(),Double.class));
        jsonObject.add("ddPass", jsonSerializationContext.serialize(algorithmAndMetricDTO.getDdpass(),Boolean.class));
        jsonObject.add("BuySell_noDD", jsonSerializationContext.serialize(algorithmAndMetricDTO.getBuysellNodd(),String.class));
        jsonObject.add("Position_noDD", jsonSerializationContext.serialize(algorithmAndMetricDTO.getPositionNodd(),Integer.class));
        jsonObject.add("avgPrice_noDD", jsonSerializationContext.serialize(algorithmAndMetricDTO.getAvgpriceNodd(),Double.class));
        jsonObject.add("posPL_tminus_noDD", jsonSerializationContext.serialize(algorithmAndMetricDTO.getPosplTminusNodd(),Double.class));
        jsonObject.add("posPL_tplus_noDD", jsonSerializationContext.serialize(algorithmAndMetricDTO.getPosplTplusNodd(),Double.class));
        jsonObject.add("consolidatedPL_noDD", jsonSerializationContext.serialize(algorithmAndMetricDTO.getConsolidatedplNodd(),Double.class));
        jsonObject.add("totRunningPL_noDD", jsonSerializationContext.serialize(algorithmAndMetricDTO.getTotrunningplNodd(),Double.class));
        jsonObject.add("posInversion_noDD", jsonSerializationContext.serialize(algorithmAndMetricDTO.getPosinversionNodd(),Boolean.class));
        jsonObject.add("cumPL", jsonSerializationContext.serialize(algorithmAndMetricDTO.getCumpl(),Double.class));
        jsonObject.add("dPL", jsonSerializationContext.serialize(algorithmAndMetricDTO.getDpl(),Double.class));
        jsonObject.add("Executed Price", jsonSerializationContext.serialize(algorithmAndMetricDTO.getExecutedPrice(),Double.class));
        jsonObject.add("Delta Price", jsonSerializationContext.serialize(algorithmAndMetricDTO.getDeltaPrice(),Double.class));

        return jsonObject;
    }
}
