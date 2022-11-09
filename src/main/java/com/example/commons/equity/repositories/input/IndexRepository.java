package com.example.commons.equity.repositories.input;

import com.example.commons.equity.model.entity.input.Index;
import org.springframework.data.jpa.repository.JpaRepository;


interface IndexRepository extends JpaRepository<Index, Long> {

}
