package com.chaochaogu.enummap;

/**
 * Using ordinal() to index array of arrays - DON'T DO THIS !
 *
 * @author chaochao Gu
 * @date 2019/8/29
 */
public enum Phase {

    /**
     * 固态
     */
    SOLID,
    LIQUID,
    GAS;

    public enum Transition {

        /**
         * 熔化
         */
        MELT,
        FREEZE,
        BOIL,
        CONDENSE,
        SUBLIME,
        DEPOSIT;

        // Rows indexed by from-ordinal, clos by to-ordinal
        private static final Transition[][] TRANSITIONS = {
                {null, MELT, SUBLIME},
                {FREEZE, null, BOIL},
                {DEPOSIT, CONDENSE, null}
        };

        // Returns the phase transition from one phase to another
        public static Transition transition(Phase from, Phase to) {
            return TRANSITIONS[from.ordinal()][to.ordinal()];
        }
    }
}
