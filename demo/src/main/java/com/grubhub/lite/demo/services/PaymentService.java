package com.grubhub.lite.demo.services;

import com.grubhub.lite.demo.exceptions.payment.PaymentNotFoundException;
import com.grubhub.lite.demo.models.Enums;
import com.grubhub.lite.demo.models.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private ApplicationContext context;

    private final RepositoryService repositoryService;
    private static final Logger log = LoggerFactory.getLogger(PaymentService.class);


    PaymentService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
        log.info( this.getClass() + " Service: UP");

    }

    public Payment getPaymentById(Long id) throws PaymentNotFoundException {
        if (repositoryService.getPaymentRepository().existsById(id)) {
            return repositoryService.getPaymentRepository().getById(id);
        }
        throw new PaymentNotFoundException(id);
    }

    public void setPaymentID (Long newVar, Long id) throws PaymentNotFoundException {
        if (repositoryService.getPaymentRepository().existsById(id)) {
            repositoryService.getPaymentRepository().getById(id).setPaymentID(newVar);
        }
        throw new PaymentNotFoundException(id);
    }

    public Long getPaymentID(Long id) throws PaymentNotFoundException {
        if (repositoryService.getPaymentRepository().existsById(id)) {
            return repositoryService.getPaymentRepository().getById(id).getPaymentID();
        }
        throw new PaymentNotFoundException(id);
    }

    public void setPaymentType (Enums newVar, Long id) throws PaymentNotFoundException {
        if (repositoryService.getPaymentRepository().existsById(id)) {
            repositoryService.getPaymentRepository().getById(id).setPaymentType(newVar);
        }
        throw new PaymentNotFoundException(id);
    }

    public Enums.PaymentType getPaymentType(Long id) throws PaymentNotFoundException {
        if (repositoryService.getPaymentRepository().existsById(id)) {
            return repositoryService.getPaymentRepository().getById(id).getPaymentType();
        }
        throw new PaymentNotFoundException(id);
    }

    public void setPaymentStatus (Enums.PaymentStatus newVar, Long id) throws PaymentNotFoundException {
        if (repositoryService.getPaymentRepository().existsById(id)) {
            repositoryService.getPaymentRepository().getById(id).setPaymentStatus(newVar);
        }
        throw new PaymentNotFoundException(id);
    }

    public Enums.PaymentStatus getPaymentStatus(Long id) throws PaymentNotFoundException {
        if (repositoryService.getPaymentRepository().existsById(id)) {
            return repositoryService.getPaymentRepository().getById(id).getPaymentStatus();
        }
        throw new PaymentNotFoundException(id);
    }


}
