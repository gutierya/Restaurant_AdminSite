package com.grubhub.lite.demo.services;

import com.grubhub.lite.demo.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    @Autowired
    private ApplicationContext context;

    private final RepositoryService repositoryService = context.getBean(RepositoryService.class);

    // create
    // rate
    // update rating
    // search by value, take, diatary, open, type
}
