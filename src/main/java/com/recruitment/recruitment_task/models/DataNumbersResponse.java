package com.recruitment.recruitment_task.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class DataNumbersResponse {

    private List<Integer> numbers;
}
