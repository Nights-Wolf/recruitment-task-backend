package com.recruitment.recruitment_task.api;

import com.recruitment.recruitment_task.servicesImpl.PongServiceImpl;
import org.apache.logging.log4j.ThreadContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PongRestController.class)
class PongRestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PongServiceImpl pongService;

    @Test
    void shouldReturnPong() throws Exception {
        Mockito.when(pongService.getPong()).thenReturn("pong");

        mockMvc.perform(MockMvcRequestBuilders.get("/api/status/ping"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("pong")));
    }

}