package com.kwasniewski.dev.salarycalculator.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryCostsRepository extends CrudRepository<CountryCosts, Long> {

    CountryCosts findByCountry(String country);

    @Query("Select country from CountryCosts")
    List<String> getAllCountriesValue();


}
