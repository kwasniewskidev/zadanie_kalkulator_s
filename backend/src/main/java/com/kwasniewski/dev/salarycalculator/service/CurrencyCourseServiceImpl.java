package com.kwasniewski.dev.salarycalculator.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;

@Service
@Slf4j
public class CurrencyCourseServiceImpl implements CurrencyCourseService {

    @Override
    public BigDecimal getExchangeRateForCurrency(String currency) {
        return PLN_CURRENCY.equals(currency) ? BigDecimal.ONE : callService(currency);
    }

    private BigDecimal callService(String currency) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        URI uri = prepareURI(currency);
        HttpEntity<CurrencyRateResponse> response = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity(headers), CurrencyRateResponse.class);
        return response.getBody().getBid();
    }

    private URI prepareURI(String currency) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(uriTemplate);
        return builder.buildAndExpand(TABLE, currency).toUri();
    }

    /**
     * current exchange rate table
     */
    private static final String TABLE = "C";

    private static final String PLN_CURRENCY = "PLN";

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${current.exchange.rate.uri}")
    private String uriTemplate;

}
