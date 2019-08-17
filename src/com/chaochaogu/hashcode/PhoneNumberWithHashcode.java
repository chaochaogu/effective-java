package com.chaochaogu.hashcode;

import java.util.Objects;

/**
 * @author chaochao Gu
 * @date 2019/8/16
 */
public final class PhoneNumberWithHashcode {

    private final short areaCode, prefix, lineNum;

    public PhoneNumberWithHashcode(short areaCode, short prefix, short lineNum) {
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
        if (!(obj instanceof PhoneNumberWithHashcode)) {
            return false;
        }
        PhoneNumberWithHashcode pn = (PhoneNumberWithHashcode) obj;
        return pn.areaCode == areaCode && pn.prefix == prefix && pn.lineNum == lineNum;
    }

    @Override
    public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
        // One-line hashCode method - mediocre performance
        // return Objects.hash(areaCode, prefix, lineNum);
    }
}
