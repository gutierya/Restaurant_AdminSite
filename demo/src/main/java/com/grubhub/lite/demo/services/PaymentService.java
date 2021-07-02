package com.grubhub.lite.demo.services;

import com.grubhub.lite.demo.exceptions.payment.PaymentNotFoundException;
import com.grubhub.lite.demo.models.Payment;
import com.grubhub.lite.demo.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentRepository paymentRepository;

    @Autowired
    public void setPaymentRepository(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment getPaymentById(long id) throws PaymentNotFoundException {
        if (paymentRepository.existsById(id)) {
            return paymentRepository.getById(id);
        }
        throw new PaymentNotFoundException(id);
    }


}
