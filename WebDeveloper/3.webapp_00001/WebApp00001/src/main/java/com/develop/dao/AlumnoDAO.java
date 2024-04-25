/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.develop.dao;

import com.develop.dto.AlumnoDTO;
import java.util.List;

/**
 *
 * @author Alexander
 */
public interface AlumnoDAO {
    public List getAlumnos();
    public int createAlumno(AlumnoDTO alumno);
    public int updateAlumno(AlumnoDTO alumno);
    public AlumnoDTO getAlumno(int idalumno);
    public int deleteAlumno(String idx);
}
