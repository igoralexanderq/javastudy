<%-- 
    Document   : alumnos
    Created on : 12 Apr 2024, 18:26:18
    Author     : Alexander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Alumnos</title>
        <style type="text/css">
            body {
                font-size: .7em
            }
        </style>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
        <link href="css/table.css" type="text/css" rel="stylesheet"/>
        <link href="css/alert.css" type="text/css" rel="stylesheet"/>
    </head>
    <body>
    <center><h1>Lista de Alumnos de Cibertec</h1></center>
        <div id="caja" style="margin: auto;width: 760px">
            <table class="navy">
                <caption>Lista de Alumnos</caption>

                <thead>
                    <tr>
                        <td>Alumno</td>
                        <td>Nacimiento</td>
                        <td>Direcci&oacute;n</td>
                        <td>Referencia</td>
                        <td>Genero</td>
                        <td>Activo</td>
                        <th style="width: 26px">
                            <a href="alumnoCreate.jsp">
                                <img src="images/ins.png" title="Nuevo Registro"/>
                            </a>
                        </th>
                        <th style="width: 26px">
                            <a id="linkDelete" target="_blank">
                                <img src="images/del.png" title="Eliminar Registros"/>
                            </a>
                        </th>
                        <th style="width: 26px">
                            <a id="linkUpdate" target="_blank">
                                <img src="images/upd.png" title="Actualizar Registro"/>
                            </a>
                        </th>
                    </tr>
                </thead>

                <tfoot>
                    <tr>
                        <th colspan="9">Cibertec - DAT</th>
                    </tr>
                </tfoot>

                <tbody id="tbody">
                  
                    
                    
                </tbody>
            </table>
        </div>
        <form id="formDel" class="navy" action="ProfesorServlet" method="post">
                <input type="hidden" name="accion" value="DEL"/>
                <input type="hidden" id="valChecks" name="valChecks"/>
        </form>
      
        <script src="jq/jquery-3.3.1.min.js"></script>
        <script src="js/alert.js"></script>
        <script src="js/alumnos.js"></script>
    </body>
</html>
