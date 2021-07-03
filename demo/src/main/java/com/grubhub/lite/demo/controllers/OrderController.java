package com.grubhub.lite.demo.controllers;

import com.grubhub.lite.demo.exceptions.order.OrderNotFoundException;
import com.grubhub.lite.demo.models.FoodOrder;
import com.grubhub.lite.demo.repositories.UserRepository;
import com.grubhub.lite.demo.repositories.OrderRepository;
import com.grubhub.lite.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Perspective - user client interaction
     * create an order
     */
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public FoodOrder placeOrder(@RequestBody FoodOrder order) {
        return this.orderService.createOrder(order);
    }

    /**
     * get order by - order id
     */
    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public FoodOrder getOrderByID(@PathVariable("orderID") Long orderId) throws OrderNotFoundException {
        return this.orderService.getOrderById(orderId);
    }

    /**
     * Perspective - user to restaurant
     * cancel an order
     */
    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.POST)
    public void cancelAnOrder(@PathVariable("orderId") Long orderId) throws OrderNotFoundException {
        this.orderService.cancelOrder(orderId);
    }

    /**
     * Perspective - user to restaurant
     * get expected completion time
     */
    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET)
    public void getExpectedCompletion(@PathVariable("orderId") Long orderId) throws OrderNotFoundException {
        this.orderService.getExpectedCompletion(orderId);
    }

    /**
     * Perspective - user to restaurant
     * get created time
     */
    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET)
    public void getCreatedTime(@PathVariable("orderId") Long orderId) throws OrderNotFoundException {
        this.orderService.getCreatedTime(orderId);
    }

    /**
     * Perspective - user to restaurant
     * get restaurant ID
     */
    @RequestMapping(value = "/order/{Id}", method = RequestMethod.GET)
    public void getRestaurantID(@PathVariable("Id") Long Id) throws OrderNotFoundException {
        this.orderService.getSourceRestaurantID(Id);
    }

    /**
     * Perspective - user to restaurant
     * get delivery driver ID
     */
    @RequestMapping(value = "/order/{Id}", method = RequestMethod.GET)
    public void getDelivererID(@PathVariable("Id") Long Id) throws OrderNotFoundException {
        this.orderService.getDeliveryDriverID(Id);
    }



}
