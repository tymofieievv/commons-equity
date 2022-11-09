package com.example.commons.equity.model.entity.output;

import com.example.commons.equity.model.enums.Operations;
import com.example.commons.equity.model.dto.output.AlgorithmAndMetricDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AlgorithmAndMetric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime time;
    private Double price;
    private Operations buySell;
    private Integer position;
    private Double avgPrice;
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
    private Double dddownlim;
    private Boolean ddpass;
    private String buysellNodd;
    private Integer positionNodd;
    private Double avgpriceNodd;
    private Double posplTminusNodd;
    private Double posplTplusNodd;
    private Double consolidatedplNodd;
    private Double totrunningplNodd;
    private Boolean posinverionsNodd;
    private Double cumpl;
    private Double dpl;
    private Double executedPrice;
    private Double deltaPrice;

    public AlgorithmAndMetric buildFromDTO(AlgorithmAndMetricDTO algorithmAndMetricDTO) {

        AlgorithmAndMetric algorithmAndMetric = new AlgorithmAndMetric();

        algorithmAndMetric.setTime(algorithmAndMetricDTO.time());
        algorithmAndMetric.setPrice(algorithmAndMetricDTO.price());
        algorithmAndMetric.setBuySell(Operations.valueOf(algorithmAndMetricDTO.buySell()));
        algorithmAndMetric.setPosition(algorithmAndMetricDTO.position());
        algorithmAndMetric.setAvgPrice(algorithmAndMetricDTO.avgprice());
        algorithmAndMetric.setPosplTminus(algorithmAndMetricDTO.posplTminus());
        algorithmAndMetric.setPosplTplus(algorithmAndMetricDTO.posplTplus());
        algorithmAndMetric.setConsolidatedpl(algorithmAndMetricDTO.consolidatedpl());
        algorithmAndMetric.setTotrunningpl(algorithmAndMetricDTO.totrunningpl());
        algorithmAndMetric.setPosinversion(algorithmAndMetricDTO.posinversion());
        algorithmAndMetric.setRollovertrade(algorithmAndMetricDTO.rollovertrade());
        algorithmAndMetric.setRolloverdata(algorithmAndMetricDTO.rolloverdata());
        algorithmAndMetric.setAvgdd(algorithmAndMetricDTO.avgdd());
        algorithmAndMetric.setStddd(algorithmAndMetricDTO.stddd());
        algorithmAndMetric.setDddownlim(algorithmAndMetricDTO.dddownlim());
        algorithmAndMetric.setDdpass(algorithmAndMetricDTO.ddpass());
        algorithmAndMetric.setBuysellNodd(algorithmAndMetricDTO.buysellNodd());
        algorithmAndMetric.setPositionNodd(algorithmAndMetricDTO.positionNodd());
        algorithmAndMetric.setAvgpriceNodd(algorithmAndMetricDTO.avgpriceNodd());
        algorithmAndMetric.setPosplTminusNodd(algorithmAndMetricDTO.posplTminusNodd());
        algorithmAndMetric.setConsolidatedplNodd(algorithmAndMetricDTO.consolidatedplNodd());
        algorithmAndMetric.setPosplTplusNodd(algorithmAndMetricDTO.posplTplusNodd());
        algorithmAndMetric.setTotrunningplNodd(algorithmAndMetricDTO.totrunningplNodd());
        algorithmAndMetric.setPosinverionsNodd(algorithmAndMetricDTO.posinverionsNodd());
        algorithmAndMetric.setCumpl(algorithmAndMetricDTO.cumpl());
        algorithmAndMetric.setDpl(algorithmAndMetricDTO.dpl());
        algorithmAndMetric.setExecutedPrice(algorithmAndMetricDTO.prezzoEseguito());
        algorithmAndMetric.setDeltaPrice(algorithmAndMetricDTO.deltaPrezzo());


        return algorithmAndMetric;
    }
}
