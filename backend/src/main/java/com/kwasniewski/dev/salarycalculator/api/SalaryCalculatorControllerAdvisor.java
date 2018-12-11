package com.kwasniewski.dev.salarycalculator.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
@Slf4j
public class SalaryCalculatorControllerAdvisor {

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity handleRestClientException() {
        log.warn("There was a problem with calling external service");
        return new ResponseEntity<>(new HttpHeaders(),HttpStatus.SERVICE_UNAVAILABLE);
    }

}
