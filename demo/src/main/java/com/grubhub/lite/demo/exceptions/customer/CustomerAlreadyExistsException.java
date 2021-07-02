package com.grubhub.lite.demo.exceptions.customer;

public class CustomerAlreadyExistsException extends RuntimeException {

    CustomerAlreadyExistsException(Long userID) {
        super("Custer " + userID + " already present in db");
    }

}
