package com.grubhub.lite.demo.exceptions.menuItems;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Controller
public class MenuItemExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MenuItemNotAvailableException.class)
    public ResponseEntity<Object> handleItemNotAvailable(MenuItemNotAvailableException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.FAILED_DEPENDENCY, request );
    }
}
