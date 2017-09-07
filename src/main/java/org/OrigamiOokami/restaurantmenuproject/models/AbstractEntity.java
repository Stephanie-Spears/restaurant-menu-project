package org.OrigamiOokami.restaurantmenuproject.models;

abstract public class AbstractEntity {

    public final int itemId;
    protected enum Category {APPETIZER, MAIN_COURSE, DESSERT}


    public AbstractEntity() {
            this.itemId = getNextId();
        }

    public int getId() {
            return itemId;
        }
    public static int index = 0;

    public static int getNextId() {
            return ++index;
        }


}
