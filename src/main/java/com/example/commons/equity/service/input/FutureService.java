package com.example.commons.equity.service.input;

import com.example.commons.equity.model.entity.input.Future;
import com.example.commons.equity.repositories.input.FutureRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FutureService {

    private final FutureRepository futureRepository;

    @Autowired
    public FutureService(FutureRepository futureRepository) {
        this.futureRepository = futureRepository;
    }

    public List<Future> getIntradayFutureByRicInput(int timeframe, String ric) {
        if (timeframe <= 0 && StringUtils.isBlank(ric)) {
            throw new IllegalArgumentException("Cannot found future intraday with timeframe=" + timeframe + " and ric=" + ric);
        } else {
            return futureRepository.getIntradayFutureByRicInput(timeframe, ric);
        }
    }

    public List<Future> getHistoryFutureByRicInput(int timeframe, String ric) {
        if (timeframe <= 0 && StringUtils.isBlank(ric)) {
            throw new IllegalArgumentException("Cannot found future intraday with timeframe=" + timeframe + " and ric=" + ric);
        } else {
            return futureRepository.getHistoryFutureByRicInput(timeframe, ric);
        }
    }

    public List<Future> findAll() {
        return futureRepository.findAll();
    }

    public Future save(Future future) {
        return futureRepository.save(future);
    }

}
