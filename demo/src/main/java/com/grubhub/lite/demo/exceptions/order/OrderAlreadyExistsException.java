package com.grubhub.lite.demo.exceptions.order;

public class OrderAlreadyExistsException extends RuntimeException {
    public OrderAlreadyExistsException(Long id) {
        super("Order " + id + " already exists");
    }
}
