package com.example.commons.equity.service.input;

import com.example.commons.equity.model.entity.input.DailyFuture;
import com.example.commons.equity.repositories.input.DailyFutureRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyFutureService {

    private final DailyFutureRepository dailyFutureRepository;

    @Autowired
    public DailyFutureService(DailyFutureRepository dailyFutureRepository) {
        this.dailyFutureRepository = dailyFutureRepository;
    }

    public List<DailyFuture> findDailyFutureByIsin(String isin) {
        if (StringUtils.isBlank(isin)) {
            throw new IllegalArgumentException("Cannot found daily future, isin is blank.");
        } else {
            return dailyFutureRepository.findDailyFutureByIsin(isin);
        }
    }

    public List<DailyFuture> findAll() {
        return dailyFutureRepository.findAll();
    }

    public DailyFuture save(DailyFuture dailyFuture) {
        return dailyFutureRepository.save(dailyFuture);
    }
}
