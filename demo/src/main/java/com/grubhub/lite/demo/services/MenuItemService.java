package com.grubhub.lite.demo.services;

import com.grubhub.lite.demo.exceptions.menuItems.MenuItemAlreadyExistsException;
import com.grubhub.lite.demo.exceptions.menuItems.MenuItemNotFoundException;
import com.grubhub.lite.demo.exceptions.restaurant.RestaurantNotFoundException;
import com.grubhub.lite.demo.models.Driver;
import com.grubhub.lite.demo.models.Enums;
import com.grubhub.lite.demo.models.MenuItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuItemService {

    @Autowired
    private ApplicationContext context;

    private final RepositoryService repositoryService;
    private static final Logger log = LoggerFactory.getLogger(MenuItemService.class);


    MenuItemService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
        log.info( this.getClass() + " Service: UP");

    }

    public List<MenuItem> getMenuItems() {
        return repositoryService.getMenuItemRepository().findAll();
    }

    public MenuItem addMenuItem(MenuItem menuItem, Long parentRestaurantId) throws MenuItemAlreadyExistsException {
        if (repositoryService.getMenuItemRepository().findAll().contains(menuItem)) {
            throw new MenuItemAlreadyExistsException(menuItem.getId());
        }
         //add menu item to restaurant
         var parentRestaurant =  repositoryService.getRestaurantRepository().getById(parentRestaurantId);
        parentRestaurant.getMenu().add(menuItem.getId());
        repositoryService.getMenuItemRepository().save(menuItem);
        return menuItem;
    }

    public MenuItem getMenuItemById(Long id) throws MenuItemNotFoundException {
        if (repositoryService.getMenuItemRepository().existsById(id)) {
            return repositoryService.getMenuItemRepository().getById(id);
        }
        throw new MenuItemNotFoundException(id);
    }

    public void setDescription (String newVar, Long id) throws MenuItemNotFoundException {
        if (repositoryService.getMenuItemRepository().existsById(id)) {
            repositoryService.getMenuItemRepository().getById(id).setDescription(newVar);
        }
        throw new MenuItemNotFoundException(id);
    }

    public String getDescription(Long id) throws MenuItemNotFoundException {
        if (repositoryService.getMenuItemRepository().existsById(id)) {
            return repositoryService.getMenuItemRepository().getById(id).getDescription();
        }
        throw new MenuItemNotFoundException(id);
    }

    public void setIngredients(List<String> newVar, Long id) throws MenuItemNotFoundException {
        if (repositoryService.getMenuItemRepository().existsById(id)) {
            repositoryService.getMenuItemRepository().getById(id).setIngredients(newVar);
        }
        throw new MenuItemNotFoundException(id);
    }

    public List<String> getIngredients(Long id) throws MenuItemNotFoundException {
        if (repositoryService.getMenuItemRepository().existsById(id)) {
            return repositoryService.getMenuItemRepository().getById(id).getIngredients();
        }
        throw new MenuItemNotFoundException(id);
    }

    public void setCalories (Integer newVar, Long id) throws MenuItemNotFoundException {
        if (repositoryService.getMenuItemRepository().existsById(id)) {
            repositoryService.getMenuItemRepository().getById(id).setCalories(newVar);
        }
        throw new MenuItemNotFoundException(id);
    }

    public Integer getCalories (Long id) throws MenuItemNotFoundException {
        if (repositoryService.getMenuItemRepository().existsById(id)) {
            return repositoryService.getMenuItemRepository().getById(id).getCalories();
        }
        throw new MenuItemNotFoundException(id);
    }

    public void setIsInStock (Boolean newVar, Long id) throws MenuItemNotFoundException {
        if (repositoryService.getMenuItemRepository().existsById(id)) {
            repositoryService.getMenuItemRepository().getById(id).setIsInStock(newVar);
        }
        throw new MenuItemNotFoundException(id);
    }

    public Boolean getIsInStock(Long id) throws MenuItemNotFoundException {
        if (repositoryService.getMenuItemRepository().existsById(id)) {
            return repositoryService.getMenuItemRepository().getById(id).getIsInStock();
        }
        throw new MenuItemNotFoundException(id);
    }

    public void setPrice (Double newVar, Long id) throws MenuItemNotFoundException {
        if (repositoryService.getMenuItemRepository().existsById(id)) {
            repositoryService.getMenuItemRepository().getById(id).setPrice(newVar);
        }
        throw new MenuItemNotFoundException(id);
    }

    public Double getPrice(Long id) throws MenuItemNotFoundException {
        if (repositoryService.getMenuItemRepository().existsById(id)) {
            return repositoryService.getMenuItemRepository().getById(id).getPrice();
        }
        throw new MenuItemNotFoundException(id);
    }

    public void setDietaryRestrictions(Enums.DietaryRestrictions newVar, Long id) throws MenuItemNotFoundException {
        if (repositoryService.getMenuItemRepository().existsById(id)) {
            repositoryService.getMenuItemRepository().getById(id).setDietaryRestrictions(newVar);
        }
        throw new MenuItemNotFoundException(id);
    }

    public Enums.DietaryRestrictions getDietaryRestrictions(Long id) throws MenuItemNotFoundException {
        if (repositoryService.getMenuItemRepository().existsById(id)) {
            return repositoryService.getMenuItemRepository().getById(id).getDietaryRestrictions();
        }
        throw new MenuItemNotFoundException(id);
    }

    public void setCategory (String newVar, Long id) throws MenuItemNotFoundException {
        if (repositoryService.getMenuItemRepository().existsById(id)) {
            repositoryService.getMenuItemRepository().getById(id).setCategory(newVar);
        }
        throw new MenuItemNotFoundException(id);
    }

    public String getCategory(Long id) throws MenuItemNotFoundException {
        if (repositoryService.getMenuItemRepository().existsById(id)) {
            return repositoryService.getMenuItemRepository().getById(id).getCategory();
        }
        throw new MenuItemNotFoundException(id);
    }

    public void setRestaurantID(Long newVar, Long id) throws RestaurantNotFoundException {
        if (repositoryService.getRestaurantRepository().existsById(newVar)) {
            repositoryService.getMenuItemRepository().getById(id).setRestaurantID(newVar);
        }
        throw new RestaurantNotFoundException(id);
    }

    public Long getRestaurantID(Long id) throws RestaurantNotFoundException {
        if (repositoryService.getMenuItemRepository().existsById(id)) {
            return repositoryService.getMenuItemRepository().getById(id).getRestaurantID();
        }
        throw new RestaurantNotFoundException(id);
    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    public MenuItem updateMenuItem(Long id, MenuItem menuDetails) {
        if(repositoryService.getMenuItemRepository().existsById(id)) {
            MenuItem current = repositoryService.getMenuItemRepository().findById(id).orElseThrow(()-> new MenuItemNotFoundException(id));
            menuDetails.setId(current.getId());
            menuDetails.setRestaurantID(current.getRestaurantID());
            repositoryService.getMenuItemRepository().save(menuDetails);
            return menuDetails;
        }
        throw new RestaurantNotFoundException(id);
    }
}
