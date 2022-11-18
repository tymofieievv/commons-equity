package com.example.commons.equity.service.input;

import com.example.commons.equity.model.entity.input.Position;
import com.example.commons.equity.repositories.input.PositionRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {

    private final PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public List<Position> findByPositionId(String positionId) {
        if (StringUtils.isBlank(positionId)) {
            throw new IllegalArgumentException("Cannot found personal data, position id is blank.");
        } else {
            return positionRepository.findByPositionId(positionId);
        }
    }

    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    public Position save(Position position) {
        return positionRepository.save(position);
    }
}
