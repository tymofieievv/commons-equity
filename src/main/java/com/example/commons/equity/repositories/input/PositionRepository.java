package com.example.commons.equity.repositories.input;

import com.example.commons.equity.model.entity.input.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

interface PositionRepository extends JpaRepository<Position, Long> {

    List<Position> findByPositionId(String positionId);
}
