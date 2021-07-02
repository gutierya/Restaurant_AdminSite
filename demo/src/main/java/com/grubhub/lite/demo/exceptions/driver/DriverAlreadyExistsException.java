package com.grubhub.lite.demo.exceptions.driver;

public class DriverAlreadyExistsException extends RuntimeException {

    DriverAlreadyExistsException(Long driverID) {
        super("Driver " +  driverID + " already Exists");
    }
}
