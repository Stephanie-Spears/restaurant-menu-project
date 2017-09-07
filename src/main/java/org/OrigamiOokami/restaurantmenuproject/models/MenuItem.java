package org.OrigamiOokami.restaurantmenuproject.models;


import java.time.Duration;
import java.time.LocalDateTime;

public class MenuItem extends AbstractEntity {
    enum Category {APPETIZER, MAIN_COURSE, DESSERT}

//    private int id;
//    static AtomicInteger nextId = new AtomicInteger();


    private Category category;
    private Double price;
    private String description;
    private LocalDateTime itemDate;
    private Boolean isNew;



    MenuItem(){
        super();
        this.category = Category.APPETIZER;
        this.price = 0.00;
        this.description = "Generic Item Description";
        this.itemDate = LocalDateTime.now();
        setIsNew(itemDate);
//        this.id = nextId.incrementAndGet();
    }

    MenuItem(Category category, Double price, String description, LocalDateTime itemDate){
        this();
        this.category = category;
        this.price = price;
        this.description = description;
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
        return ("\nID: " + id + "\nCategory: " + category + "\nPrice: " + price + "\nDescription: " + description + "\nIs New: " + isNew + "\nItem Date: " + itemDate.getMonth() + " " + itemDate.getDayOfMonth() + ", " + itemDate.getYear() + " (" +  itemDate.getDayOfWeek() + ")\n");
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
        int result = id;
        result = 31 * result + category.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + itemDate.hashCode();
        result = 31 * result + isNew.hashCode();
        return result;
    }
}
