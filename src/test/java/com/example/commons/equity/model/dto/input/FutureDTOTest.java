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
                    "REF_DATE": "04/01/2021",
                    "ISIN": "DE0009652388",
                    "TICKER": "VGH21",
                    "UNDERLYING_ID": ".STOXX50E",
                    "UNDERLYING_DESCRIPTION": ".STOXX50E",
                    "PRICE": "3564.39"
                    },
                    {
                    "REF_DATE": "05/01/2021",
                    "ISIN": "DE0009652388",
                    "TICKER": "VGH21",
                    "UNDERLYING_ID": ".STOXX50E",
                    "UNDERLYING_DESCRIPTION": ".STOXX50E",
                    "PRICE": "3547.85"
                    },
                    {
                    "REF_DATE": "06/01/2021",
                    "ISIN": "DE0009652388",
                    "TICKER": "VGH21",
                    "UNDERLYING_ID": ".STOXX50E",
                    "UNDERLYING_DESCRIPTION": ".STOXX50E",
                    "PRICE": "3611.08"
                    },
                    {
                    "REF_DATE": "07/01/2021",
                    "ISIN": "DE0009652388",
                    "TICKER": "VGH21",
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
        Assertions.assertEquals(LocalDate.of(2021, 1, 4), historyFutureDTOs[0].refDate());
        Assertions.assertEquals(LocalDate.of(2021, 1, 5), historyFutureDTOs[1].refDate());
        Assertions.assertEquals(LocalDate.of(2021, 1, 6), historyFutureDTOs[2].refDate());
        Assertions.assertEquals(LocalDate.of(2021, 1, 7), historyFutureDTOs[3].refDate());

        Assertions.assertEquals(LocalDate.of(2022, 10, 26), realtimeFutureDTOs[0].refDate());
        Assertions.assertEquals(LocalDate.of(2022, 10, 26), realtimeFutureDTOs[1].refDate());
        Assertions.assertEquals(LocalDate.of(2022, 10, 26), realtimeFutureDTOs[2].refDate());
        Assertions.assertEquals(LocalDate.of(2022, 10, 26), realtimeFutureDTOs[3].refDate());
    }


    @Test
    void testIsin() {
        Assertions.assertEquals("DE0009652388", historyFutureDTOs[0].isin());
        Assertions.assertEquals("DE0009652388", historyFutureDTOs[1].isin());
        Assertions.assertEquals("DE0009652388", historyFutureDTOs[2].isin());
        Assertions.assertEquals("DE0009652388", historyFutureDTOs[3].isin());

        Assertions.assertNull(realtimeFutureDTOs[0].isin());
        Assertions.assertNull(realtimeFutureDTOs[1].isin());
        Assertions.assertNull(realtimeFutureDTOs[2].isin());
        Assertions.assertNull(realtimeFutureDTOs[3].isin());
    }


    @Test
    void testTicker() {
        Assertions.assertEquals("VGH21", historyFutureDTOs[0].ticker());
        Assertions.assertEquals("VGH21", historyFutureDTOs[1].ticker());
        Assertions.assertEquals("VGH21", historyFutureDTOs[2].ticker());
        Assertions.assertEquals("VGH21", historyFutureDTOs[3].ticker());

        Assertions.assertNull(realtimeFutureDTOs[0].ticker());
        Assertions.assertNull(realtimeFutureDTOs[1].ticker());
        Assertions.assertNull(realtimeFutureDTOs[2].ticker());
        Assertions.assertNull(realtimeFutureDTOs[3].ticker());
    }


    @Test
    void testUnderlyingId() {
        Assertions.assertEquals(".STOXX50E", historyFutureDTOs[0].underlyingId());
        Assertions.assertEquals(".STOXX50E", historyFutureDTOs[1].underlyingId());
        Assertions.assertEquals(".STOXX50E", historyFutureDTOs[2].underlyingId());
        Assertions.assertEquals(".STOXX50E", historyFutureDTOs[3].underlyingId());

        Assertions.assertNull(realtimeFutureDTOs[0].underlyingId());
        Assertions.assertNull(realtimeFutureDTOs[1].underlyingId());
        Assertions.assertNull(realtimeFutureDTOs[2].underlyingId());
        Assertions.assertNull(realtimeFutureDTOs[3].underlyingId());
    }


    @Test
    void testUnderlyingDescription() {
        Assertions.assertEquals(".STOXX50E", historyFutureDTOs[0].underlyingDescription());
        Assertions.assertEquals(".STOXX50E", historyFutureDTOs[1].underlyingDescription());
        Assertions.assertEquals(".STOXX50E", historyFutureDTOs[2].underlyingDescription());
        Assertions.assertEquals(".STOXX50E", historyFutureDTOs[3].underlyingDescription());

        Assertions.assertNull(realtimeFutureDTOs[0].underlyingDescription());
        Assertions.assertNull(realtimeFutureDTOs[1].underlyingDescription());
        Assertions.assertNull(realtimeFutureDTOs[2].underlyingDescription());
        Assertions.assertNull(realtimeFutureDTOs[3].underlyingDescription());
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