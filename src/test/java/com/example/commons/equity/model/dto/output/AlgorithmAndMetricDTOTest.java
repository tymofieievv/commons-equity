package com.example.commons.equity.model.dto.output;

import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.Month;

@SpringBootTest
class AlgorithmAndMetricDTOTest {


    private final String jsonString =
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
    private AlgorithmAndMetricDTO[] algorithmAndMetricDTOs;

    @BeforeEach
    void init() {
        algorithmAndMetricDTOs = gson.fromJson(jsonString, AlgorithmAndMetricDTO[].class);
    }

    @Test
    void testTime() {
        Assertions.assertEquals(LocalDateTime.of(2013, Month.SEPTEMBER, 13, 0, 0), algorithmAndMetricDTOs[0].time());
        Assertions.assertEquals(LocalDateTime.of(2013, Month.SEPTEMBER, 16, 0, 0), algorithmAndMetricDTOs[1].time());
        Assertions.assertEquals(LocalDateTime.of(2013, Month.SEPTEMBER, 17, 0, 0), algorithmAndMetricDTOs[2].time());
        Assertions.assertEquals(LocalDateTime.of(2013, Month.SEPTEMBER, 18, 0, 0), algorithmAndMetricDTOs[3].time());
        Assertions.assertEquals(LocalDateTime.of(2013, Month.SEPTEMBER, 19, 0, 0), algorithmAndMetricDTOs[4].time());
        Assertions.assertEquals(LocalDateTime.of(2013, Month.SEPTEMBER, 20, 0, 0), algorithmAndMetricDTOs[5].time());
        Assertions.assertEquals(LocalDateTime.of(2013, Month.SEPTEMBER, 23, 0, 0), algorithmAndMetricDTOs[6].time());
        Assertions.assertEquals(LocalDateTime.of(2013, Month.SEPTEMBER, 24, 0, 0), algorithmAndMetricDTOs[7].time());
    }


    @Test
    void testPrice() {
        Assertions.assertEquals(2867.11, algorithmAndMetricDTOs[0].price());
        Assertions.assertEquals(2894.64, algorithmAndMetricDTOs[1].price());
        Assertions.assertEquals(2890.95, algorithmAndMetricDTOs[2].price());
        Assertions.assertEquals(2908.92, algorithmAndMetricDTOs[3].price());
        Assertions.assertEquals(2936.2, algorithmAndMetricDTOs[4].price());
        Assertions.assertEquals(2927.19, algorithmAndMetricDTOs[5].price());
        Assertions.assertEquals(2906.35, algorithmAndMetricDTOs[6].price());
        Assertions.assertEquals(2922.93, algorithmAndMetricDTOs[7].price());
    }


    @Test
    void testBuySell() {
        Assertions.assertEquals("S", algorithmAndMetricDTOs[0].buySell());
        Assertions.assertEquals("S", algorithmAndMetricDTOs[1].buySell());
        Assertions.assertEquals("N", algorithmAndMetricDTOs[2].buySell());
        Assertions.assertEquals("N", algorithmAndMetricDTOs[3].buySell());
        Assertions.assertEquals("N", algorithmAndMetricDTOs[4].buySell());
        Assertions.assertEquals("N", algorithmAndMetricDTOs[5].buySell());
        Assertions.assertEquals("N", algorithmAndMetricDTOs[6].buySell());
        Assertions.assertEquals("S", algorithmAndMetricDTOs[7].buySell());
    }


    @Test
    void testPosition() {
        Assertions.assertEquals(-27, algorithmAndMetricDTOs[0].position());
        Assertions.assertEquals(-25, algorithmAndMetricDTOs[1].position());
        Assertions.assertEquals(0, algorithmAndMetricDTOs[2].position());
        Assertions.assertEquals(0, algorithmAndMetricDTOs[3].position());
        Assertions.assertEquals(0, algorithmAndMetricDTOs[4].position());
        Assertions.assertEquals(0, algorithmAndMetricDTOs[5].position());
        Assertions.assertEquals(0, algorithmAndMetricDTOs[6].position());
        Assertions.assertEquals(-41, algorithmAndMetricDTOs[7].position());
    }


