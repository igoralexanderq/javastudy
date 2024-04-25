package com.develop.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.develop.dao.AlumnoDAO;
import com.develop.dao.AlumnoDAOImpl;
import com.develop.dto.MensajeDTO;
import com.develop.dto.AlumnoDTO;
import com.develop.util.HtmlError;
import com.develop.util.ServerMessage;
import com.develop.util.Util;
import com.google.gson.Gson;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
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
    private static final Logger logger = LoggerFactory.getLogger(AlumnoServlet.class);

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
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
        Gson gson = new Gson();                                                                   //Create object json
        response.setContentType("application/json; charset=UTF-8");                           //Define content type
        try {
            AlumnoDAO alumnoDAO = new AlumnoDAOImpl();                                            //*DAO Implement
            List<AlumnoDTO> alumnos = alumnoDAO.getAlumnos();                                     //*Get Method
            if(alumnos != null) {                                                                 //Verify
                String jsonString = gson.toJson(alumnos);                                      //Prepare JSON
                response.getWriter().write(jsonString);                                         //Write JSON
            } else {                                                                              //ELSE: Prepare Message Error
                String hash = Util.getHash();                                                     //Generate hash
                response.setStatus(HtmlError.INTERNAL_SERVER_ERROR);                           //Set Status Server
                MensajeDTO msg = new MensajeDTO(0, hash, 1, ServerMessage.M500);     //Create Message
                response.getWriter().write(gson.toJson(msg));                                //Convert to JSON and Write
                logger.error("getAlumnos: " + hash);                                              //Logging hash
            }
        } catch (IOException e) {                                                                 //EXCEPTION  
            String hash = Util.getHash();                                                         //Generate hash
            response.setStatus(HtmlError.INTERNAL_SERVER_ERROR);                               //Set Status Server
            MensajeDTO msg = new MensajeDTO(0, hash, 1, ServerMessage.M500);         //Create Message
            response.getWriter().write(gson.toJson(msg));                                    //Convert to JSON and Write
            logger.error("getAlumnos: " + hash);                                                  //Logging hash
            logger.error("getAlumnos: " + e.getMessage(), e);                               //Logging exception
        }
    }
    
    public void createAlumno(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        Gson gson = new Gson();
        response.setContentType("application/json; charset=UTF-8");
        try {     
            AlumnoDAO alumnoDAO = new AlumnoDAOImpl();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            int i = alumnoDAO.createAlumno(new AlumnoDTO(
                    0, 
                    request.getParameter("appaterno"),
                    request.getParameter("apmaterno"),
                    request.getParameter("nombres"),                    
                    new java.sql.Date(sdf.parse(request.getParameter("nacimiento")).getTime()),
                    request.getParameter("direccion"),
                    request.getParameter("referencia"),
                    request.getParameter("genero"),
                    request.getParameter("estado")
            ));
            if(i > 0){
                MensajeDTO msg = new MensajeDTO(0, "", 0, "Items created: " + i);      //Create Message
                response.getWriter().write(gson.toJson(msg));                                //Convert to JSON and Write                
            } else {                
                String hash = Util.getHash();                                                     //Generate hash
                response.setStatus(HtmlError.INTERNAL_SERVER_ERROR);                           //Set Status Server
                MensajeDTO msg = new MensajeDTO(0, hash, 1, ServerMessage.M500);     //Create Message
                response.getWriter().write(gson.toJson(msg));                                //Convert to JSON and Write
                logger.error("createAlumno: " + hash);
                logger.error("createAlumno: No se registró el alumno.");                    //Logging hash
            }           
        } catch (ParseException e) {                                                              //EXCEPTION
            String hash = Util.getHash();                                                         //Generate hash
            response.setStatus(HtmlError.INTERNAL_SERVER_ERROR);                               //Set Status Server
            MensajeDTO msg = new MensajeDTO(0, hash, 1, ServerMessage.M500);         //Create Message
            response.getWriter().write(gson.toJson(msg));                                    //Convert to JSON and Write
            logger.error("createAlumno: " + hash);                                                //Logging hash
            logger.error("createAlumno: " + e.getMessage(), e);                             //Logging exception
        }
    }
    
    public void getAlumno(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        Gson gson = new Gson();
        response.setContentType("application/json; charset=UTF-8");
        try {
            AlumnoDAO alumnoDAO = new AlumnoDAOImpl();            
            int idalumno = Integer.parseInt(request.getParameter("alumno"));  
            AlumnoDTO alumnoDTO = alumnoDAO.getAlumno(idalumno);            
            if(alumnoDTO != null) {
                String jsonString = gson.toJson(alumnoDTO);
                response.getWriter().write(jsonString);
            } else {
                String hash = Util.getHash();                                                     //Generate hash
                response.setStatus(HtmlError.INTERNAL_SERVER_ERROR);                           //Set Status Server
                MensajeDTO msg = new MensajeDTO(0, hash, 1, "Alumno no existente");  //Create Message
                response.getWriter().write(gson.toJson(msg));                                //Convert to JSON and Write
                logger.error("getAlumno: " + hash);
                logger.error("getAlumno: Alumno no existente.");                            //Logging hash
            }
            
        } catch (IOException | NumberFormatException e) {
            String hash = Util.getHash();                                                         //Generate hash
            response.setStatus(HtmlError.INTERNAL_SERVER_ERROR);                               //Set Status Server
            MensajeDTO msg = new MensajeDTO(0, hash, 1, ServerMessage.M500);         //Create Message
            response.getWriter().write(gson.toJson(msg));                                    //Convert to JSON and Write
            logger.error("getAlumno: " + hash);                                                   //Logging hash
            logger.error("getAlumno: " + e.getMessage(), e);                                //Logging exception
        }
    }
    
    public void updateAlumno(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        Gson gson = new Gson();
        response.setContentType("application/json; charset=UTF-8");
        try {
            AlumnoDAO alumnoDAO = new AlumnoDAOImpl();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            AlumnoDTO alumnoDTO = new AlumnoDTO();
            alumnoDTO.setIdalumno(Integer.parseInt(request.getParameter("alumno")));
            alumnoDTO.setAppaterno(request.getParameter("appaterno"));
            alumnoDTO.setApmaterno(request.getParameter("apmaterno"));
            alumnoDTO.setNombres(request.getParameter("nombres"));
            alumnoDTO.setNacimiento(new java.sql.Date(sdf.parse(request.getParameter("nacimiento")).getTime()));
            alumnoDTO.setDireccion(request.getParameter("direccion"));
            alumnoDTO.setReferencia(request.getParameter("referencia"));
            alumnoDTO.setGenero(request.getParameter("genero"));            
            int i = alumnoDAO.updateAlumno(alumnoDTO);
            if(i > 0) {
                MensajeDTO msg = new MensajeDTO(0, "", 0, "Items updated: " + i);      //Create Message
                response.getWriter().write(gson.toJson(msg));                                //Convert to JSON and Write
            } else {
                String hash = Util.getHash();                                                     //Generate hash
                response.setStatus(HtmlError.INTERNAL_SERVER_ERROR);                           //Set Status Server
                MensajeDTO msg = new MensajeDTO(0, hash, 1, ServerMessage.M500);     //Create Message
                response.getWriter().write(gson.toJson(msg));                                //Convert to JSON and Write
                logger.error("updateAlumno: " + hash);
                logger.error("updateAlumno: No se actualizó el alumno.");                    //Logging hash
            }
        } catch (IOException | NumberFormatException | ParseException e) {
            String hash = Util.getHash();                                                         //Generate hash
            response.setStatus(HtmlError.INTERNAL_SERVER_ERROR);                               //Set Status Server
            MensajeDTO msg = new MensajeDTO(0, hash, 1, ServerMessage.M500);         //Create Message
            response.getWriter().write(gson.toJson(msg));                                    //Convert to JSON and Write
            logger.error("updateAlumno: " + hash);                                                //Logging hash
            logger.error("updateAlumno: " + e.getMessage(), e);                             //Logging exception
        }
    }
    
    public void deleteAlumno(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        Gson gson = new Gson();
        response.setContentType("application/json; charset=UTF-8");
        try {
            AlumnoDAO alumnoDAO = new AlumnoDAOImpl();
            String alumnos = request.getParameter("alumnos");
            int i = alumnoDAO.deleteAlumno(alumnos);
            if(i > 0) {
                MensajeDTO msg = new MensajeDTO(0, "", 0, "Items deleted: " + i);      //Create Message
                response.getWriter().write(gson.toJson(msg));                                //Convert to JSON and Write
            } else {
                String hash = Util.getHash();                                                     //Generate hash
                response.setStatus(HtmlError.INTERNAL_SERVER_ERROR);                           //Set Status Server
                MensajeDTO msg = new MensajeDTO(0, hash, 1, ServerMessage.M500);     //Create Message
                response.getWriter().write(gson.toJson(msg));                                //Convert to JSON and Write
                logger.error("deleteAlumno: " + hash);
                logger.error("deleteAlumno: No se eliminaron los registros.");                    //Logging hash
            }
        } catch (IOException | NumberFormatException  e) {
            String hash = Util.getHash();                                                         //Generate hash
            response.setStatus(HtmlError.INTERNAL_SERVER_ERROR);                               //Set Status Server
            MensajeDTO msg = new MensajeDTO(0, hash, 1, ServerMessage.M500);         //Create Message
            response.getWriter().write(gson.toJson(msg));                                    //Convert to JSON and Write
            logger.error("deleteAlumno: " + hash);                                                //Logging hash
            logger.error("deleteAlumno: " + e.getMessage(), e);                             //Logging exception
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
        processRequest(request, response);
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
        processRequest(request, response);
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
