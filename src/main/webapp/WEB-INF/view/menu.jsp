<%-- 
    Document   : menu
    Created on : jul 22, 2017, 7:48:53 a.m.
    Author     : Cesar Aguirre Vega
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 

<div class="page-header">
    <h2>Controla el tiempo de tus tareas</h2>
</div>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">   
        <sec:authorize access="!isAuthenticated()">
            <ul class="nav navbar-nav" >
                <li><a href="/logout">Por favor inicie sesi&oacute;n</a></li>
            </ul>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <p class="navbar-text">Bienvenido : ${pageContext.request.userPrincipal.name}</p>
            <ul class="nav navbar-nav">                
                <li><a href="<c:url value="${request.contextPath}/"/>">Inicio</a></li>

                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li><a href="<c:url value="${request.contextPath}/user/index"/>">Usuarios</a></li>
                    </sec:authorize>
                <li><a href="<c:url value="/logout" />">Salir</a></li>
            </ul>
        </sec:authorize>


    </div>
</nav>