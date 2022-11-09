package com.example.commons.equity.model.entity.output;

import com.example.commons.equity.model.dto.output.AlgorithmAndMetricDTO;
import com.example.commons.equity.model.enums.Operations;
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

@Entity(name = "VIS10_API_ALGORITHM_AND_METRICS")
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
    private Double ddownlim;
    private Boolean ddpass;
    private String buysellNodd;
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

    public AlgorithmAndMetricDTO toDTO() {
        return new AlgorithmAndMetricDTO(
                this.getTime(),
                this.getPrice(),
                this.getBuysellNodd(),
                this.getPosition(),
                this.getPosition(),
                this.getPrice(),
                this.getPosplTminus(),
                this.getPosplTplus(),
                this.getConsolidatedpl(),
                this.getTotrunningpl(),
                this.getPosinversion(),
                this.getRollovertrade(),
                this.getRolloverdata(),
                this.getDrawdown(),
                this.getAvgdd(),
                this.getStddd(),
                this.getDdownlim(),
                this.getDdpass(),
                this.getBuysellNodd(),
                this.getPositionNodd(),
                this.getAvgpriceNodd(),
                this.getPosplTminusNodd(),
                this.getPosplTplusNodd(),
                this.getConsolidatedplNodd(),
                this.getTotrunningplNodd(),
                this.getPosinversionNodd(),
                this.getCumpl(),
                this.getDpl(),
                this.getExecutedPrice(),
                this.getDeltaPrice()
        );
    }

}
