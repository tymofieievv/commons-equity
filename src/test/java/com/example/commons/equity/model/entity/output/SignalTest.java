package com.example.commons.equity.model.entity.output;

import com.example.commons.equity.model.dto.output.SignalDTO;
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
class SignalTest {
  private static final String jsonString = 
      
              """
              [
  {
  "TIMESTAMP": "15/07/2022",
  "TRADEDATE": "15/07/2022",
  "UNDERLYING": "EU0009658145",
  "TICKER FUTURE": "VGU2",
  "BUY/SELL": "SELL",
  "QUANTITY": "-25",
  "THEORETICAL PRICE": "3477.2"
  },
  {
  "TIMESTAMP": "14/07/2022",
  "TRADEDATE": "14/07/2022",
  "UNDERLYING": "EU0009658146",
  "TICKER FUTURE": "VGU2",
  "BUY/SELL": "BUY",
  "QUANTITY": "25",
  "THEORETICAL PRICE": "3396.61"
  },
  {
  "TIMESTAMP": "13/07/2022",
  "TRADEDATE": "13/07/2022",
  "UNDERLYING": "EU0009658147",
  "TICKER FUTURE": "VGU2",
  "BUY/SELL": "SELL",
  "QUANTITY": "-26",
  "THEORETICAL PRICE": "3453.97"
  },
  {
  "TIMESTAMP": "12/07/2022",
  "TRADEDATE": "12/07/2022",
  "UNDERLYING": "EU0009658148",
  "TICKER FUTURE": "VGU2",
  "BUY/SELL": "SELL",
  "QUANTITY": "-26",
  "THEORETICAL PRICE": "3487.05"
  },
  {
  "TIMESTAMP": "11/07/2022",
  "TRADEDATE": "11/07/2022",
  "UNDERLYING": "EU0009658149",
  "TICKER FUTURE": "VGU2",
  "BUY/SELL": "BUY",
  "QUANTITY": "25",
  "THEORETICAL PRICE": "3471.69"
  }
              ]
              """;
  ;

  @Autowired
  private Gson gson;

  private List<Signal> signals;

  @BeforeEach
  void init() {
    signals = Arrays.stream(gson.fromJson(jsonString, SignalDTO[].class)).sequential().map(SignalDTO::toEntity).collect(Collectors.toList());
  }

  @Test
  void testId() {
    Assertions.assertNull(signals.get(0).getId());
    Assertions.assertNull(signals.get(1).getId());
    Assertions.assertNull(signals.get(2).getId());
    Assertions.assertNull(signals.get(3).getId());
    Assertions.assertNull(signals.get(4).getId());
  }

  @Test
  void testTimestamp() {
    Assertions.assertEquals(LocalDate.of(2022,7,15), signals.get(0).getTimestamp());
    Assertions.assertEquals(LocalDate.of(2022,7,14), signals.get(1).getTimestamp());
    Assertions.assertEquals(LocalDate.of(2022,7,13), signals.get(2).getTimestamp());
    Assertions.assertEquals(LocalDate.of(2022,7,12), signals.get(3).getTimestamp());
    Assertions.assertEquals(LocalDate.of(2022,7,11), signals.get(4).getTimestamp());
  }

  @Test
  void testTradeDate() {
    Assertions.assertEquals(LocalDate.of(2022,7,15), signals.get(0).getTradeDate());
    Assertions.assertEquals(LocalDate.of(2022,7,14), signals.get(1).getTradeDate());
    Assertions.assertEquals(LocalDate.of(2022,7,13), signals.get(2).getTradeDate());
    Assertions.assertEquals(LocalDate.of(2022,7,12), signals.get(3).getTradeDate());
    Assertions.assertEquals(LocalDate.of(2022,7,11), signals.get(4).getTradeDate());
  }

  @Test
  void testUnderlying() {
    Assertions.assertEquals("EU0009658145", signals.get(0).getUnderlying());
    Assertions.assertEquals("EU0009658146", signals.get(1).getUnderlying());
    Assertions.assertEquals("EU0009658147", signals.get(2).getUnderlying());
    Assertions.assertEquals("EU0009658148", signals.get(3).getUnderlying());
    Assertions.assertEquals("EU0009658149", signals.get(4).getUnderlying());
  }

  @Test
  void testIdSignal() {
    Assertions.assertNull(signals.get(0).getIdSignal());
    Assertions.assertNull(signals.get(1).getIdSignal());
    Assertions.assertNull(signals.get(2).getIdSignal());
    Assertions.assertNull(signals.get(3).getIdSignal());
    Assertions.assertNull(signals.get(4).getIdSignal());
  }

  @Test
  void testTicketFuture() {
    Assertions.assertEquals("VGU2",signals.get(0).getTickerFuture());
    Assertions.assertEquals("VGU2",signals.get(1).getTickerFuture());
    Assertions.assertEquals("VGU2",signals.get(2).getTickerFuture());
    Assertions.assertEquals("VGU2",signals.get(3).getTickerFuture());
    Assertions.assertEquals("VGU2",signals.get(4).getTickerFuture());
  }

  @Test
  void testOperations() {
    Assertions.assertEquals("SELL",signals.get(0).getBuySell().name());
    Assertions.assertEquals("BUY",signals.get(1).getBuySell().name());
    Assertions.assertEquals("SELL",signals.get(2).getBuySell().name());
    Assertions.assertEquals("SELL",signals.get(3).getBuySell().name());
    Assertions.assertEquals("BUY",signals.get(4).getBuySell().name());
  }

  @Test
  void testQuantity() {
    Assertions.assertEquals(-25, signals.get(0).getQuantity());
    Assertions.assertEquals(25, signals.get(1).getQuantity());
    Assertions.assertEquals(-26, signals.get(2).getQuantity());
    Assertions.assertEquals(-26, signals.get(3).getQuantity());
    Assertions.assertEquals(25, signals.get(4).getQuantity());
  }

  @Test
  void testTheoreticalPrice() {
    Assertions.assertEquals(3477.2, signals.get(0).getTheoreticalPrice());
    Assertions.assertEquals(3396.61, signals.get(1).getTheoreticalPrice());
    Assertions.assertEquals(3453.97, signals.get(2).getTheoreticalPrice());
    Assertions.assertEquals(3487.05, signals.get(3).getTheoreticalPrice());
    Assertions.assertEquals(3471.69, signals.get(4).getTheoreticalPrice());
  }
}
