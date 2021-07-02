package com.grubhub.lite.demo.exceptions.restaurant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class RestaurantExceptionHandler {

    @ExceptionHandler(RestaurantNotAvailableException.class)
    public ResponseEntity<String> handleRestaurantNotAvailable(RestaurantNotAvailableException ex) {
        return new ResponseEntity<String>(
                ex.getMessage(),
                HttpStatus.OK
        );
    }

}
