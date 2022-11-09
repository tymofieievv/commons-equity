package com.example.commons.equity.model.dto.input;

import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class DailyFutureDTOTest {


    private final String jsonString =
            """
                                [
                    {
                    "REF_DATE": "25/10/2022",
                    "ISIN": "DE0009652388",
                    "TICKER": "VGZ2",
                    "PRICE_CLOSE": "3584.59",
                    "PRICE_LOW": "3507",
                    "PRICE_HIGH": "3590",
                    "PRICE_OPEN": "3530",
                    "VOLUME": "936121"
                    },
                    {
                    "REF_DATE": "24/10/2022",
                    "ISIN": "DE0009652388",
                    "TICKER": "VGZ2",
                    "PRICE_CLOSE": "3528",
                    "PRICE_LOW": "3469",
                    "PRICE_HIGH": "3551",
                    "PRICE_OPEN": "3517",
                    "VOLUME": "939287"
                    },
                    {
                    "REF_DATE": "21/10/2022",
                    "ISIN": "DE0009652388",
                    "TICKER": "VGZ2",
                    "PRICE_CLOSE": "3509",
                    "PRICE_LOW": "3418",
                    "PRICE_HIGH": "3510",
                    "PRICE_OPEN": "3450",
                    "VOLUME": "1061095"
                    }
                                ]
                                """;


    @Autowired
    private Gson gson;
    private DailyFutureDTO[] dailyFutureDTOs;

    @BeforeEach
    void init() {
        dailyFutureDTOs = gson.fromJson(jsonString, DailyFutureDTO[].class);
    }

    @Test
    void testRefDate() {

        Assertions.assertEquals(LocalDate.of(2022, 10, 25), dailyFutureDTOs[0].refDate());
        Assertions.assertEquals(LocalDate.of(2022, 10, 24), dailyFutureDTOs[1].refDate());
        Assertions.assertEquals(LocalDate.of(2022, 10, 21), dailyFutureDTOs[2].refDate());
    }


    @Test
    void testIsin() {

        Assertions.assertEquals("DE0009652388", dailyFutureDTOs[0].isin());
        Assertions.assertEquals("DE0009652388", dailyFutureDTOs[1].isin());
        Assertions.assertEquals("DE0009652388", dailyFutureDTOs[2].isin());
    }


    @Test
    void testTicker() {

        Assertions.assertEquals("VGZ2", dailyFutureDTOs[0].ticker());
        Assertions.assertEquals("VGZ2", dailyFutureDTOs[1].ticker());
        Assertions.assertEquals("VGZ2", dailyFutureDTOs[2].ticker());
    }


    @Test
    void testPriceClose() {

        Assertions.assertEquals(3584.59, dailyFutureDTOs[0].priceClose());
        Assertions.assertEquals(3528.0, dailyFutureDTOs[1].priceClose());
        Assertions.assertEquals(3509.0, dailyFutureDTOs[2].priceClose());
    }


    @Test
    void testPriceLow() {

        Assertions.assertEquals(3507.0, dailyFutureDTOs[0].priceLow());
        Assertions.assertEquals(3469.0, dailyFutureDTOs[1].priceLow());
        Assertions.assertEquals(3418.0, dailyFutureDTOs[2].priceLow());
    }


    @Test
    void testPriceOpen() {

        Assertions.assertEquals(3530.0, dailyFutureDTOs[0].priceOpen());
        Assertions.assertEquals(3517.0, dailyFutureDTOs[1].priceOpen());
        Assertions.assertEquals(3450.0, dailyFutureDTOs[2].priceOpen());
    }


    @Test
    void testPriceHigh() {

        Assertions.assertEquals(3590.0, dailyFutureDTOs[0].priceHigh());
        Assertions.assertEquals(3551.0, dailyFutureDTOs[1].priceHigh());
        Assertions.assertEquals(3510.0, dailyFutureDTOs[2].priceHigh());
    }


    @Test
    void testVolume() {

        Assertions.assertEquals(936121, dailyFutureDTOs[0].volume());
        Assertions.assertEquals(939287, dailyFutureDTOs[1].volume());
        Assertions.assertEquals(1061095, dailyFutureDTOs[2].volume());
    }
}