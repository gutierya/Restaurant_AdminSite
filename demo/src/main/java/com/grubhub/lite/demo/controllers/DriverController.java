package com.grubhub.lite.demo.controllers;

import com.grubhub.lite.demo.models.Driver;
import com.grubhub.lite.demo.models.Restaurant;
import com.grubhub.lite.demo.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
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
    @PostMapping(value = "/createDriver")
    public void addADriver(@RequestBody Driver driver) {
        driverService.addDriver(driver);
    }


    /**
     * perspective - admin
     * Get one driver
     */
    @CrossOrigin
//    @RequestMapping(value = "/byId/{id}", method = RequestMethod.GET)
    @RequestMapping(value = "/byId/{id}")
    public Driver listAllDrivers(@PathVariable Long id){
        return this.driverService.getDriverByid(id);
    }

    /**
     * perspective - admin
     * Get all drivers
     */
    @CrossOrigin
    @GetMapping(value= "/")
    public List<Driver> listAllDrivers() {
        return driverService.getDrivers();
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
     * perspective - driver interacting with client
     * update a driver
     */
//    @CrossOrigin
//    @PutMapping("/driver/{id}")
//    public void updateADriver( @PathVariable Long id, @RequestBody Driver driverDetails) {
//        Driver myDriver = new Driver();
//        Driver updateDriver = driverService.updateUser(id, myDriver);
//    }

}
