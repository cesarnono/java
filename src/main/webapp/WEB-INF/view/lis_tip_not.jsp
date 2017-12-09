<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : lis_tip_not
    Created on : 26/04/2017, 07:13:31 PM
    Author     : César Aguirre Vega
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Tipos de Nota</title>
    </head>
    <body>
        <h1>Lista Tipos de Nota</h1>
        <table   width="100" cellspacing="1" cellpadding="2">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Editable</th>                   
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${not empty listaTipoNota}">
                        <c:forEach var="tn" items="${listaTipoNota}" >
                            <tr>
                                <td>${tn.tino_id}</td>
                                <td>${tn.tino_nombre}</td>
                                <td>${tn.tino_editable}</td>                               
                            </tr>                  
                        </c:forEach>

                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="4">No se encontraron registros</td>
                        </tr>
                    </c:otherwise>

                </c:choose>

            </tbody>
        </table>
    </body>
</html>
