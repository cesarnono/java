<%-- 
    Document   : index
    Created on : jul 20, 2017, 11:39:46 a.m.
    Author     : Cesar Aguirre Vega
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Salika WebApp</title>
         <jsp:include page="/WEB-INF/view/imports.jsp"/>
    </head>
    
    <body>
<!--        <h1>Gesti&oacute;n de usuarios</h1>-->
        <jsp:include page="../menu.jsp"/>
        <div class="panel panel-default">
            <div class="panel-heading">
                Gesti&oacute;n de usuarios
            </div>
            <div class="panel-body">
                
                <form name="formUser" method="post" >
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>&nbsp;</th>
                                <th>Usuario</th>
                                <th>Estado</th>
                                <th>Permiso</th>
                                <th>Fecha Registro</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${not empty usuarios}">
                                <c:forEach items="${usuarios}" var="usr" varStatus="i">
                                    <tr>
                                        <td><input type="radio" name="raduser" value="${usr.usua_id}" onclick="javascript:seleccionarUser(${usr.usua_id})" /></td>
                                        <td>${usr.usua_usuario}</td>
                                        <td>${usr.usua_estado eq '1'?'Activo':'Inactivo'}</td>
                                        <td>${fn:substring(usr.usua_permiso,5,fn:length(usr.usua_permiso))}</td>
                                        <td>${usr.usua_fecharegistro}</td>
                                    </tr>                    
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty usuarios}" >
                                <tr>
                                    <td colspan="4">No hay usuarios registrados</td>
                                </tr>
                            </c:if>        
                        </tbody>
                    </table>
                    <div>
                        <input type="button" value="Agregar" name="btnagr" class="btn btn-default" onclick="javascript:agregarUsuario();" />
                        <input type="button" value="Modificar" name="btnmod" class="btn btn-default" onclick="javascript:modificarUsuario();" />
                        <input type="button" value="Eliminar" name="btneli" class="btn btn-default" onclick="javascript:eliminarUsuario();"/>
                    </div>
                    <input type="hidden" id="hiduser" name="hiduser" value=""/>
                </form>
            </div>
            
        </div>
    </body>
</html>
