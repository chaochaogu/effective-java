package com.chaochaogu.bigdecimal;

import java.math.BigDecimal;

/**
 * @author chaochao gu
 * @date 2019/9/15
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(1.03 - 0.42);

        System.out.println(1.00 - 9 * 0.10);

        demo();
        demo2();
        demo3();
    }

    /**
     * Broken - uses floating point for monetary calculation!
     */
    public static void demo() {

        double funds = 1.00;
        int itemsBought = 0;
        for (double price = 0.1; funds >= price; price += 0.10) {
            funds -= price;
            itemsBought++;
        }
        System.out.println(itemsBought + "items bought.");
        System.out.println("Change: $" + funds);
    }

    public static void demo2() {

        final BigDecimal TEN_CENTS = new BigDecimal(".10");
        int itemsBought = 0;
        BigDecimal funds = new BigDecimal("1.00");
        for (BigDecimal price = TEN_CENTS; funds.compareTo(price) >= 0; price = price.add(TEN_CENTS)) {
            funds = funds.subtract(price);
            itemsBought++;
        }
        System.out.println(itemsBought + "items bought.");
        System.out.println("Money left over: $" + funds);
    }

    public static void demo3() {

        int itemsBought = 0;
        int funds = 100;
        for (int price = 10; funds >= price; price += 10) {
            funds -= price;
            itemsBought++;
        }
        System.out.println(itemsBought + "items bought.");
        System.out.println("Cash left over: " + funds + " cents");
    }
}
