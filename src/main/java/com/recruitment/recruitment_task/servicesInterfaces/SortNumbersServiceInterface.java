package com.recruitment.recruitment_task.servicesInterfaces;

import com.recruitment.recruitment_task.models.DataNumbersRequest;
import org.springframework.http.ResponseEntity;

public interface SortNumbersServiceInterface {

    ResponseEntity<Object> sortNumbers(DataNumbersRequest dataNumbersRequest);
}
