package com.example.commons.equity.model.dto.output;

import com.example.commons.equity.model.enums.Operation;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.Month;

@SpringBootTest
class AlgorithmAndMetricDTOTest {

    private final BufferedReader bufferedReader;
    @Autowired
    private Gson gson;
    private AlgorithmAndMetricDTO[] algorithmAndMetricDTOs;

    public AlgorithmAndMetricDTOTest() throws URISyntaxException, IOException {
        URL resource = OrderDTOTest.class.getClassLoader().getResource("AlgorithmAndMetric.json");
        assert resource != null;
        File file = new File(resource.toURI());
        this.bufferedReader = new BufferedReader(new InputStreamReader(Files.newInputStream(file.toPath())));
    }

    @BeforeEach
    void init() {
        algorithmAndMetricDTOs = gson.fromJson(bufferedReader, AlgorithmAndMetricDTO[].class);
    }

    @Test
    void testTime() {
        Assertions.assertEquals(LocalDateTime.of(2013, Month.SEPTEMBER, 13, 0, 0), algorithmAndMetricDTOs[0].getTime());
        Assertions.assertEquals(LocalDateTime.of(2013, Month.SEPTEMBER, 16, 0, 0), algorithmAndMetricDTOs[1].getTime());
        Assertions.assertEquals(LocalDateTime.of(2013, Month.SEPTEMBER, 17, 0, 0), algorithmAndMetricDTOs[2].getTime());
        Assertions.assertEquals(LocalDateTime.of(2013, Month.SEPTEMBER, 18, 0, 0), algorithmAndMetricDTOs[3].getTime());
        Assertions.assertEquals(LocalDateTime.of(2013, Month.SEPTEMBER, 19, 0, 0), algorithmAndMetricDTOs[4].getTime());
        Assertions.assertEquals(LocalDateTime.of(2013, Month.SEPTEMBER, 20, 0, 0), algorithmAndMetricDTOs[5].getTime());
        Assertions.assertEquals(LocalDateTime.of(2013, Month.SEPTEMBER, 23, 0, 0), algorithmAndMetricDTOs[6].getTime());
        Assertions.assertEquals(LocalDateTime.of(2013, Month.SEPTEMBER, 24, 0, 0), algorithmAndMetricDTOs[7].getTime());
    }


    @Test
    void testPrice() {
        Assertions.assertEquals(2867.11, algorithmAndMetricDTOs[0].getPrice());
        Assertions.assertEquals(2894.64, algorithmAndMetricDTOs[1].getPrice());
        Assertions.assertEquals(2890.95, algorithmAndMetricDTOs[2].getPrice());
        Assertions.assertEquals(2908.92, algorithmAndMetricDTOs[3].getPrice());
        Assertions.assertEquals(2936.2, algorithmAndMetricDTOs[4].getPrice());
        Assertions.assertEquals(2927.19, algorithmAndMetricDTOs[5].getPrice());
        Assertions.assertEquals(2906.35, algorithmAndMetricDTOs[6].getPrice());
        Assertions.assertEquals(2922.93, algorithmAndMetricDTOs[7].getPrice());
    }


    @Test
    void testBuySell() {
        Assertions.assertEquals(Operation.SELL, algorithmAndMetricDTOs[0].getBuySell());
        Assertions.assertEquals(Operation.SELL, algorithmAndMetricDTOs[1].getBuySell());
        Assertions.assertEquals(Operation.NEUTRAL, algorithmAndMetricDTOs[2].getBuySell());
        Assertions.assertEquals(Operation.NEUTRAL, algorithmAndMetricDTOs[3].getBuySell());
        Assertions.assertEquals(Operation.NEUTRAL, algorithmAndMetricDTOs[4].getBuySell());
        Assertions.assertEquals(Operation.NEUTRAL, algorithmAndMetricDTOs[5].getBuySell());
        Assertions.assertEquals(Operation.NEUTRAL, algorithmAndMetricDTOs[6].getBuySell());
        Assertions.assertEquals(Operation.SELL, algorithmAndMetricDTOs[7].getBuySell());
    }


