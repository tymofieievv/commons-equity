package com.example.commons.equity.model.dto.input;

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
import java.time.LocalTime;

@SpringBootTest
class FutureDTOTest {

    private final BufferedReader historyFutureBufferedReader;
    private final BufferedReader realtimeFutureBufferedReader;
    @Autowired
    private Gson gson;
    private FutureDTO[] historyFutureDTOs;
    private FutureDTO[] realtimeFutureDTOs;

    public FutureDTOTest() throws URISyntaxException, IOException {
        URL resourceFutureHistory = FutureDTOTest.class.getClassLoader().getResource("FutureHistory.json");
        URL resourceFutureRealtime = FutureDTOTest.class.getClassLoader().getResource("FutureRealtime.json");

        assert resourceFutureHistory != null;
        File fileHistory = new File(resourceFutureHistory.toURI());
        assert resourceFutureRealtime != null;
        File fileRealtime = new File(resourceFutureRealtime.toURI());
        this.historyFutureBufferedReader = new BufferedReader(new InputStreamReader(Files.newInputStream(fileHistory.toPath())));
        this.realtimeFutureBufferedReader = new BufferedReader(new InputStreamReader(Files.newInputStream(fileRealtime.toPath())));
    }

    @BeforeEach
    void init() {
        historyFutureDTOs = gson.fromJson(historyFutureBufferedReader, FutureDTO[].class);
        realtimeFutureDTOs = gson.fromJson(realtimeFutureBufferedReader, FutureDTO[].class);
    }

    @Test
    void testRefDate() {
        Assertions.assertNull(historyFutureDTOs[0].getTimestamp());
        Assertions.assertNull(historyFutureDTOs[1].getTimestamp());
        Assertions.assertNull(historyFutureDTOs[2].getTimestamp());
        Assertions.assertNull(historyFutureDTOs[3].getTimestamp());

        Assertions.assertEquals(LocalDateTime.of(2022, 10, 26, 11, 56, 30), realtimeFutureDTOs[0].getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2022, 10, 26, 11, 56, 15), realtimeFutureDTOs[1].getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2022, 10, 26, 11, 56, 0), realtimeFutureDTOs[2].getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2022, 10, 26, 11, 55, 45), realtimeFutureDTOs[3].getTimestamp());
    }

    @Test
    void testRic() {
        Assertions.assertNull(historyFutureDTOs[0].getRic());
        Assertions.assertNull(historyFutureDTOs[1].getRic());
        Assertions.assertNull(historyFutureDTOs[2].getRic());
        Assertions.assertNull(historyFutureDTOs[3].getRic());
        Assertions.assertNull(realtimeFutureDTOs[0].getRic());
        Assertions.assertNull(realtimeFutureDTOs[1].getRic());
        Assertions.assertNull(realtimeFutureDTOs[2].getRic());
        Assertions.assertNull(realtimeFutureDTOs[3].getRic());
    }

    @Test
    void testPriceClose() {
        Assertions.assertNull(historyFutureDTOs[0].getPriceClose());
        Assertions.assertNull(historyFutureDTOs[1].getPriceClose());
        Assertions.assertNull(historyFutureDTOs[2].getPriceClose());
        Assertions.assertNull(historyFutureDTOs[3].getPriceClose());
        Assertions.assertNull(realtimeFutureDTOs[0].getPriceClose());
        Assertions.assertNull(realtimeFutureDTOs[1].getPriceClose());
        Assertions.assertNull(realtimeFutureDTOs[2].getPriceClose());
        Assertions.assertNull(realtimeFutureDTOs[3].getPriceClose());
    }


    @Test
    void testPriceOpen() {
        Assertions.assertNull(historyFutureDTOs[0].getPriceOpen());
        Assertions.assertNull(historyFutureDTOs[1].getPriceOpen());
        Assertions.assertNull(historyFutureDTOs[2].getPriceOpen());
        Assertions.assertNull(historyFutureDTOs[3].getPriceOpen());
        Assertions.assertNull(realtimeFutureDTOs[0].getPriceOpen());
        Assertions.assertNull(realtimeFutureDTOs[1].getPriceOpen());
        Assertions.assertNull(realtimeFutureDTOs[2].getPriceOpen());
        Assertions.assertNull(realtimeFutureDTOs[3].getPriceOpen());
    }


    @Test
    void testPriceLow() {
        Assertions.assertNull(historyFutureDTOs[0].getPriceLow());
        Assertions.assertNull(historyFutureDTOs[1].getPriceLow());
        Assertions.assertNull(historyFutureDTOs[2].getPriceLow());
        Assertions.assertNull(historyFutureDTOs[3].getPriceLow());

        Assertions.assertNull(realtimeFutureDTOs[0].getPriceLow());
        Assertions.assertNull(realtimeFutureDTOs[1].getPriceLow());
        Assertions.assertNull(realtimeFutureDTOs[2].getPriceLow());
        Assertions.assertNull(realtimeFutureDTOs[3].getPriceLow());
    }


    @Test
    void testPriceHigh() {
        Assertions.assertNull(historyFutureDTOs[0].getPriceHigh());
        Assertions.assertNull(historyFutureDTOs[1].getPriceHigh());
        Assertions.assertNull(historyFutureDTOs[2].getPriceHigh());
        Assertions.assertNull(historyFutureDTOs[3].getPriceHigh());

        Assertions.assertNull(realtimeFutureDTOs[0].getPriceHigh());
        Assertions.assertNull(realtimeFutureDTOs[1].getPriceHigh());
        Assertions.assertNull(realtimeFutureDTOs[2].getPriceHigh());
        Assertions.assertNull(realtimeFutureDTOs[3].getPriceHigh());
    }


    @Test
    void testVolume() {
        Assertions.assertNull(historyFutureDTOs[0].getVolume());
        Assertions.assertNull(historyFutureDTOs[1].getVolume());
        Assertions.assertNull(historyFutureDTOs[2].getVolume());
        Assertions.assertNull(historyFutureDTOs[3].getVolume());

        Assertions.assertNull(realtimeFutureDTOs[0].getVolume());
        Assertions.assertNull(realtimeFutureDTOs[1].getVolume());
        Assertions.assertNull(realtimeFutureDTOs[2].getVolume());
        Assertions.assertNull(realtimeFutureDTOs[3].getVolume());
    }
}