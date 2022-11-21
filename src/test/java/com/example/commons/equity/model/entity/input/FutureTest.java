package com.example.commons.equity.model.entity.input;

import com.example.commons.equity.model.dto.input.FutureDTO;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class FutureTest {
    private static final String jsonString =

            """
                                [
                    {
                    "REF_DATE": "26/10/2022",
                    "UNDERLYING": ".STOXX50E",
                    "TIME": "11.56.30",
                    "PRICE": "3565"
                    },
                    {
                    "REF_DATE": "26/10/2022",
                    "UNDERLYING": ".STOXX50E",
                    "TIME": "11.56.15",
                    "PRICE": "3566"
                    },
                    {
                    "REF_DATE": "26/10/2022",
                    "UNDERLYING": ".STOXX50E",
                    "TIME": "11.56.00",
                    "PRICE": "3565.8"
                    },
                    {
                    "REF_DATE": "26/10/2022",
                    "UNDERLYING": ".STOXX50E",
                    "TIME": "11.55.45",
                    "PRICE": "3564"
                    }
                                ]
                                """;
    ;
    private static final String jsonStringHistorical =

            """
                              [
                    {
                    "REF_DATE": "26/10/2022",
                    "UNDERLYING": ".STOXX50E",
                    "TIME": "11.56.30",
                    "PRICE": "3565"
                    },
                    {
                    "REF_DATE": "26/10/2022",
                    "UNDERLYING": ".STOXX50E",
                    "TIME": "11.56.15",
                    "PRICE": "3566"
                    },
                    {
                    "REF_DATE": "26/10/2022",
                    "UNDERLYING": ".STOXX50E",
                    "TIME": "11.56.00",
                    "PRICE": "3565.8"
                    },
                    {
                    "REF_DATE": "26/10/2022",
                    "UNDERLYING": ".STOXX50E",
                    "TIME": "11.55.45",
                    "PRICE": "3564"
                    }
                              ]
                              """;


    @Autowired
    private Gson gsonHistorical;

    private List<Future> futuresHistorical;

    @BeforeEach
    void initHistorical() {
        futuresHistorical = Arrays.stream(gson.fromJson(jsonStringHistorical, FutureDTO[].class)).sequential().map(FutureDTO::toEntity).collect(Collectors.toList());
    }

    @Test
    void testIdHistorical() {
        Assertions.assertNull(futuresHistorical.get(0).getId());
        Assertions.assertNull(futuresHistorical.get(1).getId());
        Assertions.assertNull(futuresHistorical.get(2).getId());
        Assertions.assertNull(futuresHistorical.get(3).getId());
    }

    @Test
    void testRefDateHistorical() {
        Assertions.assertEquals(LocalDate.of(2022, 10, 26), futuresHistorical.get(0).getRefDate());
        Assertions.assertEquals(LocalDate.of(2022, 10, 26), futuresHistorical.get(1).getRefDate());
        Assertions.assertEquals(LocalDate.of(2022, 10, 26), futuresHistorical.get(2).getRefDate());
        Assertions.assertEquals(LocalDate.of(2022, 10, 26), futuresHistorical.get(3).getRefDate());
    }



    @Test
    void testTimeHistorical() {
        Assertions.assertEquals(LocalTime.of(11, 56, 30), futuresHistorical.get(0).getTime());
        Assertions.assertEquals(LocalTime.of(11, 56, 15), futuresHistorical.get(1).getTime());
        Assertions.assertEquals(LocalTime.of(11, 56, 0), futuresHistorical.get(2).getTime());
        Assertions.assertEquals(LocalTime.of(11, 55, 45), futuresHistorical.get(3).getTime());
    }


    @Test
    void testPriceCloseHistorical() {
        Assertions.assertNull(futuresHistorical.get(0).getPriceClose());
        Assertions.assertNull(futuresHistorical.get(1).getPriceClose());
        Assertions.assertNull(futuresHistorical.get(2).getPriceClose());
        Assertions.assertNull(futuresHistorical.get(3).getPriceClose());
    }

    @Test
    void testPriceOpenHistorical() {
        Assertions.assertNull(futuresHistorical.get(0).getPriceOpen());
        Assertions.assertNull(futuresHistorical.get(1).getPriceOpen());
        Assertions.assertNull(futuresHistorical.get(2).getPriceOpen());
        Assertions.assertNull(futuresHistorical.get(3).getPriceOpen());
    }

    @Test
    void testPriceLowHistorical() {
        Assertions.assertNull(futuresHistorical.get(0).getPriceLow());
        Assertions.assertNull(futuresHistorical.get(1).getPriceLow());
        Assertions.assertNull(futuresHistorical.get(2).getPriceLow());
        Assertions.assertNull(futuresHistorical.get(3).getPriceLow());
    }

    @Test
    void testPriceHighHistorical() {
        Assertions.assertNull(futuresHistorical.get(0).getPriceHigh());
        Assertions.assertNull(futuresHistorical.get(1).getPriceHigh());
        Assertions.assertNull(futuresHistorical.get(2).getPriceHigh());
        Assertions.assertNull(futuresHistorical.get(3).getPriceHigh());
    }

    @Test
    void testVolumeHistorical() {
        Assertions.assertNull(futuresHistorical.get(0).getVolume());
        Assertions.assertNull(futuresHistorical.get(1).getVolume());
        Assertions.assertNull(futuresHistorical.get(2).getVolume());
        Assertions.assertNull(futuresHistorical.get(3).getVolume());
    }

    @Autowired
    private Gson gson;

    private List<Future> futures;

    @BeforeEach
    void init() {
        futures = Arrays.stream(gson.fromJson(jsonString, FutureDTO[].class)).sequential().map(FutureDTO::toEntity).collect(Collectors.toList());
    }

    @Test
    void testId() {
        Assertions.assertNull(futures.get(0).getId());
        Assertions.assertNull(futures.get(1).getId());
        Assertions.assertNull(futures.get(2).getId());
        Assertions.assertNull(futures.get(3).getId());
    }

    @Test
    void testRefDate() {
        Assertions.assertEquals(LocalDate.of(2022, 10, 26), futures.get(0).getRefDate());
        Assertions.assertEquals(LocalDate.of(2022, 10, 26), futures.get(1).getRefDate());
        Assertions.assertEquals(LocalDate.of(2022, 10, 26), futures.get(2).getRefDate());
        Assertions.assertEquals(LocalDate.of(2022, 10, 26), futures.get(3).getRefDate());
    }


    @Test
    void testTime() {
        Assertions.assertEquals(LocalTime.of(11, 56, 30), futures.get(0).getTime());
        Assertions.assertEquals(LocalTime.of(11, 56, 15), futures.get(1).getTime());
        Assertions.assertEquals(LocalTime.of(11, 56, 0), futures.get(2).getTime());
        Assertions.assertEquals(LocalTime.of(11, 55, 45), futures.get(3).getTime());
    }



    @Test
    void testPriceClose() {
        Assertions.assertNull(futures.get(0).getPriceClose());
        Assertions.assertNull(futures.get(1).getPriceClose());
        Assertions.assertNull(futures.get(2).getPriceClose());
        Assertions.assertNull(futures.get(3).getPriceClose());
    }

    @Test
    void testPriceOpen() {
        Assertions.assertNull(futures.get(0).getPriceOpen());
        Assertions.assertNull(futures.get(1).getPriceOpen());
        Assertions.assertNull(futures.get(2).getPriceOpen());
        Assertions.assertNull(futures.get(3).getPriceOpen());
    }

    @Test
    void testPriceLow() {
        Assertions.assertNull(futures.get(0).getPriceLow());
        Assertions.assertNull(futures.get(1).getPriceLow());
        Assertions.assertNull(futures.get(2).getPriceLow());
        Assertions.assertNull(futures.get(3).getPriceLow());
    }

    @Test
    void testPriceHigh() {
        Assertions.assertNull(futures.get(0).getPriceHigh());
        Assertions.assertNull(futures.get(1).getPriceHigh());
        Assertions.assertNull(futures.get(2).getPriceHigh());
        Assertions.assertNull(futures.get(3).getPriceHigh());
    }

    @Test
    void testVolume() {
        Assertions.assertNull(futures.get(0).getVolume());
        Assertions.assertNull(futures.get(1).getVolume());
        Assertions.assertNull(futures.get(2).getVolume());
        Assertions.assertNull(futures.get(3).getVolume());
    }
}
