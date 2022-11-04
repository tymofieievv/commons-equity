package com.example.commons.entity.input;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="FUTURE")
public class HistoricalFuture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @NotNull
    @Column(name = "REF_DATE")
    private LocalDate refDate;
    @NotNull
    @Column(name = "ISIN")
    private String isin;
    @NotNull
    @Column(name = "TICKER")
    private String ticker;
    @NotNull
    @Column(name = "TIME")
    private LocalTime time;
    @NotNull
    @Column(name = "UNDERLYING_ID")
    private String underlyingId;
    @Column(name = "UNDERLYING_DESCRIPTION")
    private String underlyingDescription;
    @NotNull
    @Column(name = "PRICE_CLOSE")
    private Double priceClose;
    @Column(name = "PRICE_OPEN")
    private Double priceOpen;
    @Column(name = "PRICE_LOW")
    private Double priceLow;
    @Column(name = "PRICE_HIGH")
    private Double priceHigh;
    @Column(name = "VOLUME")
    private Integer volume;
}
