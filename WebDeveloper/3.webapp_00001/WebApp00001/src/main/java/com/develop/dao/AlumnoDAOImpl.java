/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.develop.dao;

import com.develop.dto.AlumnoDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Alexander
 */
public class AlumnoDAOImpl implements AlumnoDAO {
    private static final Logger logger = LoggerFactory.getLogger(AlumnoDAOImpl.class);

    @Override
    public List<AlumnoDTO> getAlumnos() {
        List<AlumnoDTO> alumnos = null;
        String sql = "CALL sp_get_alumnos();";                
        try (
            Connection cn = MySQLConnection.get();
            CallableStatement cs = cn.prepareCall(sql);            
            ResultSet rs = cs.executeQuery();
        ){   
            alumnos = new ArrayList<>();            
            while(rs.next()) {
                alumnos.add(
                    new AlumnoDTO(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        (rs.getString(9).compareTo("1") == 0 ? "Activo" : "Inactivo")
                    )
                );
            } 
            logger.info("getAlumnos: " + sql);
            logger.info("count: " + alumnos.size());
            
        } catch (Exception e) {
            logger.error("getAlumnos: " + e.getMessage(), e);
        }        
        return alumnos;
    }

    @Override
    public int createAlumno(AlumnoDTO alumno) {
        int n = 0;
        String sql = "CALL sp_create_alumno(?, ?, ?, ?, ?, ?, ?, ?);";                
        try (
            Connection cn = MySQLConnection.get();
            CallableStatement cs = cn.prepareCall(sql);                
        ){            
            cs.setString(1, alumno.getAppaterno());
            cs.setString(2, alumno.getApmaterno());
            cs.setString(3, alumno.getNombres());            
            cs.setDate(4, alumno.getNacimiento());
            cs.setString(5, alumno.getDireccion());
            cs.setString(6, alumno.getReferencia());
            cs.setString(7, alumno.getGenero());
            cs.setString(8, alumno.getEstado());
            n = cs.executeUpdate();            
            logger.info("createAlumno: " + sql);
            logger.info("created: " + n + ", item(s)");            
        } catch (Exception e) {
            logger.error("createAlumno: " + e.getMessage(), e); 
        }        
        return n;
    }

    @Override
    public int updateAlumno(AlumnoDTO alumno) {
        int n = 0;
        String sql = "CALL sp_update_alumno(?, ?, ?, ?, ?, ?, ?, ?);";  
        
        try (
            Connection cn = MySQLConnection.get();
            CallableStatement cs = cn.prepareCall(sql);
        ){
            cs.setInt(1, alumno.getIdalumno());
            cs.setString(2, alumno.getAppaterno());
            cs.setString(3, alumno.getApmaterno());
            cs.setString(4, alumno.getNombres());            
            cs.setDate(5, alumno.getNacimiento());
            cs.setString(6, alumno.getDireccion());
            cs.setString(7, alumno.getReferencia());
            cs.setString(8, alumno.getGenero());            
            n = cs.executeUpdate();
            logger.info("updateAlumno: " + sql);
            logger.info("updated: " + n + ", item(s)");            
        } catch (Exception e) {
            logger.error("updateAlumno: " + e.getMessage(), e); 
        }
        return n;
    }

    @Override
    public AlumnoDTO getAlumno(int idalumno) {
        AlumnoDTO alumnoDTO = null;
        int i = 0;
        String sql = "CALL sp_get_alumno(?);";                
        try(
            Connection cn = MySQLConnection.get();
            CallableStatement cs = cn.prepareCall(sql);
            
        ) {
            cs.setInt(1, idalumno);            
            ResultSet rs = cs.executeQuery();
            while(rs.next()) {
                alumnoDTO = new AlumnoDTO(
             rs.getInt(1), 
            rs.getString(2), 
            rs.getString(3), 
              rs.getString(4), 
           rs.getDate(5), 
            rs.getString(6), 
           rs.getString(7), 
              rs.getString(8), 
              rs.getString(9)
                );                
                i++;
            }
            
            logger.info("getAlumno: " + sql);
            logger.info("count: " + i);
            
        } catch (Exception e) {
            logger.error("getAlumno: " + e.getMessage(), e); 
        }
        return alumnoDTO;
    }

    @Override
    public int deleteAlumno(String idx) {
        int i = 0;
        String sql = "CALL sp_delete_alumnos(?);";  
        
        try (
            Connection cn = MySQLConnection.get();
            CallableStatement cs = cn.prepareCall(sql);
        ){            
            cs.setString(1, idx);            
            i = cs.executeUpdate();
            logger.info("deleteAlumno: " + sql);
            logger.info("deleted: " + i + ", item(s)");            
        } catch (Exception e) {
            logger.error("deleteAlumno: " + e.getMessage(), e); 
        }
        return i;
    }
    
}
