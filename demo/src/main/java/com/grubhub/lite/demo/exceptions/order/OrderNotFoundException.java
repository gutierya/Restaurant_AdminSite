package com.grubhub.lite.demo.exceptions.order;

public class OrderNotFoundException extends Exception {

    public OrderNotFoundException(Long orderID) {
        super("Order " + orderID + " not found");
    }
}
