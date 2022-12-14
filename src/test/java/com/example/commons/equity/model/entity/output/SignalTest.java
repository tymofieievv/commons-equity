package com.example.commons.equity.model.entity.output;

import com.example.commons.equity.model.dto.output.SignalDTO;
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
class SignalTest {

    private final BufferedReader bufferedReader;
    @Autowired
    private Gson gson;
    private List<Signal> signals;

    public SignalTest() throws URISyntaxException, IOException {
        URL resource = SignalTest.class.getClassLoader().getResource("Signal.json");
        assert resource != null;
        File file = new File(resource.toURI());
        this.bufferedReader = new BufferedReader(new InputStreamReader(Files.newInputStream(file.toPath())));
    }

    @BeforeEach
    void init() {
        signals = Arrays.stream(gson.fromJson(bufferedReader, SignalDTO[].class)).sequential().map(SignalDTO::toEntity).collect(Collectors.toList());
    }

    @Test
    void testId() {
        Assertions.assertNull(signals.get(0).getId());
        Assertions.assertNull(signals.get(1).getId());
        Assertions.assertNull(signals.get(2).getId());
        Assertions.assertNull(signals.get(3).getId());
        Assertions.assertNull(signals.get(4).getId());
    }

    @Test
    void testTimestamp() {
        Assertions.assertEquals(LocalDateTime.of(2022, 7, 15, 0, 0), signals.get(0).getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2022, 7, 14, 0, 0), signals.get(1).getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2022, 7, 13, 0, 0), signals.get(2).getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2022, 7, 12, 0, 0), signals.get(3).getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2022, 7, 11, 0, 0), signals.get(4).getTimestamp());
    }

    @Test
    void testTradeDate() {
        Assertions.assertEquals(LocalDate.of(2022, 7, 15), signals.get(0).getTradeDate());
        Assertions.assertEquals(LocalDate.of(2022, 7, 14), signals.get(1).getTradeDate());
        Assertions.assertEquals(LocalDate.of(2022, 7, 13), signals.get(2).getTradeDate());
        Assertions.assertEquals(LocalDate.of(2022, 7, 12), signals.get(3).getTradeDate());
        Assertions.assertEquals(LocalDate.of(2022, 7, 11), signals.get(4).getTradeDate());
    }

    @Test
    void testUnderlying() {
        Assertions.assertEquals("EU0009658145", signals.get(0).getUnderlying());
        Assertions.assertEquals("EU0009658146", signals.get(1).getUnderlying());
        Assertions.assertEquals("EU0009658147", signals.get(2).getUnderlying());
        Assertions.assertEquals("EU0009658148", signals.get(3).getUnderlying());
        Assertions.assertEquals("EU0009658149", signals.get(4).getUnderlying());
    }

    @Test
    void testIdSignal() {
        Assertions.assertNull(signals.get(0).getIdSignal());
        Assertions.assertNull(signals.get(1).getIdSignal());
        Assertions.assertNull(signals.get(2).getIdSignal());
        Assertions.assertNull(signals.get(3).getIdSignal());
        Assertions.assertNull(signals.get(4).getIdSignal());
    }

    @Test
    void testTicketFuture() {
        Assertions.assertEquals("VGU2", signals.get(0).getTickerFuture());
        Assertions.assertEquals("VGU2", signals.get(1).getTickerFuture());
        Assertions.assertEquals("VGU2", signals.get(2).getTickerFuture());
        Assertions.assertEquals("VGU2", signals.get(3).getTickerFuture());
        Assertions.assertEquals("VGU2", signals.get(4).getTickerFuture());
    }

    @Test
    void testOperations() {
        Assertions.assertEquals(Operation.SELL, signals.get(0).getBuySell());
        Assertions.assertEquals(Operation.BUY, signals.get(1).getBuySell());
        Assertions.assertEquals(Operation.SELL, signals.get(2).getBuySell());
        Assertions.assertEquals(Operation.SELL, signals.get(3).getBuySell());
        Assertions.assertEquals(Operation.BUY, signals.get(4).getBuySell());
    }

    @Test
    void testQuantity() {
        Assertions.assertEquals(-25, signals.get(0).getQuantity());
        Assertions.assertEquals(25, signals.get(1).getQuantity());
        Assertions.assertEquals(-26, signals.get(2).getQuantity());
        Assertions.assertEquals(-26, signals.get(3).getQuantity());
        Assertions.assertEquals(25, signals.get(4).getQuantity());
    }

    @Test
    void testTheoreticalPrice() {
        Assertions.assertEquals(3477.2, signals.get(0).getTheoreticalPrice());
        Assertions.assertEquals(3396.61, signals.get(1).getTheoreticalPrice());
        Assertions.assertEquals(3453.97, signals.get(2).getTheoreticalPrice());
        Assertions.assertEquals(3487.05, signals.get(3).getTheoreticalPrice());
        Assertions.assertEquals(3471.69, signals.get(4).getTheoreticalPrice());
    }
}
