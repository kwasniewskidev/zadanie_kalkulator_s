package com.kwasniewski.dev.salarycalculator.service;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CurrencyRate {

    private BigDecimal ask;
    private BigDecimal bid;
    private Date effectiveDate;

}
