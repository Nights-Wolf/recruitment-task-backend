package com.recruitment.recruitment_task.api;

import com.recruitment.recruitment_task.models.DataNumbersRequest;
import com.recruitment.recruitment_task.servicesInterfaces.SortNumbersServiceInterface;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SortNumbersRestController.class)
class SortNumbersRestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SortNumbersServiceInterface sortNumbersService;

    @Test
    void sortShouldSortNumbersAsc() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/numbers/sort-command")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"numbers\": [1, 3, 2, 5, 2], \"order\": \"ASC\"}"))
                .andExpect(status().isOk());

        Mockito.verify(sortNumbersService).sortNumbers(any(DataNumbersRequest.class));
    }

    @Test
    void sortShouldSortNumbersDsc() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/numbers/sort-command")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"numbers\": [1, 3, 2, 5, 2], \"order\": \"DSC\"}"))
                .andExpect(status().isOk());

        Mockito.verify(sortNumbersService).sortNumbers(any(DataNumbersRequest.class));
    }

    @Test
    void shouldReturn400IfOrderIsIncorrect() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/numbers/sort-command")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"numbers\": [1, 3, 2, 5, 2], \"order\": \"DC\"}"))
                .andExpect(status().isBadRequest());

        mockMvc.perform(MockMvcRequestBuilders.post("/api/numbers/sort-command")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"numbers\": [1, 3, 2, 5, h], \"order\": \"DSC\"}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturn400IfNumbersAreIncorrect() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/numbers/sort-command")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"numbers\": [1, 3, 2, 5, h], \"order\": \"DSC\"}"))
                .andExpect(status().isBadRequest());
    }
}