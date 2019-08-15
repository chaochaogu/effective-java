package com.chaochaogu.singleton;

/**
 * Enum Singleton -- the preferred approach
 *
 * @author chaochao Gu
 * @date 2019/8/15
 */
public enum John {

    /**
     * single element
     */
    INSTANCE;

    private String field;

    John() {

    }

    public String getField() {
        return this.field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void leaveTheBuilding() {
    }
}
