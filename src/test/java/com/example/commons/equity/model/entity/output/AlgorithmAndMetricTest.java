package com.example.commons.equity.model.entity.output;

import com.example.commons.equity.model.dto.output.AlgorithmAndMetricDTO;
import com.example.commons.equity.model.enums.Operation;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class AlgorithmAndMetricTest {
    private static final String jsonString =

            """
                                [
                    {
                    "Time": "13/09/2013 00:00",
                    "Price": "2867.11",
                    "BuySell": "S",
                    "Position": "-27",
                    "avgPrice": "2867.11",
                    "posPL_tminus": "0",
                    "posPL_tplus": "0",
                    "consolidatedPL": "0",
                    "totRunningPL": "0",
                    "posInversion": "TRUE",
                    "rollOverTrade": "FALSE",
                    "rolloverData": null,
                    "drawdown": "0",
                    "avgdd": "0",
                    "stddd": "0",
                    "ddownLim": "0",
                    "ddPass": "TRUE",
                    "BuySell_noDD": "S",
                    "Position_noDD": "-27",
                    "avgPrice_noDD": "2867.11",
                    "posPL_tminus_noDD": "0",
                    "posPL_tplus_noDD": "0",
                    "consolidatedPL_noDD": "0",
                    "totRunningPL_noDD": "0",
                    "posInversion_noDD": "TRUE",
                    "cumPL": "0",
                    "dPL": "0",
                    "Prezzo_eseguito": "2865",
                    "Delta_prezzo": "-2.1100000000001273"
                    },
                    {
                    "Time": "16/09/2013 00:00",
                    "Price": "2894.64",
                    "BuySell": "S",
                    "Position": "-25",
                    "avgPrice": "2867.11",
                    "posPL_tminus": "-743.30999999999312",
                    "posPL_tplus": "-688.24999999999363",
                    "consolidatedPL": "-55.059999999999491",
                    "totRunningPL": "-743.30999999999312",
                    "posInversion": "FALSE",
                    "rollOverTrade": "FALSE",
                    "rolloverData": null,
                    "drawdown": "0",
                    "avgdd": "0",
                    "stddd": "0",
                    "ddownLim": "0",
                    "ddPass": "TRUE",
                    "BuySell_noDD": "S",
                    "Position_noDD": "-25",
                    "avgPrice_noDD": "2867.11",
                    "posPL_tminus_noDD": "-743.30999999999312",
                    "posPL_tplus_noDD": "-688.24999999999363",
                    "consolidatedPL_noDD": "-55.059999999999491",
                    "totRunningPL_noDD": "-743.30999999999312",
                    "posInversion_noDD": "FALSE",
                    "cumPL": "-743.30999999999312",
                    "dPL": "-743.30999999999312",
                    "Prezzo_eseguito": "2896",
                    "Delta_prezzo": "1.3600000000001273"
                    },
                    {
                    "Time": "17/09/2013 00:00",
                    "Price": "2890.95",
                    "BuySell": "N",
                    "Position": "0",
                    "avgPrice": "2890.95",
                    "posPL_tminus": "-595.99999999999227",
                    "posPL_tplus": "0",
                    "consolidatedPL": "-651.05999999999176",
                    "totRunningPL": "-651.05999999999176",
                    "posInversion": "TRUE",
                    "rollOverTrade": "FALSE",
                    "rolloverData": null,
                    "drawdown": "743.30999999999312",
                    "avgdd": "14.294423076922945",
                    "stddd": "103.07855071404282",
                    "ddownLim": "478.14790129011567",
                    "ddPass": "FALSE",
                    "BuySell_noDD": "S",
                    "Position_noDD": "-24",
                    "avgPrice_noDD": "2867.11",
                    "posPL_tminus_noDD": "-595.99999999999227",
                    "posPL_tplus_noDD": "-572.15999999999258",
                    "consolidatedPL_noDD": "-78.899999999999181",
                    "totRunningPL_noDD": "-651.05999999999176",
                    "posInversion_noDD": "FALSE",
                    "cumPL": "-651.05999999999176",
                    "dPL": "92.250000000001364",
                    "Prezzo_eseguito": "2890.95",
                    "Delta_prezzo": "0"
                    },
                    {
                    "Time": "18/09/2013 00:00",
                    "Price": "2908.92",
                    "BuySell": "N",
                    "Position": "0",
                    "avgPrice": "2890.95",
                    "posPL_tminus": "0",
                    "posPL_tplus": "0",
                    "consolidatedPL": "-651.05999999999176",
                    "totRunningPL": "-651.05999999999176",
                    "posInversion": "FALSE",
                    "rollOverTrade": "FALSE",
                    "rolloverData": null,
                    "drawdown": "651.05999999999176",
                    "avgdd": "26.308867924528016",
                    "stddd": "134.42931968510837",
                    "ddownLim": "631.24080650751569",
                    "ddPass": "FALSE",
                    "BuySell_noDD": "S",
                    "Position_noDD": "-90",
                    "avgPrice_noDD": "2897.7706666666663",
                    "posPL_tminus_noDD": "-1003.4399999999987",
                    "posPL_tplus_noDD": "-1003.4400000000369",
                    "consolidatedPL_noDD": "-78.899999999999181",
                    "totRunningPL_noDD": "-1082.3400000000361",
                    "posInversion_noDD": "FALSE",
                    "cumPL": "-651.05999999999176",
                    "dPL": "0",
                    "Prezzo_eseguito": "2910",
                    "Delta_prezzo": "1.0799999999999272"
                    },
                    {
                    "Time": "19/09/2013 00:00",
                    "Price": "2936.2",
                    "BuySell": "N",
                    "Position": "0",
                    "avgPrice": "2890.95",
                    "posPL_tminus": "0",
                    "posPL_tplus": "0",
                    "consolidatedPL": "-651.05999999999176",
                    "totRunningPL": "-651.05999999999176",
                    "posInversion": "FALSE",
                    "rollOverTrade": "FALSE",
                    "rolloverData": null,
                    "drawdown": "1082.3400000000361",
                    "avgdd": "45.865000000000386",
                    "stddd": "195.91365306088653",
                    "ddownLim": "927.4764387739898",
                    "ddPass": "FALSE",
                    "BuySell_noDD": "S",
                    "Position_noDD": "-43",
                    "avgPrice_noDD": "2897.7706666666663",
                    "posPL_tminus_noDD": "-3458.640000000014",
                    "posPL_tplus_noDD": "-1652.46133333334",
                    "consolidatedPL_noDD": "-1885.0786666666731",
                    "totRunningPL_noDD": "-3537.5400000000132",
                    "posInversion_noDD": "FALSE",
                    "cumPL": "-651.05999999999176",
                    "dPL": "0",
                    "Prezzo_eseguito": "2934",
                    "Delta_prezzo": "-2.1999999999998181"
                    },
                    {
                    "Time": "20/09/2013 00:00",
                    "Price": "2927.19",
                    "BuySell": "N",
                    "Position": "0",
                    "avgPrice": "2890.95",
                    "posPL_tminus": "0",
                    "posPL_tplus": "0",
                    "consolidatedPL": "-651.05999999999176",
                    "totRunningPL": "-651.05999999999176",
                    "posInversion": "FALSE",
                    "rollOverTrade": "FALSE",
                    "rolloverData": null,
                    "drawdown": "3537.5400000000132",
                    "avgdd": "109.35000000000061",
                    "stddd": "509.25471632573283",
                    "ddownLim": "2400.9962234657987",
                    "ddPass": "FALSE",
                    "BuySell_noDD": "S",
                    "Position_noDD": "-41",
                    "avgPrice_noDD": "2897.7706666666663",
                    "posPL_tminus_noDD": "-1265.0313333333502",
                    "posPL_tplus_noDD": "-1206.1926666666827",
                    "consolidatedPL_noDD": "-1943.9173333333406",
                    "totRunningPL_noDD": "-3150.1100000000233",
                    "posInversion_noDD": "FALSE",
                    "cumPL": "-651.05999999999176",
                    "dPL": "0",
                    "Prezzo_eseguito": "2930.5",
                    "Delta_prezzo": "3.3099999999999454"
                    },
                    {
                    "Time": "23/09/2013 00:00",
                    "Price": "2906.35",
                    "BuySell": "N",
                    "Position": "0",
                    "avgPrice": "2890.95",
                    "posPL_tminus": "0",
                    "posPL_tplus": "0",
                    "consolidatedPL": "-651.05999999999176",
                    "totRunningPL": "-651.05999999999176",
                    "posInversion": "FALSE",
                    "rollOverTrade": "FALSE",
                    "rolloverData": null,
                    "drawdown": "3150.1100000000233",
                    "avgdd": "163.64928571428672",
                    "stddd": "647.87049843694854",
                    "ddownLim": "3079.0665286805552",
                    "ddPass": "FALSE",
                    "BuySell_noDD": "S",
                    "Position_noDD": "-41",
                    "avgPrice_noDD": "2897.7706666666663",
                    "posPL_tminus_noDD": "-351.75266666667676",
                    "posPL_tplus_noDD": "-351.75266666667676",
                    "consolidatedPL_noDD": "-1943.9173333333406",
                    "totRunningPL_noDD": "-2295.6700000000174",
                    "posInversion_noDD": "FALSE",
                    "cumPL": "-651.05999999999176",
                    "dPL": "0",
                    "Prezzo_eseguito": "2907",
                    "Delta_prezzo": "0.65000000000009095"
                    },
                    {
                    "Time": "24/09/2013 00:00",
                    "Price": "2922.93",
                    "BuySell": "S",
                    "Position": "-41",
                    "avgPrice": "2922.93",
                    "posPL_tminus": "0",
                    "posPL_tplus": "0",
                    "consolidatedPL": "-651.05999999999176",
                    "totRunningPL": "-651.05999999999176",
                    "posInversion": "TRUE",
                    "rollOverTrade": "FALSE",
                    "rolloverData": null,
                    "drawdown": "2295.6700000000174",
                    "avgdd": "201.05315789473815",
                    "stddd": "701.41765307879882",
                    "ddownLim": "3357.4325967493328",
                    "ddPass": "TRUE",
                    "BuySell_noDD": "S",
                    "Position_noDD": "-41",
                    "avgPrice_noDD": "2897.7706666666663",
                    "posPL_tminus_noDD": "-1031.5326666666738",
                    "posPL_tplus_noDD": "-1031.5326666666738",
                    "consolidatedPL_noDD": "-1943.9173333333406",
                    "totRunningPL_noDD": "-2975.4500000000144",
                    "posInversion_noDD": "FALSE",
                    "cumPL": "-651.05999999999176",
                    "dPL": "0",
                    "Prezzo_eseguito": "2920.93",
                    "Delta_prezzo": "-2"
                    }
                                ]
                                """;


    @Autowired
    private Gson gson;

    private List<AlgorithmAndMetric> algorithmAndMetrics;

    @BeforeEach
    void init() {
        algorithmAndMetrics = Arrays.stream(gson.fromJson(jsonString, AlgorithmAndMetricDTO[].class)).sequential().map(AlgorithmAndMetricDTO::toEntity).collect(Collectors.toList());
    }

    @Test
    void testId() {
        Assertions.assertNull(algorithmAndMetrics.get(0).getId());
        Assertions.assertNull(algorithmAndMetrics.get(1).getId());
        Assertions.assertNull(algorithmAndMetrics.get(2).getId());
        Assertions.assertNull(algorithmAndMetrics.get(3).getId());
        Assertions.assertNull(algorithmAndMetrics.get(4).getId());
        Assertions.assertNull(algorithmAndMetrics.get(5).getId());
        Assertions.assertNull(algorithmAndMetrics.get(6).getId());
        Assertions.assertNull(algorithmAndMetrics.get(7).getId());
    }

    @Test
    void testTime() {
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 13, 00, 00), algorithmAndMetrics.get(0).getTime());
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 16, 00, 00), algorithmAndMetrics.get(1).getTime());
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 17, 00, 00), algorithmAndMetrics.get(2).getTime());
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 18, 00, 00), algorithmAndMetrics.get(3).getTime());
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 19, 00, 00), algorithmAndMetrics.get(4).getTime());
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 20, 00, 00), algorithmAndMetrics.get(5).getTime());
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 23, 00, 00), algorithmAndMetrics.get(6).getTime());
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 24, 00, 00), algorithmAndMetrics.get(7).getTime());

    }

    @Test
    void testPrice() {
        Assertions.assertEquals(2867.11, algorithmAndMetrics.get(0).getPrice());
        Assertions.assertEquals(2894.64, algorithmAndMetrics.get(1).getPrice());
        Assertions.assertEquals(2890.95, algorithmAndMetrics.get(2).getPrice());
        Assertions.assertEquals(2908.92, algorithmAndMetrics.get(3).getPrice());
        Assertions.assertEquals(2936.2, algorithmAndMetrics.get(4).getPrice());
        Assertions.assertEquals(2927.19, algorithmAndMetrics.get(5).getPrice());
        Assertions.assertEquals(2906.35, algorithmAndMetrics.get(6).getPrice());
        Assertions.assertEquals(2922.93, algorithmAndMetrics.get(7).getPrice());
    }

    @Test
    void testBuySell() {
        Assertions.assertEquals(Operation.SELL, algorithmAndMetrics.get(0).getBuySell());
        Assertions.assertEquals(Operation.SELL, algorithmAndMetrics.get(1).getBuySell());
        Assertions.assertEquals(Operation.NEUTRAL, algorithmAndMetrics.get(2).getBuySell());
        Assertions.assertEquals(Operation.NEUTRAL, algorithmAndMetrics.get(3).getBuySell());
        Assertions.assertEquals(Operation.NEUTRAL, algorithmAndMetrics.get(4).getBuySell());
        Assertions.assertEquals(Operation.NEUTRAL, algorithmAndMetrics.get(5).getBuySell());
        Assertions.assertEquals(Operation.NEUTRAL, algorithmAndMetrics.get(6).getBuySell());
        Assertions.assertEquals(Operation.SELL, algorithmAndMetrics.get(7).getBuySell());
    }

    @Test
    void testPosition() {
        Assertions.assertEquals(-27, algorithmAndMetrics.get(0).getPosition());
        Assertions.assertEquals(-25, algorithmAndMetrics.get(1).getPosition());
        Assertions.assertEquals(0, algorithmAndMetrics.get(2).getPosition());
        Assertions.assertEquals(0, algorithmAndMetrics.get(3).getPosition());
        Assertions.assertEquals(0, algorithmAndMetrics.get(4).getPosition());
        Assertions.assertEquals(0, algorithmAndMetrics.get(5).getPosition());
        Assertions.assertEquals(0, algorithmAndMetrics.get(6).getPosition());
        Assertions.assertEquals(-41, algorithmAndMetrics.get(7).getPosition());
    }

    @Test
    void testAvgPrice() {
        Assertions.assertEquals(2867.11, algorithmAndMetrics.get(0).getAvgPrice());
        Assertions.assertEquals(2867.11, algorithmAndMetrics.get(1).getAvgPrice());
        Assertions.assertEquals(2890.95, algorithmAndMetrics.get(2).getAvgPrice());
        Assertions.assertEquals(2890.95, algorithmAndMetrics.get(3).getAvgPrice());
        Assertions.assertEquals(2890.95, algorithmAndMetrics.get(4).getAvgPrice());
        Assertions.assertEquals(2890.95, algorithmAndMetrics.get(5).getAvgPrice());
        Assertions.assertEquals(2890.95, algorithmAndMetrics.get(6).getAvgPrice());
        Assertions.assertEquals(2922.93, algorithmAndMetrics.get(7).getAvgPrice());
    }

    @Test
    void testPosplTminus() {
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(0).getPosplTminus());
        Assertions.assertEquals(-743.3099999999931, algorithmAndMetrics.get(1).getPosplTminus());
        Assertions.assertEquals(-595.9999999999923, algorithmAndMetrics.get(2).getPosplTminus());
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(3).getPosplTminus());
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(4).getPosplTminus());
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(5).getPosplTminus());
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(6).getPosplTminus());
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(7).getPosplTminus());
    }

    @Test
    void testPosplTplus() {
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(0).getPosplTplus());
        Assertions.assertEquals(-688.2499999999936, algorithmAndMetrics.get(1).getPosplTplus());
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(2).getPosplTplus());
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(3).getPosplTplus());
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(4).getPosplTplus());
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(5).getPosplTplus());
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(6).getPosplTplus());
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(7).getPosplTplus());
    }

    @Test
    void testConsolidatedpl() {
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(0).getConsolidatedpl());
        Assertions.assertEquals(-55.05999999999949, algorithmAndMetrics.get(1).getConsolidatedpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetrics.get(2).getConsolidatedpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetrics.get(3).getConsolidatedpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetrics.get(4).getConsolidatedpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetrics.get(5).getConsolidatedpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetrics.get(6).getConsolidatedpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetrics.get(7).getConsolidatedpl());
    }

    @Test
    void testTotrunningpl() {
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(0).getTotrunningpl());
        Assertions.assertEquals(-743.3099999999931, algorithmAndMetrics.get(1).getTotrunningpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetrics.get(2).getTotrunningpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetrics.get(3).getTotrunningpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetrics.get(4).getTotrunningpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetrics.get(5).getTotrunningpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetrics.get(6).getTotrunningpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetrics.get(7).getTotrunningpl());
    }

    @Test
    void testPosinversion() {
        Assertions.assertEquals(true, algorithmAndMetrics.get(0).getPosinversion());
        Assertions.assertEquals(false, algorithmAndMetrics.get(1).getPosinversion());
        Assertions.assertEquals(true, algorithmAndMetrics.get(2).getPosinversion());
        Assertions.assertEquals(false, algorithmAndMetrics.get(3).getPosinversion());
        Assertions.assertEquals(false, algorithmAndMetrics.get(4).getPosinversion());
        Assertions.assertEquals(false, algorithmAndMetrics.get(5).getPosinversion());
        Assertions.assertEquals(false, algorithmAndMetrics.get(6).getPosinversion());
        Assertions.assertEquals(true, algorithmAndMetrics.get(7).getPosinversion());
    }

    @Test
    void testRollovertrade() {
        Assertions.assertEquals(false, algorithmAndMetrics.get(0).getRollovertrade());
        Assertions.assertEquals(false, algorithmAndMetrics.get(1).getRollovertrade());
        Assertions.assertEquals(false, algorithmAndMetrics.get(2).getRollovertrade());
        Assertions.assertEquals(false, algorithmAndMetrics.get(3).getRollovertrade());
        Assertions.assertEquals(false, algorithmAndMetrics.get(4).getRollovertrade());
        Assertions.assertEquals(false, algorithmAndMetrics.get(5).getRollovertrade());
        Assertions.assertEquals(false, algorithmAndMetrics.get(6).getRollovertrade());
        Assertions.assertEquals(false, algorithmAndMetrics.get(7).getRollovertrade());
    }

    @Test
    void testRolloverdata() {
        Assertions.assertNull(algorithmAndMetrics.get(0).getRolloverdata());
        Assertions.assertNull(algorithmAndMetrics.get(1).getRolloverdata());
        Assertions.assertNull(algorithmAndMetrics.get(2).getRolloverdata());
        Assertions.assertNull(algorithmAndMetrics.get(3).getRolloverdata());
        Assertions.assertNull(algorithmAndMetrics.get(4).getRolloverdata());
        Assertions.assertNull(algorithmAndMetrics.get(5).getRolloverdata());
        Assertions.assertNull(algorithmAndMetrics.get(6).getRolloverdata());
        Assertions.assertNull(algorithmAndMetrics.get(7).getRolloverdata());
    }

    @Test
    void testDrawdown() {
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(0).getDrawdown());
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(1).getDrawdown());
        Assertions.assertEquals(743.3099999999931, algorithmAndMetrics.get(2).getDrawdown());
        Assertions.assertEquals(651.0599999999918, algorithmAndMetrics.get(3).getDrawdown());
        Assertions.assertEquals(1082.340000000036, algorithmAndMetrics.get(4).getDrawdown());
        Assertions.assertEquals(3537.540000000013, algorithmAndMetrics.get(5).getDrawdown());
        Assertions.assertEquals(3150.1100000000233, algorithmAndMetrics.get(6).getDrawdown());
        Assertions.assertEquals(2295.6700000000174, algorithmAndMetrics.get(7).getDrawdown());
    }

    @Test
    void testAvgdd() {
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(0).getAvgdd());
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(1).getAvgdd());
        Assertions.assertEquals(14.294423076922945, algorithmAndMetrics.get(2).getAvgdd());
        Assertions.assertEquals(26.308867924528016, algorithmAndMetrics.get(3).getAvgdd());
        Assertions.assertEquals(45.865000000000386, algorithmAndMetrics.get(4).getAvgdd());
        Assertions.assertEquals(109.3500000000006, algorithmAndMetrics.get(5).getAvgdd());
        Assertions.assertEquals(163.64928571428672, algorithmAndMetrics.get(6).getAvgdd());
        Assertions.assertEquals(201.05315789473815, algorithmAndMetrics.get(7).getAvgdd());
    }

    @Test
    void testStddd() {
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(0).getStddd());
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(1).getStddd());
        Assertions.assertEquals(103.07855071404282, algorithmAndMetrics.get(2).getStddd());
        Assertions.assertEquals(134.42931968510837, algorithmAndMetrics.get(3).getStddd());
        Assertions.assertEquals(195.91365306088653, algorithmAndMetrics.get(4).getStddd());
        Assertions.assertEquals(509.25471632573283, algorithmAndMetrics.get(5).getStddd());
        Assertions.assertEquals(647.8704984369485, algorithmAndMetrics.get(6).getStddd());
        Assertions.assertEquals(701.4176530787988, algorithmAndMetrics.get(7).getStddd());
    }

    @Test
    void testDdownlim() {
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(0).getDdownlim());
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(1).getDdownlim());
        Assertions.assertEquals(478.14790129011567, algorithmAndMetrics.get(2).getDdownlim());
        Assertions.assertEquals(631.2408065075157, algorithmAndMetrics.get(3).getDdownlim());
        Assertions.assertEquals(927.4764387739898, algorithmAndMetrics.get(4).getDdownlim());
        Assertions.assertEquals(2400.9962234657987, algorithmAndMetrics.get(5).getDdownlim());
        Assertions.assertEquals(3079.066528680555, algorithmAndMetrics.get(6).getDdownlim());
        Assertions.assertEquals(3357.432596749333, algorithmAndMetrics.get(7).getDdownlim());
    }

    @Test
    void testDdpass() {
        Assertions.assertEquals(true, algorithmAndMetrics.get(0).getDdpass());
        Assertions.assertEquals(true, algorithmAndMetrics.get(1).getDdpass());
        Assertions.assertEquals(false, algorithmAndMetrics.get(2).getDdpass());
        Assertions.assertEquals(false, algorithmAndMetrics.get(3).getDdpass());
        Assertions.assertEquals(false, algorithmAndMetrics.get(4).getDdpass());
        Assertions.assertEquals(false, algorithmAndMetrics.get(5).getDdpass());
        Assertions.assertEquals(false, algorithmAndMetrics.get(6).getDdpass());
        Assertions.assertEquals(true, algorithmAndMetrics.get(7).getDdpass());
    }

    @Test
    void testBuysellNodd() {
        Assertions.assertEquals(Operation.SELL, algorithmAndMetrics.get(0).getBuysellNodd());
        Assertions.assertEquals(Operation.SELL, algorithmAndMetrics.get(1).getBuysellNodd());
        Assertions.assertEquals(Operation.SELL, algorithmAndMetrics.get(2).getBuysellNodd());
        Assertions.assertEquals(Operation.SELL, algorithmAndMetrics.get(3).getBuysellNodd());
        Assertions.assertEquals(Operation.SELL, algorithmAndMetrics.get(4).getBuysellNodd());
        Assertions.assertEquals(Operation.SELL, algorithmAndMetrics.get(5).getBuysellNodd());
        Assertions.assertEquals(Operation.SELL, algorithmAndMetrics.get(6).getBuysellNodd());
        Assertions.assertEquals(Operation.SELL, algorithmAndMetrics.get(7).getBuysellNodd());
    }

    @Test
    void testPositionNodd() {
        Assertions.assertEquals(-27, algorithmAndMetrics.get(0).getPositionNodd());
        Assertions.assertEquals(-25, algorithmAndMetrics.get(1).getPositionNodd());
        Assertions.assertEquals(-24, algorithmAndMetrics.get(2).getPositionNodd());
        Assertions.assertEquals(-90, algorithmAndMetrics.get(3).getPositionNodd());
        Assertions.assertEquals(-43, algorithmAndMetrics.get(4).getPositionNodd());
        Assertions.assertEquals(-41, algorithmAndMetrics.get(5).getPositionNodd());
        Assertions.assertEquals(-41, algorithmAndMetrics.get(6).getPositionNodd());
        Assertions.assertEquals(-41, algorithmAndMetrics.get(7).getPositionNodd());
    }

    @Test
    void testAvgpriceNodd() {
        Assertions.assertEquals(2867.11, algorithmAndMetrics.get(0).getAvgpriceNodd());
        Assertions.assertEquals(2867.11, algorithmAndMetrics.get(1).getAvgpriceNodd());
        Assertions.assertEquals(2867.11, algorithmAndMetrics.get(2).getAvgpriceNodd());
        Assertions.assertEquals(2897.7706666666663, algorithmAndMetrics.get(3).getAvgpriceNodd());
        Assertions.assertEquals(2897.7706666666663, algorithmAndMetrics.get(4).getAvgpriceNodd());
        Assertions.assertEquals(2897.7706666666663, algorithmAndMetrics.get(5).getAvgpriceNodd());
        Assertions.assertEquals(2897.7706666666663, algorithmAndMetrics.get(6).getAvgpriceNodd());
        Assertions.assertEquals(2897.7706666666663, algorithmAndMetrics.get(7).getAvgpriceNodd());
    }

    @Test
    void testPosplTminusNodd() {
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(0).getPosplTminusNodd());
        Assertions.assertEquals(-743.3099999999931, algorithmAndMetrics.get(1).getPosplTminusNodd());
        Assertions.assertEquals(-595.9999999999923, algorithmAndMetrics.get(2).getPosplTminusNodd());
        Assertions.assertEquals(-1003.4399999999987, algorithmAndMetrics.get(3).getPosplTminusNodd());
        Assertions.assertEquals(-3458.640000000014, algorithmAndMetrics.get(4).getPosplTminusNodd());
        Assertions.assertEquals(-1265.0313333333502, algorithmAndMetrics.get(5).getPosplTminusNodd());
        Assertions.assertEquals(-351.75266666667676, algorithmAndMetrics.get(6).getPosplTminusNodd());
        Assertions.assertEquals(-1031.5326666666738, algorithmAndMetrics.get(7).getPosplTminusNodd());
    }

    @Test
    void testPosplTplusNodd() {
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(0).getPosplTplusNodd());
        Assertions.assertEquals(-688.2499999999936, algorithmAndMetrics.get(1).getPosplTplusNodd());
        Assertions.assertEquals(-572.1599999999926, algorithmAndMetrics.get(2).getPosplTplusNodd());
        Assertions.assertEquals(-1003.4400000000369, algorithmAndMetrics.get(3).getPosplTplusNodd());
        Assertions.assertEquals(-1652.46133333334, algorithmAndMetrics.get(4).getPosplTplusNodd());
        Assertions.assertEquals(-1206.1926666666827, algorithmAndMetrics.get(5).getPosplTplusNodd());
        Assertions.assertEquals(-351.75266666667676, algorithmAndMetrics.get(6).getPosplTplusNodd());
        Assertions.assertEquals(-1031.5326666666738, algorithmAndMetrics.get(7).getPosplTplusNodd());
    }

    @Test
    void testConsolidatedplNodd() {
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(0).getConsolidatedplNodd());
        Assertions.assertEquals(-55.05999999999949, algorithmAndMetrics.get(1).getConsolidatedplNodd());
        Assertions.assertEquals(-78.89999999999918, algorithmAndMetrics.get(2).getConsolidatedplNodd());
        Assertions.assertEquals(-78.89999999999918, algorithmAndMetrics.get(3).getConsolidatedplNodd());
        Assertions.assertEquals(-1885.0786666666731, algorithmAndMetrics.get(4).getConsolidatedplNodd());
        Assertions.assertEquals(-1943.9173333333406, algorithmAndMetrics.get(5).getConsolidatedplNodd());
        Assertions.assertEquals(-1943.9173333333406, algorithmAndMetrics.get(6).getConsolidatedplNodd());
        Assertions.assertEquals(-1943.9173333333406, algorithmAndMetrics.get(7).getConsolidatedplNodd());
    }

    @Test
    void testTotrunningplNodd() {
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(0).getTotrunningplNodd());
        Assertions.assertEquals(-743.3099999999931, algorithmAndMetrics.get(1).getTotrunningplNodd());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetrics.get(2).getTotrunningplNodd());
        Assertions.assertEquals(-1082.340000000036, algorithmAndMetrics.get(3).getTotrunningplNodd());
        Assertions.assertEquals(-3537.540000000013, algorithmAndMetrics.get(4).getTotrunningplNodd());
        Assertions.assertEquals(-3150.1100000000233, algorithmAndMetrics.get(5).getTotrunningplNodd());
        Assertions.assertEquals(-2295.6700000000174, algorithmAndMetrics.get(6).getTotrunningplNodd());
        Assertions.assertEquals(-2975.4500000000144, algorithmAndMetrics.get(7).getTotrunningplNodd());
    }

    @Test
    void testPosinversionNodd() {
        Assertions.assertEquals(true, algorithmAndMetrics.get(0).getPosinversionNodd());
        Assertions.assertEquals(false, algorithmAndMetrics.get(1).getPosinversionNodd());
        Assertions.assertEquals(false, algorithmAndMetrics.get(2).getPosinversionNodd());
        Assertions.assertEquals(false, algorithmAndMetrics.get(3).getPosinversionNodd());
        Assertions.assertEquals(false, algorithmAndMetrics.get(4).getPosinversionNodd());
        Assertions.assertEquals(false, algorithmAndMetrics.get(5).getPosinversionNodd());
        Assertions.assertEquals(false, algorithmAndMetrics.get(6).getPosinversionNodd());
        Assertions.assertEquals(false, algorithmAndMetrics.get(7).getPosinversionNodd());
    }

    @Test
    void testCumpl() {
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(0).getCumpl());
        Assertions.assertEquals(-743.3099999999931, algorithmAndMetrics.get(1).getCumpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetrics.get(2).getCumpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetrics.get(3).getCumpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetrics.get(4).getCumpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetrics.get(5).getCumpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetrics.get(6).getCumpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetrics.get(7).getCumpl());
    }

    @Test
    void testDpl() {
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(0).getDpl());
        Assertions.assertEquals(-743.3099999999931, algorithmAndMetrics.get(1).getDpl());
        Assertions.assertEquals(92.25000000000136, algorithmAndMetrics.get(2).getDpl());
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(3).getDpl());
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(4).getDpl());
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(5).getDpl());
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(6).getDpl());
        Assertions.assertEquals(0.0, algorithmAndMetrics.get(7).getDpl());
    }

    @Test
    void testExecutedPrice() {
        Assertions.assertNull(algorithmAndMetrics.get(0).getExecutedPrice());
        Assertions.assertNull(algorithmAndMetrics.get(1).getExecutedPrice());
        Assertions.assertNull(algorithmAndMetrics.get(2).getExecutedPrice());
        Assertions.assertNull(algorithmAndMetrics.get(3).getExecutedPrice());
        Assertions.assertNull(algorithmAndMetrics.get(4).getExecutedPrice());
        Assertions.assertNull(algorithmAndMetrics.get(5).getExecutedPrice());
        Assertions.assertNull(algorithmAndMetrics.get(6).getExecutedPrice());
        Assertions.assertNull(algorithmAndMetrics.get(7).getExecutedPrice());
    }

    @Test
    void testDeltaPrice() {
        Assertions.assertNull(algorithmAndMetrics.get(0).getDeltaPrice());
        Assertions.assertNull(algorithmAndMetrics.get(1).getDeltaPrice());
        Assertions.assertNull(algorithmAndMetrics.get(2).getDeltaPrice());
        Assertions.assertNull(algorithmAndMetrics.get(3).getDeltaPrice());
        Assertions.assertNull(algorithmAndMetrics.get(4).getDeltaPrice());
        Assertions.assertNull(algorithmAndMetrics.get(5).getDeltaPrice());
        Assertions.assertNull(algorithmAndMetrics.get(6).getDeltaPrice());
        Assertions.assertNull(algorithmAndMetrics.get(7).getDeltaPrice());
    }
}
