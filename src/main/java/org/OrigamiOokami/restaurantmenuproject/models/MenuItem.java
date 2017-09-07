package org.OrigamiOokami.restaurantmenuproject.models;


import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;

public class MenuItem extends AbstractEntity {


//
//    public Category category;
//    public Double price;
//    public String description;
//    public LocalDateTime itemDate;
//    public Boolean isNew;

    @NotNull
    private Category category;

//    @Pattern(regexp = "[0-9]+([,.][0-9]{1,2})?")
    @NotNull
    private Double price;


    @NotNull
    @Size(min=3, max=50)
    @Pattern(regexp = "[a-zA-Z !,.:?]*")
    private String description;

    @NotNull
    private LocalDateTime itemDate;

    @NotNull
    private Boolean isNew;


    public MenuItem(){
        super();
        this.category = Category.APPETIZER;
        this.price = 0.00;
        this.description = "Generic Item Description";
//        this.itemDate = LocalDateTime.now();
        this.itemDate = LocalDateTime.of(1989, Month.JULY, 29, 12, 59);
        setIsNew(itemDate);
    }

    public MenuItem(Category category, Double price, String description, LocalDateTime itemDate){
        this();
        this.category = category;
        this.price = price;
        this.description = description;
//        this.itemDate = LocalDateTime.of(1989, Month.JULY, 29, 12, 59);
        this.itemDate = LocalDateTime.now();

//        this.itemDate = itemDate;
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


    public Boolean getIsNew() {
        return isNew;
    }
    private void setIsNew(LocalDateTime anItemDate) {
        Boolean itemIsNew;
        Duration d = Duration.between(anItemDate, LocalDateTime.now());
        Duration dWeek = Duration.between(LocalDateTime.now().minusDays(7), LocalDateTime.now());
        if (d.toDays() > dWeek.toDays()){
            itemIsNew = false;
        }
        else{
            itemIsNew = true;
        }
        isNew = itemIsNew;
    }

    public LocalDateTime getDate() {
        return itemDate;
    }
    public void setDate(LocalDateTime anItemDate) {
        itemDate = anItemDate;
    }

//    @Override
//    public int getId() {
//        return id;
//    }
//    public void setId(int newId){
//        id = newId;
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
