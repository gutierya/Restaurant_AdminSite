package com.grubhub.lite.demo.controllers;

import com.grubhub.lite.demo.exceptions.order.OrderNotFoundException;
import com.grubhub.lite.demo.models.Enums;
import com.grubhub.lite.demo.models.FoodOrder;
import com.grubhub.lite.demo.repositories.*;
import com.grubhub.lite.demo.models.Payment;
import com.grubhub.lite.demo.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
public class PaymentController {


    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


        //Perspective - website admin/(restaurant)
        /**
         * Get payment by paymentID - in payment class
         */
        @RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET)
        @ResponseBody
        public Payment getPaymentByOrderID(@PathVariable("orderID") Long orderId) throws OrderNotFoundException {
            return this.paymentService.getPaymentById(orderId);
        }


        /**
         * get payment by type
         */
        @RequestMapping(value = "/payment", method = RequestMethod.GET)
        public Enums.PaymentType getPaymentViaOrderId(@PathVariable("orderID") Long orderId){
            return this.paymentService.getPaymentType(orderId);
        }

        /**
         * get payment status
         */
        @RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET)
        @ResponseBody
        public Enums.PaymentStatus getPaymentByStatus(@PathVariable("orderID") Long orderId) throws OrderNotFoundException {
            return this.paymentService.getPaymentStatus(orderId);
        }


    }

