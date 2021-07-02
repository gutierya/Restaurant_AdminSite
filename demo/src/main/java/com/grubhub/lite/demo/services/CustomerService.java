package com.grubhub.lite.demo.services;

import com.grubhub.lite.demo.exceptions.customer.CustomerAlreadyExistsException;
import com.grubhub.lite.demo.exceptions.customer.CustomerNotFoundException;
import com.grubhub.lite.demo.models.Customer;
import com.grubhub.lite.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer customer) throws CustomerAlreadyExistsException {
        if (customerRepository.existsById(customer.getUserID())) {
            throw new CustomerAlreadyExistsException(customer.getUserID());
        }
        return customerRepository.save(customer);
    }

    public Customer getCustomerByid(long id) throws CustomerNotFoundException {
        if (customerRepository.existsById(id)) {
            return customerRepository.getById(id);
        }
        throw new CustomerNotFoundException(id);
    }

    public List<Long> getFavoriteRestaurants(long id) throws CustomerNotFoundException {
        if (customerRepository.existsById(id)) {
            return customerRepository.getById(id).getFavoriteRestaurants();
        }
        throw new CustomerNotFoundException(id);
    }

    public List<Long> getFavoriteItems(long id) throws CustomerNotFoundException {
        if (customerRepository.existsById(id)) {
            return customerRepository.getById(id).getFavoriteItems();
        }
        throw new CustomerNotFoundException(id);
    }

    public List<Long> getOrderHistory(long id) throws CustomerNotFoundException  {
        if (customerRepository.existsById(id)) {
            return customerRepository.getById(id).getOrderHistory();
        }
        throw new CustomerNotFoundException(id);
    }


}


