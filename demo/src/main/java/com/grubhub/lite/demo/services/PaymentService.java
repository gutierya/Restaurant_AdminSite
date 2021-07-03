package com.grubhub.lite.demo.services;

import com.grubhub.lite.demo.exceptions.payment.PaymentNotFoundException;
import com.grubhub.lite.demo.models.Enums;
import com.grubhub.lite.demo.models.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPaymentById(Long id) throws PaymentNotFoundException {
        if (RepositoryService.getPaymentRepository().existsById(id)) {
            return RepositoryService.getPaymentRepository().getById(id);
        }
        throw new PaymentNotFoundException(id);
    }

    public void setPaymentID (Long newVar, Long id) throws PaymentNotFoundException {
        if (RepositoryService.getPaymentRepository().existsById(id)) {
            RepositoryService.getPaymentRepository().getById(id).setPaymentID(newVar);
        }
        throw new PaymentNotFoundException(id);
    }

    public Long getPaymentID(Long id) throws PaymentNotFoundException {
        if (RepositoryService.getPaymentRepository().existsById(id)) {
            return RepositoryService.getPaymentRepository().getById(id).getPaymentID();
        }
        throw new PaymentNotFoundException(id);
    }

    public void setPaymentType (Enums.PaymentType newVar, Long id) throws PaymentNotFoundException {
        if (RepositoryService.getPaymentRepository().existsById(id)) {
            RepositoryService.getPaymentRepository().getById(id).setPaymentType(newVar);
        }
        throw new PaymentNotFoundException(id);
    }

    public Enums.PaymentType getPaymentType(Long id) throws PaymentNotFoundException {
        if (RepositoryService.getPaymentRepository().existsById(id)) {
            return RepositoryService.getPaymentRepository().getById(id).getPaymentType();
        }
        throw new PaymentNotFoundException(id);
    }

    public void setPaymentStatus (Enums.PaymentStatus newVar, Long id) throws PaymentNotFoundException {
        if (RepositoryService.getPaymentRepository().existsById(id)) {
            RepositoryService.getPaymentRepository().getById(id).setPaymentStatus(newVar);
        }
        throw new PaymentNotFoundException(id);
    }

    public Enums.PaymentStatus getPaymentStatus(Long id) throws PaymentNotFoundException {
        if (RepositoryService.getPaymentRepository().existsById(id)) {
            return RepositoryService.getPaymentRepository().getById(id).getPaymentStatus();
        }
        throw new PaymentNotFoundException(id);
    }


}
