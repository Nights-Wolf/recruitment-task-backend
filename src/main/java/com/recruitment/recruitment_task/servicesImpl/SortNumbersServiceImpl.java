package com.recruitment.recruitment_task.servicesImpl;

import com.recruitment.recruitment_task.models.DataNumbersRequest;
import com.recruitment.recruitment_task.models.DataNumbersResponse;
import com.recruitment.recruitment_task.models.Order;
import com.recruitment.recruitment_task.servicesInterfaces.SortNumbersServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SortNumbersServiceImpl implements SortNumbersServiceInterface {

    @Override
    public ResponseEntity<Object> sortNumbers(DataNumbersRequest dataNumbersRequest) {
        Order order = dataNumbersRequest.getOrder();

        if (order == null) {
            Map<String, String> nullOrderError = new HashMap<>();

            nullOrderError.put("Message", "Order can not be null");
            nullOrderError.put("Status", HttpStatus.BAD_REQUEST.toString());

            return new ResponseEntity<>(nullOrderError, HttpStatus.BAD_REQUEST);
        }

        if (dataNumbersRequest.getNumbers() == null || dataNumbersRequest.getNumbers().isEmpty()) {
            List<Integer> nullOrEmpty = new ArrayList<>();
            DataNumbersResponse dataNumbersResponse = new DataNumbersResponse();
            dataNumbersResponse.setNumbers(nullOrEmpty);
            return new ResponseEntity<>(dataNumbersResponse, HttpStatus.OK);
        }

        if (order == Order.ASC) {
            List<Integer> sortedASC = dataNumbersRequest.getNumbers()
                    .stream()
                    .sorted()
                    .collect(Collectors.toList());

            DataNumbersResponse dataNumbersResponse = new DataNumbersResponse();
            dataNumbersResponse.setNumbers(sortedASC);

            return new ResponseEntity<>(dataNumbersResponse, HttpStatus.OK);
        } else if (order == Order.DSC) {
            List<Integer> sortedDSC = dataNumbersRequest.getNumbers()
                    .stream()
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());

            DataNumbersResponse dataNumbersResponse = new DataNumbersResponse();
            dataNumbersResponse.setNumbers(sortedDSC);

            return new ResponseEntity<>(dataNumbersResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
