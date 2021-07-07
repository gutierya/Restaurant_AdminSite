package com.grubhub.lite.demo.services;

import com.grubhub.lite.demo.exceptions.GlobalException;
import com.grubhub.lite.demo.exceptions.restaurant.RestaurantNotFoundException;
import com.grubhub.lite.demo.models.Enums;
import com.grubhub.lite.demo.models.MenuItem;
import com.grubhub.lite.demo.models.Restaurant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private ApplicationContext context;

    private final RepositoryService repositoryService;
    private static final Logger log = LoggerFactory.getLogger(RestaurantService.class);


    RestaurantService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
        log.info( this.getClass() + " Service: UP");

    }



    public Restaurant getRestaurantByid(Long id) throws RestaurantNotFoundException {
        if (repositoryService.getRestaurantRepository().existsById(id)) {
            return repositoryService.getRestaurantRepository().findById(id).orElseThrow(()-> new RestaurantNotFoundException(id));
        }
        throw new RestaurantNotFoundException(id);
    }

    public List<Restaurant> getRating(Short rating) throws RestaurantNotFoundException {
        if (repositoryService.getRestaurantRepository().count() > 0) {
            ArrayList<Restaurant> matchedRestaurants = new ArrayList<>();
            for(var element:  repositoryService.getRestaurantRepository().findAll()) {
                if(element.getRating() >= rating)
                    matchedRestaurants.add(element);
            }
            return matchedRestaurants;
        }
        throw new GlobalException("Restaurant DB is empty");
    }

    public Date getTimeOpen(Long id) throws RestaurantNotFoundException {
        if (repositoryService.getRestaurantRepository().existsById(id)) {
            return repositoryService.getRestaurantRepository().getById(id).getTimeOpen();
        }
        throw new RestaurantNotFoundException(id);
    }

    public Date getTimeClose(Long id) throws RestaurantNotFoundException {
        if (repositoryService.getRestaurantRepository().existsById(id)) {
            return repositoryService.getRestaurantRepository().getById(id).getTimeClose();
        }
        throw new RestaurantNotFoundException(id);
    }

    public Double getAverageWaitTime(Long id) throws RestaurantNotFoundException {
        if (repositoryService.getRestaurantRepository().existsById(id)) {
            return repositoryService.getRestaurantRepository().getById(id).getAverageWaitTime();
        }
        throw new RestaurantNotFoundException(id);
    }

    public void setRating(Short newVar, Long id) throws RestaurantNotFoundException {
        if (repositoryService.getRestaurantRepository().existsById(id)) {
            repositoryService.getRestaurantRepository().getById(id).setRating(newVar);
        }
        throw new RestaurantNotFoundException(id);
    }

    public void setAddress (String newVar, Long id) throws RestaurantNotFoundException {
        if (repositoryService.getRestaurantRepository().existsById(id)) {
            repositoryService.getRestaurantRepository().getById(id).setAddress(newVar);
        }
        throw new RestaurantNotFoundException(id);
    }

    public String getAddress(Long id) throws RestaurantNotFoundException {
        if (repositoryService.getRestaurantRepository().existsById(id)) {
            return repositoryService.getRestaurantRepository().getById(id).getAddress();
        }
        throw new RestaurantNotFoundException(id);
    }

    public void setIsOpen (Boolean newVar, Long id) throws RestaurantNotFoundException {
        if (repositoryService.getRestaurantRepository().existsById(id)) {
            repositoryService.getRestaurantRepository().getById(id).setIsOpen(newVar);
        }
        throw new RestaurantNotFoundException(id);
    }

    public Boolean getIsOpen (Long id) throws RestaurantNotFoundException {
        if (repositoryService.getRestaurantRepository().existsById(id)) {
            return repositoryService.getRestaurantRepository().getById(id).getIsOpen();
        }
        throw new RestaurantNotFoundException(id);
    }

    public List<Restaurant> getByIsOpen () throws RestaurantNotFoundException {
        if (repositoryService.getRestaurantRepository().count() > 0) {
            ArrayList<Restaurant> openRestaurants = new ArrayList<>();
            repositoryService.getRestaurantRepository().findAll().forEach(restaurant -> {
                if (restaurant.getIsOpen()) {
                    openRestaurants.add(restaurant);
                }
            });
            return openRestaurants;


        } else {
            throw new GlobalException("Restaurant DB is empty");

        }
    }

    public void setTimeOpen (Date newVar, Long id) throws RestaurantNotFoundException {
        if (repositoryService.getRestaurantRepository().existsById(id)) {
            repositoryService.getRestaurantRepository().getById(id).setTimeOpen(newVar);
        }
        throw new RestaurantNotFoundException(id);
    }

    public void setTimeClose (Date newVar, Long id) throws RestaurantNotFoundException {
        if (repositoryService.getRestaurantRepository().existsById(id)) {
            repositoryService.getRestaurantRepository().getById(id).setTimeClose(newVar);
        }
        throw new RestaurantNotFoundException(id);
    }

    public void setType (Enums.Cuisine newVar, Long id) throws RestaurantNotFoundException {
        if (repositoryService.getRestaurantRepository().existsById(id)) {
            repositoryService.getRestaurantRepository().getById(id).setType(newVar);
        }
        throw new RestaurantNotFoundException(id);
    }

    public Enums.Cuisine getType (Long id) throws RestaurantNotFoundException {
        if (repositoryService.getRestaurantRepository().existsById(id)) {
            return repositoryService.getRestaurantRepository().getById(id).getType();
        }
        throw new RestaurantNotFoundException(id);
    }

    public List<Restaurant> getByType(Enums.Cuisine cuisine) {
        if(repositoryService.getRestaurantRepository().count() > 0) {
            ArrayList<Restaurant> cuisineRestaurants = new ArrayList<>();
            repositoryService.getRestaurantRepository().findAll().forEach((restaurant -> {
                if(restaurant.getType() == cuisine) {
                    cuisineRestaurants.add(restaurant);
                }
            }));
            return cuisineRestaurants;
        }
        else throw new GlobalException("Restaurant Database is empty");
     }

    public void setAverageWaitTime (Double newVar, Long id) throws RestaurantNotFoundException {
        if (repositoryService.getRestaurantRepository().existsById(id)) {
            repositoryService.getRestaurantRepository().getById(id).setAverageWaitTime(newVar);
        }
        throw new RestaurantNotFoundException(id);
    }

    public void setValueProposition (Enums.ValueProp newVar, Long id) throws RestaurantNotFoundException {
        if (repositoryService.getRestaurantRepository().existsById(id)) {
            repositoryService.getRestaurantRepository().getById(id).setValueProposition(newVar);
        }
        throw new RestaurantNotFoundException(id);
    }

    public Enums.ValueProp getValueProposition(Long id) throws RestaurantNotFoundException {
        if (repositoryService.getRestaurantRepository().existsById(id)) {
            return repositoryService.getRestaurantRepository().getById(id).getValueProposition();
        }
        throw new RestaurantNotFoundException(id);
    }

    public void setMenu (List<Long> newVar, Long id) throws RestaurantNotFoundException {
        if (repositoryService.getRestaurantRepository().existsById(id)) {
            repositoryService.getRestaurantRepository().getById(id).setMenu(newVar);
        }
        throw new RestaurantNotFoundException(id);
    }

    public List<Long> getMenu(Long id) throws RestaurantNotFoundException {
        if (repositoryService.getRestaurantRepository().existsById(id)) {
            return repositoryService.getRestaurantRepository().getById(id).getMenu();
        }
        throw new RestaurantNotFoundException(id);
    }

    public void setOffersTakeout (Boolean newVar, Long id) throws RestaurantNotFoundException {
        if (repositoryService.getRestaurantRepository().existsById(id)) {
            repositoryService.getRestaurantRepository().getById(id).setOffersTakeout(newVar);
        }
        throw new RestaurantNotFoundException(id);
    }

    public Boolean getOffersTakeout(Long id) throws RestaurantNotFoundException {
        if (repositoryService.getRestaurantRepository().existsById(id)) {
            return repositoryService.getRestaurantRepository().getById(id).getOffersTakeout();
        }
        throw new RestaurantNotFoundException(id);
    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    public List<Restaurant> getRestaurants() {
        return repositoryService.getRestaurantRepository().findAll();
    }

    public List<Restaurant> getByValueProposition(Enums.ValueProp valueProp) {
        if(repositoryService.getRestaurantRepository().count() > 0){
            ArrayList<Restaurant> matchedRestaurants = new ArrayList<>();
            for(var element : repositoryService.getRestaurantRepository().findAll()) {
                if(element.getValueProposition() == valueProp) {
                    matchedRestaurants.add(element);
                }
            }
            return matchedRestaurants;
        }
        throw new GlobalException("Restaurant DB is empty");
    }

    public List<Restaurant> getByRestrictions(List<Enums.DietaryRestrictions> restrictions) {
        if(repositoryService.getRestaurantRepository().count() > 0) {
            ArrayList<Restaurant> matchedRestaurants = new ArrayList<>();
            for(Restaurant restaurant : repositoryService.getRestaurantRepository().findAll()) {
                if(restaurant.getDietaryRestrictions().containsAll(restrictions)) {
                    matchedRestaurants.add(restaurant);
                }
            }
            return matchedRestaurants;

        }
        throw new GlobalException("Empty Restaurant DB");

    }

    public List<MenuItem> getRestaurantMenu(Long restaurantID) {
        if(repositoryService.getRestaurantRepository().existsById(restaurantID)) {
            List<Long> menuItemIDs = repositoryService.getRestaurantRepository().findById(restaurantID).orElseThrow(
                    () -> new RestaurantNotFoundException(restaurantID)).getMenu();
            List<MenuItem> menuItems = new ArrayList<>();
            for(MenuItem item : repositoryService.getMenuItemRepository().findAll()) {
                if(menuItemIDs.contains(item.getId())) {
                    menuItems.add(item);
                }
            }
            return menuItems;
        } else throw new RestaurantNotFoundException(restaurantID);
    }

    public MenuItem addItemToRestaurantMenu(Long restaurantID, MenuItem newItem) {
        if (repositoryService.getRestaurantRepository().existsById(restaurantID)) {
            MenuItem savedItem = repositoryService.getMenuItemRepository().save(newItem);
            Restaurant parentRestaurant = repositoryService.getRestaurantRepository().findById(restaurantID).orElseThrow(
                    () -> new RestaurantNotFoundException(restaurantID));
            parentRestaurant.getMenu().add(savedItem.getId());
            repositoryService.getRestaurantRepository().save(parentRestaurant);
            return savedItem;
        } else {
            throw new RestaurantNotFoundException(restaurantID);
        }
    }

    public void deleteRestaurant(Long id) {
        repositoryService.getRestaurantRepository().deleteById(id);
    }
}
