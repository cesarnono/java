<%-- 
    Document   : index
    Created on : 24/04/2017, 03:02:59 PM
    Author     : César Aguirre Vega
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Salika WebApp</title>
        <style>
            #contenedor{
                margin: 1px auto;
                width: 100%;
                height: 5px;
            }
            .reloj{
                float: left;
                font-size: 13px;
                font-family:sans-serif;
                /*color: #cccccc;*/
            }

        </style>
        <link rel="stylesheet" href="<c:url value="/resources/js/jquery-ui-1.12.1.custom/jquery-ui.css"/>"/>
        <link rel="stylesheet" href="<c:url value="/resources/js/jquery-ui-1.12.1.custom/jquery-ui.theme.min.css"/>"/>
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-3.3.7/css/bootstrap.min.css"/>"/>
        <%--<link rel="stylesheet" href="<c:url value="/webjars/jquery-ui/1.9.2/css/smoothness/jquery-ui-1.9.2.custom.min.css"/>"/>--%>  
        <%--        <script src="<c:url value="/webjars/jquery-ui/1.9.2/js/jquery-1.8.3.js"/>"></script> 
                <script src="<c:url value="/webjars/jquery-ui/1.9.2/js/jquery-ui-1.9.2.custom.js"/>" ></script>--%>

        <script src="<c:url value="/resources/js/jquery-ui-1.12.1.custom/external/jquery/jquery.js"/>"></script>        
        <script src="<c:url value="/resources/js/jquery-ui-1.12.1.custom/jquery-ui.min.js"/>"></script>        
        <script src="<c:url value="/resources/css/bootstrap-3.3.7/js/bootstrap.min.js"/>"></script>        
        <script src="<c:url value="/resources/js/salika.js"/>"></script>   
    </head>
    <body >

        <jsp:include page="menu.jsp"/>


        <div id="tabs"  class="container-fluid">
            <ul class="nav nav-tabs" id="salika-tabs">
                <li class="active"><a  href="#tab1" data-url="listarTareaActuales" >Pendientes</a></li>
                <li><a href="#tab2" data-url="listarTareaFinalizada">Finalizadas</a></li>               
            </ul>
            <div  class="tab-content">
                <div id="tab1" class="tab-pane fade in active">

                </div>
                <div id="tab2" class="tab-pane fade">
                </div>
            </div>


        </div>
    </body>
    <script>       

        $(function () {
//         $('[data-toggle = "tabajax"]').click(function(e){
//             e.preventDefault();
//             var url = $(this).attr('href');
//             var target = $(this).attr('data-target');
//             $.get(url,function(data){
//                 $(target).html(data);
//             });
//             $(this).tab('show');
//             return false;
//         });

            $('#salika-tabs a').click(function (e) {
                e.preventDefault();

                var url = $(this).attr("data-url");
                var href = this.hash;
                var pane = $(this);

                // ajax load from data-url
                $(href).load(url, function (result) {
                    pane.tab('show');
                });
            });

            // load first tab content
            $('#tab1').load($('.active a').attr("data-url"), function (result) {
                $('.active a').tab('show');
            });



        });
    </script>

</html>
