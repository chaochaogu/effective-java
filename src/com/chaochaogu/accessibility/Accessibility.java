package com.chaochaogu.accessibility;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author chaochao gu
 * @date 2019/8/18
 */
public class Accessibility {

    // Potential security hole !
    public static final Thing[] VALUES = new Thing[123];

    private static final Thing[] PRIVATE_VALUES1 = new Thing[123];
    public static final List<Thing> VALUES2 = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES1));

    private static final Thing[] PRIVATE_VALUES2 = new Thing[123];

    public static final Thing[] values() {
        return PRIVATE_VALUES2.clone();
    }

    class Thing {
    }
}
