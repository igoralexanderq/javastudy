/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.develop.dao;

import com.develop.config.ApplicationProperties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Alexander
 */
public class MySQLConnection {    
    private static MySQLConnection instance;
    private Connection connection;
    private static final Logger logger = LoggerFactory.getLogger(MySQLConnection.class);
    
    static {
        try { 
            String driver = ApplicationProperties.get("database.mysql.driver");
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            logger.error("static: " + e.getMessage(), e);
        }
    }
    
    private MySQLConnection() {   
        logger.info("MySQLConnection: Creating a new connection");
        try {
            if(connection == null || connection.isClosed()) {                                   
                String url = ApplicationProperties.get("database.mysql.url");
                String user = ApplicationProperties.get("database.mysql.user");
                String password = ApplicationProperties.get("database.mysql.password");
                connection = DriverManager.getConnection(url, user, password);
            }                    
        } catch (SQLException e) {            
            logger.error("MySQLConnection: " + e.getMessage(), e);        
        }
    }
    
    public static synchronized Connection get()  {                        
        try {
            if(instance == null || instance.connection.isClosed()) {            
                instance = new MySQLConnection();
            }
        } catch (SQLException e) {
            logger.error("get: " + e.getMessage(), e);
        }
        return instance.connection;
    }
    
    public void close() {
        if(connection != null) {
            try {                
                connection.close();                
            } catch (SQLException e) {
                logger.error("close: " + e.getMessage(), e);
            }
        }
    }
}
