package com.example.commons.equity.model.dto.input;

import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class PersonalDataFutureDTOTest {


    private final String jsonString =
            """
                                [
                    {
                    "TICKER": "VGZ2",
                    "ISIN": "DE0009652388",
                    "DESCRIPTION": "EURO STOXX 50® Index Futures",
                    "CURRENCY": "EUR",
                    "MATURITY": "31/12/2023"
                    },
                    {
                    "TICKER": "VGZ2",
                    "ISIN": "FR0010424143",
                    "DESCRIPTION": "Lyxor UCITS Stoxx 50 Daily Double Short (BXX)",
                    "CURRENCY": "EUR",
                    "MATURITY": "31/12/2023"
                    },
                    {
                    "TICKER": "VGZ2",
                    "ISIN": "IE0008471009",
                    "DESCRIPTION": "Profilo iShares Core EURO STOXX 50 UCITS ETF EUR (Dist)",
                    "CURRENCY": "EUR",
                    "MATURITY": "31/12/2023"
                    }
                                ]
                                """;


    @Autowired
    private Gson gson;
    private PersonalDataFutureDTO[] personalDataFutureDTOs;

    @BeforeEach
    void init() {
        personalDataFutureDTOs = gson.fromJson(jsonString, PersonalDataFutureDTO[].class);
    }

    @Test
    void testTicker() {
        Assertions.assertEquals("VGZ2", personalDataFutureDTOs[0].ticker());
        Assertions.assertEquals("VGZ2", personalDataFutureDTOs[1].ticker());
        Assertions.assertEquals("VGZ2", personalDataFutureDTOs[2].ticker());
    }


    @Test
    void testIsin() {
        Assertions.assertEquals("DE0009652388", personalDataFutureDTOs[0].isin());
        Assertions.assertEquals("FR0010424143", personalDataFutureDTOs[1].isin());
        Assertions.assertEquals("IE0008471009", personalDataFutureDTOs[2].isin());
    }


    @Test
    void testDescription() {
        Assertions.assertEquals("EURO STOXX 50® Index Futures", personalDataFutureDTOs[0].description());
        Assertions.assertEquals("Lyxor UCITS Stoxx 50 Daily Double Short (BXX)", personalDataFutureDTOs[1].description());
        Assertions.assertEquals("Profilo iShares Core EURO STOXX 50 UCITS ETF EUR (Dist)", personalDataFutureDTOs[2].description());
    }


    @Test
    void testCurrency() {
        Assertions.assertEquals("EUR", personalDataFutureDTOs[0].currency());
        Assertions.assertEquals("EUR", personalDataFutureDTOs[1].currency());
        Assertions.assertEquals("EUR", personalDataFutureDTOs[2].currency());
    }


    @Test
    void testMaturity() {
        Assertions.assertEquals(LocalDate.of(2023, 12, 31), personalDataFutureDTOs[0].maturity());
        Assertions.assertEquals(LocalDate.of(2023, 12, 31), personalDataFutureDTOs[1].maturity());
        Assertions.assertEquals(LocalDate.of(2023, 12, 31), personalDataFutureDTOs[2].maturity());
    }
}