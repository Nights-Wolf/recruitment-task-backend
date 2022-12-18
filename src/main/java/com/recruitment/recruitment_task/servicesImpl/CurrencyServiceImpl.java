package com.recruitment.recruitment_task.servicesImpl;

import com.recruitment.recruitment_task.models.CurrencyResponse;
import com.recruitment.recruitment_task.models.CurrencyRequest;
import com.recruitment.recruitment_task.servicesInterfaces.CurrencyServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyServiceImpl implements CurrencyServiceInterface {

    @Override
    public ResponseEntity<Object> getCurrencyValue(CurrencyRequest currencyRequest) {
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/" + currencyRequest.getCurrency() + "?format=json";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CurrencyResponse> currencyAPIResponse;

        try {
            currencyAPIResponse = restTemplate.getForEntity(url, CurrencyResponse.class);
        } catch (HttpClientErrorException e) {
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("Message", e.getMessage());
            errorMap.put("Status", e.getStatusCode().toString());

            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
        }

        CurrencyResponse currencyResponse = currencyAPIResponse.getBody();

        return new ResponseEntity<>(currencyResponse, HttpStatus.OK);
    }
}
