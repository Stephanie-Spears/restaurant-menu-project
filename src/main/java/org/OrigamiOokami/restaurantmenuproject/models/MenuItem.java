package org.OrigamiOokami.restaurantmenuproject.models;


import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

//extends AbstractEntity
public class MenuItem {

    /*can right click and select generate, and initialize constructors automatically. it's default uses the form of "this.name" versus using a different naming parameter "aName". public Cheese(String aName){name = aName} vs public Cheese(String name){this.name = name}*/

    private int itemId;
    private static int nextId = 0;
//    public int getItemId() {
//        return itemId;
//    }
//    public void setItemId(int nextId){
//        itemId = nextId;
//        nextId++;
//    }

//    @NotNull
    private ItemCategory category;

//    @Pattern(regexp = "[0-9]+([,.][0-9]{1,2})?")
//    @NotNull
    private Double price;

//    @NotNull
//    @Size(min=3, max=50)
//    @Pattern(regexp = "[a-zA-Z !,.:?]*")
    private String description;

    //    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @NotNull
//    private LocalDate date;

//    @NotNull
    private Boolean isNew;

//    @NotNull
    public MenuItem(){
//        super();
        itemId = nextId;
        nextId++;
//        this.category = ItemCategory.APPETIZER;
//        this.price = 9.99;
//        this.description = "";
//        this.itemDate = LocalDate.now();
////        this.itemDate = LocalDate.of(1989, Month.JULY, 29);
//        setIsNew(itemDate);
    }

    private String sdate;


    public MenuItem(ItemCategory category, Double price, String description, String sdate){
        this();
        this.category = category;
        this.price = price;
        this.description = description;
//        this.itemDate = LocalDate.now();
        this.sdate = sdate;

        setIsNew(date);
    }


//
//    public ItemCategory getItemCategory() {
//        return category;
//    }
//    public void setItemCategory(ItemCategory category) {
//        this.category = category;
//    }
//
//    public Double getPrice() {
//        return price;
//    }
//    public void setPrice(Double aPrice) {
//        price = aPrice;
//    }
//    public String getDescription() {
//        return description;
//    }
//    public void setDescription(String aDescription) {
//        description = aDescription;
//    }


//    @Override
//    public String toString(){
//        return ("\nID: " + itemId + "\nItem Category: " + category + "\nPrice: " + price + "\nDescription: " + description + "\nIs New: " + isNew + "\nItem Date: " + date.getMonth() + " " + date.getDayOfMonth() + ", " + date.getYear() + " (" +  date.getDayOfWeek() + ")\n");
//    }


    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o.getClass() != getClass()) {
            return false;
        }
        MenuItem theItem = (MenuItem) o;
        return theItem.getItemId() == getItemId();
    }

//    @Override
//    public int hashCode() {
//        int result = itemId;
//        result = 31 * result + category.hashCode();
//        result = 31 * result + price.hashCode();
//        result = 31 * result + description.hashCode();
//        result = 31 * result + itemDate.hashCode();
//        result = 31 * result + isNew.hashCode();
//        return result;
//    }


    public Boolean getIsNew() {
        return isNew;
    }
    private void setIsNew(String aDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        formatter = formatter.withLocale(Locale.US);  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
        LocalDate aDate = LocalDate.parse("2005-nov-12", formatter);

        Boolean itemIsNew = true;
        if (aDate.isBefore(LocalDate.now().minusDays(7))){
            itemIsNew = false;
        }
        isNew = itemIsNew;
    }


    public int getItemId() {
        return itemId;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }


    public ItemCategory getCategory() {
        return category;
    }
    public void setCategory(ItemCategory category) {
        this.category = category;
    }


    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }


    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


    public String getDate() {
        return sdate;
    }
    public void setDate(String sdate) {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        Date parsed = format.parse(date);

//        java.util.Date date = java.sql.Date.valueOf(itemDate);

//        LocalDate ld = new java.sql.Date(date.getTime()).toLocalDate();
//        LocalDate ld = new java.sql.Date(parsed.getTime()).toLocalDate();


        this.sdate = sdate;
    }


}
