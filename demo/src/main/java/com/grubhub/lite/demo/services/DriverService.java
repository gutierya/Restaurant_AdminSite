package com.grubhub.lite.demo.services;

import com.grubhub.lite.demo.exceptions.customer.CustomerAlreadyExistsException;
import com.grubhub.lite.demo.exceptions.driver.DriverAlreadyExistsException;
import com.grubhub.lite.demo.exceptions.driver.DriverNotFoundException;
import com.grubhub.lite.demo.models.Driver;
import com.grubhub.lite.demo.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Autowired
    private ApplicationContext context;

    private final RepositoryService repositoryService = context.getBean(RepositoryService.class);

    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    public Driver addDriver(Driver driver) throws DriverAlreadyExistsException {
        if (repositoryService.getDriverRepository().existsById(driver.getUserID())) {
            throw new CustomerAlreadyExistsException(driver.getUserID());
        }
        return repositoryService.getDriverRepository().save(driver);
    }

    public Driver getDriverByid(Long id) throws DriverNotFoundException {
        if (repositoryService.getDriverRepository().existsById(id)) {
            return repositoryService.getDriverRepository().getById(id);
        }
        throw new DriverNotFoundException(id);
    }


}
