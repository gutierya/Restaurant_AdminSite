package com.grubhub.lite.demo.services;

import com.grubhub.lite.demo.exceptions.customer.CustomerAlreadyExistsException;
import com.grubhub.lite.demo.exceptions.driver.DriverNotFoundException;
import com.grubhub.lite.demo.models.Driver;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    public Driver addDriver(Driver driver) throws CustomerAlreadyExistsException {
        if (RepositoryService.getCustomerRepository().existsById(driver.getUserID())) {
            throw new CustomerAlreadyExistsException(driver.getUserID());
        }
        return RepositoryService.getDriverRepository().save(driver);
    }

    public Driver getDriverByid(long id) throws DriverNotFoundException {
        if (RepositoryService.getDriverRepository().existsById(id)) {
            return RepositoryService.getDriverRepository().getById(id);
        }
        throw new DriverNotFoundException(id);
    }


}
