package com.grubhub.lite.demo.services;

import com.grubhub.lite.demo.exceptions.customer.CustomerAlreadyExistsException;
import com.grubhub.lite.demo.exceptions.order.OrderAlreadyExistsException;
import com.grubhub.lite.demo.exceptions.order.OrderNotFoundException;
import com.grubhub.lite.demo.exceptions.order.OrderUnableToCancelException;
import com.grubhub.lite.demo.models.Enums;
import com.grubhub.lite.demo.models.FoodOrder;
import com.grubhub.lite.demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void setOrderRepository(OrderRepository orderRepo) {
        this.orderRepository = orderRepo;
    }

    public FoodOrder createOrder(FoodOrder order) throws OrderAlreadyExistsException {
        if (orderRepository.existsById(order.getId())){
            throw new CustomerAlreadyExistsException(order.getId());
        }
        return orderRepository.save(order);
    }

    public FoodOrder getOrderById(long id) throws OrderNotFoundException {
        if (orderRepository.existsById(id)) {
            return orderRepository.getById(id);
        }
        throw new OrderNotFoundException(id);
    }

    public void cancelOrder(long id) throws OrderUnableToCancelException, OrderNotFoundException {
        if (!orderRepository.existsById(id) || orderRepository.getById(id).getStatus().ordinal() >= Enums.OrderStatus.Cooking.ordinal() ) {
            throw new OrderUnableToCancelException(id);
        }
        else{
            orderRepository.getById(id).setStatus(Enums.OrderStatus.Cancelled);
            orderRepository.delete(orderRepository.getById(id));
        }
    }

    public Date getExpectedCompletion(long id) throws OrderNotFoundException {
        if (orderRepository.existsById(id)) {
            return orderRepository.getById(id).getExpectedCompletion();
        }
        throw new OrderNotFoundException(id);
    }

    public Date getCreatedTime (long id) throws OrderNotFoundException {
        if (orderRepository.existsById(id)) {
            return orderRepository.getById(id).getCreatedTime();
        }
        throw new OrderNotFoundException(id);
    }

}
