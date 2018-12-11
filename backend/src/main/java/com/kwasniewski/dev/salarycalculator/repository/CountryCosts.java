package com.kwasniewski.dev.salarycalculator.repository;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity()
@Table(name = "TB_COUNTRY_COSTS")
@NoArgsConstructor
public class CountryCosts {

    public CountryCosts(String country, String currency, Double tax, Long fixedCosts) {
        this.country = country;
        this.currency = currency;
        this.tax = tax;
        this.fixedCosts = fixedCosts;
    }

    @Id
    @GeneratedValue()
    private Long id;
    private String country;
    private String currency;
    private Double tax;
    private Long fixedCosts;

}
