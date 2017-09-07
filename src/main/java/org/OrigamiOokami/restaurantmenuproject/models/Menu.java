package org.OrigamiOokami.restaurantmenuproject.models;


import java.time.LocalDateTime;
import java.util.ArrayList;

public class Menu extends AbstractEntity {
    //    private int id;
//    private int newId = 0;
    private LocalDateTime menuDate;
    static ArrayList<MenuItem> menuList = new ArrayList<>();
//    private ArrayList<MenuItem> menuList = new ArrayList<>();


    Menu(){
        super();
        this.menuDate = LocalDateTime.now();
//        this.id = newId;
    }
    Menu(MenuItem... items){
        this();
        for (MenuItem item : items){
            this.menuList.add(item);

        }
    }

    public LocalDateTime getMenuDate() {
        return menuDate;
    }
    public void setMenuDate(LocalDateTime aMenuDate) {
        menuDate = aMenuDate;
    }
//do i need to overload and just name "add" and "remove"?
    public void addItem(MenuItem anItem){
        menuList.add(anItem);
    }
//    public void removeItem(MenuItem anItem){
//        menuList.remove(anItem);
//    }

//    public void removeItem(MenuItem anItem){
//        menuList.remove(anItem);
//    }
    public static void removeItem(int id) {
        MenuItem itemToRemove = getById(id);
        menuList.remove(itemToRemove);
    }

    // getAll
    public static ArrayList<MenuItem> getAll() {
        return menuList;
    }

    // getById
    public static MenuItem getById(int id) {
        MenuItem theItem = null;

        for (MenuItem candidateItem : menuList) {
            if (candidateItem.getId() == id) {
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
        String str = "";
        for (MenuItem item: menuList){
            str += "\nMenu Item: " + item;
        }
        return ( "\n~*~*~\nMenu Date: \n" + menuDate + "\n----" + str + "~*~*~\n");
    }

}
