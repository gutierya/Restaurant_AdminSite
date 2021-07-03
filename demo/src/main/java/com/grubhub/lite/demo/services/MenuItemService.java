package com.grubhub.lite.demo.services;

import com.grubhub.lite.demo.exceptions.menuItems.MenuItemAlreadyExistsException;
import com.grubhub.lite.demo.exceptions.menuItems.MenuItemNotFoundException;
import com.grubhub.lite.demo.exceptions.restaurant.RestaurantNotFoundException;
import com.grubhub.lite.demo.models.Enums;
import com.grubhub.lite.demo.models.MenuItem;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuItemService {
    public MenuItem addMenuItem(MenuItem menuItem, Long id) throws MenuItemAlreadyExistsException {
        if (RepositoryService.getMenuItemRepository().existsById(menuItem.getId())) {
            throw new MenuItemAlreadyExistsException(menuItem.getId());
        }
        // add menu item to restaurant
        // RepositoryService.setRestaurantRepository(RepositoryService.getMenuItemRepository().save(id));

    }

    public MenuItem getMenuItemById(Long id) throws MenuItemNotFoundException {
        if (RepositoryService.getMenuItemRepository().existsById(id)) {
            return RepositoryService.getMenuItemRepository().getById(id);
        }
        throw new MenuItemNotFoundException(id);
    }

    public void setDescription (String newVar, Long id) throws MenuItemNotFoundException {
        if (RepositoryService.getMenuItemRepository().existsById(id)) {
            RepositoryService.getMenuItemRepository().getById(id).setDescription(newVar);
        }
        throw new MenuItemNotFoundException(id);
    }

    public String getDescription(Long id) throws MenuItemNotFoundException {
        if (RepositoryService.getMenuItemRepository().existsById(id)) {
            return RepositoryService.getMenuItemRepository().getById(id).getDescription();
        }
        throw new MenuItemNotFoundException(id);
    }

    public void setIngredients(List<String> newVar, Long id) throws MenuItemNotFoundException {
        if (RepositoryService.getMenuItemRepository().existsById(id)) {
            RepositoryService.getMenuItemRepository().getById(id).setIngredients(newVar);
        }
        throw new MenuItemNotFoundException(id);
    }

    public List<String> getIngredients(Long id) throws MenuItemNotFoundException {
        if (RepositoryService.getMenuItemRepository().existsById(id)) {
            return RepositoryService.getMenuItemRepository().getById(id).getIngredients();
        }
        throw new MenuItemNotFoundException(id);
    }

    public void setCalories (Integer newVar, Long id) throws MenuItemNotFoundException {
        if (RepositoryService.getMenuItemRepository().existsById(id)) {
            RepositoryService.getMenuItemRepository().getById(id).setCalories(newVar);
        }
        throw new MenuItemNotFoundException(id);
    }

    public Integer getCalories (Long id) throws MenuItemNotFoundException {
        if (RepositoryService.getMenuItemRepository().existsById(id)) {
            return RepositoryService.getMenuItemRepository().getById(id).getCalories();
        }
        throw new MenuItemNotFoundException(id);
    }

    public void setIsInStock (Boolean newVar, Long id) throws MenuItemNotFoundException {
        if (RepositoryService.getMenuItemRepository().existsById(id)) {
            RepositoryService.getMenuItemRepository().getById(id).setIsInStock(newVar);
        }
        throw new MenuItemNotFoundException(id);
    }

    public Boolean getIsInStock(Long id) throws MenuItemNotFoundException {
        if (RepositoryService.getMenuItemRepository().existsById(id)) {
            return RepositoryService.getMenuItemRepository().getById(id).getIsInStock();
        }
        throw new MenuItemNotFoundException(id);
    }

    public void setPrice (Double newVar, Long id) throws MenuItemNotFoundException {
        if (RepositoryService.getMenuItemRepository().existsById(id)) {
            RepositoryService.getMenuItemRepository().getById(id).setPrice(newVar);
        }
        throw new MenuItemNotFoundException(id);
    }

    public Double getPrice(Long id) throws MenuItemNotFoundException {
        if (RepositoryService.getMenuItemRepository().existsById(id)) {
            return RepositoryService.getMenuItemRepository().getById(id).getPrice();
        }
        throw new MenuItemNotFoundException(id);
    }

    public void setDietaryRestrictions(List<Enums.DietaryRestrictions> newVar, Long id) throws MenuItemNotFoundException {
        if (RepositoryService.getMenuItemRepository().existsById(id)) {
            RepositoryService.getMenuItemRepository().getById(id).setDietaryRestrictions(newVar);
        }
        throw new MenuItemNotFoundException(id);
    }

    public List<Enums.DietaryRestrictions> getDietaryRestrictions(Long id) throws MenuItemNotFoundException {
        if (RepositoryService.getMenuItemRepository().existsById(id)) {
            return RepositoryService.getMenuItemRepository().getById(id).getDietaryRestrictions();
        }
        throw new MenuItemNotFoundException(id);
    }

    public void setCategory (String newVar, Long id) throws MenuItemNotFoundException {
        if (RepositoryService.getMenuItemRepository().existsById(id)) {
            RepositoryService.getMenuItemRepository().getById(id).setCategory(newVar);
        }
        throw new MenuItemNotFoundException(id);
    }

    public String getCategory(Long id) throws MenuItemNotFoundException {
        if (RepositoryService.getMenuItemRepository().existsById(id)) {
            return RepositoryService.getMenuItemRepository().getById(id).getCategory();
        }
        throw new MenuItemNotFoundException(id);
    }

    public void setRestaurantID(Long newVar, Long id) throws RestaurantNotFoundException {
        if (RepositoryService.getRestaurantRepository().existsById(newVar)) {
            RepositoryService.getMenuItemRepository().getById(id).setRestaurantID(newVar);
        }
        throw new RestaurantNotFoundException(id);
    }

    public Long getRestaurantID(Long id) throws RestaurantNotFoundException {
        if (RepositoryService.getMenuItemRepository().existsById(id)) {
            return RepositoryService.getMenuItemRepository().getById(id).getRestaurantID();
        }
        throw new RestaurantNotFoundException(id);
    }

}
