package com.kwasniewski.dev.salarycalculator.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class GetSalaryResponse {

    BigDecimal salary;

}
