package org.projects.intermediate.takeoutsystem;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @param <T>
 * `T`-type parameter extends PricedItem.
 */
public class ShoppingBag<T extends PricedItem<Integer>> {
    private Map<T, Integer> shoppingBag;

    public ShoppingBag() {
        shoppingBag = new HashMap<>();
    }
}
