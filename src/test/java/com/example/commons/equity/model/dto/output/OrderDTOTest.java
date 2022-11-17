package com.example.commons.equity.model.dto.output;

import com.example.commons.equity.model.enums.Operation;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
class OrderDTOTest {


    private final String jsonString =

            """
                                [
                    {
                    "TIMESTAMP": "13/09/2013 00:00",
                    "TRADEDATE": "13/09/2013",
                    "UNDERLYING": "SXE5 Index",
                    "ID SIGNAL": "1",
                    "PORTFOLIO_ID": "3",
                    "THEORETICAL POSITION": "21",
                    "THEORETICAL_QUANTITY": "30",
                    "EXECUTED PRICE": "30",
                    "STATUS": null,
                    "DELTA PRICE": "30",
                    "TICKET FUTURE": null,
                    "BUY/SELL": "B",
                    "QUANTITY": "30",
                    "LIVE POSITION": null,
                    "THEORETICAL PRICE": "25.0"
                    },
                    {
                    "TIMESTAMP": "13/09/2013 00:00",
                    "TRADEDATE": "13/09/2013",
                    "UNDERLYING": "SXE6 Future",
                    "ID SIGNAL": "2",
                    "PORTFOLIO_ID": "4",
                    "THEORETICAL POSITION": "22",
                    "THEORETICAL_QUANTITY": "20",
                    "EXECUTED PRICE": "20",
                    "STATUS": null,
                    "DELTA PRICE": "30",
                    "TICKET FUTURE": null,
                    "BUY/SELL": "S",
                    "QUANTITY": "20",
                    "LIVE POSITION": null,
                    "THEORETICAL PRICE": "35.0"
                    },
                    {
                    "TIMESTAMP": "13/09/2013 00:00",
                    "TRADEDATE": "13/09/2013",
                    "UNDERLYING": "SXE6 Index",
                    "ID SIGNAL": "1",
                    "PORTFOLIO_ID": "5",
                    "THEORETICAL POSITION": "35",
                    "THEORETICAL_QUANTITY": "2",
                    "EXECUTED PRICE": "2",
                    "STATUS": null,
                    "DELTA PRICE": "30",
                    "TICKET FUTURE": null,
                    "BUY/SELL": "N",
                    "QUANTITY": "2",
                    "LIVE POSITION": null,
                    "THEORETICAL PRICE": "40.0"
                    },
                    {
                    "TIMESTAMP": "13/09/2013 00:00",
                    "TRADEDATE": "13/09/2013",
                    "UNDERLYING": "SXE7 Index",
                    "ID SIGNAL": "2",
                    "PORTFOLIO_ID": "6",
                    "THEORETICAL POSITION": "21",
                    "THEORETICAL_QUANTITY": "50",
                    "EXECUTED PRICE": null,
                    "STATUS": "0",
                    "DELTA PRICE": null,
                    "TICKET FUTURE": null,
                    "BUY/SELL": "S",
                    "QUANTITY": "50",
                    "LIVE POSITION": null,
                    "THEORETICAL PRICE": "20.0"
                    },
                    {
                    "TIMESTAMP": "13/09/2013 00:00",
                    "TRADEDATE": "13/09/2013",
                    "UNDERLYING": "SXE8 Index",
                    "ID SIGNAL": "2",
                    "PORTFOLIO_ID": "7",
                    "THEORETICAL POSITION": "20",
                    "THEORETICAL_QUANTITY": "1",
                    "EXECUTED PRICE": "1",
                    "STATUS": null,
                    "DELTA PRICE": "30",
                    "TICKET FUTURE": null,
                    "BUY/SELL": "B",
                    "QUANTITY": "1",
                    "LIVE POSITION": null,
                    "THEORETICAL PRICE": "30.0"
                    }
                                ]
                                """;


    @Autowired
    private Gson gson;
    private OrderDTO[] orderDTOs;

    @BeforeEach
    void init() {
        orderDTOs = gson.fromJson(jsonString, OrderDTO[].class);
    }


    @Test
    void testIdSignal() {
        Assertions.assertEquals(1, orderDTOs[0].idSignal());
        Assertions.assertEquals(2, orderDTOs[1].idSignal());
        Assertions.assertEquals(1, orderDTOs[2].idSignal());
        Assertions.assertEquals(2, orderDTOs[3].idSignal());
        Assertions.assertEquals(2, orderDTOs[4].idSignal());
    }


