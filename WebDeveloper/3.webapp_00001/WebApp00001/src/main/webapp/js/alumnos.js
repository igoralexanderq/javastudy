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
        success: function(response) {                        
            let _hash       = response.hash ?? _BLANK;
            let _message    = response.message ?? _BLANK;
            (_hash) ? Alert.warning(_message) : addAlumnosToTable(response);
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