<%-- 
    Document   : agr
    Created on : jul 20, 2017, 5:23:12 p.m.
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
        <title>Modificar Usuario</title>
        <jsp:include page="/WEB-INF/view/imports.jsp"/>
    </head>
    <body onload="document.forms.formModUser.usua_usuario.focus();">

        <jsp:include page="../menu.jsp"/>
        <!--<form name="formModUser" action="update" method="POST">-->
        <div class="panel panel-default">
            <div class="panel-heading">
                Modificar usuario
            </div>
            <div class="panel-body">
                <sf:form cssClass="form-horizontal" action="update" name="formModUser" method="POST" commandName="usr"> 
                    <%--            <input type="hidden" name="usua_id" value="${usr.usua_id}"/>--%>
                    <sf:hidden path="usua_id"/>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="usua_usuario">Usuario:</label>
                        <div class="col-sm-10">
                            <sf:input path="usua_usuario"/>
                            <sf:errors path="usua_usuario" cssClass="error"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="usua_password">Password:</label>
                        <div class="col-sm-10">
                            <input id="usua_password" name="usua_password" type="password" value="${usr.usua_password}" />
                            <sf:errors path="usua_password" cssClass="error"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="usua_password">Permiso:</label>
                        <div class="col-sm-10">

                            <sf:select path="usua_permiso" >
                                <sf:option value=""></sf:option> 
                                <sf:option value="ROLE_ADMIN">Administrador</sf:option>
                                <sf:option value="ROLE_USER">Usuario</sf:option>
                            </sf:select>
                            <sf:errors path="usua_permiso" cssClass="error"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="usua_estado">Estado:</label>
                        <div class="col-sm-10">
                            <sf:select path="usua_estado" >                                
                                <sf:option value="1">Activo</sf:option>
                                <sf:option value="0">Inactivo</sf:option>
                            </sf:select>
                            <sf:errors path="usua_estado" cssClass="error"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="button" onclick="javascript:guardarCambiosUsuario();" class="btn btn-default">Guardar cambios</button>
                        </div>
                    </div>
                  

                </sf:form>
            </div>
        </div>
    </body>
</html>
