package org.OrigamiOokami.restaurantmenuproject.models;


import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class MenuItem extends AbstractEntity {

    @NotNull
    private Category category;

//    @Pattern(regexp = "[0-9]+([,.][0-9]{1,2})?")
    @NotNull
    private Double price;


    @NotNull
    @Size(min=3, max=50)
    @Pattern(regexp = "[a-zA-Z !,.:?]*")
    private String description;

    //    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate itemDate;

    @NotNull
    private Boolean isNew;


    @NotNull
    public MenuItem(){
        super();
        this.category = Category.APPETIZER;
        this.price = 9.99;
        this.description = "";
        this.itemDate = LocalDate.now();
//        this.itemDate = LocalDate.of(1989, Month.JULY, 29);
        setIsNew(itemDate);
    }

    public MenuItem(Category category, Double price, String description, LocalDate itemDate){
        this();
        this.category = category;
        this.price = price;
        this.description = description;
//        this.itemDate = LocalDateTime.of(1989, Month.JULY, 29, 12, 59);
//        this.itemDate = LocalDate.now();
        this.itemDate = itemDate;
        setIsNew(itemDate);
    }



    public Category getCategory() {
        return category;
    }
    public void setCategory(Category aCategory) {
        category = aCategory;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double aPrice) {
        price = aPrice;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String aDescription) {
        description = aDescription;
    }


//    public Boolean getIsNew() {
//        return isNew;
//    }
//    private void setIsNew(LocalDateTime anItemDate) {
//        Boolean itemIsNew = true;
//        Duration d = Duration.between(anItemDate, LocalDateTime.now());
//        Duration dWeek = Duration.between(LocalDateTime.now().minusDays(7), LocalDateTime.now());
//        if (d.toDays() > dWeek.toDays()){
//            itemIsNew = false;
//        }
//
//        isNew = itemIsNew;
//    }
    public Boolean getIsNew() {
        return isNew;
    }
    private void setIsNew(LocalDate anItemDate) {
        Boolean itemIsNew = true;
//        Duration d = Duration.between(anItemDate, LocalDate.now());
//        Duration dWeek = Duration.between(LocalDate.now().minusDays(7), LocalDate.now());
        if (anItemDate.isBefore(LocalDate.now().minusDays(7))){
            itemIsNew = false;
        }

        isNew = itemIsNew;
    }

    public LocalDate getDate() {
        return itemDate;
    }
    public void setDate(LocalDate anItemDate) {
        itemDate = anItemDate;
    }

//    @Override
//    public int getId() {
//        return itemId;
//    }
//    public void setId(int newId){
//        itemId = newId;
//    }

    @Override
    public String toString(){
        return ("\nID: " + itemId + "\nCategory: " + category + "\nPrice: " + price + "\nDescription: " + description + "\nIs New: " + isNew + "\nItem Date: " + itemDate.getMonth() + " " + itemDate.getDayOfMonth() + ", " + itemDate.getYear() + " (" +  itemDate.getDayOfWeek() + ")\n");
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
//        return theItem.getDescription() == getDescription() && theItem.getCategory() == getCategory();
    }

    @Override
    public int hashCode() {
        int result = itemId;
        result = 31 * result + category.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + itemDate.hashCode();
        result = 31 * result + isNew.hashCode();
        return result;
    }
}
