package com.example.commons.equity.repositories.input;

import com.example.commons.equity.model.entity.input.Future;
import com.example.commons.equity.model.entity.input.Index;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FutureRepository extends JpaRepository<Future, Long> {

    @Query(nativeQuery = true, value = "SELECT * from getFutureIntraday(:timeframe,:isinInput)")
    List<Future> getIntradayFutureByIsinInput(@Param("timeframe") int timeframe, @Param("isinInput") String isinInput);
    @Query(nativeQuery = true, value = "SELECT * from getFutureHistory(:timeframe,:isinInput)")
    List<Future> getHistoryFutureByIsinInput(@Param("timeframe") int timeframe, @Param("isinInput") String isinInput);

}
