package com.example.commons.equity.repositories.input;


import com.example.commons.equity.model.entity.input.DailyFuture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DailyFutureRepository extends JpaRepository<DailyFuture, Long> {

    List<DailyFuture> findDailyFutureByIsin(String isin);

}
