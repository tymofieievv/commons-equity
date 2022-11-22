package com.example.commons.equity.model.dto.output;

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

@SpringBootTest
class OrderDTOTest {

    private final BufferedReader bufferedReader;
    @Autowired
    private Gson gson;
    private OrderDTO[] orderDTOs;

    public OrderDTOTest() throws URISyntaxException, IOException {
        URL resource = OrderDTOTest.class.getClassLoader().getResource("Order.json");
        assert resource != null;
        File file = new File(resource.toURI());
        this.bufferedReader = new BufferedReader(new InputStreamReader(Files.newInputStream(file.toPath())));
    }

    @BeforeEach
    void init() throws URISyntaxException, IOException {
        orderDTOs = gson.fromJson(bufferedReader, OrderDTO[].class);
    }


    @Test
    void testIdSignal() {
        Assertions.assertEquals(1, orderDTOs[0].getIdSignal());
        Assertions.assertEquals(2, orderDTOs[1].getIdSignal());
        Assertions.assertEquals(1, orderDTOs[2].getIdSignal());
        Assertions.assertEquals(2, orderDTOs[3].getIdSignal());
        Assertions.assertEquals(2, orderDTOs[4].getIdSignal());
    }


    @Test
    void testTimestamp() {
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 13, 0, 0), orderDTOs[0].getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 13, 0, 0), orderDTOs[1].getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 13, 0, 0), orderDTOs[2].getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 13, 0, 0), orderDTOs[3].getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2013, 9, 13, 0, 0), orderDTOs[4].getTimestamp());
    }


    @Test
    void testTradeDate() {
        Assertions.assertEquals(LocalDate.of(2013, 9, 13), orderDTOs[0].getTradeDate());
        Assertions.assertEquals(LocalDate.of(2013, 9, 13), orderDTOs[1].getTradeDate());
        Assertions.assertEquals(LocalDate.of(2013, 9, 13), orderDTOs[2].getTradeDate());
        Assertions.assertEquals(LocalDate.of(2013, 9, 13), orderDTOs[3].getTradeDate());
        Assertions.assertEquals(LocalDate.of(2013, 9, 13), orderDTOs[4].getTradeDate());
    }


    @Test
    void testUnderlying() {
        Assertions.assertEquals("SXE5 Index", orderDTOs[0].getUnderlying());
        Assertions.assertEquals("SXE6 Future", orderDTOs[1].getUnderlying());
        Assertions.assertEquals("SXE6 Index", orderDTOs[2].getUnderlying());
        Assertions.assertEquals("SXE7 Index", orderDTOs[3].getUnderlying());
        Assertions.assertEquals("SXE8 Index", orderDTOs[4].getUnderlying());
    }


    @Test
    void testPortfolioId() {
        Assertions.assertEquals("3", orderDTOs[0].getPortfolioId());
        Assertions.assertEquals("4", orderDTOs[1].getPortfolioId());
        Assertions.assertEquals("5", orderDTOs[2].getPortfolioId());
        Assertions.assertEquals("6", orderDTOs[3].getPortfolioId());
        Assertions.assertEquals("7", orderDTOs[4].getPortfolioId());

    }


    @Test
    void testTickerFuture() {
        Assertions.assertNull(orderDTOs[0].getTickerFuture());
        Assertions.assertNull(orderDTOs[1].getTickerFuture());
        Assertions.assertNull(orderDTOs[2].getTickerFuture());
        Assertions.assertNull(orderDTOs[3].getTickerFuture());
        Assertions.assertNull(orderDTOs[4].getTickerFuture());
    }


    @Test
    void testStatus() {
        Assertions.assertNull(orderDTOs[0].getStatus());
        Assertions.assertNull(orderDTOs[1].getStatus());
        Assertions.assertNull(orderDTOs[2].getStatus());
        Assertions.assertEquals("0", orderDTOs[3].getStatus());
        Assertions.assertNull(orderDTOs[4].getStatus());
    }


    @Test
    void testBuySell() {
        Assertions.assertEquals(Operation.BUY, orderDTOs[0].getBuySell());
        Assertions.assertEquals(Operation.SELL, orderDTOs[1].getBuySell());
        Assertions.assertEquals(Operation.NEUTRAL, orderDTOs[2].getBuySell());
        Assertions.assertEquals(Operation.SELL, orderDTOs[3].getBuySell());
        Assertions.assertEquals(Operation.BUY, orderDTOs[4].getBuySell());
    }


    @Test
    void testTheoreticalQuantity() {
        Assertions.assertEquals(30, orderDTOs[0].getTheoreticalQuantity());
        Assertions.assertEquals(20, orderDTOs[1].getTheoreticalQuantity());
        Assertions.assertEquals(2, orderDTOs[2].getTheoreticalQuantity());
        Assertions.assertEquals(50, orderDTOs[3].getTheoreticalQuantity());
        Assertions.assertEquals(1, orderDTOs[4].getTheoreticalQuantity());
    }


    @Test
    void testQuantity() {
        Assertions.assertEquals(30, orderDTOs[0].getQuantity());
        Assertions.assertEquals(20, orderDTOs[1].getQuantity());
        Assertions.assertEquals(2, orderDTOs[2].getQuantity());
        Assertions.assertEquals(50, orderDTOs[3].getQuantity());
        Assertions.assertEquals(1, orderDTOs[4].getQuantity());
    }


    @Test
    void testTheoreticalPosition() {
        Assertions.assertEquals(21, orderDTOs[0].getTheoreticalPosition());
        Assertions.assertEquals(22, orderDTOs[1].getTheoreticalPosition());
        Assertions.assertEquals(35, orderDTOs[2].getTheoreticalPosition());
        Assertions.assertEquals(21, orderDTOs[3].getTheoreticalPosition());
        Assertions.assertEquals(20, orderDTOs[4].getTheoreticalPosition());
    }


    @Test
    void testLivePosition() {
        Assertions.assertNull(orderDTOs[0].getLivePosition());
        Assertions.assertNull(orderDTOs[1].getLivePosition());
        Assertions.assertNull(orderDTOs[2].getLivePosition());
        Assertions.assertNull(orderDTOs[3].getLivePosition());
        Assertions.assertNull(orderDTOs[4].getLivePosition());
    }


    @Test
    void testTheoreticalPrice() {
        Assertions.assertEquals(25.0, orderDTOs[0].getTheoreticalPrice());
        Assertions.assertEquals(35.0, orderDTOs[1].getTheoreticalPrice());
        Assertions.assertEquals(40.0, orderDTOs[2].getTheoreticalPrice());
        Assertions.assertEquals(20.0, orderDTOs[3].getTheoreticalPrice());
        Assertions.assertEquals(30.0, orderDTOs[4].getTheoreticalPrice());
    }


    @Test
    void testExecutedPrice() {
        Assertions.assertEquals(30, orderDTOs[0].getExecutedPrice());
        Assertions.assertEquals(20, orderDTOs[1].getExecutedPrice());
        Assertions.assertEquals(2, orderDTOs[2].getExecutedPrice());
        Assertions.assertNull(orderDTOs[3].getExecutedPrice());
        Assertions.assertEquals(1, orderDTOs[4].getExecutedPrice());
    }


    @Test
    void testDeltaPrice() {
        Assertions.assertEquals(30, orderDTOs[0].getDeltaPrice());
        Assertions.assertEquals(30, orderDTOs[1].getDeltaPrice());
        Assertions.assertEquals(30, orderDTOs[2].getDeltaPrice());
        Assertions.assertNull(orderDTOs[3].getDeltaPrice());
        Assertions.assertEquals(30, orderDTOs[4].getDeltaPrice());
    }
}