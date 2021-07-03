package com.grubhub.lite.demo.services;

import com.grubhub.lite.demo.exceptions.GlobalException;
import com.grubhub.lite.demo.exceptions.payment.PaymentNotFoundException;
import com.grubhub.lite.demo.models.Driver;
import com.grubhub.lite.demo.models.Restaurant;
import com.grubhub.lite.demo.repositories.*;
import org.apache.tomcat.jni.Global;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Service
public class RepositoryService {

    @Autowired
   private CustomerRepository customerRepository;
    @Autowired
   private RestaurantRepository restaurantRepository;
    @Autowired
   private MenuItemRepository menuItemRepository;
    @Autowired
   private OrderRepository orderRepository;
    @Autowired
   private UserRepository userRepository;
    @Autowired
   private DriverRepository driverRepository;
    @Autowired
   private PaymentRepository paymentRepository;

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    private static final Logger log = LoggerFactory.getLogger(RepositoryService.class);


    RepositoryService() {
        log.info( this.getClass() + " Service: UP");

    }

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public RestaurantRepository getRestaurantRepository() {
        return restaurantRepository;
    }

    public void setRestaurantRepository(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public MenuItemRepository getMenuItemRepository() {
        return menuItemRepository;
    }

    public void setMenuItemRepository(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public DriverRepository getDriverRepository() {
        return driverRepository;
    }

    public void setDriverRepository(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public PaymentRepository getPaymentRepository() {
        return paymentRepository;
    }

    public void setPaymentRepository(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

}
