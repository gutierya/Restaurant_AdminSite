package com.grubhub.lite.demo.services;

import com.grubhub.lite.demo.exceptions.customer.CustomerAlreadyExistsException;
import com.grubhub.lite.demo.exceptions.driver.DriverNotFoundException;
import com.grubhub.lite.demo.models.Driver;
import com.grubhub.lite.demo.models.Enums;
import org.springframework.stereotype.Service;

import java.util.Date;

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

    public void setRating (Short newVar, long id) throws DriverNotFoundException {
        if (RepositoryService.getDriverRepository().existsById(id)) {
            RepositoryService.getDriverRepository().getById(id).setRating(newVar);
        }
        throw new DriverNotFoundException(id);
    }

    public Short getRating (long id) throws DriverNotFoundException {
        if (RepositoryService.getDriverRepository().existsById(id)) {
            return RepositoryService.getDriverRepository().getById(id).getRating();
        }
        throw new DriverNotFoundException(id);
    }

    public void setVehicle (Enums.VehicleType newVar, long id) throws DriverNotFoundException {
        if (RepositoryService.getDriverRepository().existsById(id)) {
            RepositoryService.getDriverRepository().getById(id).setVehicle(newVar);
        }
        throw new DriverNotFoundException(id);
    }

    public Enums.VehicleType getVehicle(long id) throws DriverNotFoundException {
        if (RepositoryService.getDriverRepository().existsById(id)) {
            return RepositoryService.getDriverRepository().getById(id).getVehicle();
        }
        throw new DriverNotFoundException(id);
    }

    public void setEstimatedArrivalTime (Date newVar, long id) throws DriverNotFoundException {
        if (RepositoryService.getDriverRepository().existsById(id)) {
            RepositoryService.getDriverRepository().getById(id).setEstimatedArrivalTime(newVar);
        }
        throw new DriverNotFoundException(id);

    }

    public Date getEstimatedArrivalTime(long id) throws DriverNotFoundException {
        if (RepositoryService.getDriverRepository().existsById(id)) {
            return RepositoryService.getDriverRepository().getById(id).getEstimatedArrivalTime();
        }
        throw new DriverNotFoundException(id);

    }

}
