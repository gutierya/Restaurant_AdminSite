package com.grubhub.lite.demo.services;

import com.grubhub.lite.demo.exceptions.restaurant.RestaurantNotFoundException;
import com.grubhub.lite.demo.models.Restaurant;
import com.grubhub.lite.demo.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RestaurantService {
    private RestaurantRepository restaurantRepository;

    @Autowired
    public void setPaymentRepository(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant getRestaurantByid(long id) throws RestaurantNotFoundException {
        if (restaurantRepository.existsById(id)) {
            return restaurantRepository.getById(id);
        }
        throw new RestaurantNotFoundException(id);
    }

    public Short getRating(long id) throws RestaurantNotFoundException {
        if (restaurantRepository.existsById(id)) {
            return restaurantRepository.getById(id).getRating();
        }
        throw new RestaurantNotFoundException(id);
    }

    public Date getTimeOpen(long id) throws RestaurantNotFoundException {
        if (restaurantRepository.existsById(id)) {
            return restaurantRepository.getById(id).getTimeOpen();
        }
        throw new RestaurantNotFoundException(id);
    }

    public Date getTimeClose(long id) throws RestaurantNotFoundException {
        if (restaurantRepository.existsById(id)) {
            return restaurantRepository.getById(id).getTimeClose();
        }
        throw new RestaurantNotFoundException(id);
    }

    public Double getAverageWaitTime(long id) throws RestaurantNotFoundException {
        if (restaurantRepository.existsById(id)) {
            return restaurantRepository.getById(id).getAverageWaitTime();
        }
        throw new RestaurantNotFoundException(id);
    }

}
