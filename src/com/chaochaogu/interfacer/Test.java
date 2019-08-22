package com.chaochaogu.interfacer;

import static com.chaochaogu.interfacer.PhysicalConstantsCorrect.AVOGADROS_NUMBER;

/**
 * @author chaochao Gu
 * @date 2019/8/22
 */
public class Test {
    double atoms(double mols) {
        return AVOGADROS_NUMBER * mols;
    }

    // Many more uses of PhysicalConstants justify static import
}