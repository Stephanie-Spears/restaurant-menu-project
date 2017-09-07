package org.OrigamiOokami.restaurantmenuproject;


import java.time.LocalDateTime;
import java.util.ArrayList;

public class Menu extends AbstractEntity{
    //    private int id;
//    private int newId = 0;
    private LocalDateTime menuDate;
    private ArrayList<MenuItem> menuList = new ArrayList<>();


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

    public void addItem(MenuItem anItem){
        menuList.add(anItem);
    }
    public void removeItem(MenuItem anItem){
        menuList.remove(anItem);
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
