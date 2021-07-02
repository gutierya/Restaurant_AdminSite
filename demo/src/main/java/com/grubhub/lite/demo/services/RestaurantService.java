package com.grubhub.lite.demo.services;

import com.grubhub.lite.demo.exceptions.restaurant.RestaurantNotFoundException;
import com.grubhub.lite.demo.models.Restaurant;
import com.grubhub.lite.demo.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RestaurantService {

    public Restaurant getRestaurantByid(long id) throws RestaurantNotFoundException {
        if (RepositoryService.getRestaurantRepository().existsById(id)) {
            return RepositoryService.getRestaurantRepository().getById(id);
        }
        throw new RestaurantNotFoundException(id);
    }

    public Short getRating(long id) throws RestaurantNotFoundException {
        if (RepositoryService.getRestaurantRepository().existsById(id)) {
            return RepositoryService.getRestaurantRepository().getById(id).getRating();
        }
        throw new RestaurantNotFoundException(id);
    }

    public Date getTimeOpen(long id) throws RestaurantNotFoundException {
        if (RepositoryService.getRestaurantRepository().existsById(id)) {
            return RepositoryService.getRestaurantRepository().getById(id).getTimeOpen();
        }
        throw new RestaurantNotFoundException(id);
    }

    public Date getTimeClose(long id) throws RestaurantNotFoundException {
        if (RepositoryService.getRestaurantRepository().existsById(id)) {
            return RepositoryService.getRestaurantRepository().getById(id).getTimeClose();
        }
        throw new RestaurantNotFoundException(id);
    }

    public Double getAverageWaitTime(long id) throws RestaurantNotFoundException {
        if (RepositoryService.getRestaurantRepository().existsById(id)) {
            return RepositoryService.getRestaurantRepository().getById(id).getAverageWaitTime();
        }
        throw new RestaurantNotFoundException(id);
    }

}
