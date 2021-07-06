package com.grubhub.lite.demo.controllers;

import com.grubhub.lite.demo.exceptions.order.OrderNotFoundException;
import com.grubhub.lite.demo.models.Enums;
import com.grubhub.lite.demo.models.Payment;
import com.grubhub.lite.demo.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {


    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    /**
     * Admin Functionality, get all payments.
     *
     * @return All payments in DB
     */
    @GetMapping("/")
    @CrossOrigin
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }


    //Perspective - website admin/(restaurant)

    /**
     * Get payment by paymentID - in payment class
     */
    @GetMapping(value = "/byID/{paymentID}")
    @CrossOrigin
    public Payment getPaymentByID(@PathVariable Long paymentID) throws OrderNotFoundException {
        return this.paymentService.getPaymentById(paymentID);
    }


    /**
     * get payment by type
     */
    @GetMapping(value = "/byType/{paymentType}")
    @CrossOrigin
    public List<Payment> getPaymentType(@PathVariable Enums.PaymentType paymentType) {
        return this.paymentService.getPaymentType(paymentType);
    }

    /**
     * get payment status
     */
    @GetMapping(value = "/byStatus/{paymentStatus}")
    @CrossOrigin
    public List<Payment> getPaymentByStatus(@PathVariable Enums.PaymentStatus paymentStatus) throws OrderNotFoundException {
        return this.paymentService.getPaymentStatus(paymentStatus);
    }

    @PostMapping("/")
    @CrossOrigin
    public void addPayment(@RequestBody Payment payment) {
        this.paymentService.addPayment(payment);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public void deletePayment(@PathVariable Long id) {
        this.paymentService.deletePayment(id);
    }


}

