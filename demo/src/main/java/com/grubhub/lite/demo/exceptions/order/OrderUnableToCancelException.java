package com.grubhub.lite.demo.exceptions.order;

public class OrderUnableToCancelException extends RuntimeException {
    OrderUnableToCancelException(Long orderID) {
        super("Order " + orderID + " con not be cancelled at this time" );
    }
}
