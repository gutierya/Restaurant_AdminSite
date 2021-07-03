package com.grubhub.lite.demo.controllers;

import com.grubhub.lite.demo.exceptions.order.OrderNotFoundException;
import com.grubhub.lite.demo.models.FoodOrder;
import com.grubhub.lite.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Perspective - user client interaction
     * create an order
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public FoodOrder placeOrder(@RequestBody FoodOrder order) {
        return this.orderService.createOrder(order);
    }

    /**
     * get order by - order id
     */
    @GetMapping(value = "/byID/{orderId}")
    public FoodOrder getOrderByID(@PathVariable Long orderId) throws OrderNotFoundException {
        return this.orderService.getOrderById(orderId);
    }

    /**
     * Perspective - user to restaurant
     * cancel an order
     */
    @GetMapping(value = "/cancelOrder/{orderID}")
    public void cancelAnOrder(@PathVariable Long orderID) throws OrderNotFoundException {
        System.out.println("Order ID: " + orderID);
        this.orderService.cancelOrder(orderID);
    }

    /**
     * Perspective - user to restaurant
     * get expected completion time
     */
    @GetMapping(value = "/expectedCompletion/{orderID}")
    public void getExpectedCompletion(@PathVariable Long orderID) throws OrderNotFoundException {
        this.orderService.getExpectedCompletion(orderID);
    }

    /**
     * Perspective - user to restaurant
     * get created time
     */
    @GetMapping(value = "/createdTime/{orderID}")
    public void getCreatedTime(@PathVariable Long orderID) throws OrderNotFoundException {
        this.orderService.getCreatedTime(orderID);
    }

    /**
     * Perspective - user to restaurant
     * get restaurant ID
     */
    @GetMapping(value = "/sourceRestaurant/{orderID}")
    public void getRestaurantID(@PathVariable Long orderID) throws OrderNotFoundException {
        this.orderService.getSourceRestaurantID(orderID);
    }

    /**
     * Perspective - user to restaurant
     * get delivery driver ID
     */
    @GetMapping(value = "/driver/{orderID}")
    public void getDelivererID(@PathVariable Long orderID) throws OrderNotFoundException {
        this.orderService.getDeliveryDriverID(orderID);
    }

    @GetMapping("/")
    public List<FoodOrder> getAllOrders() {
        return orderService.getAllOrders();
    }



}
