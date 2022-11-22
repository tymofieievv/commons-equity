package com.example.commons.equity.model.entity.output;

import com.example.commons.equity.model.dto.output.AlgorithmAndMetricDTO;
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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class AlgorithmAndMetricTest {

    private final BufferedReader bufferedReader;
    @Autowired
    private Gson gson;
    private List<AlgorithmAndMetric> algorithmAndMetrics;

    public AlgorithmAndMetricTest() throws URISyntaxException, IOException {
        URL resource = AlgorithmAndMetricTest.class.getClassLoader().getResource("AlgorithmAndMetric.json");
        assert resource != null;
        File file = new File(resource.toURI());
        this.bufferedReader = new BufferedReader(new InputStreamReader(Files.newInputStream(file.toPath())));
    }

    @BeforeEach
    void init() {
        algorithmAndMetrics = Arrays.stream(gson.fromJson(bufferedReader, AlgorithmAndMetricDTO[].class)).sequential().map(AlgorithmAndMetricDTO::toEntity).collect(Collectors.toList());
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
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 13, 0, 0), algorithmAndMetrics.get(0).getTime());
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 16, 0, 0), algorithmAndMetrics.get(1).getTime());
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 17, 0, 0), algorithmAndMetrics.get(2).getTime());
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 18, 0, 0), algorithmAndMetrics.get(3).getTime());
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 19, 0, 0), algorithmAndMetrics.get(4).getTime());
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 20, 0, 0), algorithmAndMetrics.get(5).getTime());
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 23, 0, 0), algorithmAndMetrics.get(6).getTime());
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 24, 0, 0), algorithmAndMetrics.get(7).getTime());
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
        Assertions.assertEquals(2865, algorithmAndMetrics.get(0).getExecutedPrice());
        Assertions.assertEquals(2896, algorithmAndMetrics.get(1).getExecutedPrice());
        Assertions.assertEquals(2890.95, algorithmAndMetrics.get(2).getExecutedPrice());
        Assertions.assertEquals(2910, algorithmAndMetrics.get(3).getExecutedPrice());
        Assertions.assertEquals(2934, algorithmAndMetrics.get(4).getExecutedPrice());
        Assertions.assertEquals(2930.5, algorithmAndMetrics.get(5).getExecutedPrice());
        Assertions.assertEquals(2907, algorithmAndMetrics.get(6).getExecutedPrice());
        Assertions.assertEquals(2920.93, algorithmAndMetrics.get(7).getExecutedPrice());
    }

    @Test
    void testDeltaPrice() {
        Assertions.assertEquals(-2.1100000000001273, algorithmAndMetrics.get(0).getDeltaPrice());
        Assertions.assertEquals(1.3600000000001273, algorithmAndMetrics.get(1).getDeltaPrice());
        Assertions.assertEquals(0, algorithmAndMetrics.get(2).getDeltaPrice());
        Assertions.assertEquals(1.0799999999999272, algorithmAndMetrics.get(3).getDeltaPrice());
        Assertions.assertEquals(-2.1999999999998181, algorithmAndMetrics.get(4).getDeltaPrice());
        Assertions.assertEquals(3.3099999999999454, algorithmAndMetrics.get(5).getDeltaPrice());
        Assertions.assertEquals(0.65000000000009095, algorithmAndMetrics.get(6).getDeltaPrice());
        Assertions.assertEquals(-2, algorithmAndMetrics.get(7).getDeltaPrice());
    }
}
