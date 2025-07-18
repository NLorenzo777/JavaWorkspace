package org.projects.intermediate.takeoutsystem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Food implements PricedItem<Integer> {
    private String name;
    private String description;
    private int price;

    public Food(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public Integer getprice() {
        return this.price;
    }

    @Override
    public void setPrice(Integer price) {

    }

    @Override
    public String toString() {
        String message =
                "Enjoy " + this.name + ": Yummy steak " + this.name + "     Cost: $" + this.price;
        System.out.println(message);
        return message;
    }
}