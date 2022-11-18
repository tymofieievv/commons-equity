package com.example.commons.equity.repositories.input;

import com.example.commons.equity.model.entity.input.PersonalDataFuture;
import com.example.commons.equity.model.entity.input.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PersonalDataFutureRepository extends JpaRepository<PersonalDataFuture, Long> {

    Optional<PersonalDataFuture> findPersonalDataFutureByIsin(String isin);

}
