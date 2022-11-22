package com.example.commons.equity.model.entity.output;

import com.example.commons.equity.model.dto.output.OrderDTO;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class OrderTest {

    private final BufferedReader bufferedReader;
    @Autowired
    private Gson gson;
    private List<Order> orders;

    public OrderTest() throws URISyntaxException, IOException {
        URL resource = OrderTest.class.getClassLoader().getResource("Order.json");
        assert resource != null;
        File file = new File(resource.toURI());
        this.bufferedReader = new BufferedReader(new InputStreamReader(Files.newInputStream(file.toPath())));
    }

    @BeforeEach
    void init() {
        orders = Arrays.stream(gson.fromJson(bufferedReader, OrderDTO[].class)).sequential().map(OrderDTO::toEntity).collect(Collectors.toList());
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
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 13, 0, 0), orders.get(0).getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 13, 0, 0), orders.get(1).getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 13, 0, 0), orders.get(2).getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 13, 0, 0), orders.get(3).getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 13, 0, 0), orders.get(4).getTimestamp());
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
        Assertions.assertEquals("3", orders.get(0).getPortfolioId());
        Assertions.assertEquals("4", orders.get(1).getPortfolioId());
        Assertions.assertEquals("5", orders.get(2).getPortfolioId());
        Assertions.assertEquals("6", orders.get(3).getPortfolioId());
        Assertions.assertEquals("7", orders.get(4).getPortfolioId());
    }

    @Test
    void testTheoreticalPosition() {
        Assertions.assertEquals(21, orders.get(0).getTheoreticalPosition());
        Assertions.assertEquals(22, orders.get(1).getTheoreticalPosition());
        Assertions.assertEquals(35, orders.get(2).getTheoreticalPosition());
        Assertions.assertEquals(21, orders.get(3).getTheoreticalPosition());
        Assertions.assertEquals(20, orders.get(4).getTheoreticalPosition());
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
        Assertions.assertEquals(30, orders.get(0).getExecutedPrice());
        Assertions.assertEquals(30, orders.get(1).getExecutedPrice());
        Assertions.assertEquals(30, orders.get(2).getExecutedPrice());
        Assertions.assertNull(orders.get(3).getExecutedPrice());
        Assertions.assertEquals(30, orders.get(4).getExecutedPrice());
    }

    @Test
    void testStatus() {
        Assertions.assertNull(orders.get(0).getStatus());
        Assertions.assertNull(orders.get(1).getStatus());
        Assertions.assertNull(orders.get(2).getStatus());
        Assertions.assertEquals("0", orders.get(3).getStatus());
        Assertions.assertNull(orders.get(4).getStatus());
    }

    @Test
    void testDeltaPrice() {
        Assertions.assertEquals(30., orders.get(0).getDeltaPrice());
        Assertions.assertEquals(20, orders.get(1).getDeltaPrice());
        Assertions.assertEquals(2, orders.get(2).getDeltaPrice());
        Assertions.assertNull(orders.get(3).getDeltaPrice());
        Assertions.assertEquals(1, orders.get(4).getDeltaPrice());
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
    void testOperation() {
        Assertions.assertEquals(Operation.BUY, orders.get(0).getOperation());
        Assertions.assertEquals(Operation.SELL, orders.get(1).getOperation());
        Assertions.assertEquals(Operation.NEUTRAL, orders.get(2).getOperation());
        Assertions.assertEquals(Operation.SELL, orders.get(3).getOperation());
        Assertions.assertEquals(Operation.BUY, orders.get(4).getOperation());
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
