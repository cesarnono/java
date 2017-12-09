<%-- 
    Document   : lis
    Created on : ago 6, 2017, 9:12:37 a.m.
    Author     : Cesar Aguirre Vega
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>



<%--<div id="div_not_${idtarea}" style="width: 100%">--%>
<tr id="div_not_${idtarea}">
    <td colspan="4">
        <table class="table">
            <thead>
                <tr>
                    <th>&nbsp;</th>
                    <th style="width: 15%">Tipo</th>
                    <th style="width: 65%">Descripci&oacute;n</th>
                    <th style="width: 20%">Fecha</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${not empty listaNotas}">
                    <c:forEach items="${listaNotas}" var="nota" varStatus="i">
                        <tr>
                            <td><input type="radio" id="rad_nota" name="rad_nota" ${nota.tipoNotaVO.tino_editable == '0'? 'disabled':''} value="${nota.nota_id}" onclick="activarDesactivarModificacion(${nota.nota_id})" /></td>
                            <td>${nota.nota_nombre}</td>
                            <td>
                                <span id="span-nota-des-ver_${nota.nota_id}" >${nota.nota_descripcion}</span> 
                                <span id="span-nota-des-mod_${nota.nota_id}" style="display: none">
                                    <textarea id="txa-nota-des_${nota.nota_id}" name="txa-nota-des" rows="2"  cols="60" style="text-align: left;white-space: normal"  wrap="hard" >
                                        ${fn:trim(nota.nota_descripcion) }
                                    </textarea>
                                </span>

                            </td>
                            <td>${nota.nota_fecharegistro}</td>
                        </tr>                    
                    </c:forEach>
                </c:if>
                <c:if test="${empty listaNotas}">
                    <tr>
                        <td colspan="4" style="text-align: center">No existe actividad </td>

                    </tr>                    
                </c:if>
                <tr>
                    <td colspan="4" style="text-align: right">
                        <!--<a href="nota/veridtarea">ver id tarea actual</a>-->
                        <button type="button" onclick="actualizarDescripcionNota(${idtarea});" class="btn btn-default">Actualizar</button>
                    </td>
                      
</tr>    
</tbody>
</table>
</td>
</tr>
<input  type="hidden" id="idNotaUpdate" name="idNotaUpdate" value=""/>

<!--</div> -->

