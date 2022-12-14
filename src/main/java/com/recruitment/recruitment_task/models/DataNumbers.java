package com.recruitment.recruitment_task.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
@RequiredArgsConstructor
public class DataNumbers {

    private ArrayList<Integer> numbers;
    private Order order;
}
