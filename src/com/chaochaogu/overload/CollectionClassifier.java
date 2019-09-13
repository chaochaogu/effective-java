package com.chaochaogu.overload;

import java.math.BigInteger;
import java.util.*;

/**
 * Broken! - what does this program print?
 *
 * @author chaochao gu
 * @date 2019/9/13
 */
public class CollectionClassifier {

    public static String classify(Set<?> c) {
        return "Set";
    }

    public static String classify(List<?> c) {
        return "List";
    }

    public static String classify(Collection<?> c) {
         return "Unknown Collection";
//        return c instanceof Set ? "Set" :
//                c instanceof List ? "List" :
//                 "Unknown Collection";
    }

    public static void main(String[] args) {

        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };
        for (Collection c : collections) {
            System.out.println(classify(c));
        }
    }
}
