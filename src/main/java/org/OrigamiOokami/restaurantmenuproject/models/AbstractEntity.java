package org.OrigamiOokami.restaurantmenuproject.models;

import javax.validation.constraints.NotNull;

public abstract class AbstractEntity {
    /*Consider using abstract classes if any of these statements apply to your situation:
You want to share code among several closely related classes.
You expect that classes that extend your abstract class have many common methods or fields, or require access modifiers other than public (such as protected and private).
You want to declare non-static or non-final fields. This enables you to define methods that can access and modify the state of the object to which they belong.*/

//    public final int itemId;
////    protected enum Category {APPETIZER, MAIN_COURSE, DESSERT}
//
//
//    AbstractEntity() {
//            this.itemId = getNextId();
//        }
//
//    public int getId() {
//            return itemId;
//        }
//    private static int index = 0;
//
//    private static int getNextId() {
//            return ++index;
//        }

    @NotNull
    protected int id;
    @NotNull
    protected static int nextId = 0;
    AbstractEntity(){
        id = nextId;
        nextId++;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


}
