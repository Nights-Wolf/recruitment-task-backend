package com.recruitment.recruitment_task.servicesImpl;

import com.recruitment.recruitment_task.models.DataNumbers;
import com.recruitment.recruitment_task.models.Order;
import com.recruitment.recruitment_task.servicesInterfaces.SortNumbersServiceInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SortNumbersServiceImplTest {

    @Autowired
    private SortNumbersServiceInterface sortNumbersServiceInterface;

    @Test
    void shouldSortListAscended() {
        List<Integer> testNumbers = new ArrayList<>();
        testNumbers.add(5);
        testNumbers.add(2);
        testNumbers.add(4);
        testNumbers.add(10);

        DataNumbers dataNumbers = new DataNumbers();
        dataNumbers.setNumbers(testNumbers);
        dataNumbers.setOrder(Order.ASC);

        List<Integer> sortedArray = testNumbers
                .stream()
                .sorted()
                .collect(Collectors.toList());

        ResponseEntity<Object> responseEntity =  sortNumbersServiceInterface.sortNumbers(dataNumbers);

        assertEquals(sortedArray, responseEntity.getBody());
    }

    @Test
    void shouldSortListDescended() {
        List<Integer> testNumbers = new ArrayList<>();
        testNumbers.add(5);
        testNumbers.add(2);
        testNumbers.add(4);
        testNumbers.add(10);

        DataNumbers dataNumbers = new DataNumbers();
        dataNumbers.setNumbers(testNumbers);
        dataNumbers.setOrder(Order.DSC);

        List<Integer> sortedDescend = testNumbers
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        ResponseEntity<Object> responseEntity = sortNumbersServiceInterface.sortNumbers(dataNumbers);

        assertEquals(sortedDescend, responseEntity.getBody());
    }

    @Test
    void shouldReturnEmptyList() {
        List<Integer> emptyList = new ArrayList<>();

        DataNumbers dataNumbers = new DataNumbers();
        dataNumbers.setNumbers(emptyList);
        dataNumbers.setOrder(Order.ASC);

        ResponseEntity<Object> responseEntity = sortNumbersServiceInterface.sortNumbers(dataNumbers);

        assertEquals(emptyList, responseEntity.getBody());
    }

    @Test
    void shouldReturnBadRequest() {
        DataNumbers dataNumbers = new DataNumbers();

        ResponseEntity<Object> responseEntity = sortNumbersServiceInterface.sortNumbers(dataNumbers);
        HttpStatus status = HttpStatus.BAD_REQUEST;

        assertEquals(status, responseEntity.getStatusCode());
    }
}