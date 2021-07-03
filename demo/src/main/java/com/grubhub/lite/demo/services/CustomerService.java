package com.grubhub.lite.demo.services;

import com.grubhub.lite.demo.exceptions.customer.CustomerAlreadyExistsException;
import com.grubhub.lite.demo.exceptions.customer.CustomerNotFoundException;
import com.grubhub.lite.demo.exceptions.menuItems.MenuItemNotFoundException;
import com.grubhub.lite.demo.exceptions.order.OrderNotFoundException;
import com.grubhub.lite.demo.exceptions.restaurant.RestaurantNotFoundException;
import com.grubhub.lite.demo.models.Customer;
import com.grubhub.lite.demo.models.FoodOrder;
import com.grubhub.lite.demo.models.MenuItem;
import com.grubhub.lite.demo.models.Restaurant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private ApplicationContext context;

    private final RepositoryService repositoryService;
    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);


    CustomerService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
        log.info( this.getClass() + " Service: UP");
    }

    public Customer addCustomer(Customer customer) throws CustomerAlreadyExistsException {
        if (repositoryService.getCustomerRepository().existsById(customer.getUserID())) {
            throw new CustomerAlreadyExistsException(customer.getUserID());
        }
        return repositoryService.getCustomerRepository().save(customer);
    }

    public Customer getCustomerByid(Long id) throws CustomerNotFoundException {
        if (repositoryService.getCustomerRepository().existsById(id)) {
            return repositoryService.getCustomerRepository().getById(id);
        }
        throw new CustomerNotFoundException(id);
    }

    public List<Restaurant> getFavoriteRestaurants(Long id) throws CustomerNotFoundException {
        if (repositoryService.getCustomerRepository().existsById(id)) {
            List<Long> restaurantIds = repositoryService.getCustomerRepository().getById(id).getFavoriteRestaurants();
            List<Restaurant> restaurants = new ArrayList<>();
            for (Long restaurantId : restaurantIds) {
                restaurants.add(repositoryService.getRestaurantRepository().findById(restaurantId).orElseThrow(() -> new RestaurantNotFoundException(restaurantId)));
            }
            return restaurants;

        }
        throw new CustomerNotFoundException(id);
    }

    public List<MenuItem> getFavoriteItems(Long id) throws CustomerNotFoundException {
        if (repositoryService.getCustomerRepository().existsById(id)) {
            List<Long> menuItemIds = repositoryService.getCustomerRepository().getById(id).getFavoriteItems();
            List<MenuItem> favoriteItems = new ArrayList<>();
            for(Long itemID : menuItemIds) {
                favoriteItems.add(repositoryService.getMenuItemRepository().findById(itemID).orElseThrow(() -> new MenuItemNotFoundException(itemID)));
            }
            return favoriteItems;
        }
        throw new CustomerNotFoundException(id);
    }

    public List<FoodOrder> getOrderHistory(Long id) throws CustomerNotFoundException, OrderNotFoundException {
        if (repositoryService.getCustomerRepository().existsById(id)) {
            List<Long> orderIds = repositoryService.getCustomerRepository().getById(id).getOrderHistory();
            List<FoodOrder> previousOrders = new ArrayList<>();
            for(Long orderID : orderIds) {
                previousOrders.add(repositoryService.getOrderRepository().findById(orderID).orElseThrow(() -> new OrderNotFoundException(orderID)));
            }
            return previousOrders;
        }
        throw new CustomerNotFoundException(id);
    }

}


