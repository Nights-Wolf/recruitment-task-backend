package com.recruitment.recruitment_task.api;

import com.recruitment.recruitment_task.models.CurrencyRequest;
import com.recruitment.recruitment_task.models.CurrencyResponse;
import com.recruitment.recruitment_task.servicesInterfaces.CurrencyServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class CurrencyRestController {

    @Autowired
    private final CurrencyServiceInterface currencyService;

    @PostMapping("/currencies/get-current-currency-value-command")
    private ResponseEntity<Object> getCurrencyValue(@RequestBody CurrencyRequest currencyRequest) {
        return currencyService.getCurrencyValue(currencyRequest);
    }
}
