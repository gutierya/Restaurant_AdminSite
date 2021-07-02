package com.grubhub.lite.demo.Repo;

import com.grubhub.lite.demo.models.*;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.ArrayList;

@Repository
public class grubhubRepo {
    private List<Customer> customer = new ArrayList<>();
    private List<Driver> driver = new ArrayList<>();
    private List<MenuItem> menu = new ArrayList<>();
    private List<Order> order = new ArrayList<>();
    private List<Payment> payments= new ArrayList<>();
    private List<Restaurant> restaurant = new ArrayList<>();
    private List<User> user = new ArrayList<>();





    public void addPayments(Payment pay) {
        payments.add(pay);
    }

    public void addCustomer(Customer customer1){
        customer.add(customer1);
    }
    public void addUser(User user1) {
        user.add(user1);
    }

    public void addOrder (Order order1) {
        order.add(order1);
    }
    public void addMenu (MenuItem menu1) {
        menu.add(menu1);
    }
    public void addRestaurant (Restaurant restaurant1) {
        restaurant.add(restaurant1);
    }










}
