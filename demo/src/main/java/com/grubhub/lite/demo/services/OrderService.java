package com.grubhub.lite.demo.services;
import com.grubhub.lite.demo.Repo.OrderRepo;

import com.grubhub.lite.demo.exceptions.customer.CustomerAlreadyExistsException;
import com.grubhub.lite.demo.exceptions.order.OrderAlreadyExistsException;
import com.grubhub.lite.demo.exceptions.order.OrderNotFoundException;
import com.grubhub.lite.demo.exceptions.order.OrderUnableToCancelException;
import com.grubhub.lite.demo.models.Enums;
import com.grubhub.lite.demo.models.Order;
import com.grubhub.lite.demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void setOrderRepository(OrderRepository orderRepo) {
        this.orderRepository = orderRepo;
    }

    public Order createOrder(Order order) throws OrderAlreadyExistsException {
        if (orderRepository.existsById(order.getOrderID())) {
            throw new CustomerAlreadyExistsException(order.getOrderID());
        }
        return orderRepository.save(order);
    }

    public Order getOrderById(long id) throws OrderNotFoundException {
        if (orderRepository.existsById(id)) {
            return orderRepository.getById(id);
        }
        throw new OrderNotFoundException(id);
    }

    public void cancelOrder(long id) throws OrderUnableToCancelException, OrderNotFoundException {
        if (!orderRepository.existsById(id) || getOrderById(id).getStatus().ordinal() >= Enums.OrderStatus.Cooking.ordinal() ) {
            throw new OrderUnableToCancelException(id);
        }
        else{
            getOrderById(id).setStatus(Enums.OrderStatus.Cancelled);
            orderRepository.delete(getOrderById(id));
        }
    }

}
