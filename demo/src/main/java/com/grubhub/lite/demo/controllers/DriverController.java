package com.grubhub.lite.demo.controllers;

import com.grubhub.lite.demo.models.Customer;
import com.grubhub.lite.demo.models.Driver;
import com.grubhub.lite.demo.services.CustomerService;
import com.grubhub.lite.demo.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class DriverController {

    private DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    DriverController() { }

    /**
     * perspective - driver interacting with client
     * create a driver
     */
    @CrossOrigin
    @PostMapping("/driver")
    public void addADriver(@RequestBody DriverService driverService) {
        driverService.addDriver(driverService);
    }


    /**
     * perspective - driver interacting with client
     * update a driver
     */
//    @CrossOrigin
//    @PutMapping("/driver/{id}")
//    public void updateADriver( @PathVariable Long id, @RequestBody Driver driverDetails) {
//        Driver myDriver = new Driver();
//        Driver updateDriver = driverService.updateUser(id, myDriver);
//    }

    /**
     * perspective - admin
     * Get one driver
     */
    @CrossOrigin
    @RequestMapping(value = "/driver", method = RequestMethod.GET)
    public Driver listAllDrivers(@PathVariable Long id){
        return this.driverService.getDriverByid(id);
    }

    /**
     * perspective - admin
     * delete one driver
     */
//    @CrossOrigin
//    @DeleteMapping("/driver/{id}")
//    public void deleteADriver(@PathVariable Long userID) {
//        driverService.deleteById(userID);
//    }

    /**
     * perspective - admin
     * Get all drivers
     */
//    @CrossOrigin
//    @GetMapping("/drivers")
//    public List<Driver> listAllDrivers() {
//        return driverService.getAllUsers();
//    }
}
