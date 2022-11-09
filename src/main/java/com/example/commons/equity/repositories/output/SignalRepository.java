package com.example.commons.equity.repositories.output;

import com.example.commons.equity.model.entity.output.Signal;
import org.springframework.data.jpa.repository.JpaRepository;

interface SignalRepository extends JpaRepository<Signal, Long> {


}
