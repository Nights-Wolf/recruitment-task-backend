package com.recruitment.recruitment_task.servicesInterfaces;

import com.recruitment.recruitment_task.models.CurrencyRequest;
import com.recruitment.recruitment_task.models.CurrencyResponse;
import org.springframework.http.ResponseEntity;

public interface CurrencyServiceInterface {

    ResponseEntity<Object> getCurrencyValue(CurrencyRequest currencyRequest);
}
