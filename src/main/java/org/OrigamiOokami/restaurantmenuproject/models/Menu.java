package org.OrigamiOokami.restaurantmenuproject.models;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

//public class Menu extends AbstractEntity {
public class Menu {
    //    private int id;
//    private int newId = 0;

//    private LocalDateTime menuDate;
    private static LocalDate menuDate;
//    private ArrayList<MenuItem> menuList = new ArrayList<>();

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

//    public LocalDateTime getMenuDate() {
//        return menuDate;
//    }
//    public void setMenuDate(LocalDateTime aMenuDate) {
//        menuDate = aMenuDate;
//    }
////do i need to overload and just name "add" and "remove"?
//    public void addItem(MenuItem anItem){
//        menuList.add(anItem);
//    }
//
//    public void removeItem(MenuItem anItem){
//        menuList.remove(anItem);
//    }
//
//    public ArrayList<MenuItem> getAll(){
//        return menuList;
//    }

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


//    @Override
//    public int getId() {
//        return id;
//    }

//
//    public void setId(int anId){
//        id = anId;
//        anId++;
//
//    }

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
