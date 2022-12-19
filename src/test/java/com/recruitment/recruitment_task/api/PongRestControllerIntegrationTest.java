package com.recruitment.recruitment_task.api;

import com.recruitment.recruitment_task.servicesInterfaces.PongServiceInterface;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PongRestController.class)
class PongRestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PongServiceInterface pongService;

    @Test
    void shouldReturnPong() throws Exception {
        Mockito.when(pongService.getPong()).thenReturn("pong");

        mockMvc.perform(MockMvcRequestBuilders.get("/api/status/ping"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("pong")));

        Mockito.verify(pongService).getPong();
    }

}