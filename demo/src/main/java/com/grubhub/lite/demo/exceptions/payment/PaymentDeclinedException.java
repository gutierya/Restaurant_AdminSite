package com.grubhub.lite.demo.exceptions.payment;

public class PaymentDeclinedException extends RuntimeException {
    public PaymentDeclinedException(Long paymentID) {
        super("Payment" + paymentID + " was declined");
    }
}
