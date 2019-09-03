package com.chaochaogu.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

/**
 * Tasteful use of streams enhances clarity and conciseness
 *
 * @author chaochao Gu
 * @date 2019/9/3
 */
public class AnagramsProper {

    public static void main(String[] args) throws IOException {

        Path dictionary = Paths.get(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);

        try (Stream<String> words = Files.lines(dictionary)) {
            words.collect(groupingBy(word -> alphabetize(word))).values()
                    .stream().filter(group -> group.size() >= minGroupSize)
                    .map(group -> group.size() + " " + group)
                    .forEach(System.out::println);
        }
    }

    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
