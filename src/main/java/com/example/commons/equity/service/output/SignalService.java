package com.example.commons.equity.service.output;

import com.example.commons.equity.model.entity.output.Signal;
import com.example.commons.equity.repositories.output.SignalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignalService {

    private final SignalRepository signalRepository;

    @Autowired
    public SignalService(SignalRepository signalRepository) {
        this.signalRepository = signalRepository;
    }

    public List<Signal> findAll() {
        return signalRepository.findAll();
    }

    public Signal save(Signal signal) {
        return signalRepository.save(signal);
    }
}
