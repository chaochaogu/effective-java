package com.chaochaogu.stream;

import com.chaochaogu.enumm.Operation;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * @author chaochao Gu
 * @date 2019/9/4
 */
public class Main {

    public static void main(String[] args) throws Exception {

        // Uses the stream API but not the paradigm - don't do this !
        Path path = Paths.get(args[0]);
        Map<String, Long> freq = new HashMap<>();
        try (Stream<String> words = Files.lines(path)) {
            words.forEach(word -> freq.merge(word.toLowerCase(), 1L, Long::sum));
        }

        // Proper use of streams to initialize a frequency table
        Map<String, Long> freq1 = new HashMap<>();
        try (Stream<String> words = Files.lines(path)) {
            freq1 = words.collect(groupingBy(String::toLowerCase, counting()));
        }

        // Pipeline to get a top-ten list of words from a frequency table
        Map<String, Long> freq2 = new HashMap<>();
        List<String> topTen = freq2.keySet().stream()
                .sorted(comparing(freq2::get).reversed())
                .limit(10)
                .collect(Collectors.toList());

        // Using a toMap collector to make a map from string to enum
        final Map<String, Operation> stringToEnum = Stream.of(Operation.values()).collect(toMap(Object::toString, e -> e));

        // Collector to generate a map from key to chosen element for key
//        Map<Artist, Album> topHits = albums.collect(
//                toMap(Album::artist, a->a, maxBy(comparing(Album::sales))));

        // Collector to impose last-write-wins policy
//        toMap(keyMapper, valueMapper, (oldVal, newVal) ->newVal)

    }
}
