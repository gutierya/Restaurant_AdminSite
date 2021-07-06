package com.grubhub.lite.demo.services;

import com.grubhub.lite.demo.exceptions.GlobalException;
import com.grubhub.lite.demo.exceptions.payment.PaymentNotFoundException;
import com.grubhub.lite.demo.models.Enums;
import com.grubhub.lite.demo.models.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public void setPaymentType (Enums.PaymentType newVar, Long id) throws PaymentNotFoundException {
        if (repositoryService.getPaymentRepository().existsById(id)) {
            repositoryService.getPaymentRepository().getById(id).setPaymentType(newVar);
        }
        throw new PaymentNotFoundException(id);
    }

    public List<Payment> getPaymentType(Enums.PaymentType paymentType) throws PaymentNotFoundException {
        if (repositoryService.getPaymentRepository().count() > 0) {
            ArrayList<Payment> matchingPayments = new ArrayList<>();
             for (Payment payment : repositoryService.getPaymentRepository().findAll()) {
                 if(payment.getPaymentType() == paymentType) {
                     matchingPayments.add(payment);
                 }
             }
             return matchingPayments;
        }
        throw new GlobalException("Empty Payment Database");
    }

    public void setPaymentStatus (Enums.PaymentStatus newVar, Long id) throws PaymentNotFoundException {
        if (repositoryService.getPaymentRepository().existsById(id)) {
            repositoryService.getPaymentRepository().getById(id).setPaymentStatus(newVar);
        }
        throw new PaymentNotFoundException(id);
    }

    public List<Payment> getPaymentStatus(Enums.PaymentStatus paymentStatus) throws PaymentNotFoundException {
        if (repositoryService.getPaymentRepository().count() > 0) {
            ArrayList<Payment> matchingPayments = new ArrayList<>();
            for(Payment payment : repositoryService.getPaymentRepository().findAll())  {
                if(payment.getPaymentStatus() == paymentStatus) {
                    matchingPayments.add(payment);
                }
            }
            return matchingPayments;
        }
        throw new GlobalException("Payment Database is empty");
    }


    public List<Payment> getAllPayments() {
        return repositoryService.getPaymentRepository().findAll();
    }

    public void addPayment(Payment payment) {
        repositoryService.getPaymentRepository().save(payment);
    }

    public void deletePayment(Long id) {
        repositoryService.getPaymentRepository().deleteById(id);
    }
}
