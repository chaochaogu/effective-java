package com.chaochaogu.enummap;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

/**
 * Using a nested EnumMap to associate data with enum pairs
 *
 * @author chaochao gu
 * @date 2019/8/30
 */
public enum PhaseCorrect {

    /**
     * 固态
     */
    SOLID,
    LIQUID,
    GAS,
    PLASMA;

    public enum Transition {

        /**
         * 熔化
         */
        MELT(SOLID, LIQUID),
        FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS),
        CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS),
        DEPOSIT(GAS, SOLID),
        IONIZE(GAS, PLASMA),
        DEIONIZE(PLASMA, GAS);

        private final PhaseCorrect from;
        private final PhaseCorrect to;

        Transition(PhaseCorrect from, PhaseCorrect to) {
            this.from = from;
            this.to = to;
        }

        // Initialize the phase transition map
        private static final Map<PhaseCorrect, Map<PhaseCorrect, Transition>>
                m = Stream.of(values()).collect(groupingBy(t -> t.from,
                () -> new EnumMap<>(PhaseCorrect.class),
                toMap(t -> t.to, t -> t,
                        (x, y) -> y, () -> new EnumMap<>(PhaseCorrect.class))));

        public static Transition from(PhaseCorrect from, PhaseCorrect to) {
            return m.get(from).get(to);
        }
    }

    public static void main(String[] args) {
        Transition from = Transition.from(SOLID, LIQUID);
    }
}
