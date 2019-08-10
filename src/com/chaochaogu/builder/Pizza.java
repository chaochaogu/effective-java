package com.chaochaogu.builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * Builder pattern for class hierarchies
 *
 * @author chaochao gu
 * @date 2019/8/10
 */
public abstract class Pizza {
    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}
    final Set<Topping> toppings;
    int i = 1;
    int b = 2;
    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        // Subclasses must override this method to return "this"
        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }


}
