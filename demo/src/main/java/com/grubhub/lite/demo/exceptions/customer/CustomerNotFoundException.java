package com.grubhub.lite.demo.exceptions.customer;


public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long userID) {
        super("Customer" + userID + " not found");
    }
}
