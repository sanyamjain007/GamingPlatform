/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame.database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author sajain
 */
public class Database {
    public static Connection getConnection() {
        Connection connection = null;
        try { 
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rpggame?useSSL=false", "root", "123456");
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
