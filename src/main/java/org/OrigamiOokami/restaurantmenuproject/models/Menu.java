package org.OrigamiOokami.restaurantmenuproject.models;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

//public class Menu extends AbstractEntity {
public class Menu {

    private static LocalDate menuDate;

    private static final ArrayList<MenuItem> menuList = new ArrayList<>();



    private Menu(){
//        super();
        menuDate = LocalDate.now();
//        this.id = newId;
    }
    public Menu(MenuItem... items){
        this();
        Collections.addAll(menuList, items);
    }


    public static void add(MenuItem newItem) {
    menuList.add(newItem);
}
    public static void remove(int itemId) {
        MenuItem itemToRemove = getById(itemId);
        menuList.remove(itemToRemove);
    }
    // getAll
    public static ArrayList<MenuItem> getAll() {
        return menuList;
    }
    // getById
    private static MenuItem getById(int itemId) {
        MenuItem theItem = null;

        for (MenuItem candidateItem : menuList) {
            if (candidateItem.getId() == itemId) {
                theItem = candidateItem;
            }
        }

        return theItem;
    }

    @Override
    public String toString(){
        /*StringBuilder class was suggested as a better performance alternative to string concat*/
        StringBuilder sb = new StringBuilder();

        for (MenuItem item: menuList){
            sb.append("\nMenu Item: ");
            sb.append(item);
        }
        return ( "\n~*~*~\nMenu Date: \n" + menuDate + "\n----" + sb + "~*~*~\n");
    }

}
