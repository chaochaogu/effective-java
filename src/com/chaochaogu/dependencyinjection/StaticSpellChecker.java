package com.chaochaogu.dependencyinjection;

import java.util.List;

/**
 * Inappropriate use of static utility - inflexible & untestable!
 * @author chaochao Gu
 * @date 2019/8/15
 */
public class StaticSpellChecker {

    private static final Lexicon dictionary = new Lexicon();

    private StaticSpellChecker(){}

    // Inappropriate use of singleton - inflexible & untestable!
    // public static final StaticSpellChecker INSTANCE = new StaticSpellChecker();

    public boolean isValid(String word){
        return false;
    }

    public List<String> suggestions(String typo){
        return null;
    }
}
