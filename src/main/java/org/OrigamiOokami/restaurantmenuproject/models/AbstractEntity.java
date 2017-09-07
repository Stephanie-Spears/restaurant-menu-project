package org.OrigamiOokami.restaurantmenuproject.models;

abstract public class AbstractEntity {

    public final int itemId;
    protected enum Category {APPETIZER, MAIN_COURSE, DESSERT}


    AbstractEntity() {
            this.itemId = getNextId();
        }

    public int getId() {
            return itemId;
        }
    private static int index = 0;

    private static int getNextId() {
            return ++index;
        }


}
