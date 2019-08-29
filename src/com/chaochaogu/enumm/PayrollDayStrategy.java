package com.chaochaogu.enumm;

/**
 * The strategy enum pattern
 *
 * @author chaochao Gu
 * @date 2019/8/29
 */
public enum PayrollDayStrategy {
    /**
     * 周一
     */
    MONDAY,
    /**
     * 周二
     */
    TUESDAY,
    /**
     * 周三
     */
    WEDNESDAY,
    /**
     * 周四
     */
    THURSDAY,
    /**
     * 周五
     */
    FRIDAY,
    /**
     * 周六
     */
    SATURDAY(PayType.WEEKEND),
    /**
     * 周日
     */
    SUNDAY(PayType.WEEKEND);

    private final PayType payType;

    int pay(int minsWorked, int payRate) {
        return payType.pay(minsWorked, payRate);
    }

    /**
     * The strategy enum type
     */
    private enum PayType {

        /**
         * 工作日
         */
        WEEKDAY {
            @Override
            public int overtimePay(int minsWorked, int payRate) {
                return minsWorked < MINS_PER_SHIFT ? 0 : (minsWorked - MINS_PER_SHIFT) * payRate / 2;
            }
        },

        /**
         * 周末
         */
        WEEKEND {
            @Override
            public int overtimePay(int minsWorked, int payRate) {
                return minsWorked * payRate / 2;
            }
        };

        private static final int MINS_PER_SHIFT = 8 * 60;

        abstract int overtimePay(int minsWorked, int payRate);

        int pay(int minsWorkrd, int patRate) {
            int basePay = minsWorkrd * patRate;
            return basePay + overtimePay(minsWorkrd, patRate);
        }
    }

    PayrollDayStrategy() {
        this(PayType.WEEKDAY);
    }

    PayrollDayStrategy(PayType payType) {
        this.payType = payType;
    }
}
