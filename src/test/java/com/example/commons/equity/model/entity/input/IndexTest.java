package com.example.commons.equity.model.entity.input;

import com.example.commons.equity.model.dto.input.IndexDTO;
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
class IndexTest {

    private final BufferedReader historyIndexBufferedReader;
    private final BufferedReader realtimeIndexBufferedReader;
    @Autowired
    private Gson gsonHistorical;

    private List<Index> indexesHistorical;

    public IndexTest() throws URISyntaxException, IOException {
        URL resourceIndexHistory = IndexTest.class.getClassLoader().getResource("IndexHistory.json");
        URL resourceIndexRealtime = IndexTest.class.getClassLoader().getResource("IndexRealtime.json");

        assert resourceIndexHistory != null;
        File fileHistory = new File(resourceIndexHistory.toURI());
        assert resourceIndexRealtime != null;
        File fileRealtime = new File(resourceIndexRealtime.toURI());
        this.historyIndexBufferedReader = new BufferedReader(new InputStreamReader(Files.newInputStream(fileHistory.toPath())));
        this.realtimeIndexBufferedReader = new BufferedReader(new InputStreamReader(Files.newInputStream(fileRealtime.toPath())));
    }

    @BeforeEach
    void initHistorical() {
        indexesHistorical = Arrays.stream(gsonHistorical.fromJson(historyIndexBufferedReader, IndexDTO[].class)).sequential().map(IndexDTO::toEntity).collect(Collectors.toList());
    }

    @Test
    void testIdHistorical() {
        Assertions.assertNull(indexesHistorical.get(0).getId());
        Assertions.assertNull(indexesHistorical.get(1).getId());
        Assertions.assertNull(indexesHistorical.get(2).getId());
        Assertions.assertNull(indexesHistorical.get(3).getId());
        Assertions.assertNull(indexesHistorical.get(4).getId());
    }

    @Test
    void testTimestampHistorical() {

        Assertions.assertEquals(LocalDateTime.of(2021, 1, 4, 17, 0, 0), indexesHistorical.get(0).getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2021, 1, 5, 12, 5, 3), indexesHistorical.get(1).getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2021, 1, 6, 9, 30, 30), indexesHistorical.get(2).getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2021, 1, 7, 13, 45, 0), indexesHistorical.get(3).getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2021, 1, 8, 16, 0, 0), indexesHistorical.get(4).getTimestamp());
    }

    @Test
    void testInstrumentIdHistorical() {
        Assertions.assertEquals(".STOXX50E", indexesHistorical.get(0).getInstrumentId());
        Assertions.assertEquals(".STOXX50E", indexesHistorical.get(1).getInstrumentId());
        Assertions.assertEquals(".STOXX50E", indexesHistorical.get(2).getInstrumentId());
        Assertions.assertEquals(".STOXX50E", indexesHistorical.get(3).getInstrumentId());
        Assertions.assertEquals(".STOXX50E", indexesHistorical.get(4).getInstrumentId());
    }

    @Test
    void testPriceHistorical() {
        Assertions.assertEquals(3564.39, indexesHistorical.get(0).getPriceOpen());
        Assertions.assertEquals(3547.85, indexesHistorical.get(1).getPriceOpen());
        Assertions.assertEquals(3611.08, indexesHistorical.get(2).getPriceOpen());
        Assertions.assertEquals(3622.42, indexesHistorical.get(3).getPriceOpen());
        Assertions.assertEquals(3645.05, indexesHistorical.get(4).getPriceOpen());
    }

    @Autowired
    private Gson gson;

    private List<Index> indexes;

    @BeforeEach
    void init() {
        indexes = Arrays.stream(gson.fromJson(realtimeIndexBufferedReader, IndexDTO[].class)).sequential().map(IndexDTO::toEntity).collect(Collectors.toList());
    }

    @Test
    void testId() {
        Assertions.assertNull(indexes.get(0).getId());
        Assertions.assertNull(indexes.get(1).getId());
        Assertions.assertNull(indexes.get(2).getId());
        Assertions.assertNull(indexes.get(3).getId());
    }

    @Test
    void testTimestamp() {
        Assertions.assertEquals(LocalDateTime.of(2022, 10, 26, 11, 56, 30), indexes.get(0).getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2022, 10, 26, 11, 56, 15), indexes.get(1).getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2022, 10, 26, 11, 56, 0), indexes.get(2).getTimestamp());
        Assertions.assertEquals(LocalDateTime.of(2022, 10, 26, 11, 55, 45), indexes.get(3).getTimestamp());
    }

    @Test
    void testInstrumentId() {
        Assertions.assertNull(indexes.get(0).getInstrumentId());
        Assertions.assertNull(indexes.get(1).getInstrumentId());
        Assertions.assertNull(indexes.get(2).getInstrumentId());
        Assertions.assertNull(indexes.get(3).getInstrumentId());
    }

    @Test
    void testPrice() {
        Assertions.assertEquals(3577.99, indexes.get(0).getPriceOpen());
        Assertions.assertEquals(3577.05, indexes.get(1).getPriceOpen());
        Assertions.assertEquals(3576.47, indexes.get(2).getPriceOpen());
        Assertions.assertEquals(3575.78, indexes.get(3).getPriceOpen());
    }
}
