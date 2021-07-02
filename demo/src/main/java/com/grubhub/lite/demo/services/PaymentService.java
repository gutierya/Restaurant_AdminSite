package com.grubhub.lite.demo.services;

import com.grubhub.lite.demo.exceptions.payment.PaymentNotFoundException;
import com.grubhub.lite.demo.models.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPaymentById(long id) throws PaymentNotFoundException {
        if (RepositoryService.getPaymentRepository().existsById(id)) {
            return RepositoryService.getPaymentRepository().getById(id);
        }
        throw new PaymentNotFoundException(id);
    }


}
