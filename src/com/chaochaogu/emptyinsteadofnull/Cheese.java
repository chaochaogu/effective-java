package com.chaochaogu.emptyinsteadofnull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chaochao gu
 * @date 2019/9/13
 */
public class Cheese {

    // Returns null to indicate an empty collection - Don't do this!
    private final List<Cheese> cheeseInStock = null;

    /**
     * @return a list containing all of the cheeses in the shop,
     * or null if no cheeses are available for purchase.
     */
    public List<Cheese> getCheeses() {
        return cheeseInStock.isEmpty() ? null : new ArrayList<>(cheeseInStock);
    }

    // The right way to return a possibly empty collection
    public List<Cheese> getCheeses1() {
        return new ArrayList<>(cheeseInStock);
    }

    // Optimization - avoids allocating empty collections
    public List<Cheese> getCheeses2() {
        return cheeseInStock.isEmpty() ? Collections.emptyList()
                : new ArrayList<>(cheeseInStock);
    }

    // The right way to return a possibly empty array
    public Cheese[] getCheeses3() {
        return cheeseInStock.toArray(new Cheese[0]);
    }

    // Optimization - avoids allocating empty arrays
    private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];

    public Cheese[] getCheeses4() {
        return cheeseInStock.toArray(EMPTY_CHEESE_ARRAY);
    }

    // Don't do this - preallocating the array harms the performance!
    public Cheese[] getCheeses5() {
        return cheeseInStock.toArray(new Cheese[cheeseInStock.size()]);
    }
}
