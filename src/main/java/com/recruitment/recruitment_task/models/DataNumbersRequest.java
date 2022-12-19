package com.recruitment.recruitment_task.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
public class DataNumbersRequest {

    private List<Integer> numbers;
    private Order order;
}
