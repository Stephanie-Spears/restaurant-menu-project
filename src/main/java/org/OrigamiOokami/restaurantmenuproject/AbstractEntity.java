package org.OrigamiOokami.restaurantmenuproject;

abstract public class AbstractEntity {
    protected int id;
    public AbstractEntity() {
        this.id = getNextId();
    }

    public int getId() {
        return id;
    }
    protected static int index = 0;

    protected static int getNextId() {
        return ++index;
    }
}
