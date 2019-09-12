package com.chaochaogu.defencecopy;

import java.util.Date;

/**
 * Broken immutable time period class
 *
 * @author chaochao Gu
 * @date 2019/9/12
 */
public class Period {

    private final Date start;

    private final Date end;

    /**
     * @param start the beginning of the period
     * @param end   the end of the period; must not precede start
     * @throws IllegalArgumentException if start is after end
     * @throws NullPointerException     if start or end is null
     */
    public Period(Date start, Date end) {
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + "after" + end);
        }
        this.start = start;
        this.end = end;
    }

    public Date start() {
        return start;
    }

    public Date end() {
        return end;
    }
}
