   
<%-- 
    Document   : lis_tar_fin
    Created on : 01-oct-2017, 10:23:19
    Author     : César Aguirre Vega
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <div class="panel-body"> 
        <table class="table table-striped">
            <tr>
                <th>Nro</th>
                <th>Descripci&oacute;n</th>
                <th>Tiempo</th>
                <th>Fecha Inicio</th>
                <th>Fecha Fin</th>
            </tr>
            <c:if test="${not empty listaTareas}">
                <c:forEach items="${listaTareas}" var="t" >
                    <tr>
                        <td style="width: 8%">${t.tare_codigo}</td>
                        <td style="width: 41%">${t.tare_descripcion}</td>
                        <td style="width: 15%">
                            <div id="contenedor" style="width: 100%">
                                <div class="reloj" id="dias_${t.tare_id}">${t.dias}</div>
                                <div class="reloj" >:<span id="horas_${t.tare_id}"> ${t.horas}</span> </div>
                                <div class="reloj" >: <span id="minutos_${t.tare_id}"> ${t.minutos}</span> </div>
                                <div class="reloj" >: <span id="segundos_${t.tare_id}"> ${t.segundos}</span> </div> 

                            </div>
                        </td>
                        <td style="width: 18%">
                            ${t.tare_fechainicio}
                        </td>
                        <td style="width: 18%">
                            ${t.tare_fechafin}
                        </td>

                    </tr>                            
                </c:forEach>
            </c:if>
            <c:if test="${empty listaTareas}">
                <tr>
                    <td colspan="4" style="text-align: center">No hay tareas finalizadas</td>
                </tr>
            </c:if>
        </table>

    </div>
