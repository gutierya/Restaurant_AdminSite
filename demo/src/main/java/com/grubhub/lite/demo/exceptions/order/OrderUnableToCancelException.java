package com.grubhub.lite.demo.exceptions.order;

public class OrderUnableToCancelException extends RuntimeException {
    public OrderUnableToCancelException(Long orderID) {
        super("Order " + orderID + " con not be cancelled at this time" );
    }
}
