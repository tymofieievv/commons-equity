package com.example.commons.equity.service.input;

import com.example.commons.equity.model.entity.input.Index;
import com.example.commons.equity.repositories.input.IndexRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexService {


    private final IndexRepository indexRepository;

    @Autowired
    public IndexService(IndexRepository indexRepository) {
        this.indexRepository = indexRepository;
    }

    public List<Index> getIntradayIndexByIsinInput(int timeframe, String instrumentId) {
        if (timeframe <= 0 && StringUtils.isBlank(instrumentId)) {
            throw new IllegalArgumentException("Cannot found index intraday with timeframe=" + timeframe + " and instrumentId=" + instrumentId);
        } else {
            return indexRepository.getIntradayIndexByInstrumentId(timeframe, instrumentId);
        }
    }

    public List<Index> getHistoryIndexByIsinInput(int timeframe, String instrumentId) {
        if (timeframe <= 0 && StringUtils.isBlank(instrumentId)) {
            throw new IllegalArgumentException("Cannot found index intraday with timeframe=" + timeframe + " and instrumentId=" + instrumentId);
        } else {
            return indexRepository.getHistoryIndexByInstrumentId(timeframe, instrumentId);
        }
    }

    public List<Index> findAll() {
        return indexRepository.findAll();
    }

    public Index save(Index index) {
        return indexRepository.save(index);
    }

}
