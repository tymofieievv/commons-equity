package com.example.commons.equity.model.entity.input;

import com.example.commons.equity.model.dto.input.FutureDTO;
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
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class FutureTest {

    private final BufferedReader historyFutureBufferedReader;
    private final BufferedReader realtimeFutureBufferedReader;
    private List<Future> futuresHistorical;

    public FutureTest() throws URISyntaxException, IOException {
        URL resourceFutureHistory = FutureTest.class.getClassLoader().getResource("FutureHistory.json");
        URL resourceFutureRealtime = FutureTest.class.getClassLoader().getResource("FutureRealtime.json");

        assert resourceFutureHistory != null;
        File fileHistory = new File(resourceFutureHistory.toURI());
        assert resourceFutureRealtime != null;
        File fileRealtime = new File(resourceFutureRealtime.toURI());
        this.historyFutureBufferedReader = new BufferedReader(new InputStreamReader(Files.newInputStream(fileHistory.toPath())));
        this.realtimeFutureBufferedReader = new BufferedReader(new InputStreamReader(Files.newInputStream(fileRealtime.toPath())));
    }

    @BeforeEach
    void initHistorical() {
        futuresHistorical = Arrays.stream(gson.fromJson(historyFutureBufferedReader, FutureDTO[].class)).sequential().map(FutureDTO::toEntity).collect(Collectors.toList());
    }

    @Test
    void testIdHistorical() {
        Assertions.assertNull(futuresHistorical.get(0).getId());
        Assertions.assertNull(futuresHistorical.get(1).getId());
        Assertions.assertNull(futuresHistorical.get(2).getId());
        Assertions.assertNull(futuresHistorical.get(3).getId());
    }

    @Test
    void testTimestampHistorical() {
        Assertions.assertNull(futuresHistorical.get(0).getTimestamp());
        Assertions.assertNull(futuresHistorical.get(1).getTimestamp());
        Assertions.assertNull(futuresHistorical.get(2).getTimestamp());
        Assertions.assertNull(futuresHistorical.get(3).getTimestamp());
    }


    @Test
    void testPriceCloseHistorical() {
        Assertions.assertNull(futuresHistorical.get(0).getPriceClose());
        Assertions.assertNull(futuresHistorical.get(1).getPriceClose());
        Assertions.assertNull(futuresHistorical.get(2).getPriceClose());
        Assertions.assertNull(futuresHistorical.get(3).getPriceClose());
    }

    @Test
    void testPriceOpenHistorical() {
        Assertions.assertNull(futuresHistorical.get(0).getPriceOpen());
        Assertions.assertNull(futuresHistorical.get(1).getPriceOpen());
        Assertions.assertNull(futuresHistorical.get(2).getPriceOpen());
        Assertions.assertNull(futuresHistorical.get(3).getPriceOpen());
    }

    @Test
    void testPriceLowHistorical() {
        Assertions.assertNull(futuresHistorical.get(0).getPriceLow());
        Assertions.assertNull(futuresHistorical.get(1).getPriceLow());
        Assertions.assertNull(futuresHistorical.get(2).getPriceLow());
        Assertions.assertNull(futuresHistorical.get(3).getPriceLow());
    }

    @Test
    void testPriceHighHistorical() {
        Assertions.assertNull(futuresHistorical.get(0).getPriceHigh());
        Assertions.assertNull(futuresHistorical.get(1).getPriceHigh());
        Assertions.assertNull(futuresHistorical.get(2).getPriceHigh());
        Assertions.assertNull(futuresHistorical.get(3).getPriceHigh());
    }

    @Test
    void testVolumeHistorical() {
        Assertions.assertNull(futuresHistorical.get(0).getVolume());
        Assertions.assertNull(futuresHistorical.get(1).getVolume());
        Assertions.assertNull(futuresHistorical.get(2).getVolume());
        Assertions.assertNull(futuresHistorical.get(3).getVolume());
    }

    @Autowired
    private Gson gson;

    private List<Future> futures;

    @BeforeEach
    void init() {
        futures = Arrays.stream(gson.fromJson(realtimeFutureBufferedReader, FutureDTO[].class)).sequential().map(FutureDTO::toEntity).collect(Collectors.toList());
    }

    @Test
    void testId() {
        Assertions.assertNull(futures.get(0).getId());
        Assertions.assertNull(futures.get(1).getId());
        Assertions.assertNull(futures.get(2).getId());
        Assertions.assertNull(futures.get(3).getId());
    }

    @Test
    void testTimestamp() {
        Assertions.assertEquals(LocalDateTime.of(2022, 10, 26, 11, 56, 30), futures.get(0).getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2022, 10, 26, 11, 56, 15), futures.get(1).getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2022, 10, 26, 11, 56, 0), futures.get(2).getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2022, 10, 26, 11, 55, 45), futures.get(3).getTimestamp());
    }


    @Test
    void testPriceClose() {
        Assertions.assertNull(futures.get(0).getPriceClose());
        Assertions.assertNull(futures.get(1).getPriceClose());
        Assertions.assertNull(futures.get(2).getPriceClose());
        Assertions.assertNull(futures.get(3).getPriceClose());
    }

    @Test
    void testPriceOpen() {
        Assertions.assertNull(futures.get(0).getPriceOpen());
        Assertions.assertNull(futures.get(1).getPriceOpen());
        Assertions.assertNull(futures.get(2).getPriceOpen());
        Assertions.assertNull(futures.get(3).getPriceOpen());
    }

    @Test
    void testPriceLow() {
        Assertions.assertNull(futures.get(0).getPriceLow());
        Assertions.assertNull(futures.get(1).getPriceLow());
        Assertions.assertNull(futures.get(2).getPriceLow());
        Assertions.assertNull(futures.get(3).getPriceLow());
    }

    @Test
    void testPriceHigh() {
        Assertions.assertNull(futures.get(0).getPriceHigh());
        Assertions.assertNull(futures.get(1).getPriceHigh());
        Assertions.assertNull(futures.get(2).getPriceHigh());
        Assertions.assertNull(futures.get(3).getPriceHigh());
    }

    @Test
    void testVolume() {
        Assertions.assertNull(futures.get(0).getVolume());
        Assertions.assertNull(futures.get(1).getVolume());
        Assertions.assertNull(futures.get(2).getVolume());
        Assertions.assertNull(futures.get(3).getVolume());
    }
}
