package com.chaochaogu.overload;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chaochao gu
 * @date 2019/9/13
 */
class Wine {
    String name() {
        return "Wine";
    }
}

class SparklingWine extends Wine {
    @Override
    String name() {
        return "Sparking Wine";
    }
}

class Champagne extends Wine {
    @Override
    String name() {
        return "Champagne";
    }
}

/**
 * @author chaochao gu
 * @date 2019/9/13
 */
public class Overriding {

    public static void main(String[] args) {

        List<Wine> wineList = new ArrayList<>();
        wineList.add(new Wine());
        wineList.add(new SparklingWine());
        wineList.add(new Champagne());

        for (Wine wine : wineList) {
            System.out.println(wine.name());
        }
    }
}
