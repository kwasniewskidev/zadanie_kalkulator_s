package com.kwasniewski.dev.salarycalculator;

import com.kwasniewski.dev.salarycalculator.api.model.GetCountriesResponse;
import com.kwasniewski.dev.salarycalculator.api.model.GetSalaryResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SalaryCalculatorApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SalaryCalculatorRestControllerTest {

    @Test
    public void shouldCalculateValueTest() {
        //given

        //when
        ResponseEntity<GetSalaryResponse> response = restTemplate.exchange(
                createURLWithPort("/api/v1/calculator/salary?dailySalary=100&&currency=EUR"),
                HttpMethod.GET, new HttpEntity<>(headers), GetSalaryResponse.class);

        //then
        assertNotNull(response.getBody());
    }

    @Test
    public void shouldReturnAllCurrenciesTest() {
        //given

        //when
        ResponseEntity<GetCountriesResponse> response = restTemplate.exchange(
                createURLWithPort("/api/v1/calculator/countries"),
                HttpMethod.GET, new HttpEntity<>(null, headers), GetCountriesResponse.class);

        //then
        assertNotNull(response);
        assertEquals(3,response.getBody().getCountries().size());
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

    @LocalServerPort
    private int port;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    private HttpHeaders headers = new HttpHeaders();

}
