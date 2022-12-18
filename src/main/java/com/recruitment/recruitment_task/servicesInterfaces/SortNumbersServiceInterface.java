package com.recruitment.recruitment_task.servicesInterfaces;

import com.recruitment.recruitment_task.models.DataNumbers;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SortNumbersServiceInterface {

    ResponseEntity<Object> sortNumbers(DataNumbers dataNumbers);
}
