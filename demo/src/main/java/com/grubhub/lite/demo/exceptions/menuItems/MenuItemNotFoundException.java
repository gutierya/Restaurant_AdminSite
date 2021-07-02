package com.grubhub.lite.demo.exceptions.menuItems;

public class MenuItemNotFoundException extends RuntimeException {
    public MenuItemNotFoundException(Long id) {
        super("Menu Item " + id + " not found");
    }
}
