package com.kwasniewski.dev.salarycalculator.api;

import com.kwasniewski.dev.salarycalculator.repository.CountryCostsRepository;
import com.kwasniewski.dev.salarycalculator.SalaryCalculatorBean;
import com.kwasniewski.dev.salarycalculator.api.model.GetCountriesResponse;
import com.kwasniewski.dev.salarycalculator.api.model.GetSalaryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController()
@RequestMapping(value = "/api/v1/calculator")
public class SalaryCalculatorRestController {

    @GetMapping("/salary")
    public GetSalaryResponse getSalary(@RequestParam String country, @RequestParam BigDecimal dailySalary) {
        log.info("> getSalary country={} dailySalary={dailySalary}", country, dailySalary);
        BigDecimal monthlySalary = calculatorBean.calculateMonthtlySalary(country, dailySalary);
        log.info("< getSalary monthlySalary={}", monthlySalary);
        return new GetSalaryResponse(monthlySalary);
    }

    @GetMapping("/countries")
    public GetCountriesResponse getCountries() {
        log.info("> getCountries");
        List countries = countryCostsRepository.getAllCountriesValue();
        log.info("< getCountries countries={}", countries);
        return new GetCountriesResponse(countries);
    }

    private final CountryCostsRepository countryCostsRepository;

    private final SalaryCalculatorBean calculatorBean;

}
