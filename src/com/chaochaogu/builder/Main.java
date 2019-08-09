package com.chaochaogu.builder;

/**
 * @author chaochao Gu
 * @date 2019/8/9
 */
public class Main {

    public static void main(String[] args) {

        new NutritionFacts(240, 8, 100, 0, 20);

        NutritionFacts1 nutritionFacts1 = new NutritionFacts1();
        nutritionFacts1.setServings(100);
        nutritionFacts1.setServings(3);
        nutritionFacts1.setCalories(0);

        NutritionFacts2 cocaCoLa = new NutritionFacts2.Builder(240, 8).calories(100).sodium(35).carbohydrate(27).build();

    }

}
