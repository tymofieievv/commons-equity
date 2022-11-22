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
class PositionDTOTest {

    private final BufferedReader bufferedReader;
    @Autowired
    private Gson gson;
    private PositionDTO[] positionDTOs;

    public PositionDTOTest() throws URISyntaxException, IOException {
        URL resource = PositionDTOTest.class.getClassLoader().getResource("Position.json");
        assert resource != null;
        File file = new File(resource.toURI());
        this.bufferedReader = new BufferedReader(new InputStreamReader(Files.newInputStream(file.toPath())));
    }

    @BeforeEach
    void init() {
        positionDTOs = gson.fromJson(bufferedReader, PositionDTO[].class);
    }

    @Test
    void testRefDate() {
        Assertions.assertEquals(LocalDateTime.of(2022, 9, 29, 0, 0), positionDTOs[0].getRefDate());
        Assertions.assertEquals(LocalDateTime.of(2022, 9, 29, 0, 0), positionDTOs[1].getRefDate());
        Assertions.assertEquals(LocalDateTime.of(2022, 9, 29, 0, 0), positionDTOs[2].getRefDate());
        Assertions.assertEquals(LocalDateTime.of(2022, 9, 29, 0, 0), positionDTOs[3].getRefDate());
        Assertions.assertEquals(LocalDateTime.of(2022, 9, 29, 0, 0), positionDTOs[4].getRefDate());
        Assertions.assertEquals(LocalDateTime.of(2022, 9, 29, 0, 0), positionDTOs[5].getRefDate());
    }


    @Test
    void testPortfolioId() {
        Assertions.assertEquals("RELATIVE09", positionDTOs[0].getPortfolioId());
        Assertions.assertEquals("ETF_DIR", positionDTOs[1].getPortfolioId());
        Assertions.assertEquals("ETF_DIR", positionDTOs[2].getPortfolioId());
        Assertions.assertEquals("SYST_VOL", positionDTOs[3].getPortfolioId());
        Assertions.assertEquals("EQ_SSVOL", positionDTOs[4].getPortfolioId());
        Assertions.assertEquals("LONG_ONLY", positionDTOs[5].getPortfolioId());
    }


    @Test
    void testInstrumentId() {
        Assertions.assertEquals("C Jun3 65.0 C", positionDTOs[0].getInstrumentId());
        Assertions.assertEquals("FESX 202212", positionDTOs[1].getInstrumentId());
        Assertions.assertEquals("EMINI S&P DEC0", positionDTOs[2].getInstrumentId());
        Assertions.assertEquals("Roblox Corp RBLX", positionDTOs[3].getInstrumentId());
        Assertions.assertEquals("STLA1X13.2169X", positionDTOs[4].getInstrumentId());
        Assertions.assertEquals("KWEB", positionDTOs[5].getInstrumentId());
    }


    @Test
    void testFamily() {
        Assertions.assertEquals("Equities", positionDTOs[0].getFamily());
        Assertions.assertEquals("Equities", positionDTOs[1].getFamily());
        Assertions.assertEquals("Equities", positionDTOs[2].getFamily());
        Assertions.assertEquals("Equities", positionDTOs[3].getFamily());
        Assertions.assertEquals("Equities", positionDTOs[4].getFamily());
        Assertions.assertEquals("Equities", positionDTOs[5].getFamily());
    }


    @Test
    void testGroup() {
        Assertions.assertEquals("Options", positionDTOs[0].getGroup());
        Assertions.assertEquals("Futures", positionDTOs[1].getGroup());
        Assertions.assertEquals("Futures", positionDTOs[2].getGroup());
        Assertions.assertEquals("Equities", positionDTOs[3].getGroup());
        Assertions.assertEquals("Options", positionDTOs[4].getGroup());
        Assertions.assertEquals("Collective investment vehicles", positionDTOs[5].getGroup());
    }


    @Test
    void testType() {
        Assertions.assertEquals("Call", positionDTOs[0].getType());
        Assertions.assertEquals("Financial Futures", positionDTOs[1].getType());
        Assertions.assertEquals("Financial Futures", positionDTOs[2].getType());
        Assertions.assertEquals("Common/Ordinary shares", positionDTOs[3].getType());
        Assertions.assertEquals("Put", positionDTOs[4].getType());
        Assertions.assertEquals("ETF", positionDTOs[5].getType());
    }


    @Test
    void testCurrency() {
        Assertions.assertEquals("USD", positionDTOs[0].getCurrency());
        Assertions.assertEquals("EUR", positionDTOs[1].getCurrency());
        Assertions.assertEquals("USD", positionDTOs[2].getCurrency());
        Assertions.assertEquals("USD", positionDTOs[3].getCurrency());
        Assertions.assertEquals("EUR", positionDTOs[4].getCurrency());
        Assertions.assertEquals("USD", positionDTOs[5].getCurrency());
    }


    @Test
    void testPOSITION() {
        Assertions.assertEquals(0, positionDTOs[0].getPosition());
        Assertions.assertEquals(-170, positionDTOs[1].getPosition());
        Assertions.assertEquals(0, positionDTOs[2].getPosition());
        Assertions.assertEquals(300, positionDTOs[3].getPosition());
        Assertions.assertEquals(0, positionDTOs[4].getPosition());
        Assertions.assertEquals(-2238, positionDTOs[5].getPosition());
    }


    @Test
    void testEntity() {
        Assertions.assertEquals("INTESA SANPAOLO SPA - MILANO", positionDTOs[0].getEntity());
        Assertions.assertEquals("INTESA SANPAOLO SPA - MILANO", positionDTOs[1].getEntity());
        Assertions.assertEquals("INTESA SANPAOLO SPA - MILANO", positionDTOs[2].getEntity());
        Assertions.assertEquals("INTESA SANPAOLO SPA - MILANO", positionDTOs[3].getEntity());
        Assertions.assertEquals("INTESA SANPAOLO SPA - MILANO", positionDTOs[4].getEntity());
        Assertions.assertEquals("INTESA SANPAOLO SPA - MILANO", positionDTOs[5].getEntity());
    }


    @Test
    void testDivision() {
        Assertions.assertEquals("CIB", positionDTOs[0].getDivision());
        Assertions.assertEquals("CIB", positionDTOs[1].getDivision());
        Assertions.assertEquals("CIB", positionDTOs[2].getDivision());
        Assertions.assertEquals("CIB", positionDTOs[3].getDivision());
        Assertions.assertEquals("CIB", positionDTOs[4].getDivision());
        Assertions.assertEquals("CIB", positionDTOs[5].getDivision());
    }


    @Test
    void testMarketName() {
        Assertions.assertEquals("Reuters Elektron", positionDTOs[0].getMarketName());
        Assertions.assertEquals("Eurex NTA", positionDTOs[1].getMarketName());
        Assertions.assertEquals("FFastFill", positionDTOs[2].getMarketName());
        Assertions.assertEquals("Virtu", positionDTOs[3].getMarketName());
        Assertions.assertEquals("Borsa Italiana IDEM", positionDTOs[4].getMarketName());
        Assertions.assertEquals("Virtu", positionDTOs[5].getMarketName());
    }
}