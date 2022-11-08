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

        jsonObject.add("Time", jsonSerializationContext.serialize(algorithmAndMetricDTO.time(), LocalDateTime.class));
        jsonObject.add("Price", jsonSerializationContext.serialize(algorithmAndMetricDTO.price(),Double.class));
        jsonObject.add("BuySell", jsonSerializationContext.serialize(algorithmAndMetricDTO.buySell(),String.class));
        jsonObject.add("Position", jsonSerializationContext.serialize(algorithmAndMetricDTO.position(),Integer.class));
        jsonObject.add("avgPrice", jsonSerializationContext.serialize(algorithmAndMetricDTO.avgprice(),Double.class));
        jsonObject.add("posPL_tminus", jsonSerializationContext.serialize(algorithmAndMetricDTO.posplTminus(),Double.class));
        jsonObject.add("posPL_tplus", jsonSerializationContext.serialize(algorithmAndMetricDTO.posplTplus(),Double.class));
        jsonObject.add("consolidatedPL", jsonSerializationContext.serialize(algorithmAndMetricDTO.consolidatedpl(),Double.class));
        jsonObject.add("totRunningPL", jsonSerializationContext.serialize(algorithmAndMetricDTO.totrunningpl(),Double.class));
        jsonObject.add("posInversion", jsonSerializationContext.serialize(algorithmAndMetricDTO.posinversion(),Boolean.class));
        jsonObject.add("rollOverTrade", jsonSerializationContext.serialize(algorithmAndMetricDTO.rollovertrade(),Boolean.class));
        jsonObject.add("rolloverData", jsonSerializationContext.serialize(algorithmAndMetricDTO.rolloverdata(), LocalDate.class));
        jsonObject.add("drawdown", jsonSerializationContext.serialize(algorithmAndMetricDTO.drawdown(),Double.class));
        jsonObject.add("avgdd", jsonSerializationContext.serialize(algorithmAndMetricDTO.avgdd(),Double.class));
        jsonObject.add("stddd", jsonSerializationContext.serialize(algorithmAndMetricDTO.stddd(),Double.class));
        jsonObject.add("ddownLim", jsonSerializationContext.serialize(algorithmAndMetricDTO.ddownlim(),Double.class));
        jsonObject.add("ddPass", jsonSerializationContext.serialize(algorithmAndMetricDTO.ddpass(),Boolean.class));
        jsonObject.add("BuySell_noDD", jsonSerializationContext.serialize(algorithmAndMetricDTO.buysellNodd(),String.class));
        jsonObject.add("Position_noDD", jsonSerializationContext.serialize(algorithmAndMetricDTO.positionNodd(),Integer.class));
        jsonObject.add("avgPrice_noDD", jsonSerializationContext.serialize(algorithmAndMetricDTO.avgpriceNodd(),Double.class));
        jsonObject.add("posPL_tminus_noDD", jsonSerializationContext.serialize(algorithmAndMetricDTO.posplTminusNodd(),Double.class));
        jsonObject.add("posPL_tplus_noDD", jsonSerializationContext.serialize(algorithmAndMetricDTO.posplTplusNodd(),Double.class));
        jsonObject.add("consolidatedPL_noDD", jsonSerializationContext.serialize(algorithmAndMetricDTO.consolidatedplNodd(),Double.class));
        jsonObject.add("totRunningPL_noDD", jsonSerializationContext.serialize(algorithmAndMetricDTO.totrunningplNodd(),Double.class));
        jsonObject.add("posInversion_noDD", jsonSerializationContext.serialize(algorithmAndMetricDTO.posinversionNodd(),Boolean.class));
        jsonObject.add("cumPL", jsonSerializationContext.serialize(algorithmAndMetricDTO.cumpl(),Double.class));
        jsonObject.add("dPL", jsonSerializationContext.serialize(algorithmAndMetricDTO.dpl(),Double.class));
        jsonObject.add("Prezzo_eseguito", jsonSerializationContext.serialize(algorithmAndMetricDTO.prezzoEseguito(),Double.class));
        jsonObject.add("Delta_prezzo", jsonSerializationContext.serialize(algorithmAndMetricDTO.deltaPrezzo(),Double.class));

        return jsonObject;
    }
}
