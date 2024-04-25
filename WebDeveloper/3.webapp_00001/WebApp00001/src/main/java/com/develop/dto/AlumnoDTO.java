/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.develop.dto;

import java.sql.Date;

/**
 *
 * @author Alexander
 */
public class AlumnoDTO {
    private int idalumno;
    private String appaterno;
    private String apmaterno;
    private String nombres;
    private Date nacimiento;
    //private String nacimientoYYYYMMDD;
    private String direccion;
    private String referencia;
    private String genero;
    private String estado;

    public AlumnoDTO() { }

    public AlumnoDTO(int idalumno, String appaterno, String apmaterno, 
            String nombres, Date nacimiento, String direccion, 
            String referencia, String genero, String estado) {
        this.idalumno = idalumno;
        this.appaterno = appaterno;
        this.apmaterno = apmaterno;
        this.nombres = nombres;
        this.nacimiento = nacimiento;
        this.direccion = direccion;
        this.referencia = referencia;
        this.genero = genero;
        this.estado = estado;
    }

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public String getAppaterno() {
        return appaterno;
    }

    public void setAppaterno(String appaterno) {
        this.appaterno = appaterno;
    }

    public String getApmaterno() {
        return apmaterno;
    }

    public void setApmaterno(String apmaterno) {
        this.apmaterno = apmaterno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }
    /*
    public String getNacimientoYYYYMMDD() {
        return nacimientoYYYYMMDD;
    }

    public void setNacimientoYYYYMMDD(String nacimientoYYYYMMDD) {
        this.nacimientoYYYYMMDD = nacimientoYYYYMMDD;
    }
    */
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AlumnoDTO{");
        sb.append("idalumno=").append(idalumno);
        sb.append(", appaterno=").append(appaterno);
        sb.append(", apmaterno=").append(apmaterno);
        sb.append(", nombres=").append(nombres);
        sb.append(", nacimiento=").append(nacimiento);
        //sb.append(", nacimientoYYYYMMDD=").append(nacimientoYYYYMMDD);
        sb.append(", direccion=").append(direccion);
        sb.append(", referencia=").append(referencia);
        sb.append(", genero=").append(genero);
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }  
    
    
}
