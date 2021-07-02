package com.grubhub.lite.demo.exceptions.menuItems;

public class MenuItemNotAvailableException extends RuntimeException {

    public MenuItemNotAvailableException(Long id) {
        super("Menu item " + id  + " currently not available");
    }
}
