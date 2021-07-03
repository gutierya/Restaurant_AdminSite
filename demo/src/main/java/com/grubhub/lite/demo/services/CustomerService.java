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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    public Customer addCustomer(Customer customer) throws CustomerAlreadyExistsException {
        if (RepositoryService.getCustomerRepository().existsById(customer.getUserID())) {
            throw new CustomerAlreadyExistsException(customer.getUserID());
        }
        return RepositoryService.getCustomerRepository().save(customer);
    }

    public Customer getCustomerByid(Long id) throws CustomerNotFoundException {
        if (RepositoryService.getCustomerRepository().existsById(id)) {
            return RepositoryService.getCustomerRepository().getById(id);
        }
        throw new CustomerNotFoundException(id);
    }

    public List<Restaurant> getFavoriteRestaurants(Long id) throws CustomerNotFoundException {
        if (RepositoryService.getCustomerRepository().existsById(id)) {
            List<Long> restaurantIds = RepositoryService.getCustomerRepository().getById(id).getFavoriteRestaurants();
            List<Restaurant> restaurants = new ArrayList<>();
            for (Long restaurantId : restaurantIds) {
                restaurants.add(RepositoryService.getRestaurantRepository().findById(restaurantId).orElseThrow(() -> new RestaurantNotFoundException(restaurantId)));
            }
            return restaurants;

        }
        throw new CustomerNotFoundException(id);
    }

    public List<MenuItem> getFavoriteItems(Long id) throws CustomerNotFoundException {
        if (RepositoryService.getCustomerRepository().existsById(id)) {
            List<Long> menuItemIds = RepositoryService.getCustomerRepository().getById(id).getFavoriteItems();
            List<MenuItem> favoriteItems = new ArrayList<>();
            for(Long itemID : menuItemIds) {
                favoriteItems.add(RepositoryService.getMenuItemRepository().findById(itemID).orElseThrow(() -> new MenuItemNotFoundException(itemID)));
            }
            return favoriteItems;
        }
        throw new CustomerNotFoundException(id);
    }

    public List<FoodOrder> getOrderHistory(Long id) throws CustomerNotFoundException, OrderNotFoundException {
        if (RepositoryService.getCustomerRepository().existsById(id)) {
            List<Long> orderIds = RepositoryService.getCustomerRepository().getById(id).getOrderHistory();
            List<FoodOrder> previousOrders = new ArrayList<>();
            for(Long orderID : orderIds) {
                previousOrders.add(RepositoryService.getOrderRepository().findById(orderID).orElseThrow(() -> new OrderNotFoundException(orderID)));
            }
            return previousOrders;
        }
        throw new CustomerNotFoundException(id);
    }

//    public void setFavoriteRestaurant (List<Long> newVar, Long id) throws CustomerNotFoundException, RestaurantNotFoundException {
//    }

//     public void setFavoriteItems setFavoriteItems (List<Long> newVar, Long id) throws CustomerNotFoundException, MenuItemNotFoundException {
//     }

}


