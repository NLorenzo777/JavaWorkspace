package org.projects.intermediate.takeoutsystem;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @param <T>
 * `T`-type parameter extends PricedItem of Integer type.
 */
public class ShoppingBag<T extends PricedItem<Integer>> {
    private Map<T, Integer> shoppingBag;

    /**
     * CONSTRUCTOR
     */
    public ShoppingBag() {
        shoppingBag = new HashMap<>();
    }

    public void addItem(T item) {
        if (shoppingBag.containsKey(item)) {
            shoppingBag.replace(item, shoppingBag.get(item) + 1);
        } else {
            shoppingBag.put(item, 1);
        }
    }

    public int getTotalPrice() {
        int totalPrice = 0;

        for (T item: shoppingBag.keySet()) {
            int itemPrice = item.getprice();
            int quantity = shoppingBag.get(item);
            int totalPriceOfItem = itemPrice * quantity;
            totalPrice = totalPrice + totalPriceOfItem;
        }

        return totalPrice;
    }

    public static void main(String[] args) {
        Map<String, Integer> sampleBag = new HashMap<String, Integer>();
        sampleBag.put("Test1", 1);
        sampleBag.put("Test2", 2);
        sampleBag.put("Test3", 3);

        System.out.println(sampleBag.values());
    }
}
