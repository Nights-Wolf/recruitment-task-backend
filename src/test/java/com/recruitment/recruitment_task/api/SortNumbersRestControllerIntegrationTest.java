package com.recruitment.recruitment_task.api;

import com.recruitment.recruitment_task.models.DataNumbersRequest;
import com.recruitment.recruitment_task.models.Order;
import com.recruitment.recruitment_task.servicesImpl.SortNumbersServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SortNumbersRestController.class)
class SortNumbersRestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SortNumbersServiceImpl sortNumbersService;

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
}