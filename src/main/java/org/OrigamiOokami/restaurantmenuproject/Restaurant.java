package org.OrigamiOokami.restaurantmenuproject;

import java.time.LocalDateTime;
import java.time.Month;

public class Restaurant {
    public static void main(String[] args){
//        Menu newMenu = new Menu();


        MenuItem menuItem1 = new MenuItem();
        menuItem1.setCategory(MenuItem.Category.DESSERT);
        menuItem1.setPrice(7.99);
        menuItem1.setDescription("Chocolate Cake");
        menuItem1.setDate(LocalDateTime.now());
        MenuItem menuItem2 = new MenuItem(MenuItem.Category.MAIN_COURSE, 12.50, "Pineapple Pie", LocalDateTime.of(2016, Month.JULY, 29, 12, 01));
        MenuItem menuItem3 = new MenuItem(MenuItem.Category.APPETIZER, 48.50, "Pot Stickers", LocalDateTime.of(2017, Month.AUGUST, 27, 1, 01));
        MenuItem menuItem4 = new MenuItem(MenuItem.Category.MAIN_COURSE, 12.50, "Pineapple Pie", LocalDateTime.of(2016, Month.JULY, 29, 12, 01));
        MenuItem menuItem5 = new MenuItem(MenuItem.Category.MAIN_COURSE, 12.50, "Pineapple Pie", LocalDateTime.of(2016, Month.JULY, 29, 12, 01));

        Menu newMenu = new Menu(menuItem1, menuItem2, menuItem3, menuItem4, menuItem5);


        newMenu.addItem( new MenuItem(MenuItem.Category.DESSERT, 1.55, "Lemon Cake", LocalDateTime.of(1997, Month.APRIL, 10, 5, 59)));

//        menuItem2.setId(33);
        System.out.println(newMenu.getId());

        System.out.println(menuItem1.getId());
        System.out.println(menuItem2.getId());
        System.out.println(menuItem3.getId());
        System.out.println(menuItem4.getId());
        System.out.println(menuItem5.getId());
        System.out.println(newMenu);
        System.out.println(newMenu.getId());
//        System.out.println(menuItem3);


    }

}
