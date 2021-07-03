package com.grubhub.lite.demo.exceptions.restaurant;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Controller
public class RestaurantExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RestaurantNotAvailableException.class)
    public ResponseEntity<Object> handleRestaurantNotAvailable(RestaurantNotAvailableException ex, WebRequest request) {
       return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.OK, request );

    }

}