    @Test
    void testPosition() {
        Assertions.assertEquals(-27, algorithmAndMetricDTOs[0].getPosition());
        Assertions.assertEquals(-25, algorithmAndMetricDTOs[1].getPosition());
        Assertions.assertEquals(0, algorithmAndMetricDTOs[2].getPosition());
        Assertions.assertEquals(0, algorithmAndMetricDTOs[3].getPosition());
        Assertions.assertEquals(0, algorithmAndMetricDTOs[4].getPosition());
        Assertions.assertEquals(0, algorithmAndMetricDTOs[5].getPosition());
        Assertions.assertEquals(0, algorithmAndMetricDTOs[6].getPosition());
        Assertions.assertEquals(-41, algorithmAndMetricDTOs[7].getPosition());
    }


    @Test
    void testAvgprice() {
        Assertions.assertEquals(2867.11, algorithmAndMetricDTOs[0].getAvgprice());
        Assertions.assertEquals(2867.11, algorithmAndMetricDTOs[1].getAvgprice());
        Assertions.assertEquals(2890.95, algorithmAndMetricDTOs[2].getAvgprice());
        Assertions.assertEquals(2890.95, algorithmAndMetricDTOs[3].getAvgprice());
        Assertions.assertEquals(2890.95, algorithmAndMetricDTOs[4].getAvgprice());
        Assertions.assertEquals(2890.95, algorithmAndMetricDTOs[5].getAvgprice());
        Assertions.assertEquals(2890.95, algorithmAndMetricDTOs[6].getAvgprice());
        Assertions.assertEquals(2922.93, algorithmAndMetricDTOs[7].getAvgprice());
    }


