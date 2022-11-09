package com.example.commons.equity.model.entity.input;

import com.example.commons.equity.model.dto.input.PositionDTO;
import com.google.gson.Gson;
import java.lang.String;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PositionTest {
  private static final String jsonString = 
      
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
  "POSITION": "0",
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
  "POSITION": "-170",
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
  "POSITION": "0",
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
  "POSITION": "300",
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
  "POSITION": "0",
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
  "POSITION": "-2238",
  "ENTITY": "INTESA SANPAOLO SPA - MILANO",
  "DIVISION": "CIB",
  "MARKET_NAME": "Virtu"
  }
              ]
              """;
  ;

  @Autowired
  private Gson gson;

  private List<Position> positions;

  @BeforeEach
  void init() {
    positions = Arrays.stream(gson.fromJson(jsonString, PositionDTO[].class)).sequential().map(PositionDTO::toEntity).collect(Collectors.toList());
  }

  @Test
  void testId() {
    Assertions.assertNull(positions.get(0).getId());
    Assertions.assertNull(positions.get(1).getId());
    Assertions.assertNull(positions.get(2).getId());
    Assertions.assertNull(positions.get(3).getId());
    Assertions.assertNull(positions.get(4).getId());
    Assertions.assertNull(positions.get(5).getId());
  }

  @Test
  void testRefDate() {
    Assertions.assertEquals(LocalDateTime.of(2022,9,29,0,0), positions.get(0).getRefDate());
    Assertions.assertEquals(LocalDateTime.of(2022,9,29,0,0), positions.get(1).getRefDate());
    Assertions.assertEquals(LocalDateTime.of(2022,9,29,0,0), positions.get(2).getRefDate());
    Assertions.assertEquals(LocalDateTime.of(2022,9,29,0,0), positions.get(3).getRefDate());
    Assertions.assertEquals(LocalDateTime.of(2022,9,29,0,0), positions.get(4).getRefDate());
    Assertions.assertEquals(LocalDateTime.of(2022,9,29,0,0), positions.get(5).getRefDate());
  }

  @Test
  void testPortfolioId() {
    Assertions.assertEquals("RELATIVE09", positions.get(0).getPortfolioId());
    Assertions.assertEquals("ETF_DIR", positions.get(1).getPortfolioId());
    Assertions.assertEquals("ETF_DIR", positions.get(2).getPortfolioId());
    Assertions.assertEquals("SYST_VOL", positions.get(3).getPortfolioId());
    Assertions.assertEquals("EQ_SSVOL", positions.get(4).getPortfolioId());
    Assertions.assertEquals("LONG_ONLY", positions.get(5).getPortfolioId());
  }

  @Test
  void testInstrumentId() {
    Assertions.assertEquals("C Jun3 65.0 C", positions.get(0).getInstrumentId());
    Assertions.assertEquals("FESX 202212", positions.get(1).getInstrumentId());
    Assertions.assertEquals("EMINI S&P DEC0", positions.get(2).getInstrumentId());
    Assertions.assertEquals("Roblox Corp RBLX", positions.get(3).getInstrumentId());
    Assertions.assertEquals("STLA1X13.2169X", positions.get(4).getInstrumentId());
    Assertions.assertEquals("KWEB", positions.get(5).getInstrumentId());
  }

  @Test
  void testPositionId() {
    Assertions.assertNull(positions.get(0).getPositionId());
    Assertions.assertNull(positions.get(1).getPositionId());
    Assertions.assertNull(positions.get(2).getPositionId());
    Assertions.assertNull(positions.get(3).getPositionId());
    Assertions.assertNull(positions.get(4).getPositionId());
    Assertions.assertNull(positions.get(5).getPositionId());
  }

  @Test
  void testFamily() {
    Assertions.assertEquals("Equities", positions.get(0).getFamily());
    Assertions.assertEquals("Equities", positions.get(1).getFamily());
    Assertions.assertEquals("Equities", positions.get(2).getFamily());
    Assertions.assertEquals("Equities", positions.get(3).getFamily());
    Assertions.assertEquals("Equities", positions.get(4).getFamily());
    Assertions.assertEquals("Equities", positions.get(5).getFamily());
  }

  @Test
  void testGroup() {
    Assertions.assertEquals("Options", positions.get(0).getGroup());
    Assertions.assertEquals("Futures", positions.get(1).getGroup());
    Assertions.assertEquals("Futures", positions.get(2).getGroup());
    Assertions.assertEquals("Equities", positions.get(3).getGroup());
    Assertions.assertEquals("Options", positions.get(4).getGroup());
    Assertions.assertEquals("Collective investment vehicles", positions.get(5).getGroup());
  }

  @Test
  void testType() {
    Assertions.assertEquals("Call", positions.get(0).getType());
    Assertions.assertEquals("Financial Futures", positions.get(1).getType());
    Assertions.assertEquals("Financial Futures", positions.get(2).getType());
    Assertions.assertEquals("Common/Ordinary shares", positions.get(3).getType());
    Assertions.assertEquals("Put", positions.get(4).getType());
    Assertions.assertEquals("ETF", positions.get(5).getType());
  }

  @Test
  void testCurrency() {
    Assertions.assertEquals("USD", positions.get(0).getCurrency());
    Assertions.assertEquals("EUR", positions.get(1).getCurrency());
    Assertions.assertEquals("USD", positions.get(2).getCurrency());
    Assertions.assertEquals("USD", positions.get(3).getCurrency());
    Assertions.assertEquals("EUR", positions.get(4).getCurrency());
    Assertions.assertEquals("USD", positions.get(5).getCurrency());
  }

  @Test
  void testPosition() {
    Assertions.assertEquals(0, positions.get(0).getPosition());
    Assertions.assertEquals(-170, positions.get(1).getPosition());
    Assertions.assertEquals(0, positions.get(2).getPosition());
    Assertions.assertEquals(300, positions.get(3).getPosition());
    Assertions.assertEquals(0, positions.get(4).getPosition());
    Assertions.assertEquals(-2238, positions.get(5).getPosition());
  }

  @Test
  void testEntity() {
    Assertions.assertEquals("INTESA SANPAOLO SPA - MILANO", positions.get(0).getEntity());
    Assertions.assertEquals("INTESA SANPAOLO SPA - MILANO", positions.get(1).getEntity());
    Assertions.assertEquals("INTESA SANPAOLO SPA - MILANO", positions.get(2).getEntity());
    Assertions.assertEquals("INTESA SANPAOLO SPA - MILANO", positions.get(3).getEntity());
    Assertions.assertEquals("INTESA SANPAOLO SPA - MILANO", positions.get(4).getEntity());
    Assertions.assertEquals("INTESA SANPAOLO SPA - MILANO", positions.get(5).getEntity());
  }

  @Test
  void testDivision() {
    Assertions.assertEquals("CIB", positions.get(0).getDivision());
    Assertions.assertEquals("CIB", positions.get(1).getDivision());
    Assertions.assertEquals("CIB", positions.get(2).getDivision());
    Assertions.assertEquals("CIB", positions.get(3).getDivision());
    Assertions.assertEquals("CIB", positions.get(4).getDivision());
    Assertions.assertEquals("CIB", positions.get(5).getDivision());
  }

  @Test
  void testMarketName() {
    Assertions.assertEquals("Reuters Elektron", positions.get(0).getMarketName());
    Assertions.assertEquals("Eurex NTA", positions.get(1).getMarketName());
    Assertions.assertEquals("FFastFill", positions.get(2).getMarketName());
    Assertions.assertEquals("Virtu", positions.get(3).getMarketName());
    Assertions.assertEquals("Borsa Italiana IDEM", positions.get(4).getMarketName());
    Assertions.assertEquals("Virtu", positions.get(5).getMarketName());
  }
}
