package com.kwasniewski.dev.salarycalculator;

import com.kwasniewski.dev.salarycalculator.repository.CountryCosts;
import com.kwasniewski.dev.salarycalculator.service.CurrencyCourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@RequiredArgsConstructor
@Component
public class SalaryCalculatorBeanImpl implements SalaryCalculatorBean {

    @Override
    public BigDecimal calculateMonthtlySalary(String country, BigDecimal dailySalary) {
        log.info("> calculateMonthtlySalary country={}, dailySalary={}", country, dailySalary);
        CountryCosts countryCosts = CountryCostsRepository.findByCountry(country);
        if (countryCosts == null) {
            log.warn("Couldn't find costs for country={}", countryCosts);
            return BigDecimal.ZERO;
        }
        BigDecimal exchangeRate = currencyCourseService.getExchangeRateForCurrency(countryCosts.getCurrency());
        BigDecimal monthlySalary = calculate(dailySalary, exchangeRate, countryCosts);
        log.info("< calculateMonthtlySalary monthlySalary={}", monthlySalary);
        return monthlySalary;
    }

    private BigDecimal calculate(BigDecimal dailySalary, BigDecimal course, CountryCosts countryCosts) {
        BigDecimal totalSalary = dailySalary.multiply(DAYS_IN_MONTH);
        BigDecimal salaryFixedCostsPaid = totalSalary.subtract(new BigDecimal(countryCosts.getFixedCosts()));
        BigDecimal salaryTaxPaid = salaryFixedCostsPaid.multiply(new BigDecimal(1 - countryCosts.getTax()));
        BigDecimal salaryInPln = salaryTaxPaid.multiply(course);
        return salaryInPln.setScale(2, BigDecimal.ROUND_HALF_DOWN);
    }

    private static final BigDecimal DAYS_IN_MONTH = new BigDecimal("22");

    private final CurrencyCourseService currencyCourseService;

    private final com.kwasniewski.dev.salarycalculator.repository.CountryCostsRepository CountryCostsRepository;
}
