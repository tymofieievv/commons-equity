package com.example.commons.equity.repositories.input;

import com.example.commons.equity.model.entity.input.Position;
import org.springframework.data.jpa.repository.JpaRepository;

interface PositionRepository extends JpaRepository<Position, Long> {

}