    @Test
    void testTimestamp() {
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 13, 00, 00), orderDTOs[0].timestamp());
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 13, 00, 00), orderDTOs[1].timestamp());
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 13, 00, 00), orderDTOs[2].timestamp());
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 13, 00, 00), orderDTOs[3].timestamp());
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 13, 00, 00), orderDTOs[4].timestamp());
    }


    @Test
    void testTradeDate() {
        Assertions.assertEquals(LocalDate.of(2013, 9, 13), orderDTOs[0].tradeDate());
        Assertions.assertEquals(LocalDate.of(2013, 9, 13), orderDTOs[1].tradeDate());
        Assertions.assertEquals(LocalDate.of(2013, 9, 13), orderDTOs[2].tradeDate());
        Assertions.assertEquals(LocalDate.of(2013, 9, 13), orderDTOs[3].tradeDate());
        Assertions.assertEquals(LocalDate.of(2013, 9, 13), orderDTOs[4].tradeDate());
    }


    @Test
    void testUnderlying() {
        Assertions.assertEquals("SXE5 Index", orderDTOs[0].underlying());
        Assertions.assertEquals("SXE6 Future", orderDTOs[1].underlying());
        Assertions.assertEquals("SXE6 Index", orderDTOs[2].underlying());
        Assertions.assertEquals("SXE7 Index", orderDTOs[3].underlying());
        Assertions.assertEquals("SXE8 Index", orderDTOs[4].underlying());
    }


    @Test
    void testPortfolioId() {
        Assertions.assertEquals("3", orderDTOs[0].portfolioId());
        Assertions.assertEquals("4", orderDTOs[1].portfolioId());
        Assertions.assertEquals("5", orderDTOs[2].portfolioId());
        Assertions.assertEquals("6", orderDTOs[3].portfolioId());
        Assertions.assertEquals("7", orderDTOs[4].portfolioId());
    }


    @Test
    void testTickerFuture() {
        Assertions.assertNull(orderDTOs[0].tickerFuture());
        Assertions.assertNull(orderDTOs[1].tickerFuture());
        Assertions.assertNull(orderDTOs[2].tickerFuture());
        Assertions.assertNull(orderDTOs[3].tickerFuture());
        Assertions.assertNull(orderDTOs[4].tickerFuture());
    }


    @Test
    void testStatus() {
        Assertions.assertNull(orderDTOs[0].status());
        Assertions.assertNull(orderDTOs[1].status());
        Assertions.assertNull(orderDTOs[2].status());
        Assertions.assertEquals("0", orderDTOs[3].status());
        Assertions.assertNull(orderDTOs[4].status());
    }


    @Test
    void testBuySell() {
        Assertions.assertEquals(Operation.BUY, orderDTOs[0].buySell());
        Assertions.assertEquals(Operation.SELL, orderDTOs[1].buySell());
        Assertions.assertEquals(Operation.NEUTRAL, orderDTOs[2].buySell());
        Assertions.assertEquals(Operation.SELL, orderDTOs[3].buySell());
        Assertions.assertEquals(Operation.BUY, orderDTOs[4].buySell());
    }


    @Test
    void testTheoreticalQuantity() {
        Assertions.assertEquals(30, orderDTOs[0].theoreticalQuantity());
        Assertions.assertEquals(20, orderDTOs[1].theoreticalQuantity());
        Assertions.assertEquals(2, orderDTOs[2].theoreticalQuantity());
        Assertions.assertEquals(50, orderDTOs[3].theoreticalQuantity());
        Assertions.assertEquals(1, orderDTOs[4].theoreticalQuantity());
    }


    @Test
    void testQuantity() {
        Assertions.assertEquals(30, orderDTOs[0].quantity());
        Assertions.assertEquals(20, orderDTOs[1].quantity());
        Assertions.assertEquals(2, orderDTOs[2].quantity());
        Assertions.assertEquals(50, orderDTOs[3].quantity());
        Assertions.assertEquals(1, orderDTOs[4].quantity());
    }


    @Test
    void testTheoreticalPosition() {
        Assertions.assertEquals(21, orderDTOs[0].theoreticalPosition());
        Assertions.assertEquals(22, orderDTOs[1].theoreticalPosition());
        Assertions.assertEquals(35, orderDTOs[2].theoreticalPosition());
        Assertions.assertEquals(21, orderDTOs[3].theoreticalPosition());
        Assertions.assertEquals(20, orderDTOs[4].theoreticalPosition());
    }


    @Test
    void testLivePosition() {
        Assertions.assertNull(orderDTOs[0].livePosition());
        Assertions.assertNull(orderDTOs[1].livePosition());
        Assertions.assertNull(orderDTOs[2].livePosition());
        Assertions.assertNull(orderDTOs[3].livePosition());
        Assertions.assertNull(orderDTOs[4].livePosition());
    }


    @Test
    void testTheoreticalPrice() {
        Assertions.assertEquals(25.0, orderDTOs[0].theoreticalPrice());
        Assertions.assertEquals(35.0, orderDTOs[1].theoreticalPrice());
        Assertions.assertEquals(40.0, orderDTOs[2].theoreticalPrice());
        Assertions.assertEquals(20.0, orderDTOs[3].theoreticalPrice());
        Assertions.assertEquals(30.0, orderDTOs[4].theoreticalPrice());
    }


    @Test
    void testExecutedPrice() {
        Assertions.assertEquals(30, orderDTOs[0].executedPrice());
        Assertions.assertEquals(20, orderDTOs[1].executedPrice());
        Assertions.assertEquals(2, orderDTOs[2].executedPrice());
        Assertions.assertNull( orderDTOs[3].executedPrice());
        Assertions.assertEquals(1, orderDTOs[4].executedPrice());
    }


    @Test
    void testDeltaPrice() {
        Assertions.assertEquals(30, orderDTOs[0].deltaPrice());
        Assertions.assertEquals(30, orderDTOs[1].deltaPrice());
        Assertions.assertEquals(30, orderDTOs[2].deltaPrice());
        Assertions.assertNull( orderDTOs[3].deltaPrice());
        Assertions.assertEquals(30, orderDTOs[4].deltaPrice());
    }
}