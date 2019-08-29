package com.chaochaogu.enumset;

/**
 * Bit field Enumeration constants - OBSOLETE !
 *
 * @author chaochao Gu
 * @date 2019/8/29
 */
public class Text {

    public static final int STYLE_BOLD = 1 << 0; // 1

    public static final int STYLE_ITALIC = 1 << 1; // 2

    public static final int STYLE_UNDERLINE = 1 << 2; // 4

    public static final int STYLE_STRIKETHROUGH = 1 << 3; // 8

    /**
     * Parameter is bitwise OR of zero or more STYLE_constants
     *
     * @param style
     */
    public void applyStyles(int style) {

    }
}
