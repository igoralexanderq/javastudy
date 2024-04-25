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
    private int id;
    private String hash;
    private int code;
    private String message;
    
    public MensajeDTO() {}

    public MensajeDTO(int id, String hash, int code, String message) {
        this.id = id;
        this.hash = hash;
        this.code = code;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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
        sb.append("id=").append(id);
        sb.append(", hash=").append(hash);
        sb.append(", code=").append(code);
        sb.append(", message=").append(message);
        sb.append('}');
        return sb.toString();
    }
}
