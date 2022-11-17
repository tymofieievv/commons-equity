package com.example.commons.equity.model.entity.output;

import com.example.commons.equity.model.dto.output.OrderDTO;
import com.example.commons.equity.model.enums.Operation;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class OrderTest {
    private final String jsonString =

            """
                                [
                    {
                    "TIMESTAMP": "13/09/2013 00:00",
                    "TRADEDATE": "13/09/2013",
                    "UNDERLYING": "SXE5 Index",
                    "ID SIGNAL": 1,
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

    private List<Order> orders;

    @BeforeEach
    void init() {
        orders = Arrays.stream(gson.fromJson(jsonString, OrderDTO[].class)).sequential().map(OrderDTO::toEntity).collect(Collectors.toList());
    }

    @Test
    void testId() {
        Assertions.assertNull(orders.get(0).getId());
        Assertions.assertNull(orders.get(1).getId());
        Assertions.assertNull(orders.get(2).getId());
        Assertions.assertNull(orders.get(3).getId());
        Assertions.assertNull(orders.get(4).getId());
    }

    @Test
    void testTimestamp() {
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 13, 00, 00 ), orders.get(0).getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 13, 00, 00 ), orders.get(1).getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 13, 00, 00 ), orders.get(2).getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 13, 00, 00 ), orders.get(3).getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 13, 00, 00 ), orders.get(4).getTimestamp());
    }

    @Test
    void testTradeDate() {
        Assertions.assertEquals(LocalDate.of(2013, 9, 13), orders.get(0).getTradeDate());
        Assertions.assertEquals(LocalDate.of(2013, 9, 13), orders.get(1).getTradeDate());
        Assertions.assertEquals(LocalDate.of(2013, 9, 13), orders.get(2).getTradeDate());
        Assertions.assertEquals(LocalDate.of(2013, 9, 13), orders.get(3).getTradeDate());
        Assertions.assertEquals(LocalDate.of(2013, 9, 13), orders.get(4).getTradeDate());
    }

    @Test
    void testUnderlying() {
        Assertions.assertEquals("SXE5 Index", orders.get(0).getUnderlying());
        Assertions.assertEquals("SXE6 Future", orders.get(1).getUnderlying());
        Assertions.assertEquals("SXE6 Index", orders.get(2).getUnderlying());
        Assertions.assertEquals("SXE7 Index", orders.get(3).getUnderlying());
        Assertions.assertEquals("SXE8 Index", orders.get(4).getUnderlying());
    }

    @Test
    void testIdSignal() {
        Assertions.assertEquals(1, orders.get(0).getIdSignal());
        Assertions.assertEquals(2, orders.get(1).getIdSignal());
        Assertions.assertEquals(1, orders.get(2).getIdSignal());
        Assertions.assertEquals(2, orders.get(3).getIdSignal());
        Assertions.assertEquals(2, orders.get(4).getIdSignal());
    }
    

    @Test
    void testPortfolioId() {
        Assertions.assertEquals("3",orders.get(0).getPortfolioId());
        Assertions.assertEquals("4",orders.get(1).getPortfolioId());
        Assertions.assertEquals("5",orders.get(2).getPortfolioId());
        Assertions.assertEquals("6",orders.get(3).getPortfolioId());
        Assertions.assertEquals("7",orders.get(4).getPortfolioId());
    }

    @Test
    void testTheoreticalPosition() {
        Assertions.assertEquals(21,orders.get(0).getTheoreticalPosition());
        Assertions.assertEquals(22,orders.get(1).getTheoreticalPosition());
        Assertions.assertEquals(35,orders.get(2).getTheoreticalPosition());
        Assertions.assertEquals(21,orders.get(3).getTheoreticalPosition());
        Assertions.assertEquals(20,orders.get(4).getTheoreticalPosition());
    }

    @Test
    void testTheoreticalQuantity() {
        Assertions.assertEquals(30, orders.get(0).getTheoreticalQuantity());
        Assertions.assertEquals(20, orders.get(1).getTheoreticalQuantity());
        Assertions.assertEquals(2, orders.get(2).getTheoreticalQuantity());
        Assertions.assertEquals(50, orders.get(3).getTheoreticalQuantity());
        Assertions.assertEquals(1, orders.get(4).getTheoreticalQuantity());
    }

    @Test
    void testExecutedPrice() {
        Assertions.assertEquals(30,orders.get(0).getExecutedPrice());
        Assertions.assertEquals(30,orders.get(1).getExecutedPrice());
        Assertions.assertEquals(30,orders.get(2).getExecutedPrice());
        Assertions.assertNull(orders.get(3).getExecutedPrice());
        Assertions.assertEquals(30,orders.get(4).getExecutedPrice());
    }

    @Test
    void testStatus() {
        Assertions.assertNull( orders.get(0).getStatus());
        Assertions.assertNull( orders.get(1).getStatus());
        Assertions.assertNull( orders.get(2).getStatus());
        Assertions.assertEquals("0", orders.get(3).getStatus());
        Assertions.assertNull( orders.get(4).getStatus());
    }

    @Test
    void testDeltaPrice() {
        Assertions.assertEquals(30.,orders.get(0).getDeltaPrice());
        Assertions.assertEquals(20,orders.get(1).getDeltaPrice());
        Assertions.assertEquals(2,orders.get(2).getDeltaPrice());
        Assertions.assertNull(orders.get(3).getDeltaPrice());
        Assertions.assertEquals(1,orders.get(4).getDeltaPrice());
    }

    @Test
    void testTickerFuture() {
        Assertions.assertNull(orders.get(0).getTickerFuture());
        Assertions.assertNull(orders.get(1).getTickerFuture());
        Assertions.assertNull(orders.get(2).getTickerFuture());
        Assertions.assertNull(orders.get(3).getTickerFuture());
        Assertions.assertNull(orders.get(4).getTickerFuture());
    }

    @Test
    void testBuysell() {
        Assertions.assertEquals(Operation.BUY, orders.get(0).getBuysell());
        Assertions.assertEquals(Operation.SELL, orders.get(1).getBuysell());
        Assertions.assertEquals(Operation.NEUTRAL, orders.get(2).getBuysell());
        Assertions.assertEquals(Operation.SELL, orders.get(3).getBuysell());
        Assertions.assertEquals(Operation.BUY, orders.get(4).getBuysell());
    }

    @Test
    void testQuantity() {
        Assertions.assertEquals(30, orders.get(0).getQuantity());
        Assertions.assertEquals(20, orders.get(1).getQuantity());
        Assertions.assertEquals(2, orders.get(2).getQuantity());
        Assertions.assertEquals(50, orders.get(3).getQuantity());
        Assertions.assertEquals(1, orders.get(4).getQuantity());
    }

    @Test
    void testLivePosition() {
        Assertions.assertNull(orders.get(0).getLivePosition());
        Assertions.assertNull(orders.get(1).getLivePosition());
        Assertions.assertNull(orders.get(2).getLivePosition());
        Assertions.assertNull(orders.get(3).getLivePosition());
        Assertions.assertNull(orders.get(4).getLivePosition());
    }

    @Test
    void testTheoreticalPrice() {
        Assertions.assertEquals(25.0, orders.get(0).getTheoreticalPrice());
        Assertions.assertEquals(35.0, orders.get(1).getTheoreticalPrice());
        Assertions.assertEquals(40.0, orders.get(2).getTheoreticalPrice());
        Assertions.assertEquals(20.0, orders.get(3).getTheoreticalPrice());
        Assertions.assertEquals(30.0, orders.get(4).getTheoreticalPrice());
    }


}
