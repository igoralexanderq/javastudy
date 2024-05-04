/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.develop.dao;

import com.develop.dto.AlumnoDTO;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Alexander
 */
public interface AlumnoDAO {
    public List getAlumnos() throws SQLException;
    public int createAlumno(AlumnoDTO alumno) throws SQLException;
    public int updateAlumno(AlumnoDTO alumno) throws SQLException;
    public AlumnoDTO getAlumno(int idalumno) throws SQLException;
    public int deleteAlumno(String idx) throws SQLException;
}
