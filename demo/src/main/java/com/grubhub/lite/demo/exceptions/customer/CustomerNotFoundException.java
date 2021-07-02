package com.grubhub.lite.demo.exceptions.customer;


public class CustomerNotFoundException extends RuntimeException {

    CustomerNotFoundException(Long userID) {
        super("Customer" + userID + " not found");
    }
}
