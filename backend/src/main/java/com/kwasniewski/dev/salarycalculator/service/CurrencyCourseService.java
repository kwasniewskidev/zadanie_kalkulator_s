package com.kwasniewski.dev.salarycalculator.service;

import java.math.BigDecimal;

public interface CurrencyCourseService {

    BigDecimal getExchangeRateForCurrency(String currency);

}
