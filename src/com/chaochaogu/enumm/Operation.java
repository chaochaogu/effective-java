package com.chaochaogu.enumm;

/**
 * Enum type that switches on its own value - questionable
 *
 * @author chaochao Gu
 * @date 2019/8/29
 */
public enum Operation {

    /**
     * 加
     */
    PLUS,
    /**
     * 减
     */
    MINUS,
    /**
     * 乘
     */
    TIMES,
    /**
     * 除
     */
    DIVIDE;

    // Do the arithmetic operation represented by this constant
    public double apply(double x, double y) {
        switch (this) {
            case PLUS:
                return x + y;
            case MINUS:
                return x - y;
            case TIMES:
                return x * y;
            case DIVIDE:
                return x / y;
        }
        throw new AssertionError("Unknown op: " + this);
    }

    public static Operation inverse(Operation op) {
        switch (op) {
            case PLUS:
                return Operation.MINUS;
            case MINUS:
                return Operation.PLUS;
            case TIMES:
                return Operation.DIVIDE;
            case DIVIDE:
                return Operation.TIMES;
            default:
                throw new AssertionError("Unknown operation: " + op);
        }
    }
}
