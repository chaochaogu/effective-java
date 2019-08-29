package com.chaochaogu.enumset;

import java.util.EnumSet;

/**
 * @author chaochao Gu
 * @date 2019/8/29
 */
public class Main {

    public static void main(String[] args) {

        Text text = new Text();
        text.applyStyles(Text.STYLE_BOLD | Text.STYLE_ITALIC);

        TextCorrect textCorrect = new TextCorrect();
        textCorrect.applyStyles(EnumSet.of(TextCorrect.Style.BOLD, TextCorrect.Style.ITALIC));
    }
}
