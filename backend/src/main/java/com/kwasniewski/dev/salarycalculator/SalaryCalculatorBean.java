package com.kwasniewski.dev.salarycalculator;

import java.math.BigDecimal;

public interface SalaryCalculatorBean {

    BigDecimal calculateMonthtlySalary(String country, BigDecimal dailySalary);

}
