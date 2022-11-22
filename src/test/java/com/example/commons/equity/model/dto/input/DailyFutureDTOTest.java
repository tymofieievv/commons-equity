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

@SpringBootTest
class DailyFutureDTOTest {

    private final BufferedReader bufferedReader;
    @Autowired
    private Gson gson;
    private DailyFutureDTO[] dailyFutureDTOs;

    public DailyFutureDTOTest() throws URISyntaxException, IOException {
        URL resource = DailyFutureDTOTest.class.getClassLoader().getResource("DailyFuture.json");
        assert resource != null;
        File file = new File(resource.toURI());
        this.bufferedReader = new BufferedReader(new InputStreamReader(Files.newInputStream(file.toPath())));
    }

    @BeforeEach
    void init() {
        dailyFutureDTOs = gson.fromJson(bufferedReader, DailyFutureDTO[].class);
    }

    @Test
    void testRefDate() {
        Assertions.assertEquals(LocalDate.of(2022, 10, 25), dailyFutureDTOs[0].getRefDate());
        Assertions.assertEquals(LocalDate.of(2022, 10, 24), dailyFutureDTOs[1].getRefDate());
        Assertions.assertEquals(LocalDate.of(2022, 10, 21), dailyFutureDTOs[2].getRefDate());
    }


    @Test
    void testPriceClose() {
        Assertions.assertEquals(3584.59, dailyFutureDTOs[0].getPriceClose());
        Assertions.assertEquals(3528.0, dailyFutureDTOs[1].getPriceClose());
        Assertions.assertEquals(3509.0, dailyFutureDTOs[2].getPriceClose());
    }


    @Test
    void testPriceLow() {
        Assertions.assertEquals(3507.0, dailyFutureDTOs[0].getPriceLow());
        Assertions.assertEquals(3469.0, dailyFutureDTOs[1].getPriceLow());
        Assertions.assertEquals(3418.0, dailyFutureDTOs[2].getPriceLow());
    }


    @Test
    void testPriceOpen() {
        Assertions.assertEquals(3530.0, dailyFutureDTOs[0].getPriceOpen());
        Assertions.assertEquals(3517.0, dailyFutureDTOs[1].getPriceOpen());
        Assertions.assertEquals(3450.0, dailyFutureDTOs[2].getPriceOpen());
    }


    @Test
    void testPriceHigh() {
        Assertions.assertEquals(3590.0, dailyFutureDTOs[0].getPriceHigh());
        Assertions.assertEquals(3551.0, dailyFutureDTOs[1].getPriceHigh());
        Assertions.assertEquals(3510.0, dailyFutureDTOs[2].getPriceHigh());
    }


    @Test
    void testVolume() {
        Assertions.assertEquals(936121, dailyFutureDTOs[0].getVolume());
        Assertions.assertEquals(939287, dailyFutureDTOs[1].getVolume());
        Assertions.assertEquals(1061095, dailyFutureDTOs[2].getVolume());
    }
}