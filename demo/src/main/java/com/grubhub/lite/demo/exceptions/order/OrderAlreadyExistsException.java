package com.grubhub.lite.demo.exceptions.order;

public class OrderAlreadyExistsException extends RuntimeException {
    OrderAlreadyExistsException(Long id) {
        super("Order " + id + " already exists");
    }
}
