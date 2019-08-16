package com.chaochaogu.equals;

import java.util.Objects;

/**
 * 自反性（Reflexivity）
 * 对称性（Symmetry）
 * 传递性（Transitivity）
 * 一致性（Consistent）
 * 非空性（Non-nullity）
 * @author chaochao Gu
 * @date 2019/8/16
 */
public class CaseInsensitiveString {

    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    // Broken - violates symmetry!
    @Override
    public boolean equals(Object o) {
        /*if (o instanceof CaseInsensitiveString) {
            return s.equalsIgnoreCase(
                    ((CaseInsensitiveString) o).s);
        }
        if (o instanceof String) { // One-way interoperability!
            return s.equalsIgnoreCase((String) o);
        }
        return false;*/
        return o instanceof CaseInsensitiveString &&
                ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
    }
}
