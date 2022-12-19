package com.recruitment.recruitment_task.servicesImpl;

import com.recruitment.recruitment_task.models.CurrencyRequest;
import com.recruitment.recruitment_task.models.CurrencyResponse;
import com.recruitment.recruitment_task.servicesInterfaces.CurrencyServiceInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CurrencyServiceImplTest {

    @Autowired
    private CurrencyServiceInterface currencyServiceInterface;

    @Test
    void shouldReturnCurrencyResponseBody() {
        String currency = "EUR";

        CurrencyRequest currencyRequest = new CurrencyRequest();
        currencyRequest.setCurrency(currency);

        String url = "http://api.nbp.pl/api/exchangerates/rates/a/" + currencyRequest.getCurrency() + "?format=json";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<CurrencyResponse> currencyResponseResponseEntity = restTemplate.getForEntity(url, CurrencyResponse.class);
        CurrencyResponse currencyResponseExpected = currencyResponseResponseEntity.getBody();

        ResponseEntity<Object> responseEntity = currencyServiceInterface.getCurrencyValue(currencyRequest);
        CurrencyResponse currencyResponseActual = (CurrencyResponse) responseEntity.getBody();

        assertEquals(currencyResponseExpected.getClass(), currencyResponseActual.getClass());
    }

    @Test
    void shouldReturn404() {
        String currency = "ER";

        CurrencyRequest currencyRequest = new CurrencyRequest();
        currencyRequest.setCurrency(currency);

        ResponseEntity<Object> currencyResponseResponseEntity = currencyServiceInterface.getCurrencyValue(currencyRequest);

        HttpStatus status = HttpStatus.NOT_FOUND;

        assertEquals(status, currencyResponseResponseEntity.getStatusCode());
    }
}