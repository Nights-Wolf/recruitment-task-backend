package com.recruitment.recruitment_task.servicesImpl;

import com.recruitment.recruitment_task.servicesInterfaces.PongServiceInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PongServiceImplUnitTest {

    @Autowired
    private PongServiceInterface pongServiceInterface;
    @Test
    void shouldReturnPong() {
        String targetResponse = "pong";
        String response = pongServiceInterface.getPong();
        assertEquals(response, targetResponse);
    }
}