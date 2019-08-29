package com.chaochaogu.enumm;

/**
 * Enum that switches on its value to share code - questionable
 *
 * @author chaochao Gu
 * @date 2019/8/29
 */
public enum PayrolllDay {

    /**
     * 周一
     */
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    private static final int MINS_PER_SHIFT = 8 * 60;

    int Pay(int minutesWorked, int payRate) {

        int basePay = minutesWorked * payRate;
        int overtimePay;

        switch (this) {
            case SATURDAY:
            case SUNDAY:
                // weekend
                overtimePay = basePay / 2;
                break;
            default:
                // weekday
                overtimePay = minutesWorked < MINS_PER_SHIFT ? 0 : (minutesWorked - MINS_PER_SHIFT) * payRate / 2;
        }
        return basePay + overtimePay;
    }
}
