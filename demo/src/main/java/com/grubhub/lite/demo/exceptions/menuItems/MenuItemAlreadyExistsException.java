package com.grubhub.lite.demo.exceptions.menuItems;

public class MenuItemAlreadyExistsException extends RuntimeException {

    MenuItemAlreadyExistsException(Long id) {
        super("Menu Item " + id + " already exists");
    }
}
