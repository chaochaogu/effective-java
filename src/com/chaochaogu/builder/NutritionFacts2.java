package com.chaochaogu.builder;

/**
 * @author chaochao Gu
 * @description: Builder pattern
 * @date 2019/8/9
 */
public class NutritionFacts2 {

    private int servingSize; // required

    private int servings; // required

    private int calories; // optional

    private int sodium; // optional

    private int fat; // optional

    private int carbohydrate; // optional

    public static class Builder{

        // required parameter
        private int servingSize;

        // required parameter
        private int servings;

        // optional
        private int calories = 0;

        // optional
        private int sodium = 0;

        // optional
        private int fat = 0;

        // optional
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val){
            calories = val;
            return this;
        }

        public Builder sodium(int val){
            sodium = val;
            return this;
        }

        public Builder fat(int val){
            fat = val;
            return this;
        }

        public Builder carbohydrate(int val){
            carbohydrate = val;
            return this;
        }

        public NutritionFacts2 build(){
            return new NutritionFacts2(this);
        }

    }

    private NutritionFacts2(Builder builder) {
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.sodium = builder.sodium;
        this.fat = builder.fat;
        this.carbohydrate = builder.carbohydrate;
    }
}
