package com.grubhub.lite.demo.services;

import com.grubhub.lite.demo.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private ApplicationContext context;

    private final RepositoryService repositoryService = context.getBean(RepositoryService.class);

    // set
    // return payment
}
