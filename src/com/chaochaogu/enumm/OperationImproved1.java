package com.chaochaogu.enumm;

/**
 * Enum type with constant-specific method implementations
 *
 * @author chaochao Gu
 * @date 2019/8/29
 */
public enum OperationImproved1 {

    PLUS {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE {
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    };

    public abstract double apply(double x, double y);
}
