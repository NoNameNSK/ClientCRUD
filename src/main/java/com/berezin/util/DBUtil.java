package com.berezin.util;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
            try {
                Class.forName("org.hsqldb.jdbcDriver");
            } catch (ClassNotFoundException e) {
                System.out.println("Драйвер не найден");
                e.printStackTrace();
            }
            try{
                con = DriverManager.getConnection("jdbc:hsqldb:mem:ClientDB", "SA", "");
            }
            catch (SQLException e) {
                System.out.println("Ошибка подключенияк базе");
                e.printStackTrace();
            }
            try {
                Statement statement = con.createStatement();
                String sql = "CREATE TABLE Clients (clientId INT PRIMARY KEY NOT NULL IDENTITY,firstName VARCHAR (50) ,secondName VARCHAR (50) , lastName VARCHAR (50) )";
                statement.executeUpdate(sql);
            } catch (SQLException e) {
                System.out.println("Неудалось создать таблицу");
                e.printStackTrace();
            }
            return con;
        }
    }

}
