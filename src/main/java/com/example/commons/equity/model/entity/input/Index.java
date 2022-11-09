package com.example.commons.equity.model.entity.input;

import com.example.commons.equity.model.dto.input.IndexDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity(name = "REF0_KAFKA_INDEX")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Index {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate refDate;
    private String instrumentId;
    private String securityDescription;
    private LocalTime time;
    private Double price;
    private String underlying;

    public IndexDTO toDTO() {
        return new IndexDTO(
                this.getRefDate(),
                this.getTime(),
                this.getPrice(),
                this.getInstrumentId(),
                this.getSecurityDescription()
        );
    }


}
