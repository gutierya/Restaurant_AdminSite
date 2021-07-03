package com.grubhub.lite.demo.services;

import com.grubhub.lite.demo.exceptions.restaurant.RestaurantNotFoundException;
import com.grubhub.lite.demo.models.Enums;
import com.grubhub.lite.demo.models.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private ApplicationContext context;

    private final RepositoryService repositoryService = context.getBean(RepositoryService.class);

    public Restaurant getRestaurantByid(Long id) throws RestaurantNotFoundException {
        if (repositoryService.getRestaurantRepository().existsById(id)) {
            return repositoryService.getRestaurantRepository().getById(id);
        }
        throw new RestaurantNotFoundException(id);
    }

    public Short getRating(Long id) throws RestaurantNotFoundException {
        if (repositoryService.getRestaurantRepository().existsById(id)) {
            return repositoryService.getRestaurantRepository().getById(id).getRating();
        }
        throw new RestaurantNotFoundException(id);
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
}
