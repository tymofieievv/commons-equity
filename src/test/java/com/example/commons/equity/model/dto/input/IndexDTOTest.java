package com.example.commons.equity.model.dto.input;

import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootTest
class IndexDTOTest {

    private final String historyIndexString =
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
                    "TIME": "09.30.30",
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
    private final String realtimeIndexString =
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


    @Autowired
    private Gson gson;
    private IndexDTO[] realtimeIndexDTOs;
    private IndexDTO[] historyIndexDTOs;

    @BeforeEach
    void init() {
        realtimeIndexDTOs = gson.fromJson(realtimeIndexString, IndexDTO[].class);
        historyIndexDTOs = gson.fromJson(historyIndexString, IndexDTO[].class);
    }

    @Test
    void testRefDate() {
        Assertions.assertEquals(LocalDate.of(2022, 10, 26), realtimeIndexDTOs[0].refDate());
        Assertions.assertEquals(LocalDate.of(2022, 10, 26), realtimeIndexDTOs[1].refDate());
        Assertions.assertEquals(LocalDate.of(2022, 10, 26), realtimeIndexDTOs[2].refDate());
        Assertions.assertEquals(LocalDate.of(2022, 10, 26), realtimeIndexDTOs[3].refDate());

        Assertions.assertEquals(LocalDate.of(2021, 1, 4), historyIndexDTOs[0].refDate());
        Assertions.assertEquals(LocalDate.of(2021, 1, 5), historyIndexDTOs[1].refDate());
        Assertions.assertEquals(LocalDate.of(2021, 1, 6), historyIndexDTOs[2].refDate());
        Assertions.assertEquals(LocalDate.of(2021, 1, 7), historyIndexDTOs[3].refDate());
        Assertions.assertEquals(LocalDate.of(2021, 1, 8), historyIndexDTOs[4].refDate());
    }


    @Test
    void testTime() {
        Assertions.assertEquals(LocalTime.of(11, 56, 30), realtimeIndexDTOs[0].time());
        Assertions.assertEquals(LocalTime.of(11, 56, 15), realtimeIndexDTOs[1].time());
        Assertions.assertEquals(LocalTime.of(11, 56, 0), realtimeIndexDTOs[2].time());
        Assertions.assertEquals(LocalTime.of(11, 55, 45), realtimeIndexDTOs[3].time());

        Assertions.assertEquals(LocalTime.of(17, 0, 0), historyIndexDTOs[0].time());
        Assertions.assertEquals(LocalTime.of(12, 5, 3), historyIndexDTOs[1].time());
        Assertions.assertEquals(LocalTime.of(9, 30, 30), historyIndexDTOs[2].time());
        Assertions.assertEquals(LocalTime.of(13, 45, 0), historyIndexDTOs[3].time());
        Assertions.assertEquals(LocalTime.of(16, 0, 0), historyIndexDTOs[4].time());
    }


    @Test
    void testPrice() {
        Assertions.assertEquals(3577.99, realtimeIndexDTOs[0].price());
        Assertions.assertEquals(3577.05, realtimeIndexDTOs[1].price());
        Assertions.assertEquals(3576.47, realtimeIndexDTOs[2].price());
        Assertions.assertEquals(3575.78, realtimeIndexDTOs[3].price());

        Assertions.assertEquals(3564.39, historyIndexDTOs[0].price());
        Assertions.assertEquals(3547.85, historyIndexDTOs[1].price());
        Assertions.assertEquals(3611.08, historyIndexDTOs[2].price());
        Assertions.assertEquals(3622.42, historyIndexDTOs[3].price());
        Assertions.assertEquals(3645.05, historyIndexDTOs[4].price());
    }


    @Test
    void testInstrumentId() {
        Assertions.assertNull(realtimeIndexDTOs[0].instrumentId());
        Assertions.assertNull(realtimeIndexDTOs[1].instrumentId());
        Assertions.assertNull(realtimeIndexDTOs[2].instrumentId());
        Assertions.assertNull(realtimeIndexDTOs[3].instrumentId());

        Assertions.assertEquals(".STOXX50E", historyIndexDTOs[0].instrumentId());
        Assertions.assertEquals(".STOXX50E", historyIndexDTOs[1].instrumentId());
        Assertions.assertEquals(".STOXX50E", historyIndexDTOs[2].instrumentId());
        Assertions.assertEquals(".STOXX50E", historyIndexDTOs[3].instrumentId());
        Assertions.assertEquals(".STOXX50E", historyIndexDTOs[4].instrumentId());
    }


    @Test
    void testSecurityDescription() {
        Assertions.assertNull(realtimeIndexDTOs[0].securityDescription());
        Assertions.assertNull(realtimeIndexDTOs[1].securityDescription());
        Assertions.assertNull(realtimeIndexDTOs[2].securityDescription());
        Assertions.assertNull(realtimeIndexDTOs[3].securityDescription());

        Assertions.assertEquals("ESTX 50 PR INDEX", historyIndexDTOs[0].securityDescription());
        Assertions.assertEquals("ESTX 50 PR INDEX", historyIndexDTOs[1].securityDescription());
        Assertions.assertEquals("ESTX 50 PR INDEX", historyIndexDTOs[2].securityDescription());
        Assertions.assertEquals("ESTX 50 PR INDEX", historyIndexDTOs[3].securityDescription());
        Assertions.assertEquals("ESTX 50 PR INDEX", historyIndexDTOs[4].securityDescription());
    }

}