package com.grubhub.lite.demo.exceptions.menuItems;

public class MenuItemNotFoundException extends RuntimeException {
    MenuItemNotFoundException(Long id) {
        super("Menu Item " + id + " not found");
    }
}
