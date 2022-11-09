package com.example.commons.equity.config;

import com.example.commons.equity.model.dto.input.*;
import com.example.commons.equity.model.dto.output.AlgorithmAndMetricDTO;
import com.example.commons.equity.model.dto.output.OrderDTO;
import com.example.commons.equity.model.dto.output.SignalDTO;
import com.example.commons.equity.model.dto.output.StrategyPerformanceDTO;
import com.example.commons.equity.persistence.deserializers.*;
import com.google.gson.GsonBuilder;
import org.springframework.boot.autoconfigure.gson.GsonBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Configuration
public class GsonConfiguration {

    @Bean
    public GsonBuilderCustomizer typeAdapterRegistration() {
        return builder -> {
            //TODO registerSerializers
            registerDeserializers(builder);
        };
    }

    private static void registerDeserializers(GsonBuilder builder) {
        builder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());
        builder.registerTypeAdapter(LocalTime.class, new LocalTimeDeserializer());
        builder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());

        builder.registerTypeAdapter(DailyFutureDTO.class, new DailyFutureDTODeserializer());
        builder.registerTypeAdapter(FutureDTO.class, new FutureDTODeserializer());
        builder.registerTypeAdapter(IndexDTO.class, new IndexDTODeserializer());
        builder.registerTypeAdapter(PersonalDataFutureDTO.class, new PersonalDataFutureDTODeserializer());
        builder.registerTypeAdapter(PositionDTO.class, new PositionDTODeserializer());

        builder.registerTypeAdapter(AlgorithmAndMetricDTO.class, new AlgorithmAndMetricDTODeserializer());
        builder.registerTypeAdapter(OrderDTO.class, new OrderDTODeserializer());
        builder.registerTypeAdapter(SignalDTO.class, new SignalDTODeserializer());
        builder.registerTypeAdapter(StrategyPerformanceDTO.class, new StrategyPerformanceDTODeserializer());
    }
}
