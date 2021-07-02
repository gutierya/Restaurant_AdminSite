package com.grubhub.lite.demo.exceptions.payment;

public class PaymentNotFoundException extends RuntimeException {
    PaymentNotFoundException(Long id) {
        super ("Payment " + id + " could not be located");
    }


}
