package com.grubhub.lite.demo.exceptions.menuItems;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class MenuItemExceptionHandler {

    @ExceptionHandler(MenuItemNotAvailableException.class)
    public ResponseEntity<String> handleItemNotAvailable(MenuItemNotAvailableException ex) {
        return new ResponseEntity<String>(
                ex.getMessage(),
                HttpStatus.FAILED_DEPENDENCY
        );
    }
}
