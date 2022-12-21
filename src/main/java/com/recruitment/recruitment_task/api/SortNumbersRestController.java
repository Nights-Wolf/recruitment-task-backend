package com.recruitment.recruitment_task.api;

import com.recruitment.recruitment_task.models.DataNumbersRequest;
import com.recruitment.recruitment_task.servicesInterfaces.SortNumbersServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SortNumbersRestController {

    private final SortNumbersServiceInterface sortNumbersService;

    @PostMapping("/numbers/sort-command")
    public ResponseEntity<Object> sortNumbers(@RequestBody DataNumbersRequest dataNumbersRequest) {
            return sortNumbersService.sortNumbers(dataNumbersRequest);
    }
}
