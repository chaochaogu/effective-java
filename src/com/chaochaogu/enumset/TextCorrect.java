package com.chaochaogu.enumset;

import java.util.Set;

/**
 * EnumSet - a modern replacement for bit fields
 * @author chaochao Gu
 * @date 2019/8/29
 */
public class TextCorrect {

    public enum Style {BOLD, ITALIC, UNDERLINE, STRIKETHROUGH}

    // Any Set could be passed in , but EnumSet is clearly beat
    public void applyStyles(Set<Style> styles) {
    }
}
