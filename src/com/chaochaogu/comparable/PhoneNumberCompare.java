package com.chaochaogu.comparable;

import java.util.Comparator;

/**
 * @author chaochao Gu
 * @date 2019/8/16
 */
public final class PhoneNumberCompare implements Comparable<PhoneNumberCompare> {

    private static final Comparator<PhoneNumberCompare> COMPARATOR =
            Comparator.comparingInt((PhoneNumberCompare pn) -> pn.areaCode)
                    .thenComparing(pn -> pn.prefix)
                    .thenComparing(pn -> pn.lineNum);

    static Comparator<Object> hashcodeOrder = Comparator.comparingInt(o -> o.hashCode());

    private final short areaCode, prefix, lineNum;

    public PhoneNumberCompare(short areaCode, short prefix, short lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "areaCode");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 9999, "lineNum");
    }

    private short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max) {
            throw new IllegalArgumentException(arg + ":" + val);
        }
        return (short) val;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhoneNumberCompare)) {
            return false;
        }
        PhoneNumberCompare pn = (PhoneNumberCompare) obj;
        return pn.areaCode == areaCode && pn.prefix == prefix && pn.lineNum == lineNum;
    }

    @Override
    public int compareTo(PhoneNumberCompare pn) {
        int result = Short.compare(areaCode, pn.areaCode);
        if (result == 0) {
            result = Short.compare(prefix, pn.prefix);
            if (result == 0) {
                result = Short.compare(lineNum, pn.lineNum);
            }
        }
        return result;
//        return COMPARATOR.compare(this, pn);
    }
}
