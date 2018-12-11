package com.kwasniewski.dev.salarycalculator.service;

import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
public class CurrencyRateResponse {

    public BigDecimal getBid() {
        return rates.isEmpty() ? BigDecimal.ZERO :
                rates.get(0).getAsk();
    }

    private List<CurrencyRate> rates;

}

