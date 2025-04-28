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

//    public T getTotalPrice() {
//        shoppingBag.values().stream()
//                .map((quantity) -> quantity * )
//    }

    public static void main(String[] args) {
        Map<String, Integer> sampleBag = new HashMap<String, Integer>();
        sampleBag.put("Test1", 1);
        sampleBag.put("Test2", 2);
        sampleBag.put("Test3", 3);

        System.out.println(sampleBag.values());
    }
}
