package com.example.commons.equity.repositories.input;

import com.example.commons.equity.model.entity.input.Index;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IndexRepository extends JpaRepository<Index, Long> {

    @Query(nativeQuery = true, value = "SELECT * from getIndexIntraday(:timeframe,:instrumentId)")
    List<Index> getIntradayIndexByInstrumentId(@Param("timeframe") int timeframe, @Param("instrumentId") String instrumentId);

    @Query(nativeQuery = true, value = "SELECT * from getIndexHistory(:timeframe,:instrumentId)")
    List<Index> getHistoryIndexByInstrumentId(@Param("timeframe") int timeframe, @Param("instrumentId") String instrumentId);

}
