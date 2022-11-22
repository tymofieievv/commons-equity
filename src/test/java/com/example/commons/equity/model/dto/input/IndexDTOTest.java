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
import java.time.LocalDateTime;

@SpringBootTest
class IndexDTOTest {

    private final BufferedReader historyIndexBufferedReader;
    private final BufferedReader realtimeIndexBufferedReader;
    @Autowired
    private Gson gson;
    private IndexDTO[] realtimeIndexDTOs;
    private IndexDTO[] historyIndexDTOs;

    public IndexDTOTest() throws URISyntaxException, IOException {
        URL resourceIndexHistory = IndexDTOTest.class.getClassLoader().getResource("IndexHistory.json");
        URL resourceIndexRealtime = IndexDTOTest.class.getClassLoader().getResource("IndexRealtime.json");

        assert resourceIndexHistory != null;
        File fileHistory = new File(resourceIndexHistory.toURI());
        assert resourceIndexRealtime != null;
        File fileRealtime = new File(resourceIndexRealtime.toURI());
        this.historyIndexBufferedReader = new BufferedReader(new InputStreamReader(Files.newInputStream(fileHistory.toPath())));
        this.realtimeIndexBufferedReader = new BufferedReader(new InputStreamReader(Files.newInputStream(fileRealtime.toPath())));
    }

    @BeforeEach
    void init() {
        realtimeIndexDTOs = gson.fromJson(realtimeIndexBufferedReader, IndexDTO[].class);
        historyIndexDTOs = gson.fromJson(historyIndexBufferedReader, IndexDTO[].class);
    }

    @Test
    void testRefDate() {
        Assertions.assertEquals(LocalDateTime.of(2022, 10, 26, 11, 56, 30), realtimeIndexDTOs[0].getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2022, 10, 26, 11, 56, 15), realtimeIndexDTOs[1].getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2022, 10, 26, 11, 56, 0), realtimeIndexDTOs[2].getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2022, 10, 26, 11, 55, 45), realtimeIndexDTOs[3].getTimestamp());

        Assertions.assertEquals(LocalDateTime.of(2021, 1, 4, 17, 0, 0), historyIndexDTOs[0].getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2021, 1, 5, 12, 5, 3), historyIndexDTOs[1].getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2021, 1, 6, 9, 30, 30), historyIndexDTOs[2].getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2021, 1, 7, 13, 45, 0), historyIndexDTOs[3].getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2021, 1, 8, 16, 0, 0), historyIndexDTOs[4].getTimestamp());
    }

    @Test
    void testPrice() {
        Assertions.assertEquals(3577.99, realtimeIndexDTOs[0].getPriceOpen());
        Assertions.assertEquals(3577.05, realtimeIndexDTOs[1].getPriceOpen());
        Assertions.assertEquals(3576.47, realtimeIndexDTOs[2].getPriceOpen());
        Assertions.assertEquals(3575.78, realtimeIndexDTOs[3].getPriceOpen());

        Assertions.assertEquals(3564.39, historyIndexDTOs[0].getPriceOpen());
        Assertions.assertEquals(3547.85, historyIndexDTOs[1].getPriceOpen());
        Assertions.assertEquals(3611.08, historyIndexDTOs[2].getPriceOpen());
        Assertions.assertEquals(3622.42, historyIndexDTOs[3].getPriceOpen());
        Assertions.assertEquals(3645.05, historyIndexDTOs[4].getPriceOpen());
    }


    @Test
    void testInstrumentId() {
        Assertions.assertNull(realtimeIndexDTOs[0].getInstrumentId());
        Assertions.assertNull(realtimeIndexDTOs[1].getInstrumentId());
        Assertions.assertNull(realtimeIndexDTOs[2].getInstrumentId());
        Assertions.assertNull(realtimeIndexDTOs[3].getInstrumentId());

        Assertions.assertEquals(".STOXX50E", historyIndexDTOs[0].getInstrumentId());
        Assertions.assertEquals(".STOXX50E", historyIndexDTOs[1].getInstrumentId());
        Assertions.assertEquals(".STOXX50E", historyIndexDTOs[2].getInstrumentId());
        Assertions.assertEquals(".STOXX50E", historyIndexDTOs[3].getInstrumentId());
        Assertions.assertEquals(".STOXX50E", historyIndexDTOs[4].getInstrumentId());
    }


}