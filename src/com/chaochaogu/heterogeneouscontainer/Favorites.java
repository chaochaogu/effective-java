package com.chaochaogu.heterogeneouscontainer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Typesafe heterogeneous container pattern - implementation
 *
 * @author chaochao Gu
 * @date 2019/8/28
 */
public class Favorites {

    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type), type.cast(instance));
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }
}
