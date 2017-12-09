<%-- 
    Document   : lis_tar_eje
    Created on : ago 20, 2017, 10:09:40 a.m.
    Author     : Cesar Aguirre Vega
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div class="panel panel-default">
    <div class="panel-body">        
        <sf:form cssClass="form-inline" name="tareaForm" action="${pageContext.request.contextPath}/regtarea" method="post" commandName="tareaN">
            <div class="form-group">
                <label for="tare_codigo">Codigo:</label>       
                <sf:input  path="tare_codigo" cssClass="form-control" type="text"/> 
            </div>
            <div class="form-group">
                <label for="tare_descripcion">Descripci&oacute;n:</label>       
                <sf:input path="tare_descripcion" type="text" cssClass="form-control" size="60" />
            </div>
            <button type="button" onclick="javascript:agregarTarea();" class="btn btn-default">Agregar</button>
            <!--<a href="javascript:agregarTarea();"><img src="resources/imagenes/add.png" title="agregar tarea" /></a>-->
        </sf:form>
    </div>

</div>
<div id="divlistarea" class="panel panel-default" >
    <div class="panel-body"> 
        <sf:form id="traceTareaForm" name="traceTareaForm" method="post" >
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Codigo</th>
                        <th>Descripci&oacute;n</th>
                        <th>Tiempo(dd:hh:mm:ss)</th>
                        <th>&nbsp;</th>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${not empty usuario.tareas}">
                        <c:forEach items="${usuario.tareas}" var="t" >

                            <tr id="tr_${t.tare_id}">
                                <td style="width: 10%">${t.tare_codigo}</td>
                                <td style="width: 45%">${t.tare_descripcion}</td>
                                <td style="width: 25%">
                                    <!--                                                <div id="contenedor" >-->
                                    <div class="reloj" id="dias_${t.tare_id}">${t.dias}</div>
                                    <div class="reloj" >:<span id="horas_${t.tare_id}"> ${t.horas}</span> </div>
                                    <div class="reloj" >: <span id="minutos_${t.tare_id}"> ${t.minutos}</span> </div>
                                    <div class="reloj" >: <span id="segundos_${t.tare_id}"> ${t.segundos}</span> </div> 
                                    <input type="hidden" id="hid_dias_${t.tare_id}" name="dias_${t.tare_id}" value="${t.tare_dias}" />
                                    <input type="hidden" id="hid_horas_${t.tare_id}" name="horas_${t.tare_id}" value="${t.tare_horas}" />
                                    <input type="hidden" id="hid_minutos_${t.tare_id}" name="minutos_${t.tare_id}" value="${t.tare_minutos}"/>
                                    <input type="hidden" id="hid_segundos_${t.tare_id}" name="segundos_${t.tare_id}" value="${t.tare_segundos}" />
                                    <input type="hidden" id="hid_centesimas_${t.tare_id}" name="centesimas_${t.tare_id}"  value="${t.tare_centesimas}"/>
                                    <!--</div>-->
                                </td>
                                <td id="td_${t.tare_id}" class="botones" style="width: 20%">                                             
                                    <a id="inicio_${t.tare_id}" href="javascript:iniciarTarea('${t.tare_id}');"><img src="resources/imagenes/iniciar.png" title="iniciar" /></a>
                                    &nbsp;                                            
                                    <a id="parar_${t.tare_id}" href="javascript:pausarTarea('${t.tare_id}');"><img src="resources/imagenes/pausa.png" title="pausar" /></a>
                                    &nbsp;
                                    <a id="fin_${t.tare_id}" href="javascript:finalizarTarea('${t.tare_id}');"><img src="resources/imagenes/fin.png" title="finalizar" /></a>
                                    &nbsp;
                                    <a id="veract_${t.tare_id}" href="javascript: verActividadTarea('${t.tare_id}');"><img src="resources/imagenes/list.png" title="ver actividad" /></a>
                                </td>
                            </tr> 

                        </c:forEach>
                    </c:if>
                    <c:if test="${empty usuario.tareas}">
                        <tr>
                            <td colspan="4" style="text-align: center">No hay tareas registradas</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </sf:form>
    </div>
</div>  
<script>
    $("#tare_codigo").focus();
    <c:if test="${not empty usuario.tareaEjecionVO}">
     continuarCronometrajeTarea(${usuario.tareaEjecionVO.tare_id});
    </c:if>

</script>