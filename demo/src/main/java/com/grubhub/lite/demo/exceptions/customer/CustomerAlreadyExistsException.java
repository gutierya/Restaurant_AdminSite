package com.grubhub.lite.demo.exceptions.customer;

public class CustomerAlreadyExistsException extends RuntimeException {

    public CustomerAlreadyExistsException(Long userID) {
        super("Custer " + userID + " already present in db");
    }

}
