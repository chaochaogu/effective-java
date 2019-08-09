package com.chaochaogu.builder;

/**
 * @author chaochao Gu
 * @description: javabean pattern
 * @date 2019/8/9
 */
public class NutritionFacts1 {

    private int servingSize; // required

    private int servings; // required

    private int calories; // optional

    private int sodium; // optional

    private int fat; // optional

    private int carbohydrate; // optional

    public NutritionFacts1() {
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }
}
