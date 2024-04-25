<%-- 
    Document   : alumnoCreate
    Created on : 15 Apr 2024, 17:32:36
    Author     : Alexander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/main.css" type="text/css" rel="stylesheet"/>
        <link href="css/form.css" type="text/css" rel="stylesheet"/>
        <link href="css/alert.css" type="text/css" rel="stylesheet"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserción de alumno</title>
    </head>
    <body>
        <div id="caja" style="margin: auto;width: 280px">
            <form class="navy" action="AlumnoServlet" method="post">                
                <fieldset>
                    <legend>Datos de nuevo alumno</legend>

                    <label style="width: 60px">Ap. Paterno</label>
                    <input id="appaterno" type="text" name="appaterno" required
                           style="width: 170px" maxlength="50"/>

                    <label style="width: 60px">Ap. Materno</label>
                    <input id="apmaterno" type="text" name="apmaterno" required
                           style="width: 170px" maxlength="50"/>

                    <label style="width: 60px">Nombres</label>
                    <input id="nombres" type="text" name="nombres" required
                           style="width: 170px" maxlength="50"/>

                    <label style="width: 60px">Nacimiento</label>
                    <input id="nacimiento" type="date" name="nacimiento" required
                           style="width: 140px" maxlength="50"/>

                    <label style="width: 60px">Género</label>
                    <span>
                        <input type="radio" name="genero" value="M"
                               checked="checked"> Masculino
                        <input type="radio" name="genero" value="F"> Femenino
                    </span>

                    <label style="width: 60px">Dirección</label>
                    <textarea id="direccion" name="direccion" 
                              style="width: 170px;height: 40px"></textarea>

                    <label style="width: 60px">Referencia</label>
                    <textarea id="referencia" name="referencia" 
                              style="width: 170px;height: 40px"></textarea>

                    <label style="width: 60px">Estado</label>
                    <span>
                        <input type="radio" name="estado" value="1"
                               checked="checked"> Activo
                        <input type="radio" name="estado" value="0"> No activo
                    </span>

                    <div class="submit">
                        <input id="btnSave" type="button" value="Enviar Datos"/>
                    </div>
                </fieldset>
            </form>

            <p style="text-align: center">
                <a class="simple" href="alumnos.jsp">
                    Cancelar
                </a>
            </p>
        </div>
    </body>
    <script src="jq/jquery-3.3.1.min.js"></script>
    <script src="js/alert.js"></script>
    <script>
        let _btnSave = $("#btnSave");
        
        _btnSave.on('click', function() {
            saveAlumno();
        });
        
        function saveAlumno() {            
            let _appaterno      = $("#appaterno");
            let _apmaterno      = $("#apmaterno");
            let _nombres        = $("#nombres");
            let _nacimiento     = $("#nacimiento");
            let _genero         = $("input[type='radio'][name='genero']:checked");
            let _direccion      = $("#direccion");
            let _referencia     = $("#referencia");
            let _estado         = $("input[type='radio'][name='estado']:checked");            
            
            $.ajax({
                url: "AlumnoServlet", 
                method: "POST", 
                data: {
                    action          : "CREATE",
                    appaterno       : _appaterno.val(),
                    apmaterno       : _apmaterno.val(),
                    nombres         : _nombres.val(),
                    nacimiento      : _nacimiento.val(),
                    genero          : _genero.val(),
                    direccion       : _direccion.val(),
                    referencia      : _referencia.val(),
                    estado          : _estado.val()
                },
                dataType: "json", 
                success: function(r) {                        
                    let _message = r.message ?? _BLANK;
                    Alert.success(_message);                    
                    setTimeout(function() {
                        window.location.href = 'alumnos.jsp';
                    }, 2000);                    
                },
                error: function(e) {
                    let _response   = e.responseJSON ?? {};
                    let _hash       = _response.hash ?? _BLANK;
                    let _message    = _response.message ?? _BLANK;
                    Alert.error(_hash, _message);
                }
            }); 
        }
    </script>
</html>

