package com.grubhub.lite.demo.services;

import com.grubhub.lite.demo.exceptions.customer.CustomerAlreadyExistsException;
import com.grubhub.lite.demo.exceptions.order.OrderAlreadyExistsException;
import com.grubhub.lite.demo.exceptions.order.OrderNotFoundException;
import com.grubhub.lite.demo.exceptions.order.OrderUnableToCancelException;
import com.grubhub.lite.demo.models.Enums;
import com.grubhub.lite.demo.models.FoodOrder;
import com.grubhub.lite.demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private ApplicationContext context;

    private final RepositoryService repositoryService = context.getBean(RepositoryService.class);

    public FoodOrder createOrder(FoodOrder order) throws OrderAlreadyExistsException {
        if (repositoryService.getOrderRepository().existsById(order.getId())) {
            throw new CustomerAlreadyExistsException(order.getId());
        }
        return repositoryService.getOrderRepository().save(order);
    }

    public FoodOrder getOrderById(long id) throws OrderNotFoundException {
        if (repositoryService.getOrderRepository().existsById(id)) {
            return repositoryService.getOrderRepository().getById(id);
        }
        throw new OrderNotFoundException(id);
    }

    public void cancelOrder(long id) throws OrderUnableToCancelException, OrderNotFoundException {
        if (!repositoryService.getOrderRepository().existsById(id) || getOrderById(id).getStatus().ordinal() >= Enums.OrderStatus.Cooking.ordinal() ) {
            throw new OrderUnableToCancelException(id);
        }
        else{
            getOrderById(id).setStatus(Enums.OrderStatus.Cancelled);
            repositoryService.getOrderRepository().delete(getOrderById(id));
        }
    }

}
