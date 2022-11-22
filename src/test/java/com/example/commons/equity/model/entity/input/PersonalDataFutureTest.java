package com.example.commons.equity.model.entity.input;

import com.example.commons.equity.model.dto.input.PersonalDataFutureDTO;
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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class PersonalDataFutureTest {

    private final BufferedReader bufferedReader;
    @Autowired
    private Gson gson;

    private List<PersonalDataFuture> personalDataFutures;
    public PersonalDataFutureTest() throws URISyntaxException, IOException {
        URL resource = PersonalDataFutureTest.class.getClassLoader().getResource("PersonalDataFuture.json");
        assert resource != null;
        File file = new File(resource.toURI());
        this.bufferedReader = new BufferedReader(new InputStreamReader(Files.newInputStream(file.toPath())));
    }
    @BeforeEach
    void init() {
        personalDataFutures = Arrays.stream(gson.fromJson(bufferedReader, PersonalDataFutureDTO[].class)).sequential().map(PersonalDataFutureDTO::toEntity).collect(Collectors.toList());
    }

    @Test
    void testId() {
        Assertions.assertNull(personalDataFutures.get(0).getId());
        Assertions.assertNull(personalDataFutures.get(1).getId());
        Assertions.assertNull(personalDataFutures.get(2).getId());
    }

    @Test
    void testIsin() {
        Assertions.assertEquals("DE0009652388", personalDataFutures.get(0).getIsin());
        Assertions.assertEquals("FR0010424143", personalDataFutures.get(1).getIsin());
        Assertions.assertEquals("IE0008471009", personalDataFutures.get(2).getIsin());
    }

    @Test
    void testTicker() {
        Assertions.assertEquals("VGZ2", personalDataFutures.get(0).getTicker());
        Assertions.assertEquals("VGZ2", personalDataFutures.get(1).getTicker());
        Assertions.assertEquals("VGZ2", personalDataFutures.get(2).getTicker());
    }

    @Test
    void testDescription() {
        Assertions.assertEquals("EURO STOXX 50 Index Futures", personalDataFutures.get(0).getDescription());
        Assertions.assertEquals("Lyxor UCITS Stoxx 50 Daily Double Short (BXX)", personalDataFutures.get(1).getDescription());
        Assertions.assertEquals("Profilo iShares Core EURO STOXX 50 UCITS ETF EUR (Dist)", personalDataFutures.get(2).getDescription());
    }

    @Test
    void testCurrency() {
        Assertions.assertEquals("EUR", personalDataFutures.get(0).getCurrency());
        Assertions.assertEquals("EUR", personalDataFutures.get(1).getCurrency());
        Assertions.assertEquals("EUR", personalDataFutures.get(2).getCurrency());
    }

    @Test
    void testMaturity() {
        Assertions.assertEquals(LocalDate.of(2023, 12, 31), personalDataFutures.get(0).getMaturity());
        Assertions.assertEquals(LocalDate.of(2023, 12, 31), personalDataFutures.get(1).getMaturity());
        Assertions.assertEquals(LocalDate.of(2023, 12, 31), personalDataFutures.get(2).getMaturity());
    }
}
