/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.develop.dao;

import com.develop.config.ApplicationProperties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alexander
 */
public class MySQLConnectionOld {
    private static final String DRIVER = ApplicationProperties.get("database.mysql.driver");
    private static final String URL = ApplicationProperties.get("database.mysql.url");
    private static final String USER = ApplicationProperties.get("database.mysql.user");
    private static final String PASSWORD = ApplicationProperties.get("database.mysql.password");
    
    private static MySQLConnectionOld instance;
    private Connection connection;
    
    private MySQLConnectionOld() {        
        try {
            if(connection == null || connection.isClosed()) {                   
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }                    
        } catch (SQLException e) {            
            throw new RuntimeException("Error al conectar a la base de datos");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static synchronized Connection get() throws SQLException {                
        if(instance == null || instance.connection.isClosed()) {            
            instance = new MySQLConnectionOld();
        }
        return instance.connection;
    }
    
    public void close() {
        if(connection != null) {
            try {                
                connection.close();                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
