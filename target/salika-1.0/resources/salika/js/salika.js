/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



try {
    var centesimas = 0;
    var segundos = 0;
    var minutos = 0;
    var horas = 0;
    var index = -1;
    var dias = 0;
    var hayTareaEjecutandose = 'NO';

    /*$(function () {
        $("#tabs").tabs({
            beforeLoad: function (event, ui) {
                ui.jqXHR.fail(function () {
                    ui.panel.html(
                            "Ocurrio un error al cargar el contenido.");
                });
            }
        });
        if (index != -1) {
            $("#dias_" + index).css("font-weight", "bold");
            $("#horas_" + index).css("font-weight", "bold");
            $("#minutos_" + index).css("font-weight", "bold");
            $("#segundos_" + index).css("font-weight", "bold");
        }
    });*/

    function iniciarTarea(id) {
        centesimas = Number(document.getElementById("hid_centesimas_" + id).value);
        segundos = Number(document.getElementById("segundos_" + id).innerHTML);
        minutos = Number(document.getElementById("minutos_" + id).innerHTML);
        horas = Number(document.getElementById("horas_" + id).innerHTML);
        dias = Number(document.getElementById("dias_" + id).innerHTML);
        control = setInterval(cronometro, 10);
        index = id;
//        $("input[id*='inicio_']").attr("disabled", true);
        $(".botones").hide();
        $("#td_" + id).show();
        $("#inicio_" + id).prop("href", "#");
        hayTareaEjecutandose = 'SI';
        enviarAjax("iniciarTarea/" + id);
    }
    function continuarCronometrajeTarea(id) {
        //alert("continuarCronometrajeTarea");
        centesimas = Number(document.getElementById("hid_centesimas_" + id).value);
        segundos = Number(document.getElementById("segundos_" + id).innerHTML);
        minutos = Number(document.getElementById("minutos_" + id).innerHTML);
        horas = Number(document.getElementById("horas_" + id).innerHTML);
        dias = Number(document.getElementById("dias_" + id).innerHTML);
        control = setInterval(cronometro, 10);
        index = id;
        $(".botones").hide();
        $("#td_" + id).show();
        $("#inicio_" + id).prop("href", "#");
        hayTareaEjecutandose = 'SI';
    }

    function pausarTarea(id) {
        //document.getElementById("inicio_" + id).disabled = true;
        if (hayTareaEjecutandose === 'SI') {
            clearInterval(control);
            document.forms.traceTareaForm.action = "pausarTarea/" + id;
            document.forms.traceTareaForm.submit();
        }
    }
    function finalizarTarea(id) {
        if (hayTareaEjecutandose === 'SI') {
            clearInterval(control);
        }
        document.forms.traceTareaForm.action = "finalizarTarea/" + id;
        document.forms.traceTareaForm.submit();

    }

    function cronometro() {

        if (centesimas < 99) {
            centesimas++;
//            if (centesimas < 10) {
//                centesimas = "0" + centesimas
//            }
            document.getElementById("hid_centesimas_" + index).value = centesimas;
        }
        if (centesimas == 99) {
            centesimas = -1;
        }
        if (centesimas == 0) {
            segundos++;
            document.getElementById("segundos_" + index).innerHTML = segundos < 10 ? "0" + segundos : segundos;
            document.getElementById("hid_segundos_" + index).value = segundos;
        }
        if (segundos == 59) {
            segundos = -1;
        }
        if ((centesimas == 0) && (segundos == 0)) {
            minutos++;
            document.getElementById("minutos_" + index).innerHTML = minutos < 10 ? "0" + minutos : minutos;
            document.getElementById("hid_minutos_" + index).value = minutos;
        }
        if (minutos == 59) {
            minutos = -1;
        }
        if ((centesimas == 0) && (segundos == 0) && (minutos == 0)) {
            horas++;
            document.getElementById("horas_" + index).innerHTML = horas < 10 ? "0" + horas : horas;
            document.getElementById("hid_horas_" + index).value = horas;
        }
        if (horas == 23) {
            horas = -1;
        }
        if (centesimas == 0 && segundos == 0 && minutos == 0 && horas == 0) {
            dias++;
            document.getElementById("dias_" + index).innerHTML = dias < 10 ? "0" + dias : dias;
            document.getElementById("hid_dias_" + index).value = dias;
        }
        if (segundos == 45) { // cada 45 segundos se recarga la pagina
            location.reload();
        }

    }

    function enviarAjax(urlPeticion) {
//        alert( "enviarAjax");
        $.ajax({
            type: "POST",
            url: urlPeticion,
            data: {idtarea: index}
        }).done(function (e) {
//        alert( "datos guardados");
            console.log("datos guardos OK");
        });
    }

    function agregarTarea() {
        if ($("#tare_codigo").val() == '' || $("#tare_descripcion").val() == '') {
            alert('El numero y/o descripción de la tarea es obligatoria');
            return;
        }
        document.tareaForm.submit();
    }

    function seleccionarUser(idUser) {
        $("#hiduser").val(idUser);
    }

    function agregarUsuario() {
        //alert("agregarUser");
        //document.forms.formUser.action = "showSave";
       // document.forms.formUser.submit();
        location.href = "showSave";
    }

    function registrarUsuario() {
        if (confirm("Desea registrar el usuario ?")) {
            document.forms.formSaveUser.submit();
        }
    }


    function modificarUsuario() {
        //alert("agregarUser");
        if ($("#hiduser").val() == '') {
            alert("Debe seleccionar un usuario");
            return;
        }
        //document.forms.formUser.action = "showUpdate";
       // document.forms.formUser.submit();
       location.href = "showUpdate?hiduser="+$("#hiduser").val();
    }
    function guardarCambiosUsuario() {
        if (confirm("Desea guardar cambios del usuario ?")) {
            document.forms.formModUser.submit();
        }
    }

    function eliminarUsuario() {
        if (confirm("Desea eliminar el usuario ?")) {
            document.forms.formUser.action = "delete";
            document.forms.formUser.submit();
        }
    }

    function verActividadTarea(idtarea) {
        if ($("#div_not_" + idtarea).length === 0) {
            //$("#tr_" + idtarea).after("<tr id='tr_not_" + idtarea + "'><td>Esto es una prueba</td></tr>");
            $.ajax({
                type: 'GET',
                url: "nota/",
                data: {idtarea: idtarea},
                success: function (data, textStatus, jqXHR) {
                    $("#tr_" + idtarea).after(data);
                }

            });
        } else {
            $("#div_not_" + idtarea).remove();
        }

    }

    function activarDesactivarModificacion(idNota) {
        $("span[id*='span-nota-des-mod_']").hide();
        $("span[id*='span-nota-des-ver_']").show();
        $("#span-nota-des-ver_" + idNota).hide();
        $("#span-nota-des-mod_" + idNota).show();
        $("#txa-nota-des_" + idNota).focus();
        $("#idNotaUpdate").val(idNota);
    }

    function actualizarDescripcionNota(idtarea) {
        if (!haySeleccionadoRadio()) {
            alert("Seleccione la actividad a actualizar");
            return;
        }
        if (confirm('Desea actualizar la actividad ?')) {
            
            $.ajax({
                type: 'POST',
                url: "nota/actualizar",
                beforeSend: function () {
                    $("#div_not_" + idtarea).html('<td>Cargando...</>');
                },
                data: {idNota: $("#idNotaUpdate").val(),
                       descripcionNota:$("#txa-nota-des_" + $("#idNotaUpdate").val()).val() },
                success: function (data, textStatus, jqXHR) {
                   // $("#div_not_" + idtarea).html(data);
                    $("#div_not_" + idtarea).remove();
                    $("#tr_" + idtarea).after(data);
                    
                }

            });
        }

    }

    function haySeleccionadoRadio() {
        var haySeleccionado = false;
        $("input:radio").each(function () {
            //alert($(this).is(":checked"));
            if ($(this).is(":checked")) {
                haySeleccionado = true;
            }
        });
        return haySeleccionado;

    }


    function filtrarTarea(elem){
    var dataForm = $("#tareaFormBusq").serialize();
       $.ajax({
            url: 'filtrarTarea',
            type: 'GET' ,
            data:  dataForm ,
            success: function(data, textStatus, jqXHR){
                //alert(data);
                // $("#div-lis-tar-fin").html(data);
                 $("#"+elem).html(data);
            }           
        });
        //alert("ALERT");
        
    }
} catch (e) {
    alert(e.message);
}
