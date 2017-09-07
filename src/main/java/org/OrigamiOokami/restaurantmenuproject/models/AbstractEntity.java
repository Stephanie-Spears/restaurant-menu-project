package org.OrigamiOokami.restaurantmenuproject.models;

abstract public class AbstractEntity {
//        public int id;
//        public AbstractEntity() {
//            this.id = getNextId();
//        }
//
//        public int getId() {
//            return id;
//        }
//        public static int index = 0;
//
//        public static int getNextId() {
//            return ++index;
//        }
//        protected int itemId;
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


//    protected int id;
//    public AbstractEntity() {
//        this.id = getNextId();
//    }
//
//    public int getId() {
//        return id;
//    }
//    protected static int index = 0;
//
//    protected static int getNextId() {
//        return ++index;
//    }
}
