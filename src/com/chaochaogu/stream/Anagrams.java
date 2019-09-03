package com.chaochaogu.stream;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Prints all large anagram groups in a dictionary iteratively
 *
 * @author chaochao Gu
 * @date 2019/9/2
 */
public class Anagrams {

    public static void main(String[] args) throws IOException {

        File dictionary = new File(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);
        Map<String, Set<String>> groups = new HashMap<>();

        try (Scanner s = new Scanner(dictionary)) {
            while (s.hasNext()) {
                String word = s.next();
                groups.computeIfAbsent(alphabetize(word), (unused) -> new TreeSet<>()).add(word);
            }
        }
        for (Set<String> group : groups.values()) {
            if (group.size() >= minGroupSize) {
                System.out.println(group.size() + " " + group);
            }
        }
    }

    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}