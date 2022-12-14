package com.recruitment.recruitment_task.servicesImpl;

import com.recruitment.recruitment_task.servicesInterfaces.PongServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PongServiceImpl implements PongServiceInterface {

    @Override
    public String getPong() {
        return "pong";
    }
}
