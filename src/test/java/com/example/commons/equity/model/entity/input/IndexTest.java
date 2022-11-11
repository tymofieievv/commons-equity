package com.example.commons.equity.model.entity.input;

import com.example.commons.equity.model.dto.input.IndexDTO;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class IndexTest {
    private static final String jsonString =

            """
                                [
                    {
                    "REF_DATE": "26/10/2022",
                    "UNDERLYING": "EU0009658145",
                    "TIME": "11.56.30",
                    "PRICE": "3577.99"
                    },
                    {
                    "REF_DATE": "26/10/2022",
                    "UNDERLYING": "EU0009658145",
                    "TIME": "11.56.15",
                    "PRICE": "3577.05"
                    },
                    {
                    "REF_DATE": "26/10/2022",
                    "UNDERLYING": "EU0009658145",
                    "TIME": "11.56.00",
                    "PRICE": "3576.47"
                    },
                    {
                    "REF_DATE": "26/10/2022",
                    "UNDERLYING": "EU0009658145",
                    "TIME": "11.55.45",
                    "PRICE": "3575.78"
                    }
                                ]
                                """;
    ;
    private static final String jsonStringHistorical =

            """
                              [
                    {
                    "REF_DATE": "04/01/2021",
                    "INSTRUMENT_ID": ".STOXX50E",
                    "SECURITY_DESCRIPTION": "ESTX 50 PR INDEX",
                    "TIME": "17.00.00",
                    "PRICE": "3564.39"
                    },
                    {
                    "REF_DATE": "05/01/2021",
                    "INSTRUMENT_ID": ".STOXX50E",
                    "SECURITY_DESCRIPTION": "ESTX 50 PR INDEX",
                    "TIME": "12.05.03",
                    "PRICE": "3547.85"
                    },
                    {
                    "REF_DATE": "06/01/2021",
                    "INSTRUMENT_ID": ".STOXX50E",
                    "SECURITY_DESCRIPTION": "ESTX 50 PR INDEX",
                    "TIME": "09.30.10",
                    "PRICE": "3611.08"
                    },
                    {
                    "REF_DATE": "07/01/2021",
                    "INSTRUMENT_ID": ".STOXX50E",
                    "SECURITY_DESCRIPTION": "ESTX 50 PR INDEX",
                    "TIME": "13.45.00",
                    "PRICE": "3622.42"
                    },
                    {
                    "REF_DATE": "08/01/2021",
                    "INSTRUMENT_ID": ".STOXX50E",
                    "SECURITY_DESCRIPTION": "ESTX 50 PR INDEX",
                    "TIME": "16.00.00",
                    "PRICE": "3645.05"
                    }
                              ]
                              """;
    ;

    @Autowired
    private Gson gsonHistorical;

    private List<Index> indexsHistorical;

    @BeforeEach
    void initHistorical() {
        indexsHistorical = Arrays.stream(gsonHistorical.fromJson(jsonStringHistorical, IndexDTO[].class)).sequential().map(IndexDTO::toEntity).collect(Collectors.toList());
    }

    @Test
    void testIdHistorical() {
        Assertions.assertNull(indexsHistorical.get(0).getId());
        Assertions.assertNull(indexsHistorical.get(1).getId());
        Assertions.assertNull(indexsHistorical.get(2).getId());
        Assertions.assertNull(indexsHistorical.get(3).getId());
        Assertions.assertNull(indexsHistorical.get(4).getId());
    }

    @Test
    void testRefDateHistorical() {
        Assertions.assertEquals(LocalDate.of(2021, 1, 4), indexsHistorical.get(0).getRefDate());
        Assertions.assertEquals(LocalDate.of(2021, 1, 5), indexsHistorical.get(1).getRefDate());
        Assertions.assertEquals(LocalDate.of(2021, 1, 6), indexsHistorical.get(2).getRefDate());
        Assertions.assertEquals(LocalDate.of(2021, 1, 7), indexsHistorical.get(3).getRefDate());
        Assertions.assertEquals(LocalDate.of(2021, 1, 8), indexsHistorical.get(4).getRefDate());
    }

    @Test
    void testInstrumentIdHistorical() {
        Assertions.assertEquals(".STOXX50E", indexsHistorical.get(0).getInstrumentId());
        Assertions.assertEquals(".STOXX50E", indexsHistorical.get(1).getInstrumentId());
        Assertions.assertEquals(".STOXX50E", indexsHistorical.get(2).getInstrumentId());
        Assertions.assertEquals(".STOXX50E", indexsHistorical.get(3).getInstrumentId());
        Assertions.assertEquals(".STOXX50E", indexsHistorical.get(4).getInstrumentId());
    }

    @Test
    void testSecurityDescriptionHistorical() {
        Assertions.assertEquals("ESTX 50 PR INDEX", indexsHistorical.get(0).getSecurityDescription());
        Assertions.assertEquals("ESTX 50 PR INDEX", indexsHistorical.get(1).getSecurityDescription());
        Assertions.assertEquals("ESTX 50 PR INDEX", indexsHistorical.get(2).getSecurityDescription());
        Assertions.assertEquals("ESTX 50 PR INDEX", indexsHistorical.get(3).getSecurityDescription());
        Assertions.assertEquals("ESTX 50 PR INDEX", indexsHistorical.get(4).getSecurityDescription());
    }

    @Test
    void testTimeHistorical() {
        Assertions.assertEquals(LocalTime.of(17, 0, 0), indexsHistorical.get(0).getTime());
        Assertions.assertEquals(LocalTime.of(12, 5, 3), indexsHistorical.get(1).getTime());
        Assertions.assertEquals(LocalTime.of(9, 30, 10), indexsHistorical.get(2).getTime());
        Assertions.assertEquals(LocalTime.of(13, 45, 0), indexsHistorical.get(3).getTime());
        Assertions.assertEquals(LocalTime.of(16, 0, 0), indexsHistorical.get(4).getTime());
    }

    @Test
    void testPriceHistorical() {
        Assertions.assertEquals(3564.39, indexsHistorical.get(0).getPrice());
        Assertions.assertEquals(3547.85, indexsHistorical.get(1).getPrice());
        Assertions.assertEquals(3611.08, indexsHistorical.get(2).getPrice());
        Assertions.assertEquals(3622.42, indexsHistorical.get(3).getPrice());
        Assertions.assertEquals(3645.05, indexsHistorical.get(4).getPrice());
    }

    @Autowired
    private Gson gson;

    private List<Index> indexs;

    @BeforeEach
    void init() {
        indexs = Arrays.stream(gson.fromJson(jsonString, IndexDTO[].class)).sequential().map(IndexDTO::toEntity).collect(Collectors.toList());
    }

    @Test
    void testId() {
        Assertions.assertNull(indexs.get(0).getId());
        Assertions.assertNull(indexs.get(1).getId());
        Assertions.assertNull(indexs.get(2).getId());
        Assertions.assertNull(indexs.get(3).getId());
    }

    @Test
    void testRefDate() {
        Assertions.assertEquals(LocalDate.of(2022, 10, 26), indexs.get(0).getRefDate());
        Assertions.assertEquals(LocalDate.of(2022, 10, 26), indexs.get(1).getRefDate());
        Assertions.assertEquals(LocalDate.of(2022, 10, 26), indexs.get(2).getRefDate());
        Assertions.assertEquals(LocalDate.of(2022, 10, 26), indexs.get(3).getRefDate());
    }

    @Test
    void testInstrumentId() {
        Assertions.assertNull(indexs.get(0).getInstrumentId());
        Assertions.assertNull(indexs.get(1).getInstrumentId());
        Assertions.assertNull(indexs.get(2).getInstrumentId());
        Assertions.assertNull(indexs.get(3).getInstrumentId());
    }

    @Test
    void testSecurityDescription() {
        Assertions.assertNull(indexs.get(0).getSecurityDescription());
        Assertions.assertNull(indexs.get(1).getSecurityDescription());
        Assertions.assertNull(indexs.get(2).getSecurityDescription());
        Assertions.assertNull(indexs.get(3).getSecurityDescription());
    }

    @Test
    void testTime() {
        Assertions.assertEquals(LocalTime.of(11, 56, 30), indexs.get(0).getTime());
        Assertions.assertEquals(LocalTime.of(11, 56, 15), indexs.get(1).getTime());
        Assertions.assertEquals(LocalTime.of(11, 56, 0), indexs.get(2).getTime());
        Assertions.assertEquals(LocalTime.of(11, 55, 45), indexs.get(3).getTime());
    }

    @Test
    void testPrice() {
        Assertions.assertEquals(3577.99, indexs.get(0).getPrice());
        Assertions.assertEquals(3577.05, indexs.get(1).getPrice());
        Assertions.assertEquals(3576.47, indexs.get(2).getPrice());
        Assertions.assertEquals(3575.78, indexs.get(3).getPrice());
    }
}
