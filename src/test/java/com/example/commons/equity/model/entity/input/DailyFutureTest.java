package com.example.commons.equity.model.entity.input;

import com.example.commons.equity.model.dto.input.DailyFutureDTO;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class DailyFutureTest {
    private static final String jsonString =

            """
                                [
                    {
                    "REF_DATE": "25/10/2022",
                    "ISIN": "DE0009652388",
                    "TICKER": "VGZ2",
                    "PRICE_CLOSE": "3584",
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
    ;

    @Autowired
    private Gson gson;

    private List<DailyFuture> dailyFutures;

    @BeforeEach
    void init() {
        dailyFutures = Arrays.stream(gson.fromJson(jsonString, DailyFutureDTO[].class)).sequential().map(DailyFutureDTO::toEntity).collect(Collectors.toList());
    }

    @Test
    void testId() {
        Assertions.assertNull(dailyFutures.get(0).getId());
        Assertions.assertNull(dailyFutures.get(1).getId());
        Assertions.assertNull(dailyFutures.get(2).getId());
    }

    @Test
    void testRefDate() {
        Assertions.assertEquals(LocalDate.of(2022, 10, 25), dailyFutures.get(0).getRefDate());
        Assertions.assertEquals(LocalDate.of(2022, 10, 24), dailyFutures.get(1).getRefDate());
        Assertions.assertEquals(LocalDate.of(2022, 10, 21), dailyFutures.get(2).getRefDate());
    }


    @Test
    void testPriceClose() {
        Assertions.assertEquals(3584.0, dailyFutures.get(0).getPriceClose());
        Assertions.assertEquals(3528.0, dailyFutures.get(1).getPriceClose());
        Assertions.assertEquals(3509.0, dailyFutures.get(2).getPriceClose());
    }


    @Test
    void testPriceLow() {
        Assertions.assertEquals(3507.0, dailyFutures.get(0).getPriceLow());
        Assertions.assertEquals(3469.0, dailyFutures.get(1).getPriceLow());
        Assertions.assertEquals(3418.0, dailyFutures.get(2).getPriceLow());
    }

    @Test
    void testPriceOpen() {
        Assertions.assertEquals(3530.0, dailyFutures.get(0).getPriceOpen());
        Assertions.assertEquals(3517.0, dailyFutures.get(1).getPriceOpen());
        Assertions.assertEquals(3450.0, dailyFutures.get(2).getPriceOpen());
    }

    @Test
    void testPriceHigh() {
        Assertions.assertEquals(3590.0, dailyFutures.get(0).getPriceHigh());
        Assertions.assertEquals(3551.0, dailyFutures.get(1).getPriceHigh());
        Assertions.assertEquals(3510.0, dailyFutures.get(2).getPriceHigh());
    }

    @Test
    void testVolume() {
        Assertions.assertEquals(936121, dailyFutures.get(0).getVolume());
        Assertions.assertEquals(939287, dailyFutures.get(1).getVolume());
        Assertions.assertEquals(1061095, dailyFutures.get(2).getVolume());
    }
}
