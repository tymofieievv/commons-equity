package com.example.commons.equity.service.input;

import com.example.commons.equity.model.entity.input.PersonalDataFuture;
import com.example.commons.equity.repositories.input.PersonalDataFutureRepository;
import org.apache.commons.lang3.StringUtils;
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

    public PersonalDataFuture findPersonalDataFutureByIsin(String isin) throws IllegalArgumentException {
        if (StringUtils.isBlank(isin)) {
            throw new IllegalArgumentException("Cannot found personal data, isin is blank.");
        } else {
            Optional<PersonalDataFuture> personalDataFutureByIsin = personalDataFutureRepository.findPersonalDataFutureByIsin(isin);
            if (!personalDataFutureByIsin.isPresent()) {
                throw new IllegalArgumentException("No personal data future was found with isin=" + isin);
            } else {
                return personalDataFutureByIsin.get();
            }
        }
    }
}
