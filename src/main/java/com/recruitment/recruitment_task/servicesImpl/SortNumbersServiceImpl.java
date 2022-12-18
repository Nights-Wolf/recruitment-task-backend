package com.recruitment.recruitment_task.servicesImpl;

import com.recruitment.recruitment_task.models.DataNumbers;
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
    public ResponseEntity<Object> sortNumbers(DataNumbers dataNumbers) {
        Order order = dataNumbers.getOrder();

        if (order == null) {
            Map<String, String> nullOrderError = new HashMap<>();

            nullOrderError.put("Message", "Order can not be null");
            nullOrderError.put("Status", HttpStatus.BAD_REQUEST.toString());

            return new ResponseEntity<>(nullOrderError, HttpStatus.BAD_REQUEST);
        }

        if (dataNumbers.getNumbers() == null || dataNumbers.getNumbers().isEmpty()) {
            List<Integer> nullOrEmpty = new ArrayList<>();
            return new ResponseEntity<>(nullOrEmpty, HttpStatus.OK);
        }

        if (order == Order.ASC) {
            List<Integer> sortedASC = dataNumbers.getNumbers()
                    .stream()
                    .sorted()
                    .collect(Collectors.toList());

            return new ResponseEntity<>(sortedASC, HttpStatus.OK);
        } else if (order == Order.DSC) {
            List<Integer> sortedDSC = dataNumbers.getNumbers()
                    .stream()
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());

            return new ResponseEntity<>(sortedDSC, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