    @Test
    void testAvgprice() {
        Assertions.assertEquals(2867.11, algorithmAndMetricDTOs[0].avgprice());
        Assertions.assertEquals(2867.11, algorithmAndMetricDTOs[1].avgprice());
        Assertions.assertEquals(2890.95, algorithmAndMetricDTOs[2].avgprice());
        Assertions.assertEquals(2890.95, algorithmAndMetricDTOs[3].avgprice());
        Assertions.assertEquals(2890.95, algorithmAndMetricDTOs[4].avgprice());
        Assertions.assertEquals(2890.95, algorithmAndMetricDTOs[5].avgprice());
        Assertions.assertEquals(2890.95, algorithmAndMetricDTOs[6].avgprice());
        Assertions.assertEquals(2922.93, algorithmAndMetricDTOs[7].avgprice());
    }


    @Test
    void testPosplTminus() {
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[0].posplTminus());
        Assertions.assertEquals(-743.3099999999931, algorithmAndMetricDTOs[1].posplTminus());
        Assertions.assertEquals(-595.9999999999923, algorithmAndMetricDTOs[2].posplTminus());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[3].posplTminus());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[4].posplTminus());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[5].posplTminus());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[6].posplTminus());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[7].posplTminus());
    }


    @Test
    void testPosplTplus() {
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[0].posplTplus());
        Assertions.assertEquals(-688.2499999999936, algorithmAndMetricDTOs[1].posplTplus());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[2].posplTplus());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[3].posplTplus());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[4].posplTplus());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[5].posplTplus());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[6].posplTplus());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[7].posplTplus());
    }


    @Test
    void testConsolidatedpl() {
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[0].consolidatedpl());
        Assertions.assertEquals(-55.05999999999949, algorithmAndMetricDTOs[1].consolidatedpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[2].consolidatedpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[3].consolidatedpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[4].consolidatedpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[5].consolidatedpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[6].consolidatedpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[7].consolidatedpl());
    }


    @Test
    void testTotrunningpl() {
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[0].totrunningpl());
        Assertions.assertEquals(-743.3099999999931, algorithmAndMetricDTOs[1].totrunningpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[2].totrunningpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[3].totrunningpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[4].totrunningpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[5].totrunningpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[6].totrunningpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[7].totrunningpl());
    }


    @Test
    void testPosinversion() {
        Assertions.assertEquals(true, algorithmAndMetricDTOs[0].posinversion());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[1].posinversion());
        Assertions.assertEquals(true, algorithmAndMetricDTOs[2].posinversion());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[3].posinversion());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[4].posinversion());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[5].posinversion());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[6].posinversion());
        Assertions.assertEquals(true, algorithmAndMetricDTOs[7].posinversion());
    }


    @Test
    void testRollovertrade() {
        Assertions.assertEquals(false, algorithmAndMetricDTOs[0].rollovertrade());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[1].rollovertrade());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[2].rollovertrade());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[3].rollovertrade());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[4].rollovertrade());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[5].rollovertrade());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[6].rollovertrade());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[7].rollovertrade());
    }


    @Test
    void testRolloverdata() {
        Assertions.assertNull(algorithmAndMetricDTOs[0].rolloverdata());
        Assertions.assertNull(algorithmAndMetricDTOs[1].rolloverdata());
        Assertions.assertNull(algorithmAndMetricDTOs[2].rolloverdata());
        Assertions.assertNull(algorithmAndMetricDTOs[3].rolloverdata());
        Assertions.assertNull(algorithmAndMetricDTOs[4].rolloverdata());
        Assertions.assertNull(algorithmAndMetricDTOs[5].rolloverdata());
        Assertions.assertNull(algorithmAndMetricDTOs[6].rolloverdata());
        Assertions.assertNull(algorithmAndMetricDTOs[7].rolloverdata());
    }


    @Test
    void testDrawdown() {
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[0].drawdown());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[1].drawdown());
        Assertions.assertEquals(743.3099999999931, algorithmAndMetricDTOs[2].drawdown());
        Assertions.assertEquals(651.0599999999918, algorithmAndMetricDTOs[3].drawdown());
        Assertions.assertEquals(1082.340000000036, algorithmAndMetricDTOs[4].drawdown());
        Assertions.assertEquals(3537.540000000013, algorithmAndMetricDTOs[5].drawdown());
        Assertions.assertEquals(3150.1100000000233, algorithmAndMetricDTOs[6].drawdown());
        Assertions.assertEquals(2295.6700000000174, algorithmAndMetricDTOs[7].drawdown());
    }


    @Test
    void testAvgdd() {
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[0].avgdd());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[1].avgdd());
        Assertions.assertEquals(14.294423076922945, algorithmAndMetricDTOs[2].avgdd());
        Assertions.assertEquals(26.308867924528016, algorithmAndMetricDTOs[3].avgdd());
        Assertions.assertEquals(45.865000000000386, algorithmAndMetricDTOs[4].avgdd());
        Assertions.assertEquals(109.3500000000006, algorithmAndMetricDTOs[5].avgdd());
        Assertions.assertEquals(163.64928571428672, algorithmAndMetricDTOs[6].avgdd());
        Assertions.assertEquals(201.05315789473815, algorithmAndMetricDTOs[7].avgdd());
    }


    @Test
    void testStddd() {
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[0].stddd());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[1].stddd());
        Assertions.assertEquals(103.07855071404282, algorithmAndMetricDTOs[2].stddd());
        Assertions.assertEquals(134.42931968510837, algorithmAndMetricDTOs[3].stddd());
        Assertions.assertEquals(195.91365306088653, algorithmAndMetricDTOs[4].stddd());
        Assertions.assertEquals(509.25471632573283, algorithmAndMetricDTOs[5].stddd());
        Assertions.assertEquals(647.8704984369485, algorithmAndMetricDTOs[6].stddd());
        Assertions.assertEquals(701.4176530787988, algorithmAndMetricDTOs[7].stddd());
    }


    @Test
    void testDdownlim() {
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[0].ddownlim());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[1].ddownlim());
        Assertions.assertEquals(478.14790129011567, algorithmAndMetricDTOs[2].ddownlim());
        Assertions.assertEquals(631.2408065075157, algorithmAndMetricDTOs[3].ddownlim());
        Assertions.assertEquals(927.4764387739898, algorithmAndMetricDTOs[4].ddownlim());
        Assertions.assertEquals(2400.9962234657987, algorithmAndMetricDTOs[5].ddownlim());
        Assertions.assertEquals(3079.066528680555, algorithmAndMetricDTOs[6].ddownlim());
        Assertions.assertEquals(3357.432596749333, algorithmAndMetricDTOs[7].ddownlim());
    }


    @Test
    void testDdpass() {
        Assertions.assertEquals(true, algorithmAndMetricDTOs[0].ddpass());
        Assertions.assertEquals(true, algorithmAndMetricDTOs[1].ddpass());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[2].ddpass());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[3].ddpass());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[4].ddpass());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[5].ddpass());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[6].ddpass());
        Assertions.assertEquals(true, algorithmAndMetricDTOs[7].ddpass());
    }


    @Test
    void testBuysellNodd() {
        Assertions.assertEquals("S", algorithmAndMetricDTOs[0].buysellNodd());
        Assertions.assertEquals("S", algorithmAndMetricDTOs[1].buysellNodd());
        Assertions.assertEquals("S", algorithmAndMetricDTOs[2].buysellNodd());
        Assertions.assertEquals("S", algorithmAndMetricDTOs[3].buysellNodd());
        Assertions.assertEquals("S", algorithmAndMetricDTOs[4].buysellNodd());
        Assertions.assertEquals("S", algorithmAndMetricDTOs[5].buysellNodd());
        Assertions.assertEquals("S", algorithmAndMetricDTOs[6].buysellNodd());
        Assertions.assertEquals("S", algorithmAndMetricDTOs[7].buysellNodd());
    }


    @Test
    void testPositionNodd() {
        Assertions.assertEquals(-27, algorithmAndMetricDTOs[0].positionNodd());
        Assertions.assertEquals(-25, algorithmAndMetricDTOs[1].positionNodd());
        Assertions.assertEquals(-24, algorithmAndMetricDTOs[2].positionNodd());
        Assertions.assertEquals(-90, algorithmAndMetricDTOs[3].positionNodd());
        Assertions.assertEquals(-43, algorithmAndMetricDTOs[4].positionNodd());
        Assertions.assertEquals(-41, algorithmAndMetricDTOs[5].positionNodd());
        Assertions.assertEquals(-41, algorithmAndMetricDTOs[6].positionNodd());
        Assertions.assertEquals(-41, algorithmAndMetricDTOs[7].positionNodd());
    }


    @Test
    void testAvgpriceNodd() {
        Assertions.assertEquals(2867.11, algorithmAndMetricDTOs[0].avgpriceNodd());
        Assertions.assertEquals(2867.11, algorithmAndMetricDTOs[1].avgpriceNodd());
        Assertions.assertEquals(2867.11, algorithmAndMetricDTOs[2].avgpriceNodd());
        Assertions.assertEquals(2897.7706666666663, algorithmAndMetricDTOs[3].avgpriceNodd());
        Assertions.assertEquals(2897.7706666666663, algorithmAndMetricDTOs[4].avgpriceNodd());
        Assertions.assertEquals(2897.7706666666663, algorithmAndMetricDTOs[5].avgpriceNodd());
        Assertions.assertEquals(2897.7706666666663, algorithmAndMetricDTOs[6].avgpriceNodd());
        Assertions.assertEquals(2897.7706666666663, algorithmAndMetricDTOs[7].avgpriceNodd());
    }


    @Test
    void testPosplTminusNodd() {
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[0].posplTminusNodd());
        Assertions.assertEquals(-743.3099999999931, algorithmAndMetricDTOs[1].posplTminusNodd());
        Assertions.assertEquals(-595.9999999999923, algorithmAndMetricDTOs[2].posplTminusNodd());
        Assertions.assertEquals(-1003.4399999999987, algorithmAndMetricDTOs[3].posplTminusNodd());
        Assertions.assertEquals(-3458.640000000014, algorithmAndMetricDTOs[4].posplTminusNodd());
        Assertions.assertEquals(-1265.0313333333502, algorithmAndMetricDTOs[5].posplTminusNodd());
        Assertions.assertEquals(-351.75266666667676, algorithmAndMetricDTOs[6].posplTminusNodd());
        Assertions.assertEquals(-1031.5326666666738, algorithmAndMetricDTOs[7].posplTminusNodd());
    }


    @Test
    void testPosplTplusNodd() {
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[0].posplTplusNodd());
        Assertions.assertEquals(-688.2499999999936, algorithmAndMetricDTOs[1].posplTplusNodd());
        Assertions.assertEquals(-572.1599999999926, algorithmAndMetricDTOs[2].posplTplusNodd());
        Assertions.assertEquals(-1003.4400000000369, algorithmAndMetricDTOs[3].posplTplusNodd());
        Assertions.assertEquals(-1652.46133333334, algorithmAndMetricDTOs[4].posplTplusNodd());
        Assertions.assertEquals(-1206.1926666666827, algorithmAndMetricDTOs[5].posplTplusNodd());
        Assertions.assertEquals(-351.75266666667676, algorithmAndMetricDTOs[6].posplTplusNodd());
        Assertions.assertEquals(-1031.5326666666738, algorithmAndMetricDTOs[7].posplTplusNodd());
    }


    @Test
    void testConsolidatedplNodd() {
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[0].consolidatedplNodd());
        Assertions.assertEquals(-55.05999999999949, algorithmAndMetricDTOs[1].consolidatedplNodd());
        Assertions.assertEquals(-78.89999999999918, algorithmAndMetricDTOs[2].consolidatedplNodd());
        Assertions.assertEquals(-78.89999999999918, algorithmAndMetricDTOs[3].consolidatedplNodd());
        Assertions.assertEquals(-1885.0786666666731, algorithmAndMetricDTOs[4].consolidatedplNodd());
        Assertions.assertEquals(-1943.9173333333406, algorithmAndMetricDTOs[5].consolidatedplNodd());
        Assertions.assertEquals(-1943.9173333333406, algorithmAndMetricDTOs[6].consolidatedplNodd());
        Assertions.assertEquals(-1943.9173333333406, algorithmAndMetricDTOs[7].consolidatedplNodd());
    }


    @Test
    void testTotrunningplNodd() {
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[0].totrunningplNodd());
        Assertions.assertEquals(-743.3099999999931, algorithmAndMetricDTOs[1].totrunningplNodd());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[2].totrunningplNodd());
        Assertions.assertEquals(-1082.340000000036, algorithmAndMetricDTOs[3].totrunningplNodd());
        Assertions.assertEquals(-3537.540000000013, algorithmAndMetricDTOs[4].totrunningplNodd());
        Assertions.assertEquals(-3150.1100000000233, algorithmAndMetricDTOs[5].totrunningplNodd());
        Assertions.assertEquals(-2295.6700000000174, algorithmAndMetricDTOs[6].totrunningplNodd());
        Assertions.assertEquals(-2975.4500000000144, algorithmAndMetricDTOs[7].totrunningplNodd());
    }


    @Test
    void testPosinversionNodd() {
        Assertions.assertEquals(true, algorithmAndMetricDTOs[0].posinversionNodd());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[1].posinversionNodd());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[2].posinversionNodd());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[3].posinversionNodd());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[4].posinversionNodd());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[5].posinversionNodd());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[6].posinversionNodd());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[7].posinversionNodd());
    }


    @Test
    void testCumpl() {
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[0].cumpl());
        Assertions.assertEquals(-743.3099999999931, algorithmAndMetricDTOs[1].cumpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[2].cumpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[3].cumpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[4].cumpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[5].cumpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[6].cumpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[7].cumpl());
    }


    @Test
    void testDpl() {
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[0].dpl());
        Assertions.assertEquals(-743.3099999999931, algorithmAndMetricDTOs[1].dpl());
        Assertions.assertEquals(92.25000000000136, algorithmAndMetricDTOs[2].dpl());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[3].dpl());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[4].dpl());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[5].dpl());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[6].dpl());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[7].dpl());
    }


    @Test
    void testPrezzoEseguito() {
        Assertions.assertEquals(2865.0, algorithmAndMetricDTOs[0].prezzoEseguito());
        Assertions.assertEquals(2896.0, algorithmAndMetricDTOs[1].prezzoEseguito());
        Assertions.assertEquals(2890.95, algorithmAndMetricDTOs[2].prezzoEseguito());
        Assertions.assertEquals(2910.0, algorithmAndMetricDTOs[3].prezzoEseguito());
        Assertions.assertEquals(2934.0, algorithmAndMetricDTOs[4].prezzoEseguito());
        Assertions.assertEquals(2930.5, algorithmAndMetricDTOs[5].prezzoEseguito());
        Assertions.assertEquals(2907.0, algorithmAndMetricDTOs[6].prezzoEseguito());
        Assertions.assertEquals(2920.93, algorithmAndMetricDTOs[7].prezzoEseguito());
    }


    @Test
    void testDeltaPrezzo() {
        Assertions.assertEquals(-2.1100000000001273, algorithmAndMetricDTOs[0].deltaPrezzo());
        Assertions.assertEquals(1.3600000000001273, algorithmAndMetricDTOs[1].deltaPrezzo());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[2].deltaPrezzo());
        Assertions.assertEquals(1.0799999999999272, algorithmAndMetricDTOs[3].deltaPrezzo());
        Assertions.assertEquals(-2.199999999999818, algorithmAndMetricDTOs[4].deltaPrezzo());
        Assertions.assertEquals(3.3099999999999454, algorithmAndMetricDTOs[5].deltaPrezzo());
        Assertions.assertEquals(0.650000000000091, algorithmAndMetricDTOs[6].deltaPrezzo());
        Assertions.assertEquals(-2.0, algorithmAndMetricDTOs[7].deltaPrezzo());
    }
}