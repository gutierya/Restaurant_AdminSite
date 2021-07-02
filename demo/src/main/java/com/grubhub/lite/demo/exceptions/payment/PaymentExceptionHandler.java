package com.grubhub.lite.demo.exceptions.payment;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class PaymentExceptionHandler {

    @ExceptionHandler(PaymentNotFoundException.class)
    public ResponseEntity<String> handlePaymentNotFound(PaymentNotFoundException ex) {
        return new ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(PaymentDeclinedException.class)
    public ResponseEntity<String> handlePaymentDeclined(PaymentDeclinedException ex) {
        return new ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.EXPECTATION_FAILED
        );
    }
}
