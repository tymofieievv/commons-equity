package com.example.commons.equity.model.dto.output;

import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

@SpringBootTest
class SignalDTOTest {

    private final String jsonString =
            """
                                [
                    {
                    "TIMESTAMP": "15/07/2022 00:00",
                    "TRADEDATE": "15/07/2022",
                    "UNDERLYING": "EU0009658145",
                    "TICKER FUTURE": "VGU2",
                    "BUY/SELL": "S",
                    "QUANTITY": "-25",
                    "THEORETICAL PRICE": "3477.2"
                    },
                    {
                    "TIMESTAMP": "14/07/2022 00:00",
                    "TRADEDATE": "14/07/2022",
                    "UNDERLYING": "EU0009658146",
                    "TICKER FUTURE": "VGU2",
                    "BUY/SELL": "B",
                    "QUANTITY": "25",
                    "THEORETICAL PRICE": "3396.61"
                    },
                    {
                    "TIMESTAMP": "13/07/2022 00:00",
                    "TRADEDATE": "13/07/2022",
                    "UNDERLYING": "EU0009658147",
                    "TICKER FUTURE": "VGU2",
                    "BUY/SELL": "S",
                    "QUANTITY": "-26",
                    "THEORETICAL PRICE": "3453.97"
                    },
                    {
                    "TIMESTAMP": "12/07/2022 00:00",
                    "TRADEDATE": "12/07/2022",
                    "UNDERLYING": "EU0009658148",
                    "TICKER FUTURE": "VGU2",
                    "BUY/SELL": "S",
                    "QUANTITY": "-26",
                    "THEORETICAL PRICE": "3487.05"
                    },
                    {
                    "TIMESTAMP": "11/07/2022 00:00",
                    "TRADEDATE": "11/07/2022",
                    "UNDERLYING": "EU0009658149",
                    "TICKER FUTURE": "VGU2",
                    "BUY/SELL": "B",
                    "QUANTITY": "25",
                    "THEORETICAL PRICE": "3471.69"
                    }
                                ]
                                """;


    @Autowired
    private Gson gson;
    private SignalDTO[] signalDTOs;

    @BeforeEach
    void init() {
        signalDTOs = gson.fromJson(jsonString, SignalDTO[].class);
    }

    @Test
    void testSignalId() {
        Assertions.assertNull(signalDTOs[0].signalId());
        Assertions.assertNull(signalDTOs[1].signalId());
        Assertions.assertNull(signalDTOs[2].signalId());
        Assertions.assertNull(signalDTOs[3].signalId());
        Assertions.assertNull(signalDTOs[4].signalId());
    }


    @Test
    void testTimestamp() {
        Assertions.assertEquals(LocalDateTime.of(2022, Month.JULY, 15, 0, 0), signalDTOs[0].timestamp());
        Assertions.assertEquals(LocalDateTime.of(2022, Month.JULY, 14, 0, 0), signalDTOs[1].timestamp());
        Assertions.assertEquals(LocalDateTime.of(2022, Month.JULY, 13, 0, 0), signalDTOs[2].timestamp());
        Assertions.assertEquals(LocalDateTime.of(2022, Month.JULY, 12, 0, 0), signalDTOs[3].timestamp());
        Assertions.assertEquals(LocalDateTime.of(2022, Month.JULY, 11, 0, 0), signalDTOs[4].timestamp());
    }


    @Test
    void testTradeDate() {
        Assertions.assertEquals(LocalDate.of(2022, 7, 15), signalDTOs[0].tradeDate());
        Assertions.assertEquals(LocalDate.of(2022, 7, 14), signalDTOs[1].tradeDate());
        Assertions.assertEquals(LocalDate.of(2022, 7, 13), signalDTOs[2].tradeDate());
        Assertions.assertEquals(LocalDate.of(2022, 7, 12), signalDTOs[3].tradeDate());
        Assertions.assertEquals(LocalDate.of(2022, 7, 11), signalDTOs[4].tradeDate());
    }


    @Test
    void testUnderlying() {
        Assertions.assertEquals("EU0009658145", signalDTOs[0].underlying());
        Assertions.assertEquals("EU0009658146", signalDTOs[1].underlying());
        Assertions.assertEquals("EU0009658147", signalDTOs[2].underlying());
        Assertions.assertEquals("EU0009658148", signalDTOs[3].underlying());
        Assertions.assertEquals("EU0009658149", signalDTOs[4].underlying());
    }


    @Test
    void testTickerFuture() {
        Assertions.assertEquals("VGU2", signalDTOs[0].tickerFuture());
        Assertions.assertEquals("VGU2", signalDTOs[1].tickerFuture());
        Assertions.assertEquals("VGU2", signalDTOs[2].tickerFuture());
        Assertions.assertEquals("VGU2", signalDTOs[3].tickerFuture());
        Assertions.assertEquals("VGU2", signalDTOs[4].tickerFuture());
    }


    @Test
    void testBuySell() {
        Assertions.assertEquals("S", signalDTOs[0].buySell());
        Assertions.assertEquals("B", signalDTOs[1].buySell());
        Assertions.assertEquals("S", signalDTOs[2].buySell());
        Assertions.assertEquals("S", signalDTOs[3].buySell());
        Assertions.assertEquals("B", signalDTOs[4].buySell());
    }


    @Test
    void testQuantity() {
        Assertions.assertEquals(-25, signalDTOs[0].quantity());
        Assertions.assertEquals(25, signalDTOs[1].quantity());
        Assertions.assertEquals(-26, signalDTOs[2].quantity());
        Assertions.assertEquals(-26, signalDTOs[3].quantity());
        Assertions.assertEquals(25, signalDTOs[4].quantity());
    }


    @Test
    void testTheoreticalPrice() {
        Assertions.assertEquals(3477.2, signalDTOs[0].theoreticalPrice());
        Assertions.assertEquals(3396.61, signalDTOs[1].theoreticalPrice());
        Assertions.assertEquals(3453.97, signalDTOs[2].theoreticalPrice());
        Assertions.assertEquals(3487.05, signalDTOs[3].theoreticalPrice());
        Assertions.assertEquals(3471.69, signalDTOs[4].theoreticalPrice());
    }
}