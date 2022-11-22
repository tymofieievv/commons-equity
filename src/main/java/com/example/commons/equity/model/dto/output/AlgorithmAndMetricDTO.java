package com.example.commons.equity.model.dto.output;

import com.example.commons.equity.model.entity.output.AlgorithmAndMetric;
import com.example.commons.equity.model.enums.Operation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AlgorithmAndMetricDTO {
    private LocalDateTime time;
    private Double price;
    private Operation buySell;
    private Integer quantity;
    private Integer position;
    private Double avgprice;
    private Double posplTminus;
    private Double posplTplus;
    private Double consolidatedpl;
    private Double totrunningpl;
    private Boolean posinversion;
    private Boolean rollovertrade;
    private LocalDate rolloverdata;
    private Double drawdown;
    private Double avgdd;
    private Double stddd;
    private Double ddownlim;
    private Boolean ddpass;
    private Operation buysellNodd;
    private Integer positionNodd;
    private Double avgpriceNodd;
    private Double posplTminusNodd;
    private Double posplTplusNodd;
    private Double consolidatedplNodd;
    private Double totrunningplNodd;
    private Boolean posinversionNodd;
    private Double cumpl;
    private Double dpl;
    private Double executedPrice;
    private Double deltaPrice;

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
