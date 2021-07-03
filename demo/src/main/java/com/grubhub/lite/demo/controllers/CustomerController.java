package com.grubhub.lite.demo.controllers;

import com.grubhub.lite.demo.models.Customer;
import com.grubhub.lite.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    CustomerController() { }

    /**
     * perspective - user interacting with client
     * create a user
     */
    @CrossOrigin
    @PostMapping("/customer")
    public void addAUser(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }


    /**
     * perspective - user interacting with client
     * update a user
     */
//    @CrossOrigin
//    @PutMapping("/customer/{id}")
//    public void updateAUser( @PathVariable Long id, @RequestBody Customer customerDetails) {
//        Customer myCust = new Customer();
//        Customer updateCust = customerService.updateUser(id, myCust);
//    }

    /**
     * perspective - admin
     * Get one customer
     */
    @CrossOrigin
    @RequestMapping(value = "/customer/{userID}", method = RequestMethod.GET)
    public Customer listOneUser( @PathVariable Long userID){
        return this.customerService.getCustomerByid(userID);
    }

    /**
     * perspective - admin
     * delete one customer
     */
//    @CrossOrigin
//    @DeleteMapping(value = "/customer/{id}" )
//    public void deleteAUser(@PathVariable Long userID) {
//        customerService.deleteById(userID);
//    }

    /**
     * perspective - admin
     * Get all customers
     */
//    @CrossOrigin
//    @GetMapping("/customers")
//    public List<Customer> listAllUsers() {
//        return customerService.getAllUsers();
//    }
}
