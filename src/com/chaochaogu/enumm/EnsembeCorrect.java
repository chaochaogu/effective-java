package com.chaochaogu.enumm;

/**
 * @author chaochao Gu
 * @date 2019/8/29
 */
public enum EnsembeCorrect {

    /**
     * 独奏
     */
    SOLO(1),
    /**
     * 二重奏
     */
    DUET(2),
    /**
     * 三重奏
     */
    TRIO(3),
    QUARTET(4),
    QUINTET(5),
    SEXTET(6),
    SEPTET(7),
    OCTET(8),
    NONET(9),
    /**
     * 十重奏
     */
    DECTET(10);

    private final int numberOfMusicians;

    EnsembeCorrect(int size) {
        this.numberOfMusicians = size;
    }

    public int getNumberOfMusicians() {
        return numberOfMusicians;
    }
}
