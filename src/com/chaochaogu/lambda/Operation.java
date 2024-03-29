package com.chaochaogu.lambda;

import java.util.function.DoubleBinaryOperator;

/**
 * @author chaochao Gu
 * @date 2019/9/2
 */
public enum Operation {

    /**
     * 加
     */
    PLUS("+", (x, y) -> x + y),

    MINUS("-", (x, y) -> x - y),

    TIMES("*", (x, y) -> x * y),

    DIVIDE("/", (x, y) -> x / y);

    private final String symbol;

    private final DoubleBinaryOperator op;

    Operation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }

    @Override
    public String toString() {
        return symbol;
    }
}
