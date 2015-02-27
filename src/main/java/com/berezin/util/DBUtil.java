package com.berezin.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by a.berezin on 27.02.2015.
 */
public class DBUtil {
    private static Connection con = null;

    public static Connection getConnection(){
        if (con != null ){
            return con;
        }
        else {
            try{
                con = DriverManager.getConnection("jdbc:hsqldb:hsql://ClientDB", "SA", "");
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            return con;
        }
    }

}
