package org.OrigamiOokami.restaurantmenuproject.models;

public enum ItemCategory {
    APPETIZER("Appetizer"),
    MAIN_COURSE("Main Course"),
    DESSERT("Dessert");

    private final String name;
    ItemCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
