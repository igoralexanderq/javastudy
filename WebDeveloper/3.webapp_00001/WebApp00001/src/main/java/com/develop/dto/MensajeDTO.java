/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.develop.dto;

/**
 *
 * @author Alexander
 */
public class MensajeDTO {  
    private String hash;
    private String message;
    
    public MensajeDTO() {}

    public MensajeDTO(String hash, String message) {
        this.hash = hash;        
        this.message = message;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MensajeDTO{");        
        sb.append(", hash=").append(hash);        
        sb.append(", message=").append(message);
        sb.append('}');
        return sb.toString();
    }
}
