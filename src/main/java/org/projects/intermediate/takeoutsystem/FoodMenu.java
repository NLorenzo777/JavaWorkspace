package org.projects.intermediate.takeoutsystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FoodMenu {
    private List<Food> menu;

    public FoodMenu() {
        menu = new ArrayList<>();
        menu.add(new Food("Food_Item_1", "This is a sample food item [1].", 10));
        menu.add(new Food("Food_Item_2", "This is a sample food item [2].", 10));
        menu.add(new Food("Food_Item_3", "This is a sample food item [3].", 20));
    }

    @Override
    public String toString() {
        int itemNumber = 1;
        String output = "";
        output += "MENU FOR TODAY:\n";

        for (Food item : menu) {
            output += String.format("[%d] %s : %s - Price: %d\n", itemNumber, item.getName(), item.getDescription(), item.getprice());
            itemNumber++;
        }

        return output;
    }

    public Food getFood(int index) {
        try {
            return menu.get(index - 1);

        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public Food getLowestCostFood() {
        int lowestPrice = menu.getFirst().getprice();
        Food lowestPricedFood = menu.getFirst();

        for (Food food : menu) {
            if (food.getprice() < lowestPrice) {
                lowestPrice = food.getprice();
                lowestPricedFood = food;
            }
        }

        return lowestPricedFood;
    }
}