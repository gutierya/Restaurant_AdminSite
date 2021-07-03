package com.grubhub.lite.demo.services;

import com.grubhub.lite.demo.exceptions.customer.CustomerAlreadyExistsException;
import com.grubhub.lite.demo.exceptions.driver.DriverNotFoundException;
import com.grubhub.lite.demo.models.Driver;
import com.grubhub.lite.demo.models.Enums;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DriverService {
    @Autowired
    private ApplicationContext context;

    private final RepositoryService repositoryService;
    private static final Logger log = LoggerFactory.getLogger(DriverService.class);


    DriverService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
        log.info( this.getClass() + " Service: UP");


    }

    public Driver addDriver(DriverService driver) throws CustomerAlreadyExistsException {
        if (repositoryService.getCustomerRepository().existsById(driver.getUserID())) {
            throw new CustomerAlreadyExistsException(driver.getUserID());
        }
        return repositoryService.getDriverRepository().save(driver);
    }

    public Driver getDriverByid(long id) throws DriverNotFoundException {
        if (repositoryService.getDriverRepository().existsById(id)) {
            return repositoryService.getDriverRepository().getById(id);
        }
        throw new DriverNotFoundException(id);
    }

    public void setRating (Short newVar, long id) throws DriverNotFoundException {
        if (repositoryService.getDriverRepository().existsById(id)) {
            repositoryService.getDriverRepository().getById(id).setRating(newVar);
        }
        throw new DriverNotFoundException(id);
    }

    public Short getRating (long id) throws DriverNotFoundException {
        if (repositoryService.getDriverRepository().existsById(id)) {
            return repositoryService.getDriverRepository().getById(id).getRating();
        }
        throw new DriverNotFoundException(id);
    }

    public void setVehicle (Enums.VehicleType newVar, long id) throws DriverNotFoundException {
        if (repositoryService.getDriverRepository().existsById(id)) {
            repositoryService.getDriverRepository().getById(id).setVehicle(newVar);
        }
        throw new DriverNotFoundException(id);
    }

    public Enums.VehicleType getVehicle(long id) throws DriverNotFoundException {
        if (repositoryService.getDriverRepository().existsById(id)) {
            return repositoryService.getDriverRepository().getById(id).getVehicle();
        }
        throw new DriverNotFoundException(id);
    }

    public void setEstimatedArrivalTime (Date newVar, long id) throws DriverNotFoundException {
        if (repositoryService.getDriverRepository().existsById(id)) {
            repositoryService.getDriverRepository().getById(id).setEstimatedArrivalTime(newVar);
        }
        throw new DriverNotFoundException(id);

    }

    public Date getEstimatedArrivalTime(long id) throws DriverNotFoundException {
        if (repositoryService.getDriverRepository().existsById(id)) {
            return repositoryService.getDriverRepository().getById(id).getEstimatedArrivalTime();
        }
        throw new DriverNotFoundException(id);

    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }
}
