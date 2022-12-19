package com.recruitment.recruitment_task.api;

import com.recruitment.recruitment_task.models.CurrencyRequest;
import com.recruitment.recruitment_task.servicesInterfaces.CurrencyServiceInterface;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;

@WebMvcTest(CurrencyRestController.class)
class CurrencyRestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CurrencyServiceInterface currencyServiceInterface;

    @Test
    void shouldReturnCurrencyResponse() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/currencies/get-current-currency-value-command")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"currency\": \"EUR\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(currencyServiceInterface).getCurrencyValue(any(CurrencyRequest.class));
    }

    @Test
    void shouldGive400IfCurrencyIsNotString() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/currencies/get-current-currency-value-command")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"currency\": EUR}"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}