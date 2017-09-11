package org.OrigamiOokami.restaurantmenuproject.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.*;
import java.time.format.DateTimeFormatter;

//extends AbstractEntity
public class MenuItem extends AbstractEntity {

    /*can right click and select generate, and initialize constructors automatically. it's default uses the form of "this.name" versus using a different naming parameter "aName". public Cheese(String aName){name = aName} vs public Cheese(String name){this.name = name}*/

    @NotNull
    private ItemCategory category;
    @NotNull
    private Double price;
    @NotNull
    @Size(min=3, max=50)
    @Pattern(regexp = "[a-zA-Z !,.:?]*")
    private String description;

    @NotNull
    private Boolean isNew;

    @NotNull
    private LocalDate date;


    public MenuItem(){
        super();
    }



    public MenuItem(ItemCategory category, Double price, String description, LocalDate date){
        this();
        this.category = category;
        this.price = price;
        this.description = description;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }
    public void setDate(String sdate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(sdate, formatter);
        setIsNew(date);
        this.date = date;
    }

    public Boolean getIsNew() {
        return isNew;
    }
    private void setIsNew(LocalDate date) {
        Boolean itemIsNew = true;
        if (date.isBefore(LocalDate.now().minusDays(7))){
            itemIsNew = false;
        }
        this.isNew = itemIsNew;
    }


    @Override
    public String toString(){
        return ("\nID: " + id + "\nItem Category: " + category + "\nPrice: " + price + "\nDescription: " + description + "\nIs New: " + isNew + "\nItem Date: " + date.getMonth() + " " + date.getDayOfMonth() + ", " + date.getYear() + " (" +  date.getDayOfWeek() + ")\n");
    }

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
        return theItem.getId() == getId();
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (isNew != null ? isNew.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }


}
