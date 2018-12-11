package com.kwasniewski.dev.salarycalculator;

import com.kwasniewski.dev.salarycalculator.repository.CountryCosts;
import com.kwasniewski.dev.salarycalculator.repository.CountryCostsRepository;
import com.kwasniewski.dev.salarycalculator.service.CurrencyCourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;


@RunWith(MockitoJUnitRunner.class)
public class SalaryCalculatorBeanImplTest {

    @Test
    public void shouldReturnCorrectValueTest() {
        //given
        Mockito.when(countryCostsRepository.findByCountry(any())).thenReturn(new CountryCosts("DE", "EUR", new Double("0.20"), 800L));
        Mockito.when(currencyCourseService.getExchangeRateForCurrency(any())).thenReturn(new BigDecimal("4.23"));
        BigDecimal dailySalary = new BigDecimal("80");
        String currency = "EUR";

        //when
        BigDecimal monthlySalary = bean.calculateMonthtlySalary(currency, dailySalary);
        BigDecimal expectedResult = new BigDecimal("3248.64");

        //then
        assertNotNull(monthlySalary);
        assertEquals(expectedResult, monthlySalary);
    }

    @Test
    public void shouldReturnZeroWhenCurrencyIsInvalidTest() {
        //given
        Mockito.when(countryCostsRepository.findByCountry(any())).thenReturn(null);
        BigDecimal dailySalary = new BigDecimal("80");
        String currency = "EUR";

        //when
        BigDecimal monthlySalary = bean.calculateMonthtlySalary(currency, dailySalary);

        //then
        BigDecimal expectedResult = BigDecimal.ZERO;
        assertNotNull(monthlySalary);
        assertEquals(expectedResult, monthlySalary);
    }

    @InjectMocks
    private SalaryCalculatorBeanImpl bean;

    @Mock
    private CurrencyCourseService currencyCourseService;

    @Mock
    private CountryCostsRepository countryCostsRepository;

}