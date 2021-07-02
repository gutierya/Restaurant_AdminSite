package com.grubhub.lite.demo.services;

import com.grubhub.lite.demo.exceptions.payment.PaymentNotFoundException;
import com.grubhub.lite.demo.models.Driver;
import com.grubhub.lite.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class RepositoryService {

    static private CustomerRepository customerRepository;
    static private RestaurantRepository restaurantRepository;
    static private MenuItemRepository menuItemRepository;
    static private OrderRepository orderRepository;
    static private UserRepository userRepository;
    static private DriverRepository driverRepository;
    static private PaymentRepository paymentRepository;

    public static CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public static void setCustomerRepository(CustomerRepository customerRepository) {
        RepositoryService.customerRepository = customerRepository;
    }

    public static RestaurantRepository getRestaurantRepository() {
        return restaurantRepository;
    }

    public static void setRestaurantRepository(RestaurantRepository restaurantRepository) {
        RepositoryService.restaurantRepository = restaurantRepository;
    }

    public static MenuItemRepository getMenuItemRepository() {
        return menuItemRepository;
    }

    public static void setMenuItemRepository(MenuItemRepository menuItemRepository) {
        RepositoryService.menuItemRepository = menuItemRepository;
    }

    public static OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public static void setOrderRepository(OrderRepository orderRepository) {
        RepositoryService.orderRepository = orderRepository;
    }

    public static UserRepository getUserRepository() {
        return userRepository;
    }

    public static void setUserRepository(UserRepository userRepository) {
        RepositoryService.userRepository = userRepository;
    }

    public static DriverRepository getDriverRepository() {
        return driverRepository;
    }

    public static void setDriverRepository(DriverRepository driverRepository) {
        RepositoryService.driverRepository = driverRepository;
    }

    public static PaymentRepository getPaymentRepository() {
        return paymentRepository;
    }

    public static void setPaymentRepository(PaymentRepository paymentRepository) {
        RepositoryService.paymentRepository = paymentRepository;
    }
}
