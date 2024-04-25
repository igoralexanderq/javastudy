/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.develop.config;

import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Alexander
 */
public class ApplicationProperties extends Properties{
    private static ApplicationProperties instace;
        
    private ApplicationProperties() {
        super();
        try {
            load(ApplicationProperties.class.getResourceAsStream("/application.properties"));
        } catch (IOException e) {
            
        }
    };
    
    private static ApplicationProperties getInstance() {
        if(instace == null) {
            synchronized (ApplicationProperties.class) {
                if(instace == null) {
                    instace = new ApplicationProperties();
                }
            }
        }
        return instace;
    }
    
    public static String get(String key) {
        String prop = ApplicationProperties.getInstance().getProperty(key);
        return prop;
    }
    
    public static void main(String[] args) {
        System.err.println(ApplicationProperties.get("database.mysql.url"));
    }
}
