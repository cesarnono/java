<%-- 
    Document   : login
    Created on : 16-abr-2017, 12:40:10
    Author     : Cesar Aguirre Vega
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acceso a usuarios</title>
        <style>
            .error {
                padding: 15px;
                margin-bottom: 20px;
                border: 1px solid transparent;
                border-radius: 4px;
                color: #a94442;
                background-color: #f2dede;
                border-color: #ebccd1;
            }

            .msg {
                padding: 15px;
                margin-bottom: 20px;
                border: 1px solid transparent;
                border-radius: 4px;
                color: #31708f;
                background-color: #d9edf7;
                border-color: #bce8f1;
            }

            #login-box {
                width: 300px;
                padding: 20px;
                margin: 100px auto;
                background: #fff;
                -webkit-border-radius: 2px;
                -moz-border-radius: 2px;
                border: 1px solid #000;
            }
        </style>
    </head>
    <body onload="document.loginForm.username.focus();">
        <h1>Acceso a usuarios</h1>


        <c:if test="${param.error != null}"> 
            <p class="error">Invalido Usuario / password</p>
        </c:if>

            <form name="loginForm" action="j_spring_security_check" method="post">
            <table border="0" width="100" cellspacing="1" cellpadding="2">
                <tbody>
                    <tr>
                        <td>

                            <label for="username">Usuario:</label>
                        </td>
                        <td>
                            <input type="text" id="username" name="username"/> 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="password">Password:</label>
                        </td>
                        <td>
                            <input type="password" id="password" name="password"> 
                        </td>
                    </tr>
                    <tr>
                        <td>

                        </td>
                        <td>
                            <input name="submit" type="submit" value="Acceder"/>
                        </td>
                    </tr>
                </tbody>
            </table>





        </form>


    </body>
</html>

