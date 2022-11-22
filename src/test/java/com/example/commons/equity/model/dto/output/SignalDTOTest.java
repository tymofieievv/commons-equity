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
import java.time.Month;

@SpringBootTest
class SignalDTOTest {

    private final BufferedReader bufferedReader;
    @Autowired
    private Gson gson;
    private SignalDTO[] signalDTOs;

    public SignalDTOTest() throws URISyntaxException, IOException {
        URL resource = OrderDTOTest.class.getClassLoader().getResource("Signal.json");
        assert resource != null;
        File file = new File(resource.toURI());
        this.bufferedReader = new BufferedReader(new InputStreamReader(Files.newInputStream(file.toPath())));
    }

    @BeforeEach
    void init() {
        signalDTOs = gson.fromJson(bufferedReader, SignalDTO[].class);
    }

    @Test
    void testSignalId() {
        Assertions.assertNull(signalDTOs[0].getSignalId());
        Assertions.assertNull(signalDTOs[1].getSignalId());
        Assertions.assertNull(signalDTOs[2].getSignalId());
        Assertions.assertNull(signalDTOs[3].getSignalId());
        Assertions.assertNull(signalDTOs[4].getSignalId());
    }


    @Test
    void testTimestamp() {
        Assertions.assertEquals(LocalDateTime.of(2022, Month.JULY, 15, 0, 0), signalDTOs[0].getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2022, Month.JULY, 14, 0, 0), signalDTOs[1].getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2022, Month.JULY, 13, 0, 0), signalDTOs[2].getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2022, Month.JULY, 12, 0, 0), signalDTOs[3].getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2022, Month.JULY, 11, 0, 0), signalDTOs[4].getTimestamp());
    }


    @Test
    void testTradeDate() {
        Assertions.assertEquals(LocalDate.of(2022, 7, 15), signalDTOs[0].getTradeDate());
        Assertions.assertEquals(LocalDate.of(2022, 7, 14), signalDTOs[1].getTradeDate());
        Assertions.assertEquals(LocalDate.of(2022, 7, 13), signalDTOs[2].getTradeDate());
        Assertions.assertEquals(LocalDate.of(2022, 7, 12), signalDTOs[3].getTradeDate());
        Assertions.assertEquals(LocalDate.of(2022, 7, 11), signalDTOs[4].getTradeDate());
    }


    @Test
    void testUnderlying() {
        Assertions.assertEquals("EU0009658145", signalDTOs[0].getUnderlying());
        Assertions.assertEquals("EU0009658146", signalDTOs[1].getUnderlying());
        Assertions.assertEquals("EU0009658147", signalDTOs[2].getUnderlying());
        Assertions.assertEquals("EU0009658148", signalDTOs[3].getUnderlying());
        Assertions.assertEquals("EU0009658149", signalDTOs[4].getUnderlying());
    }


    @Test
    void testTickerFuture() {
        Assertions.assertEquals("VGU2", signalDTOs[0].getTickerFuture());
        Assertions.assertEquals("VGU2", signalDTOs[1].getTickerFuture());
        Assertions.assertEquals("VGU2", signalDTOs[2].getTickerFuture());
        Assertions.assertEquals("VGU2", signalDTOs[3].getTickerFuture());
        Assertions.assertEquals("VGU2", signalDTOs[4].getTickerFuture());
    }


    @Test
    void testBuySell() {
        Assertions.assertEquals(Operation.SELL, signalDTOs[0].getBuySell());
        Assertions.assertEquals(Operation.BUY, signalDTOs[1].getBuySell());
        Assertions.assertEquals(Operation.SELL, signalDTOs[2].getBuySell());
        Assertions.assertEquals(Operation.SELL, signalDTOs[3].getBuySell());
        Assertions.assertEquals(Operation.BUY, signalDTOs[4].getBuySell());
    }


    @Test
    void testQuantity() {
        Assertions.assertEquals(-25, signalDTOs[0].getQuantity());
        Assertions.assertEquals(25, signalDTOs[1].getQuantity());
        Assertions.assertEquals(-26, signalDTOs[2].getQuantity());
        Assertions.assertEquals(-26, signalDTOs[3].getQuantity());
        Assertions.assertEquals(25, signalDTOs[4].getQuantity());
    }


    @Test
    void testTheoreticalPrice() {
        Assertions.assertEquals(3477.2, signalDTOs[0].getTheoreticalPrice());
        Assertions.assertEquals(3396.61, signalDTOs[1].getTheoreticalPrice());
        Assertions.assertEquals(3453.97, signalDTOs[2].getTheoreticalPrice());
        Assertions.assertEquals(3487.05, signalDTOs[3].getTheoreticalPrice());
        Assertions.assertEquals(3471.69, signalDTOs[4].getTheoreticalPrice());
    }
}