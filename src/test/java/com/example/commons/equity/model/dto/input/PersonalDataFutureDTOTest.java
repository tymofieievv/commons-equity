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
class PersonalDataFutureDTOTest {

    private final BufferedReader bufferedReader;
    @Autowired
    private Gson gson;
    private PersonalDataFutureDTO[] personalDataFutureDTOs;

    public PersonalDataFutureDTOTest() throws URISyntaxException, IOException {
        URL resource = PersonalDataFutureDTOTest.class.getClassLoader().getResource("PersonalDataFuture.json");
        assert resource != null;
        File file = new File(resource.toURI());
        this.bufferedReader = new BufferedReader(new InputStreamReader(Files.newInputStream(file.toPath())));
    }

    @BeforeEach
    void init() {
        personalDataFutureDTOs = gson.fromJson(bufferedReader, PersonalDataFutureDTO[].class);
    }

    @Test
    void testTicker() {
        Assertions.assertEquals("VGZ2", personalDataFutureDTOs[0].getTicker());
        Assertions.assertEquals("VGZ2", personalDataFutureDTOs[1].getTicker());
        Assertions.assertEquals("VGZ2", personalDataFutureDTOs[2].getTicker());
    }


    @Test
    void testIsin() {
        Assertions.assertEquals("DE0009652388", personalDataFutureDTOs[0].getIsin());
        Assertions.assertEquals("FR0010424143", personalDataFutureDTOs[1].getIsin());
        Assertions.assertEquals("IE0008471009", personalDataFutureDTOs[2].getIsin());
    }


    @Test
    void testDescription() {
        Assertions.assertEquals("EURO STOXX 50 Index Futures", personalDataFutureDTOs[0].getDescription());
        Assertions.assertEquals("Lyxor UCITS Stoxx 50 Daily Double Short (BXX)", personalDataFutureDTOs[1].getDescription());
        Assertions.assertEquals("Profilo iShares Core EURO STOXX 50 UCITS ETF EUR (Dist)", personalDataFutureDTOs[2].getDescription());
    }


    @Test
    void testCurrency() {
        Assertions.assertEquals("EUR", personalDataFutureDTOs[0].getCurrency());
        Assertions.assertEquals("EUR", personalDataFutureDTOs[1].getCurrency());
        Assertions.assertEquals("EUR", personalDataFutureDTOs[2].getCurrency());
    }


    @Test
    void testMaturity() {
        Assertions.assertEquals(LocalDate.of(2023, 12, 31), personalDataFutureDTOs[0].getMaturity());
        Assertions.assertEquals(LocalDate.of(2023, 12, 31), personalDataFutureDTOs[1].getMaturity());
        Assertions.assertEquals(LocalDate.of(2023, 12, 31), personalDataFutureDTOs[2].getMaturity());
    }
}