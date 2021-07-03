package com.grubhub.lite.demo.services;

import com.grubhub.lite.demo.exceptions.customer.CustomerNotFoundException;
import com.grubhub.lite.demo.exceptions.driver.DriverNotFoundException;
import com.grubhub.lite.demo.exceptions.order.OrderAlreadyExistsException;
import com.grubhub.lite.demo.exceptions.order.OrderNotFoundException;
import com.grubhub.lite.demo.exceptions.order.OrderUnableToCancelException;
import com.grubhub.lite.demo.exceptions.restaurant.RestaurantNotFoundException;
import com.grubhub.lite.demo.models.Enums;
import com.grubhub.lite.demo.models.FoodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import java.util.Date;


@Service
public class OrderService {

    @Autowired
    private ApplicationContext context;

    private final RepositoryService repositoryService;
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);


    OrderService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
        log.info( this.getClass() + " Service: UP");

    }

    public FoodOrder createOrder(FoodOrder order) throws OrderAlreadyExistsException {
        if (repositoryService.getOrderRepository().existsById(order.getId())){
            throw new OrderAlreadyExistsException(order.getId());
        }
        return repositoryService.getOrderRepository().save(order);
    }

    public FoodOrder getOrderById(Long id) throws OrderNotFoundException {
        if (repositoryService.getOrderRepository().existsById(id)) {
            return repositoryService.getOrderRepository().getById(id);
        }
        throw new OrderNotFoundException(id);
    }

    public void cancelOrder(Long id) throws OrderUnableToCancelException, OrderNotFoundException {
        if (!repositoryService.getOrderRepository().existsById(id) || repositoryService.getOrderRepository().getById(id).getStatus().ordinal() >= Enums.OrderStatus.Cooking.ordinal() ) {
            throw new OrderUnableToCancelException(id);
        }
        else{
            repositoryService.getOrderRepository().getById(id).setStatus(Enums.OrderStatus.Cancelled);
            repositoryService.getOrderRepository().delete(repositoryService.getOrderRepository().getById(id));
        }
    }

    public Date getExpectedCompletion(Long id) throws OrderNotFoundException {
        if (repositoryService.getOrderRepository().existsById(id)) {
            return repositoryService.getOrderRepository().getById(id).getExpectedCompletion();
        }
        throw new OrderNotFoundException(id);
    }

    public Date getCreatedTime (Long id) throws OrderNotFoundException {
        if (repositoryService.getOrderRepository().existsById(id)) {
            return repositoryService.getOrderRepository().getById(id).getCreatedTime();
        }
        throw new OrderNotFoundException(id);
    }

    public void setExpectedCompletion (Date newVar, Long id) throws OrderNotFoundException {
        if (repositoryService.getOrderRepository().existsById(id)) {
            repositoryService.getOrderRepository().getById(id).setExpectedCompletion(newVar);
        }
        throw new OrderNotFoundException(id);
    }

    public void setCreatedTime (Date newVar, Long id) throws OrderNotFoundException {
        if (repositoryService.getOrderRepository().existsById(id)) {
            repositoryService.getOrderRepository().getById(id).setCreatedTime(newVar);
        }
        throw new OrderNotFoundException(id);
    }

    public void setSourceRestaurantID (Long newVar, Long id) throws RestaurantNotFoundException, OrderNotFoundException {
        if (!repositoryService.getRestaurantRepository().existsById(newVar) ) {
            throw new RestaurantNotFoundException(newVar);
        }
        if (!repositoryService.getOrderRepository().existsById(id)) {
            throw new OrderNotFoundException(id);
        }
        repositoryService.getOrderRepository().getById(id).setSourceRestaurantID(newVar);
    }

    public Long getSourceRestaurantID(Long id) throws OrderNotFoundException {
        if (!repositoryService.getOrderRepository().existsById(id)) {
            throw new OrderNotFoundException(id);
        }
        return repositoryService.getOrderRepository().getById(id).getSourceRestaurantID(id);
    }

    public void setDeliveryDriverID (Long newVar, Long id) throws OrderNotFoundException, DriverNotFoundException {
        if (!repositoryService.getOrderRepository().existsById(id)) {
            throw new OrderNotFoundException(id);
        }
        if (!repositoryService.getDriverRepository().existsById(newVar)) {
            throw new DriverNotFoundException(newVar);
        }
        repositoryService.getOrderRepository().getById(id).setDeliveryDriverID(newVar);
    }

    public Long getDeliveryDriverID(Long id) throws OrderNotFoundException {
        if (!repositoryService.getOrderRepository().existsById(id)) {
            throw new OrderNotFoundException(id);
        }
        return repositoryService.getOrderRepository().getById(id).getDeliveryDriverID();
    }

    public void setDestUserID (Long newVar, Long id) throws OrderNotFoundException {
        if (!repositoryService.getOrderRepository().existsById(id)) {
            throw new OrderNotFoundException(id);
        }
        repositoryService.getOrderRepository().getById(id).setDestUserID(newVar);
    }

    public Long getDestUserID(Long id) throws OrderNotFoundException {
        if (!repositoryService.getOrderRepository().existsById(id)) {
            throw new OrderNotFoundException(id);
        }
        return repositoryService.getOrderRepository().getById(id).getDestUserID();
    }

    public void setTax (double newVar, Long id) throws OrderNotFoundException  {
        if (!repositoryService.getOrderRepository().existsById(id)) {
            throw new OrderNotFoundException(id);
        }
        repositoryService.getOrderRepository().getById(id).setTax(newVar);
    }

    public double getTax(Long id) throws OrderNotFoundException {
        if (!repositoryService.getOrderRepository().existsById(id)) {
            throw new OrderNotFoundException(id);
        }
        return repositoryService.getOrderRepository().getById(id).getTax();
    }

    public void setCustomerID(Long newVar, Long id) throws OrderNotFoundException, CustomerNotFoundException {
        if (!repositoryService.getCustomerRepository().existsById(newVar)) {
            throw new CustomerNotFoundException(newVar);
        }
        if (!repositoryService.getOrderRepository().existsById(id)) {
            throw new OrderNotFoundException(id);
        }
        repositoryService.getOrderRepository().getById(id).setCustomerID(newVar);
    }

    public Long getCustomerID(Long id) throws OrderNotFoundException {
        if (!repositoryService.getOrderRepository().existsById(id)) {
            throw new OrderNotFoundException(id);
        }
        return repositoryService.getOrderRepository().getById(id).getCustomerID();
    }

    public void setTipAmount(Double newVar, Long id) throws OrderNotFoundException {
        if (!repositoryService.getOrderRepository().existsById(id)) {
            throw new OrderNotFoundException(id);
        }
        repositoryService.getOrderRepository().getById(id).setTipAmount(newVar);
    }

    public Double getTipAmount(Long id) throws OrderNotFoundException {
        if (!repositoryService.getOrderRepository().existsById(id)) {
            throw new OrderNotFoundException(id);
        }
        return repositoryService.getOrderRepository().getById(id).getTipAmount();
    }

    public void setPaymentID (Long newVar, Long id) throws OrderNotFoundException {
        if (!repositoryService.getOrderRepository().existsById(id)) {
            throw new OrderNotFoundException(id);
        }
        repositoryService.getOrderRepository().getById(id).setPaymentID(newVar);
    }

    public Long getPaymentID(Long id) throws OrderNotFoundException{
        if (!repositoryService.getOrderRepository().existsById(id)) {
            throw new OrderNotFoundException(id);
        }
        return repositoryService.getOrderRepository().getById(id).getPaymentID();
    }

    // public void setItems (List<Long> newVar) throws MenuItemNotFoundException

    //    public List<Long> getItems (Long id) throws OrderNotFoundException {
    //        if (!RepositoryService.getOrderRepository().existsById(id)) {
    //            throw new OrderNotFoundException(id);
    //        }
    //    }

    // public void setOrderSubTotal (double newVar)

    //  public double getOrderSubTotal ()


    public void setContext(ApplicationContext context) {
        this.context = context;
    }
}
