package com.example.commons.equity.model.dto.input;

import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class PositionDTOTest {


    private final String jsonString =
            """
                                [
                    {
                    "REF_DATE": "29/09/2022 00:00",
                    "PORTFOLIO_ID": "RELATIVE09",
                    "INSTRUMENT_ID": "C Jun3 65.0 C",
                    "FAMILY": "Equities",
                    "GROUP": "Options",
                    "TYPE": "Call",
                    "CURRENCY": "USD",
                    "QUANTITY": "0",
                    "ENTITY": "INTESA SANPAOLO SPA - MILANO",
                    "DIVISION": "CIB",
                    "MARKET_NAME": "Reuters Elektron"
                    },
                    {
                    "REF_DATE": "29/09/2022 00:00",
                    "PORTFOLIO_ID": "ETF_DIR",
                    "INSTRUMENT_ID": "FESX 202212",
                    "FAMILY": "Equities",
                    "GROUP": "Futures",
                    "TYPE": "Financial Futures",
                    "CURRENCY": "EUR",
                    "QUANTITY": "-170",
                    "ENTITY": "INTESA SANPAOLO SPA - MILANO",
                    "DIVISION": "CIB",
                    "MARKET_NAME": "Eurex NTA"
                    },
                    {
                    "REF_DATE": "29/09/2022 00:00",
                    "PORTFOLIO_ID": "ETF_DIR",
                    "INSTRUMENT_ID": "EMINI S&P DEC0",
                    "FAMILY": "Equities",
                    "GROUP": "Futures",
                    "TYPE": "Financial Futures",
                    "CURRENCY": "USD",
                    "QUANTITY": "0",
                    "ENTITY": "INTESA SANPAOLO SPA - MILANO",
                    "DIVISION": "CIB",
                    "MARKET_NAME": "FFastFill"
                    },
                    {
                    "REF_DATE": "29/09/2022 00:00",
                    "PORTFOLIO_ID": "SYST_VOL",
                    "INSTRUMENT_ID": "Roblox Corp RBLX",
                    "FAMILY": "Equities",
                    "GROUP": "Equities",
                    "TYPE": "Common/Ordinary shares",
                    "CURRENCY": "USD",
                    "QUANTITY": "300",
                    "ENTITY": "INTESA SANPAOLO SPA - MILANO",
                    "DIVISION": "CIB",
                    "MARKET_NAME": "Virtu"
                    },
                    {
                    "REF_DATE": "29/09/2022 00:00",
                    "PORTFOLIO_ID": "EQ_SSVOL",
                    "INSTRUMENT_ID": "STLA1X13.2169X",
                    "FAMILY": "Equities",
                    "GROUP": "Options",
                    "TYPE": "Put",
                    "CURRENCY": "EUR",
                    "QUANTITY": "0",
                    "ENTITY": "INTESA SANPAOLO SPA - MILANO",
                    "DIVISION": "CIB",
                    "MARKET_NAME": "Borsa Italiana IDEM"
                    },
                    {
                    "REF_DATE": "29/09/2022 00:00",
                    "PORTFOLIO_ID": "LONG_ONLY",
                    "INSTRUMENT_ID": "KWEB",
                    "FAMILY": "Equities",
                    "GROUP": "Collective investment vehicles",
                    "TYPE": "ETF",
                    "CURRENCY": "USD",
                    "QUANTITY": "-2238",
                    "ENTITY": "INTESA SANPAOLO SPA - MILANO",
                    "DIVISION": "CIB",
                    "MARKET_NAME": "Virtu"
                    }
                                ]
                                """;


    @Autowired
    private Gson gson;
    private PositionDTO[] positionDTOs;

    @BeforeEach
    void init() {
        positionDTOs = gson.fromJson(jsonString, PositionDTO[].class);
    }

    @Test
    void testRefDate() {
        Assertions.assertEquals(LocalDateTime.of(2022, 9, 29, 0, 0), positionDTOs[0].refDate());
        Assertions.assertEquals(LocalDateTime.of(2022, 9, 29, 0, 0), positionDTOs[1].refDate());
        Assertions.assertEquals(LocalDateTime.of(2022, 9, 29, 0, 0), positionDTOs[2].refDate());
        Assertions.assertEquals(LocalDateTime.of(2022, 9, 29, 0, 0), positionDTOs[3].refDate());
        Assertions.assertEquals(LocalDateTime.of(2022, 9, 29, 0, 0), positionDTOs[4].refDate());
        Assertions.assertEquals(LocalDateTime.of(2022, 9, 29, 0, 0), positionDTOs[5].refDate());
    }


    @Test
    void testPortfolioId() {
        Assertions.assertEquals("RELATIVE09", positionDTOs[0].portfolioId());
        Assertions.assertEquals("ETF_DIR", positionDTOs[1].portfolioId());
        Assertions.assertEquals("ETF_DIR", positionDTOs[2].portfolioId());
        Assertions.assertEquals("SYST_VOL", positionDTOs[3].portfolioId());
        Assertions.assertEquals("EQ_SSVOL", positionDTOs[4].portfolioId());
        Assertions.assertEquals("LONG_ONLY", positionDTOs[5].portfolioId());
    }


    @Test
    void testInstrumentId() {
        Assertions.assertEquals("C Jun3 65.0 C", positionDTOs[0].instrumentId());
        Assertions.assertEquals("FESX 202212", positionDTOs[1].instrumentId());
        Assertions.assertEquals("EMINI S&P DEC0", positionDTOs[2].instrumentId());
        Assertions.assertEquals("Roblox Corp RBLX", positionDTOs[3].instrumentId());
        Assertions.assertEquals("STLA1X13.2169X", positionDTOs[4].instrumentId());
        Assertions.assertEquals("KWEB", positionDTOs[5].instrumentId());
    }


    @Test
    void testFamily() {
        Assertions.assertEquals("Equities", positionDTOs[0].family());
        Assertions.assertEquals("Equities", positionDTOs[1].family());
        Assertions.assertEquals("Equities", positionDTOs[2].family());
        Assertions.assertEquals("Equities", positionDTOs[3].family());
        Assertions.assertEquals("Equities", positionDTOs[4].family());
        Assertions.assertEquals("Equities", positionDTOs[5].family());
    }


    @Test
    void testGroup() {
        Assertions.assertEquals("Options", positionDTOs[0].group());
        Assertions.assertEquals("Futures", positionDTOs[1].group());
        Assertions.assertEquals("Futures", positionDTOs[2].group());
        Assertions.assertEquals("Equities", positionDTOs[3].group());
        Assertions.assertEquals("Options", positionDTOs[4].group());
        Assertions.assertEquals("Collective investment vehicles", positionDTOs[5].group());
    }


    @Test
    void testType() {
        Assertions.assertEquals("Call", positionDTOs[0].type());
        Assertions.assertEquals("Financial Futures", positionDTOs[1].type());
        Assertions.assertEquals("Financial Futures", positionDTOs[2].type());
        Assertions.assertEquals("Common/Ordinary shares", positionDTOs[3].type());
        Assertions.assertEquals("Put", positionDTOs[4].type());
        Assertions.assertEquals("ETF", positionDTOs[5].type());
    }


    @Test
    void testCurrency() {
        Assertions.assertEquals("USD", positionDTOs[0].currency());
        Assertions.assertEquals("EUR", positionDTOs[1].currency());
        Assertions.assertEquals("USD", positionDTOs[2].currency());
        Assertions.assertEquals("USD", positionDTOs[3].currency());
        Assertions.assertEquals("EUR", positionDTOs[4].currency());
        Assertions.assertEquals("USD", positionDTOs[5].currency());
    }


    @Test
    void testQuantity() {
        Assertions.assertEquals(0, positionDTOs[0].quantity());
        Assertions.assertEquals(-170, positionDTOs[1].quantity());
        Assertions.assertEquals(0, positionDTOs[2].quantity());
        Assertions.assertEquals(300, positionDTOs[3].quantity());
        Assertions.assertEquals(0, positionDTOs[4].quantity());
        Assertions.assertEquals(-2238, positionDTOs[5].quantity());
    }


    @Test
    void testEntity() {
        Assertions.assertEquals("INTESA SANPAOLO SPA - MILANO", positionDTOs[0].entity());
        Assertions.assertEquals("INTESA SANPAOLO SPA - MILANO", positionDTOs[1].entity());
        Assertions.assertEquals("INTESA SANPAOLO SPA - MILANO", positionDTOs[2].entity());
        Assertions.assertEquals("INTESA SANPAOLO SPA - MILANO", positionDTOs[3].entity());
        Assertions.assertEquals("INTESA SANPAOLO SPA - MILANO", positionDTOs[4].entity());
        Assertions.assertEquals("INTESA SANPAOLO SPA - MILANO", positionDTOs[5].entity());
    }


    @Test
    void testDivision() {
        Assertions.assertEquals("CIB", positionDTOs[0].division());
        Assertions.assertEquals("CIB", positionDTOs[1].division());
        Assertions.assertEquals("CIB", positionDTOs[2].division());
        Assertions.assertEquals("CIB", positionDTOs[3].division());
        Assertions.assertEquals("CIB", positionDTOs[4].division());
        Assertions.assertEquals("CIB", positionDTOs[5].division());
    }


    @Test
    void testMarketName() {
        Assertions.assertEquals("Reuters Elektron", positionDTOs[0].marketName());
        Assertions.assertEquals("Eurex NTA", positionDTOs[1].marketName());
        Assertions.assertEquals("FFastFill", positionDTOs[2].marketName());
        Assertions.assertEquals("Virtu", positionDTOs[3].marketName());
        Assertions.assertEquals("Borsa Italiana IDEM", positionDTOs[4].marketName());
        Assertions.assertEquals("Virtu", positionDTOs[5].marketName());
    }
}