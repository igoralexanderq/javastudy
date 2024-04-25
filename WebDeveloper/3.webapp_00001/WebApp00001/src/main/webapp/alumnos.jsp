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
        <script>  
            const _BLANK = '';
            
            function initTable() {
                let _btnDelete = $('#linkDelete');
                _btnDelete.on('click', function() {
                    deleteAlumnos();
                });
            }
            
            $(function() {
                getAlumnos();     
                initTable();
            });
            
            $('#linkUpdate').on('click', function(){
                var valSel = $('input[name="rad_upd"]:checked').val();
                if(!valSel) 
                    alert('Debe de seleccionar un alumno');
                else {
                    window.location = 'alumnoUpdate.jsp?alumno=' + valSel;
                }

            });
            
            function getAlumnos() {
                $.ajax({
                    url: "AlumnoServlet", 
                    method: "POST", 
                    data: {
                      action: "LIST"
                    },
                    dataType: "json", 
                    success: function(r) {
                        //console.log("success");
                        //console.log(r)
                        addAlumnosToTable(r);
                    },
                    error: function(e) {
                        let _response   = e.responseJSON ?? {};
                        let _hash       = _response.hash ?? _BLANK;
                        let _message    = _response.message ?? _BLANK;
                        Alert.error(_hash, _message);              
                    }
                });
            }
            
            function addAlumnosToTable(r) {               
                let _tbody = $("#tbody");
                _tbody.html(_BLANK);
                r.forEach((e, i) => {                                  
                    const _html = 
                        '<tr>\n\
                            <td>'+ e.appaterno + ' ' + e.apmaterno + ', ' + e.nombres + '</td>\n\
                            <td>'+ e.nacimiento +'</td>\n\
                            <td>'+ e.direccion +'</td>\n\
                            <td>'+ e.referencia +'</td>\n\
                            <td>'+ e.genero +'</td>\n\
                            <td colspan="2">'+ e.estado +'</td>\n\
                            <th>\n\
                                <input type="checkbox" value="'+ e.idalumno +'" name="chk_del"/>\n\
                            </th>\n\
                            <th>\n\
                                <input type="radio" value="'+ e.idalumno +'" name="rad_upd"/>\n\
                            </th>\n\
                        </tr>';
                     //console.log(_html);
                    _tbody.append(_html);
                });
            }
            
            function deleteAlumnos() {
                var valChecks = $('input[name="chk_del"]:checked').map(function() {
                        return $(this).val();
                    }).get().join(",");
                    console.table(valChecks);
                    
                    if(valChecks === "") {
                        alert("Seleccione al menos un alumno.");
                    } else {
                        if(confirm("Está seguro de eliminar los alumnos seleccionados?")) {
                            $.ajax({
                                url: "AlumnoServlet", 
                                method: "POST", 
                                data: {
                                  action: "DELETE",
                                  alumnos: valChecks
                                },
                                dataType: "json", 
                                success: function(r) {                                    
                                    let _message = r.message ?? _BLANK;
                                    Alert.success(_message);
                                    getAlumnos();
                                    initTable();
                                },
                                error: function(e) {
                                    let _response   = e.responseJSON ?? {};
                                    let _hash       = _response.hash ?? _BLANK;
                                    let _message    = _response.message ?? _BLANK;
                                    Alert.error(_hash, _message);              
                                }
                            });
                        } 
                    
                    }
            }
        </script>
    </body>
</html>
