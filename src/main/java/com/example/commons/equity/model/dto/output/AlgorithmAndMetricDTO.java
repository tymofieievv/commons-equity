package com.example.commons.equity.model.dto.output;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AlgorithmAndMetricDTO
        (LocalDateTime time,
         Double price,
         String buySell,
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
         String buysellNodd,
         Integer positionNodd,
         Double avgpriceNodd,
         Double posplTminusNodd,
         Double posplTplusNodd,
         Double consolidatedplNodd,
         Double totrunningplNodd,
         Boolean posinversionNodd,
         Double cumpl,
         Double dpl,
         Double prezzoEseguito,
         Double deltaPrezzo) {
}