    @Test
    void testPosplTminus() {
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[0].getPosplTminus());
        Assertions.assertEquals(-743.3099999999931, algorithmAndMetricDTOs[1].getPosplTminus());
        Assertions.assertEquals(-595.9999999999923, algorithmAndMetricDTOs[2].getPosplTminus());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[3].getPosplTminus());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[4].getPosplTminus());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[5].getPosplTminus());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[6].getPosplTminus());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[7].getPosplTminus());
    }


    @Test
    void testPosplTplus() {
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[0].getPosplTplus());
        Assertions.assertEquals(-688.2499999999936, algorithmAndMetricDTOs[1].getPosplTplus());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[2].getPosplTplus());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[3].getPosplTplus());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[4].getPosplTplus());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[5].getPosplTplus());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[6].getPosplTplus());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[7].getPosplTplus());
    }


    @Test
    void testConsolidatedpl() {
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[0].getConsolidatedpl());
        Assertions.assertEquals(-55.05999999999949, algorithmAndMetricDTOs[1].getConsolidatedpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[2].getConsolidatedpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[3].getConsolidatedpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[4].getConsolidatedpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[5].getConsolidatedpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[6].getConsolidatedpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[7].getConsolidatedpl());
    }


    @Test
    void testTotrunningpl() {
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[0].getTotrunningpl());
        Assertions.assertEquals(-743.3099999999931, algorithmAndMetricDTOs[1].getTotrunningpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[2].getTotrunningpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[3].getTotrunningpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[4].getTotrunningpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[5].getTotrunningpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[6].getTotrunningpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[7].getTotrunningpl());
    }


    @Test
    void testPosinversion() {
        Assertions.assertEquals(true, algorithmAndMetricDTOs[0].getPosinversion());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[1].getPosinversion());
        Assertions.assertEquals(true, algorithmAndMetricDTOs[2].getPosinversion());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[3].getPosinversion());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[4].getPosinversion());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[5].getPosinversion());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[6].getPosinversion());
        Assertions.assertEquals(true, algorithmAndMetricDTOs[7].getPosinversion());
    }


    @Test
    void testRollovertrade() {
        Assertions.assertEquals(false, algorithmAndMetricDTOs[0].getRollovertrade());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[1].getRollovertrade());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[2].getRollovertrade());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[3].getRollovertrade());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[4].getRollovertrade());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[5].getRollovertrade());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[6].getRollovertrade());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[7].getRollovertrade());
    }


    @Test
    void testRolloverdata() {
        Assertions.assertNull(algorithmAndMetricDTOs[0].getRolloverdata());
        Assertions.assertNull(algorithmAndMetricDTOs[1].getRolloverdata());
        Assertions.assertNull(algorithmAndMetricDTOs[2].getRolloverdata());
        Assertions.assertNull(algorithmAndMetricDTOs[3].getRolloverdata());
        Assertions.assertNull(algorithmAndMetricDTOs[4].getRolloverdata());
        Assertions.assertNull(algorithmAndMetricDTOs[5].getRolloverdata());
        Assertions.assertNull(algorithmAndMetricDTOs[6].getRolloverdata());
        Assertions.assertNull(algorithmAndMetricDTOs[7].getRolloverdata());
    }


    @Test
    void testDrawdown() {
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[0].getDrawdown());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[1].getDrawdown());
        Assertions.assertEquals(743.3099999999931, algorithmAndMetricDTOs[2].getDrawdown());
        Assertions.assertEquals(651.0599999999918, algorithmAndMetricDTOs[3].getDrawdown());
        Assertions.assertEquals(1082.340000000036, algorithmAndMetricDTOs[4].getDrawdown());
        Assertions.assertEquals(3537.540000000013, algorithmAndMetricDTOs[5].getDrawdown());
        Assertions.assertEquals(3150.1100000000233, algorithmAndMetricDTOs[6].getDrawdown());
        Assertions.assertEquals(2295.6700000000174, algorithmAndMetricDTOs[7].getDrawdown());
    }


    @Test
    void testAvgdd() {
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[0].getAvgdd());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[1].getAvgdd());
        Assertions.assertEquals(14.294423076922945, algorithmAndMetricDTOs[2].getAvgdd());
        Assertions.assertEquals(26.308867924528016, algorithmAndMetricDTOs[3].getAvgdd());
        Assertions.assertEquals(45.865000000000386, algorithmAndMetricDTOs[4].getAvgdd());
        Assertions.assertEquals(109.3500000000006, algorithmAndMetricDTOs[5].getAvgdd());
        Assertions.assertEquals(163.64928571428672, algorithmAndMetricDTOs[6].getAvgdd());
        Assertions.assertEquals(201.05315789473815, algorithmAndMetricDTOs[7].getAvgdd());
    }


    @Test
    void testStddd() {
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[0].getStddd());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[1].getStddd());
        Assertions.assertEquals(103.07855071404282, algorithmAndMetricDTOs[2].getStddd());
        Assertions.assertEquals(134.42931968510837, algorithmAndMetricDTOs[3].getStddd());
        Assertions.assertEquals(195.91365306088653, algorithmAndMetricDTOs[4].getStddd());
        Assertions.assertEquals(509.25471632573283, algorithmAndMetricDTOs[5].getStddd());
        Assertions.assertEquals(647.8704984369485, algorithmAndMetricDTOs[6].getStddd());
        Assertions.assertEquals(701.4176530787988, algorithmAndMetricDTOs[7].getStddd());
    }


    @Test
    void testDdownlim() {
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[0].getDdownlim());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[1].getDdownlim());
        Assertions.assertEquals(478.14790129011567, algorithmAndMetricDTOs[2].getDdownlim());
        Assertions.assertEquals(631.2408065075157, algorithmAndMetricDTOs[3].getDdownlim());
        Assertions.assertEquals(927.4764387739898, algorithmAndMetricDTOs[4].getDdownlim());
        Assertions.assertEquals(2400.9962234657987, algorithmAndMetricDTOs[5].getDdownlim());
        Assertions.assertEquals(3079.066528680555, algorithmAndMetricDTOs[6].getDdownlim());
        Assertions.assertEquals(3357.432596749333, algorithmAndMetricDTOs[7].getDdownlim());
    }


    @Test
    void testDdpass() {
        Assertions.assertEquals(true, algorithmAndMetricDTOs[0].getDdpass());
        Assertions.assertEquals(true, algorithmAndMetricDTOs[1].getDdpass());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[2].getDdpass());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[3].getDdpass());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[4].getDdpass());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[5].getDdpass());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[6].getDdpass());
        Assertions.assertEquals(true, algorithmAndMetricDTOs[7].getDdpass());
    }


    @Test
    void testBuysellNodd() {
        Assertions.assertEquals(Operation.SELL, algorithmAndMetricDTOs[0].getBuysellNodd());
        Assertions.assertEquals(Operation.SELL, algorithmAndMetricDTOs[1].getBuysellNodd());
        Assertions.assertEquals(Operation.SELL, algorithmAndMetricDTOs[2].getBuysellNodd());
        Assertions.assertEquals(Operation.SELL, algorithmAndMetricDTOs[3].getBuysellNodd());
        Assertions.assertEquals(Operation.SELL, algorithmAndMetricDTOs[4].getBuysellNodd());
        Assertions.assertEquals(Operation.SELL, algorithmAndMetricDTOs[5].getBuysellNodd());
        Assertions.assertEquals(Operation.SELL, algorithmAndMetricDTOs[6].getBuysellNodd());
        Assertions.assertEquals(Operation.SELL, algorithmAndMetricDTOs[7].getBuysellNodd());
    }


    @Test
    void testPositionNodd() {
        Assertions.assertEquals(-27, algorithmAndMetricDTOs[0].getPositionNodd());
        Assertions.assertEquals(-25, algorithmAndMetricDTOs[1].getPositionNodd());
        Assertions.assertEquals(-24, algorithmAndMetricDTOs[2].getPositionNodd());
        Assertions.assertEquals(-90, algorithmAndMetricDTOs[3].getPositionNodd());
        Assertions.assertEquals(-43, algorithmAndMetricDTOs[4].getPositionNodd());
        Assertions.assertEquals(-41, algorithmAndMetricDTOs[5].getPositionNodd());
        Assertions.assertEquals(-41, algorithmAndMetricDTOs[6].getPositionNodd());
        Assertions.assertEquals(-41, algorithmAndMetricDTOs[7].getPositionNodd());
    }


    @Test
    void testAvgpriceNodd() {
        Assertions.assertEquals(2867.11, algorithmAndMetricDTOs[0].getAvgpriceNodd());
        Assertions.assertEquals(2867.11, algorithmAndMetricDTOs[1].getAvgpriceNodd());
        Assertions.assertEquals(2867.11, algorithmAndMetricDTOs[2].getAvgpriceNodd());
        Assertions.assertEquals(2897.7706666666663, algorithmAndMetricDTOs[3].getAvgpriceNodd());
        Assertions.assertEquals(2897.7706666666663, algorithmAndMetricDTOs[4].getAvgpriceNodd());
        Assertions.assertEquals(2897.7706666666663, algorithmAndMetricDTOs[5].getAvgpriceNodd());
        Assertions.assertEquals(2897.7706666666663, algorithmAndMetricDTOs[6].getAvgpriceNodd());
        Assertions.assertEquals(2897.7706666666663, algorithmAndMetricDTOs[7].getAvgpriceNodd());
    }


    @Test
    void testPosplTminusNodd() {
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[0].getPosplTminusNodd());
        Assertions.assertEquals(-743.3099999999931, algorithmAndMetricDTOs[1].getPosplTminusNodd());
        Assertions.assertEquals(-595.9999999999923, algorithmAndMetricDTOs[2].getPosplTminusNodd());
        Assertions.assertEquals(-1003.4399999999987, algorithmAndMetricDTOs[3].getPosplTminusNodd());
        Assertions.assertEquals(-3458.640000000014, algorithmAndMetricDTOs[4].getPosplTminusNodd());
        Assertions.assertEquals(-1265.0313333333502, algorithmAndMetricDTOs[5].getPosplTminusNodd());
        Assertions.assertEquals(-351.75266666667676, algorithmAndMetricDTOs[6].getPosplTminusNodd());
        Assertions.assertEquals(-1031.5326666666738, algorithmAndMetricDTOs[7].getPosplTminusNodd());
    }


    @Test
    void testPosplTplusNodd() {
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[0].getPosplTplusNodd());
        Assertions.assertEquals(-688.2499999999936, algorithmAndMetricDTOs[1].getPosplTplusNodd());
        Assertions.assertEquals(-572.1599999999926, algorithmAndMetricDTOs[2].getPosplTplusNodd());
        Assertions.assertEquals(-1003.4400000000369, algorithmAndMetricDTOs[3].getPosplTplusNodd());
        Assertions.assertEquals(-1652.46133333334, algorithmAndMetricDTOs[4].getPosplTplusNodd());
        Assertions.assertEquals(-1206.1926666666827, algorithmAndMetricDTOs[5].getPosplTplusNodd());
        Assertions.assertEquals(-351.75266666667676, algorithmAndMetricDTOs[6].getPosplTplusNodd());
        Assertions.assertEquals(-1031.5326666666738, algorithmAndMetricDTOs[7].getPosplTplusNodd());
    }


    @Test
    void testConsolidatedplNodd() {
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[0].getConsolidatedplNodd());
        Assertions.assertEquals(-55.05999999999949, algorithmAndMetricDTOs[1].getConsolidatedplNodd());
        Assertions.assertEquals(-78.89999999999918, algorithmAndMetricDTOs[2].getConsolidatedplNodd());
        Assertions.assertEquals(-78.89999999999918, algorithmAndMetricDTOs[3].getConsolidatedplNodd());
        Assertions.assertEquals(-1885.0786666666731, algorithmAndMetricDTOs[4].getConsolidatedplNodd());
        Assertions.assertEquals(-1943.9173333333406, algorithmAndMetricDTOs[5].getConsolidatedplNodd());
        Assertions.assertEquals(-1943.9173333333406, algorithmAndMetricDTOs[6].getConsolidatedplNodd());
        Assertions.assertEquals(-1943.9173333333406, algorithmAndMetricDTOs[7].getConsolidatedplNodd());
    }


    @Test
    void testTotrunningplNodd() {
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[0].getTotrunningplNodd());
        Assertions.assertEquals(-743.3099999999931, algorithmAndMetricDTOs[1].getTotrunningplNodd());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[2].getTotrunningplNodd());
        Assertions.assertEquals(-1082.340000000036, algorithmAndMetricDTOs[3].getTotrunningplNodd());
        Assertions.assertEquals(-3537.540000000013, algorithmAndMetricDTOs[4].getTotrunningplNodd());
        Assertions.assertEquals(-3150.1100000000233, algorithmAndMetricDTOs[5].getTotrunningplNodd());
        Assertions.assertEquals(-2295.6700000000174, algorithmAndMetricDTOs[6].getTotrunningplNodd());
        Assertions.assertEquals(-2975.4500000000144, algorithmAndMetricDTOs[7].getTotrunningplNodd());
    }


    @Test
    void testPosinversionNodd() {
        Assertions.assertEquals(true, algorithmAndMetricDTOs[0].getPosinversionNodd());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[1].getPosinversionNodd());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[2].getPosinversionNodd());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[3].getPosinversionNodd());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[4].getPosinversionNodd());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[5].getPosinversionNodd());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[6].getPosinversionNodd());
        Assertions.assertEquals(false, algorithmAndMetricDTOs[7].getPosinversionNodd());
    }


    @Test
    void testCumpl() {
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[0].getCumpl());
        Assertions.assertEquals(-743.3099999999931, algorithmAndMetricDTOs[1].getCumpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[2].getCumpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[3].getCumpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[4].getCumpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[5].getCumpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[6].getCumpl());
        Assertions.assertEquals(-651.0599999999918, algorithmAndMetricDTOs[7].getCumpl());
    }


    @Test
    void testDpl() {
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[0].getDpl());
        Assertions.assertEquals(-743.3099999999931, algorithmAndMetricDTOs[1].getDpl());
        Assertions.assertEquals(92.25000000000136, algorithmAndMetricDTOs[2].getDpl());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[3].getDpl());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[4].getDpl());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[5].getDpl());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[6].getDpl());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[7].getDpl());
    }


    @Test
    void testExecutedPrice() {
        Assertions.assertEquals(2865.0, algorithmAndMetricDTOs[0].getExecutedPrice());
        Assertions.assertEquals(2896.0, algorithmAndMetricDTOs[1].getExecutedPrice());
        Assertions.assertEquals(2890.95, algorithmAndMetricDTOs[2].getExecutedPrice());
        Assertions.assertEquals(2910.0, algorithmAndMetricDTOs[3].getExecutedPrice());
        Assertions.assertEquals(2934.0, algorithmAndMetricDTOs[4].getExecutedPrice());
        Assertions.assertEquals(2930.5, algorithmAndMetricDTOs[5].getExecutedPrice());
        Assertions.assertEquals(2907.0, algorithmAndMetricDTOs[6].getExecutedPrice());
        Assertions.assertEquals(2920.93, algorithmAndMetricDTOs[7].getExecutedPrice());
    }


    @Test
    void testDeltaPrice() {
        Assertions.assertEquals(-2.1100000000001273, algorithmAndMetricDTOs[0].getDeltaPrice());
        Assertions.assertEquals(1.3600000000001273, algorithmAndMetricDTOs[1].getDeltaPrice());
        Assertions.assertEquals(0.0, algorithmAndMetricDTOs[2].getDeltaPrice());
        Assertions.assertEquals(1.0799999999999272, algorithmAndMetricDTOs[3].getDeltaPrice());
        Assertions.assertEquals(-2.199999999999818, algorithmAndMetricDTOs[4].getDeltaPrice());
        Assertions.assertEquals(3.3099999999999454, algorithmAndMetricDTOs[5].getDeltaPrice());
        Assertions.assertEquals(0.650000000000091, algorithmAndMetricDTOs[6].getDeltaPrice());
        Assertions.assertEquals(-2.0, algorithmAndMetricDTOs[7].getDeltaPrice());
    }
}