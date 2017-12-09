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
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Salika WebApp</title>
        <jsp:include page="/WEB-INF/view/imports.jsp"/>      
    </head>
    <body onload="document.forms.formSaveUser.usua_usuario.focus();">

        <jsp:include page="../menu.jsp"/>
        <!--        <form name="formSaveUser" action="save" method="POST">-->
        <div class="panel panel-default">
            <div class="panel-heading">
                Agregar usuario
            </div>
            <div class="panel-body">
                <sf:form cssClass="form-horizontal" action="save" name="formSaveUser" method="POST" commandName="usr">            
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="usua_usuario">Usuario:</label>
                        <div class="col-sm-10">
                            <sf:input path="usua_usuario" placeholder="Nombre de usuario"/>
                            <sf:errors path="usua_usuario" cssClass="error"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="usua_password">Password:</label>
                        <div class="col-sm-10">
                            <sf:password path="usua_password"/>
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
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="button" onclick="javascript:registrarUsuario();" class="btn btn-default">Registrar</button>
                        </div>
                    </div>
                </sf:form>
            </div>
        </div>
        <!--        </form>-->
    </body>
</html>
