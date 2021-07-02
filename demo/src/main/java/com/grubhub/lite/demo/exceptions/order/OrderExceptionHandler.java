package com.grubhub.lite.demo.exceptions.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class OrderExceptionHandler{

    @ExceptionHandler(OrderUnableToCancelException.class)
    public ResponseEntity<String> handleUnableToCancelOrder(OrderUnableToCancelException ex) {
        return new ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.PRECONDITION_FAILED
        );
    }
}
