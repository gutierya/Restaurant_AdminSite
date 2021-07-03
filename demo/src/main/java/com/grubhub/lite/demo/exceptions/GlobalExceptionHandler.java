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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class GlobalExceptionHandler {

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<String> handleException(GlobalException ex) {
        return new ResponseEntity<String> (
                ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }


    @ExceptionHandler({
            CustomerAlreadyExistsException.class,
            DriverAlreadyExistsException.class,
            OrderAlreadyExistsException.class,
            RestaurantAlreadyExistsException.class,
            MenuItemAlreadyExistsException.class,
    })
    public ResponseEntity<String> handleAlreadyExistsExceptions(RuntimeException ex) {
        return new ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler({
            CustomerNotFoundException.class,
            DriverNotFoundException.class,
            OrderNotFoundException.class,
            PaymentNotFoundException.class,
            RestaurantNotFoundException.class,
            MenuItemNotFoundException.class,
    })
    public ResponseEntity<String> handleNotFoundExceptions(RuntimeException ex) {
        return new ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.NOT_FOUND
        );
    }
}
