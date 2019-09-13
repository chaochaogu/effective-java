package com.chaochaogu.defencecopy;

import java.util.Date;

/**
 * @author chaochao gu
 * @date 2019/9/13
 */
public class Period1 {

    private final Date start;

    private final Date end;

    /**
     * Repaired constructor - makes defensive copies of parameters
     *
     * @param start
     * @param end
     */
    public Period1(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + "After" + end);
        }
    }

    public Date start() {
        return new Date(start.getTime());
    }

    /**
     * Repaired accessors - make defensive copies of internal fields
     *
     * @return
     */
    public Date end() {
        return new Date(end.getTime());
    }
}
