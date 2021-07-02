package com.grubhub.lite.demo.exceptions.driver;

public class DriverNotFoundException extends RuntimeException {

    public DriverNotFoundException(Long driverID) {
        super("Driver " + driverID + " not found");
    }
}
