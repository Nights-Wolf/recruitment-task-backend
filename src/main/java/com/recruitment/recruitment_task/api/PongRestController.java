package com.recruitment.recruitment_task.api;

import com.recruitment.recruitment_task.servicesInterfaces.PongServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class PongRestController {

    @Autowired
    private final PongServiceInterface pongService;

    @GetMapping("/status/ping")
    private String getPong() {
        return pongService.getPong();
    }
}
