package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.*;

import javax.sql.DataSource;


public class C3P0Utils {
	
	private static DataSource ds ;

    static {

        try {
            //初始化连接池对象
            ds = new ComboPooledDataSource("testc3p0");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接池对象
     */
    public static DataSource getDataSource(){
        return ds;
    }


    /**
     * 获取连接Connection对象
     */
    public static Connection getConnection() throws SQLException {
        return  ds.getConnection();
    }
	
	


}
