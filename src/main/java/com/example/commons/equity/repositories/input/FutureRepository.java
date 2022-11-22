package com.example.commons.equity.repositories.input;

import com.example.commons.equity.model.entity.input.Future;
import com.example.commons.equity.model.entity.input.Index;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FutureRepository extends JpaRepository<Future, Long> {

    @Query(nativeQuery = true, value = "SELECT * from getFutureIntraday(:timeframe,:ricInput)")
    List<Future> getIntradayFutureByRicInput(@Param("timeframe") int timeframe, @Param("ricInput") String ricInput);
    @Query(nativeQuery = true, value = "SELECT * from getFutureHistory(:timeframe,:ricInput)")
    List<Future> getHistoryFutureByRicInput(@Param("timeframe") int timeframe, @Param("ricInput") String ricInput);

}
