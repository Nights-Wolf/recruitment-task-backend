package com.recruitment.recruitment_task.servicesImpl;

import com.recruitment.recruitment_task.models.DataNumbersRequest;
import com.recruitment.recruitment_task.models.DataNumbersResponse;
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
class SortNumbersServiceImplUnitTest {

    @Autowired
    private SortNumbersServiceInterface sortNumbersServiceInterface;

    @Test
    void shouldSortListAscended() {
        List<Integer> testNumbers = new ArrayList<>();
        testNumbers.add(5);
        testNumbers.add(2);
        testNumbers.add(4);
        testNumbers.add(10);

        DataNumbersRequest dataNumbersRequest = new DataNumbersRequest();
        dataNumbersRequest.setNumbers(testNumbers);
        dataNumbersRequest.setOrder(Order.ASC);

        List<Integer> sortedArray = testNumbers
                .stream()
                .sorted()
                .collect(Collectors.toList());

        DataNumbersResponse dataNumbersResponse = new DataNumbersResponse();
        dataNumbersResponse.setNumbers(sortedArray);

        ResponseEntity<Object> responseEntity =  sortNumbersServiceInterface.sortNumbers(dataNumbersRequest);
        DataNumbersResponse dataNumbersResponseActual = (DataNumbersResponse) responseEntity.getBody();

        assertEquals(dataNumbersResponse.getNumbers(), dataNumbersResponseActual.getNumbers());
    }

    @Test
    void shouldSortListDescended() {
        List<Integer> testNumbers = new ArrayList<>();
        testNumbers.add(5);
        testNumbers.add(2);
        testNumbers.add(4);
        testNumbers.add(10);

        DataNumbersRequest dataNumbersRequest = new DataNumbersRequest();
        dataNumbersRequest.setNumbers(testNumbers);
        dataNumbersRequest.setOrder(Order.DSC);

        List<Integer> sortedDescend = testNumbers
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        DataNumbersResponse dataNumbersResponse = new DataNumbersResponse();
        dataNumbersResponse.setNumbers(sortedDescend);

        ResponseEntity<Object> responseEntity = sortNumbersServiceInterface.sortNumbers(dataNumbersRequest);
        DataNumbersResponse dataNumbersResponseActual = (DataNumbersResponse) responseEntity.getBody();

        assertEquals(dataNumbersResponse.getNumbers(), dataNumbersResponseActual.getNumbers());
    }

    @Test
    void shouldReturnEmptyList() {
        List<Integer> emptyList = new ArrayList<>();

        DataNumbersRequest dataNumbersRequest = new DataNumbersRequest();
        dataNumbersRequest.setNumbers(emptyList);
        dataNumbersRequest.setOrder(Order.ASC);

        DataNumbersResponse dataNumbersResponse = new DataNumbersResponse();
        dataNumbersResponse.setNumbers(emptyList);

        ResponseEntity<Object> responseEntity = sortNumbersServiceInterface.sortNumbers(dataNumbersRequest);
        DataNumbersResponse dataNumbersResponseActual = (DataNumbersResponse) responseEntity.getBody();

        assertEquals(dataNumbersResponse.getNumbers(), dataNumbersResponseActual.getNumbers());
    }

    @Test
    void shouldReturnBadRequest() {
        DataNumbersRequest dataNumbersRequest = new DataNumbersRequest();

        ResponseEntity<Object> responseEntity = sortNumbersServiceInterface.sortNumbers(dataNumbersRequest);
        HttpStatus status = HttpStatus.BAD_REQUEST;

        assertEquals(status, responseEntity.getStatusCode());
    }

    @Test
    void shouldConvertDoubleOrFloatToInteger() {
        List<Integer> testNumbersDouble = new ArrayList<>();
        testNumbersDouble.add((int) 2.5);
        testNumbersDouble.add((int) 2.5);
        testNumbersDouble.add((int) 4.3);
        testNumbersDouble.add((int) 10.1);

        DataNumbersRequest dataNumbersRequest = new DataNumbersRequest();
        dataNumbersRequest.setNumbers(testNumbersDouble);
        dataNumbersRequest.setOrder(Order.DSC);

        List<Integer> testNumbers = new ArrayList<>();
        testNumbers.add(2);
        testNumbers.add(2);
        testNumbers.add(4);
        testNumbers.add(10);

        List<Integer> sortedDescend = testNumbers
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        DataNumbersResponse dataNumbersResponse = new DataNumbersResponse();
        dataNumbersResponse.setNumbers(sortedDescend);

        ResponseEntity<Object> responseEntity = sortNumbersServiceInterface.sortNumbers(dataNumbersRequest);
        DataNumbersResponse dataNumbersResponseActual = (DataNumbersResponse) responseEntity.getBody();

        assertEquals(dataNumbersResponse.getNumbers(), dataNumbersResponseActual.getNumbers());
    }
}