package com.chaochaogu.singleton;

/**
 * @author chaochao Gu
 * @date 2019/8/15
 */
public enum DataSourceEnum {

    /**
     *
     */
    DATASOURCE;

    private DBConnection connection = null;

    private DataSourceEnum(){
        connection = new DBConnection();
    }

    public DBConnection getConnection(){
        return connection;
    }

    public class DBConnection{}
}
