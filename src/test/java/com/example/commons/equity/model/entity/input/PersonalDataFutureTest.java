package com.example.commons.equity.model.entity.input;

import com.example.commons.equity.model.dto.input.PersonalDataFutureDTO;
import com.google.gson.Gson;
import java.lang.String;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonalDataFutureTest {
  private static final String jsonString = 
      
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
  ;

  @Autowired
  private Gson gson;

  private List<PersonalDataFuture> personalDataFutures;

  @BeforeEach
  void init() {
    personalDataFutures = Arrays.stream(gson.fromJson(jsonString, PersonalDataFutureDTO[].class)).sequential().map(PersonalDataFutureDTO::toEntity).collect(Collectors.toList());
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
    Assertions.assertEquals("EURO STOXX 50® Index Futures", personalDataFutures.get(0).getDescription());
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
    Assertions.assertEquals(LocalDate.of(2023,12,31), personalDataFutures.get(0).getMaturity());
    Assertions.assertEquals(LocalDate.of(2023,12,31), personalDataFutures.get(1).getMaturity());
    Assertions.assertEquals(LocalDate.of(2023,12,31), personalDataFutures.get(2).getMaturity());
  }
}
