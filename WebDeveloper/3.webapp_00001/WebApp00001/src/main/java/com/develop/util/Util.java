/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.develop.util;

import com.develop.controller.AlumnoServlet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Alexander
 */
public class Util {
    private static final Logger logger = LoggerFactory.getLogger(Util.class);
    
    public static String getHash(){
        String info = String.valueOf(new Date().getTime());
        String hashString = "";

        try {           
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(info.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            hashString = hexString.toString();           
            
        } catch (NoSuchAlgorithmException e) {
            logger.error("getHash: " + e.getMessage(), e); 
        }
        return hashString;
    }
}
