package com.example.commons.equity.service.input;

import com.example.commons.equity.model.entity.input.PersonalDataFuture;
import com.example.commons.equity.repositories.input.PersonalDataFutureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonalDataService {

    private final PersonalDataFutureRepository personalDataFutureRepository;

    @Autowired
    public PersonalDataService(PersonalDataFutureRepository personalDataFutureRepository) {
        this.personalDataFutureRepository = personalDataFutureRepository;
    }

    public PersonalDataFuture findPersonalDataFutureByIsin(String isin) {
        Optional<PersonalDataFuture> personalDataFutureByIsin = personalDataFutureRepository.findPersonalDataFutureByIsin(isin);
        return personalDataFutureByIsin.orElseThrow(() -> {
            throw new IllegalArgumentException("No personal data future was found with isin=" + isin);
        });
    }
}
