package com.chaochaogu.singleton;

/**
 * @author chaochao Gu
 * @date 2019/8/15
 */
public class Main {

    public static void main(String[] args) {

        Elvis elvis = Elvis.INSTANCE;
        Alex alex = Alex.getInstance();
        // Enum Singleton
        John john = John.INSTANCE;
        john.setField("ww");
        John john1 = John.INSTANCE;
        john1.setField("qq");
        assert john == john1;

        DataSourceEnum.DBConnection connection = DataSourceEnum.DATASOURCE.getConnection();
        DataSourceEnum.DBConnection connection1 = DataSourceEnum.DATASOURCE.getConnection();
        assert connection == connection1;
    }
}
