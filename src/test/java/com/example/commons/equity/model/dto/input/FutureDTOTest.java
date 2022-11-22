package com.example.commons.equity.model.dto.input;

import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootTest
class FutureDTOTest {


    private final String historyFutureString =
            """
                                [
                    {
                  
                    "UNDERLYING_ID": ".STOXX50E",
                    "UNDERLYING_DESCRIPTION": ".STOXX50E",
                    "PRICE": "3564.39"
                    },
                    {
                   
                    "UNDERLYING_ID": ".STOXX50E",
                    "UNDERLYING_DESCRIPTION": ".STOXX50E",
                    "PRICE": "3547.85"
                    },
                    {
                    
                    "UNDERLYING_ID": ".STOXX50E",
                    "UNDERLYING_DESCRIPTION": ".STOXX50E",
                    "PRICE": "3611.08"
                    },
                    {
                    
                    "UNDERLYING_ID": ".STOXX50E",
                    "UNDERLYING_DESCRIPTION": ".STOXX50E",
                    "PRICE": "3622.42"
                    }
                                ]
                                """;
    private final String realtimeFutureString =
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
    private Gson gson;
    private FutureDTO[] historyFutureDTOs;
    private FutureDTO[] realtimeFutureDTOs;

    @BeforeEach
    void init() {
        historyFutureDTOs = gson.fromJson(historyFutureString, FutureDTO[].class);
        realtimeFutureDTOs = gson.fromJson(realtimeFutureString, FutureDTO[].class);
    }

    @Test
    void testRefDate() {

        Assertions.assertEquals(LocalDate.of(2022, 10, 26), realtimeFutureDTOs[0].refDate());
        Assertions.assertEquals(LocalDate.of(2022, 10, 26), realtimeFutureDTOs[1].refDate());
        Assertions.assertEquals(LocalDate.of(2022, 10, 26), realtimeFutureDTOs[2].refDate());
        Assertions.assertEquals(LocalDate.of(2022, 10, 26), realtimeFutureDTOs[3].refDate());
    }

    @Test
    void testRic(){
        Assertions.assertNull(historyFutureDTOs[0].ric());
        Assertions.assertNull(historyFutureDTOs[1].ric());
        Assertions.assertNull(historyFutureDTOs[2].ric());
        Assertions.assertNull(historyFutureDTOs[3].ric());
        Assertions.assertNull(realtimeFutureDTOs[0].ric());
        Assertions.assertNull(realtimeFutureDTOs[1].ric());
        Assertions.assertNull(realtimeFutureDTOs[2].ric());
        Assertions.assertNull(realtimeFutureDTOs[3].ric());
    }


    @Test
    void testTime() {
        Assertions.assertNull(historyFutureDTOs[0].time());
        Assertions.assertNull(historyFutureDTOs[1].time());
        Assertions.assertNull(historyFutureDTOs[2].time());
        Assertions.assertNull(historyFutureDTOs[3].time());

        Assertions.assertEquals(LocalTime.of(11, 56, 30), realtimeFutureDTOs[0].time());
        Assertions.assertEquals(LocalTime.of(11, 56, 15), realtimeFutureDTOs[1].time());
        Assertions.assertEquals(LocalTime.of(11, 56, 0), realtimeFutureDTOs[2].time());
        Assertions.assertEquals(LocalTime.of(11, 55, 45), realtimeFutureDTOs[3].time());
    }


    @Test
    void testPriceClose() {
        Assertions.assertNull(historyFutureDTOs[0].priceClose());
        Assertions.assertNull(historyFutureDTOs[1].priceClose());
        Assertions.assertNull(historyFutureDTOs[2].priceClose());
        Assertions.assertNull(historyFutureDTOs[3].priceClose());
        Assertions.assertNull(realtimeFutureDTOs[0].priceClose());
        Assertions.assertNull(realtimeFutureDTOs[1].priceClose());
        Assertions.assertNull(realtimeFutureDTOs[2].priceClose());
        Assertions.assertNull(realtimeFutureDTOs[3].priceClose());
    }


    @Test
    void testPriceOpen() {
        Assertions.assertNull(historyFutureDTOs[0].priceOpen());
        Assertions.assertNull(historyFutureDTOs[1].priceOpen());
        Assertions.assertNull(historyFutureDTOs[2].priceOpen());
        Assertions.assertNull(historyFutureDTOs[3].priceOpen());
        Assertions.assertNull(realtimeFutureDTOs[0].priceOpen());
        Assertions.assertNull(realtimeFutureDTOs[1].priceOpen());
        Assertions.assertNull(realtimeFutureDTOs[2].priceOpen());
        Assertions.assertNull(realtimeFutureDTOs[3].priceOpen());
    }


    @Test
    void testPriceLow() {
        Assertions.assertNull(historyFutureDTOs[0].priceLow());
        Assertions.assertNull(historyFutureDTOs[1].priceLow());
        Assertions.assertNull(historyFutureDTOs[2].priceLow());
        Assertions.assertNull(historyFutureDTOs[3].priceLow());

        Assertions.assertNull(realtimeFutureDTOs[0].priceLow());
        Assertions.assertNull(realtimeFutureDTOs[1].priceLow());
        Assertions.assertNull(realtimeFutureDTOs[2].priceLow());
        Assertions.assertNull(realtimeFutureDTOs[3].priceLow());
    }


    @Test
    void testPriceHigh() {
        Assertions.assertNull(historyFutureDTOs[0].priceHigh());
        Assertions.assertNull(historyFutureDTOs[1].priceHigh());
        Assertions.assertNull(historyFutureDTOs[2].priceHigh());
        Assertions.assertNull(historyFutureDTOs[3].priceHigh());

        Assertions.assertNull(realtimeFutureDTOs[0].priceHigh());
        Assertions.assertNull(realtimeFutureDTOs[1].priceHigh());
        Assertions.assertNull(realtimeFutureDTOs[2].priceHigh());
        Assertions.assertNull(realtimeFutureDTOs[3].priceHigh());
    }


    @Test
    void testVolume() {
        Assertions.assertNull(historyFutureDTOs[0].volume());
        Assertions.assertNull(historyFutureDTOs[1].volume());
        Assertions.assertNull(historyFutureDTOs[2].volume());
        Assertions.assertNull(historyFutureDTOs[3].volume());

        Assertions.assertNull(realtimeFutureDTOs[0].volume());
        Assertions.assertNull(realtimeFutureDTOs[1].volume());
        Assertions.assertNull(realtimeFutureDTOs[2].volume());
        Assertions.assertNull(realtimeFutureDTOs[3].volume());
    }
}