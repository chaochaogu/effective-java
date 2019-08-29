package com.chaochaogu.enumm;

/**
 * Abuse of ordinal to derive an associated value - DON'T DO THIS !
 *
 * @author chaochao Gu
 * @date 2019/8/29
 */
public enum Ensembe {
    /**
     * 独奏
     */
    SOLO,
    /**
     * 二重奏
     */
    DUET,
    /**
     * 三重奏
     */
    TRIO,
    QUARTET,
    QUINTET,
    SEXTET,
    SEPTET,
    OCTET,
    NONET,
    /**
     * 十重奏
     */
    DECTET;

    public int numberOfMusicians() {
        return ordinal() + 1;
    }
}

