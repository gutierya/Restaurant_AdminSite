package com.grubhub.lite.demo.exceptions;

import com.grubhub.lite.demo.exceptions.customer.CustomerAlreadyExistsException;
import com.grubhub.lite.demo.exceptions.customer.CustomerNotFoundException;
import com.grubhub.lite.demo.exceptions.driver.DriverAlreadyExistsException;
import com.grubhub.lite.demo.exceptions.driver.DriverNotFoundException;
import com.grubhub.lite.demo.exceptions.menuItems.MenuItemAlreadyExistsException;
import com.grubhub.lite.demo.exceptions.menuItems.MenuItemNotFoundException;
import com.grubhub.lite.demo.exceptions.order.OrderAlreadyExistsException;
import com.grubhub.lite.demo.exceptions.order.OrderNotFoundException;
import com.grubhub.lite.demo.exceptions.payment.PaymentNotFoundException;
import com.grubhub.lite.demo.exceptions.restaurant.RestaurantAlreadyExistsException;
import com.grubhub.lite.demo.exceptions.restaurant.RestaurantNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<Object> handleException(GlobalException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request );
    }



    @ExceptionHandler({
            CustomerAlreadyExistsException.class,
            DriverAlreadyExistsException.class,
            OrderAlreadyExistsException.class,
            RestaurantAlreadyExistsException.class,
            MenuItemAlreadyExistsException.class,
    })
    public ResponseEntity<Object> handleAlreadyExistsExceptions( RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.CONFLICT, request );

    }

    @ExceptionHandler({
            CustomerNotFoundException.class,
            DriverNotFoundException.class,
            OrderNotFoundException.class,
            PaymentNotFoundException.class,
            RestaurantNotFoundException.class,
            MenuItemNotFoundException.class,
    })
    public ResponseEntity<Object> handleNotFoundExceptions(RuntimeException ex, WebRequest request) {
       return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request );

    }
}
