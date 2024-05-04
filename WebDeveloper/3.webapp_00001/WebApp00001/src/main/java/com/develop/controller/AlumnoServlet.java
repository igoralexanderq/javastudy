package com.develop.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.develop.dao.AlumnoDAO;
import com.develop.dao.AlumnoDAOImpl;
import com.develop.dto.MensajeDTO;
import com.develop.dto.AlumnoDTO;
import com.develop.util.HtmlResponseCode;
import com.develop.util.ServerMessage;
import com.develop.util.Util;
import com.google.gson.Gson;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Alexander
 */
@WebServlet(urlPatterns = {"/AlumnoServlet"})
public class AlumnoServlet extends HttpServlet {
    private AlumnoDAO alumnoDAO;
    private Gson gson;
    private SimpleDateFormat sdf;
    private static final Logger logger = LoggerFactory.getLogger(AlumnoServlet.class);

    public AlumnoServlet() {
        this.alumnoDAO = new AlumnoDAOImpl();
        this.gson = new Gson();
        this.sdf = new SimpleDateFormat("yyyy-MM-dd");
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {        
        String action = request.getParameter("action");  
        logger.info("processRequest: " + action);
        switch (action) {
            case "LIST": 
                getAlumnos(request, response);                      
            break;
            case "CREATE": 
                createAlumno(request, response);                      
            break;
            case "GET":
                getAlumno(request, response);
            break;
            case "UPDATE":
                updateAlumno(request, response);
            break;
            case "DELETE":
                deleteAlumno(request, response);
            break;
        }        
    }
    
    public void getAlumnos(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {                                                                                
        try {
            List<AlumnoDTO> alumnos = alumnoDAO.getAlumnos();
            if(alumnos == null) {
                prepareMessage(response, ServerMessage.EXCEPTION, HtmlResponseCode.INTERNAL_SERVER_ERROR);
            } else if(alumnos.isEmpty()) {
                prepareMessage(response, ServerMessage.NOT_RECORDS_FOUND, HtmlResponseCode.OK);
            } else {
                response.setContentType("application/json; charset=UTF-8");
                String jsonString = gson.toJson(alumnos);
                response.getWriter().write(jsonString);
            }            
        } catch (IOException | SQLException e) {
            treatException("getAlumnos", e, response);                                           
        }
    }
    
    public void createAlumno(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("application/json; charset=UTF-8");
        try {     
            int i = alumnoDAO.createAlumno(validate(request));
            if(i > 0){
                MensajeDTO msg = new MensajeDTO("", "Items created: " + i); 
                response.getWriter().write(gson.toJson(msg));                                //Convert to JSON and Write                
            } else {                
                String hash = Util.getHash();                                                     //Generate hash
                response.setStatus(HtmlResponseCode.INTERNAL_SERVER_ERROR);                           //Set Status Server
                MensajeDTO msg = new MensajeDTO(hash, ServerMessage.M500);     //Create Message
                response.getWriter().write(gson.toJson(msg));                                //Convert to JSON and Write
                logger.error("createAlumno: " + hash);
                logger.error("createAlumno: No se registró el alumno.");                    //Logging hash
            }           
        } catch (Exception e) {                                                              //EXCEPTION
            treatException("createAlumno", e, response);
        }
    }
    
    public void getAlumno(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, SQLException {
   
        response.setContentType("application/json; charset=UTF-8");
        try {
                
            int idalumno = Integer.parseInt(request.getParameter("alumno"));  
            AlumnoDTO alumnoDTO = alumnoDAO.getAlumno(idalumno);            
            if(alumnoDTO != null) {
                String jsonString = gson.toJson(alumnoDTO);
                response.getWriter().write(jsonString);
            } else {
                String hash = Util.getHash();                                                     //Generate hash
                response.setStatus(HtmlResponseCode.INTERNAL_SERVER_ERROR);                           //Set Status Server
                MensajeDTO msg = new MensajeDTO(hash, "Alumno no existente");  //Create Message
                response.getWriter().write(gson.toJson(msg));                                //Convert to JSON and Write
                logger.error("getAlumno: " + hash);
                logger.error("getAlumno: Alumno no existente.");                            //Logging hash
            }
            
        } catch (IOException | NumberFormatException e) {
            treatException("getAlumno", e, response);
        }
    }
    
    public void updateAlumno(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, SQLException {      
        response.setContentType("application/json; charset=UTF-8");
        try {                       
            AlumnoDTO alumnoDTO = validate(request);
            int i = alumnoDAO.updateAlumno(alumnoDTO);
            if(i > 0) {
                MensajeDTO msg = new MensajeDTO("", "Items updated: " + i);      //Create Message
                response.getWriter().write(gson.toJson(msg));                                //Convert to JSON and Write
            } else {
                String hash = Util.getHash();                                                     //Generate hash
                response.setStatus(HtmlResponseCode.INTERNAL_SERVER_ERROR);                           //Set Status Server
                MensajeDTO msg = new MensajeDTO(hash, ServerMessage.M500);     //Create Message
                response.getWriter().write(gson.toJson(msg));                                //Convert to JSON and Write
                logger.error("updateAlumno: " + hash);
                logger.error("updateAlumno: No se actualizó el alumno.");                    //Logging hash
            }
        } catch (IOException | NumberFormatException e) {
            treatException("updateAlumno", e, response);
        }
    }
    
    public void deleteAlumno(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, SQLException {
      
        response.setContentType("application/json; charset=UTF-8");
        try {

            String alumnos = request.getParameter("alumnos");
            int i = alumnoDAO.deleteAlumno(alumnos);
            if(i > 0) {
                MensajeDTO msg = new MensajeDTO("", "Items deleted: " + i);      //Create Message
                response.getWriter().write(gson.toJson(msg));                                //Convert to JSON and Write
            } else {
                String hash = Util.getHash();                                                     //Generate hash
                response.setStatus(HtmlResponseCode.INTERNAL_SERVER_ERROR);                           //Set Status Server
                MensajeDTO msg = new MensajeDTO(hash, ServerMessage.M500);     //Create Message
                response.getWriter().write(gson.toJson(msg));                                //Convert to JSON and Write
                logger.error("deleteAlumno: " + hash);
                logger.error("deleteAlumno: No se eliminaron los registros.");                    //Logging hash
            }
        } catch (IOException | NumberFormatException  e) {
            treatException("deleteAlumno", e, response);
        }
    }

    public AlumnoDTO validate(HttpServletRequest request) {
        AlumnoDTO alumnoDTO = new AlumnoDTO();
        alumnoDTO.setIdalumno(Integer.parseInt(request.getParameter("idalumno")));
        alumnoDTO.setAppaterno(request.getParameter("appaterno"));
        alumnoDTO.setApmaterno(request.getParameter("apmaterno"));
        alumnoDTO.setNombres(request.getParameter("nombres"));
        alumnoDTO.setNacimiento(java.sql.Date.valueOf(request.getParameter("nacimiento")));
        alumnoDTO.setDireccion(request.getParameter("direccion"));
        alumnoDTO.setReferencia(request.getParameter("referencia"));
        alumnoDTO.setGenero(request.getParameter("genero"));
        alumnoDTO.setEstado(request.getParameter("estado"));
        return alumnoDTO;
    }

    public void treatException(String method, Exception e, HttpServletResponse response) 
            throws IOException {        
        response.setContentType("application/json; charset=UTF-8");
        response.setStatus(HtmlResponseCode.INTERNAL_SERVER_ERROR);
        String hash = Util.getHash();
        MensajeDTO msg = new MensajeDTO(hash, ServerMessage.M500);
        response.getWriter().write(gson.toJson(msg));
        logger.error(method + ": " + hash);
        logger.error(method + ": " + e.getMessage(), e);
    }

    public void prepareMessage(HttpServletResponse response, String message, int status) {
        response.setContentType("application/json; charset=UTF-8");
        response.setStatus(status);
        try {
            String hash = Util.getHash();
            MensajeDTO msg = new MensajeDTO(hash, message);
            response.getWriter().write(gson.toJson(msg));
        } catch (IOException e) {
            logger.error("prepareMessage: " + e.getMessage(), e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AlumnoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AlumnoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
