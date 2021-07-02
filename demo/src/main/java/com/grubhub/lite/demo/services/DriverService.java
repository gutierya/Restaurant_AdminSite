package com.grubhub.lite.demo.services;

import com.grubhub.lite.demo.exceptions.customer.CustomerAlreadyExistsException;
import com.grubhub.lite.demo.exceptions.driver.DriverAlreadyExistsException;
import com.grubhub.lite.demo.exceptions.driver.DriverNotFoundException;
import com.grubhub.lite.demo.models.Driver;
import com.grubhub.lite.demo.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public void setDriverRepository(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver addDriver(Driver driver) throws DriverAlreadyExistsException {
        if (driverRepository.existsById(driver.getUserID())) {
            throw new CustomerAlreadyExistsException(driver.getUserID());
        }
        return driverRepository.save(driver);
    }

    public Driver getDriverByid(long id) throws DriverNotFoundException {
        if (driverRepository.existsById(id)) {
            return (Driver) driverRepository.getById(id);
        }
        throw new DriverNotFoundException(id);
    }


}
