package com.chaochaogu.builder;

/**
 * telescoping constructor pattern - does not scale well
 * @author chaochao Gu
 * @date 2019/8/9
 */
public class NutritionFacts {

    /**
     * required
     */
    private int servingSize;

    /**
     * required
     */
    private int servings;

    /**
     * optional
     */
    private int calories;

    /**
     * optional
     */
    private int sodium;

    /**
     * optional
     */
    private int fat;

    /**
     * optional
     */
    private int carbohydrate;

    public NutritionFacts(int servingSize, int servings){
        this(servingSize, servings, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int sodium) {
        this(servingSize, servings, calories, sodium, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int sodium, int fat) {
        this(servingSize, servings, calories, sodium, fat, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int sodium, int fat, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.sodium = sodium;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
    }

}
