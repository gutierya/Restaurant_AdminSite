package com.grubhub.lite.demo.controllers;

import com.grubhub.lite.demo.exceptions.order.OrderNotFoundException;
import com.grubhub.lite.demo.models.Driver;
import com.grubhub.lite.demo.models.MenuItem;
import com.grubhub.lite.demo.models.Payment;
import com.grubhub.lite.demo.services.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menuItems")
public class MenuController {
    private MenuItemService menuItemService;

    @Autowired
    public MenuController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    MenuController() { }

    /**
     * perspective - user interacting with client
     * create a menu item
     */
    @CrossOrigin
    @PostMapping("/menuItem")
    public void addAMenuItem(@RequestBody MenuItem menuItem, Long parentRestaurantID) {
        menuItemService.addMenuItem(menuItem,parentRestaurantID);
    }


    /**
     * perspective - user interacting with client
     * Get a menu item by id
     */
    @CrossOrigin
    @PutMapping(value = "/menuItem/{id}")
    public void updateAMenuItem( @PathVariable Long id, @RequestBody MenuItem menuDetails) {
        MenuItem updateMenuItem = menuItemService.getMenuItemById(id);
    }

    /**
     * perspective - admin
     * Get all menu items
     */
    @CrossOrigin
    @GetMapping("/")
    public List<MenuItem> listAllMenuItems() {
        return menuItemService.getMenuItems();
    }

}
