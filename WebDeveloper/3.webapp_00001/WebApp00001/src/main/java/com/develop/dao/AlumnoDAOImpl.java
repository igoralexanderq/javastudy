/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.develop.dao;

import com.develop.dto.AlumnoDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Alexander
 */
public class AlumnoDAOImpl implements AlumnoDAO {
    private static final String SQL_GET_ALUMNOS = "CALL sp_get_alumnos();";
    private static final String SQL_CREATE_ALUMNO = "CALL sp_create_alumno(?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SQL_UPDATE_ALUMNO = "CALL sp_update_alumno(?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SQL_GET_ALUMNO = "CALL sp_get_alumno(?);";
    private static final String SQL_DELETE_ALUMNO = "CALL sp_delete_alumno(?);";

    private static final Logger logger = LoggerFactory.getLogger(AlumnoDAOImpl.class);

    @Override
    public List<AlumnoDTO> getAlumnos() throws SQLException {
        List<AlumnoDTO> alumnos = null;               
        try (
            Connection cn = MySQLConnection.get();
            CallableStatement cs = cn.prepareCall(SQL_GET_ALUMNOS);            
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
            logger.info("getAlumnos: " + SQL_GET_ALUMNOS);
            logger.info("count: " + alumnos.size());
            
        } catch (SQLException e) {
            logger.error("getAlumnos: " + e.getMessage(), e);
            throw e;
        }        
        return alumnos;
    }

    @Override
    public int createAlumno(AlumnoDTO alumno) throws SQLException {
        int n = 0;
        try (
            Connection cn = MySQLConnection.get();
            CallableStatement cs = cn.prepareCall(SQL_CREATE_ALUMNO);                
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
            logger.info("createAlumno: " + SQL_CREATE_ALUMNO);
            logger.info("created: " + n + ", item(s)");            
        } catch (SQLException e) {
            logger.error("createAlumno: " + e.getMessage(), e); 
            throw e;
        }        
        return n;
    }

    @Override
    public int updateAlumno(AlumnoDTO alumno) throws SQLException{
        int n = 0;
        try (
            Connection cn = MySQLConnection.get();
            CallableStatement cs = cn.prepareCall(SQL_UPDATE_ALUMNO);
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
            logger.info("updateAlumno: " + SQL_UPDATE_ALUMNO);
            logger.info("updated: " + n + ", item(s)");            
        } catch (Exception e) {
            logger.error("updateAlumno: " + e.getMessage(), e); 
            throw e;
        }
        return n;
    }

    @Override
    public AlumnoDTO getAlumno(int idalumno) throws SQLException{
        ResultSet rs = null;
        AlumnoDTO alumnoDTO = null;
        int i = 0;        
        try(
            Connection cn = MySQLConnection.get();
            CallableStatement cs = cn.prepareCall(SQL_GET_ALUMNO);            
        ) {
            cs.setInt(1, idalumno);            
            rs = cs.executeQuery();
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
            logger.info("getAlumno: " + SQL_GET_ALUMNO);
            logger.info("count: " + i);            
        } catch (SQLException e) {
            logger.error("getAlumno: " + e.getMessage(), e); 
            throw e;
        } finally {
            rs.close();
        }
        
        return alumnoDTO;
    }

    @Override
    public int deleteAlumno(String idx) throws SQLException{
        int i = 0;        
        try (
            Connection cn = MySQLConnection.get();
            CallableStatement cs = cn.prepareCall(SQL_DELETE_ALUMNO);
        ){            
            cs.setString(1, idx);            
            i = cs.executeUpdate();
            logger.info("deleteAlumno: " + SQL_DELETE_ALUMNO);
            logger.info("deleted: " + i + ", item(s)");            
        } catch (SQLException e) {
            logger.error("deleteAlumno: " + e.getMessage(), e); 
            throw e;
        }
        return i;
    }
    
}
