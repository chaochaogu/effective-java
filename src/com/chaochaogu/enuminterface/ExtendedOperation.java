package com.chaochaogu.enuminterface;

/**
 * Emulated extension enum
 *
 * @author chaochao gu
 * @date 2019/9/1
 */
public enum ExtendedOperation implements Operation {

    /**
     * pow
     */
    EXP("^") {
        @Override
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    },
    REMAINDER("%") {
        @Override
        public double apply(double x, double y) {
            return x % y;
        }
    };

    private final String symbol;

    ExtendedOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
