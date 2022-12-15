package com.recruitment.recruitment_task.api;

import com.recruitment.recruitment_task.models.DataNumbers;
import com.recruitment.recruitment_task.servicesImpl.SortNumbersServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class SortNumbersRestController {

    private final SortNumbersServiceImpl sortNumbersService;

    @PostMapping("/numbers/sort-command")
    public ResponseEntity<List<Integer>> sortNumbers(@RequestBody DataNumbers dataNumbers) {
            return sortNumbersService.sortNumbers(dataNumbers);
    }
}
