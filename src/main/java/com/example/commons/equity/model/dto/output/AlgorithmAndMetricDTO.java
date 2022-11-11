package com.example.commons.equity.model.dto.output;

import com.example.commons.equity.model.entity.output.AlgorithmAndMetric;
import com.example.commons.equity.model.enums.Operation;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AlgorithmAndMetricDTO
        (LocalDateTime time,
         Double price,
         Operation buySell,
         Integer quantity,
         Integer position,
         Double avgprice,
         Double posplTminus,
         Double posplTplus,
         Double consolidatedpl,
         Double totrunningpl,
         Boolean posinversion,
         Boolean rollovertrade,
         LocalDate rolloverdata,
         Double drawdown,
         Double avgdd,
         Double stddd,
         Double ddownlim,
         Boolean ddpass,
         Operation buysellNodd,
         Integer positionNodd,
         Double avgpriceNodd,
         Double posplTminusNodd,
         Double posplTplusNodd,
         Double consolidatedplNodd,
         Double totrunningplNodd,
         Boolean posinversionNodd,
         Double cumpl,
         Double dpl,
         Double executedPrice,
         Double deltaPrice) {

    public AlgorithmAndMetric toEntity() {

        AlgorithmAndMetric algorithmAndMetric = new AlgorithmAndMetric();

        algorithmAndMetric.setTime(this.time);
        algorithmAndMetric.setPrice(this.price);
        algorithmAndMetric.setBuySell(this.buySell);
        algorithmAndMetric.setPosition(this.position);
        algorithmAndMetric.setAvgPrice(this.avgprice);
        algorithmAndMetric.setPosplTminus(this.posplTminus);
        algorithmAndMetric.setPosplTplus(this.posplTplus);
        algorithmAndMetric.setConsolidatedpl(this.consolidatedpl);
        algorithmAndMetric.setTotrunningpl(this.totrunningpl);
        algorithmAndMetric.setPosinversion(this.posinversion);
        algorithmAndMetric.setRollovertrade(this.rollovertrade);
        algorithmAndMetric.setRolloverdata(this.rolloverdata);
        algorithmAndMetric.setDrawdown(this.drawdown);
        algorithmAndMetric.setAvgdd(this.avgdd);
        algorithmAndMetric.setStddd(this.stddd);
        algorithmAndMetric.setDdownlim(this.ddownlim);
        algorithmAndMetric.setDdpass(this.ddpass);
        algorithmAndMetric.setBuysellNodd(this.buysellNodd);
        algorithmAndMetric.setPositionNodd(this.positionNodd);
        algorithmAndMetric.setAvgpriceNodd(this.avgpriceNodd);
        algorithmAndMetric.setPosplTminusNodd(this.posplTminusNodd);
        algorithmAndMetric.setConsolidatedplNodd(this.consolidatedplNodd);
        algorithmAndMetric.setPosplTplusNodd(this.posplTplusNodd);
        algorithmAndMetric.setTotrunningplNodd(this.totrunningplNodd);
        algorithmAndMetric.setPosinversionNodd(this.posinversionNodd);
        algorithmAndMetric.setCumpl(this.cumpl);
        algorithmAndMetric.setDpl(this.dpl);
        algorithmAndMetric.setExecutedPrice(this.executedPrice);
        algorithmAndMetric.setDeltaPrice(this.deltaPrice);

        return algorithmAndMetric;
    }

}
