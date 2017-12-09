<%-- 
    Document   : lis_tar_fin
    Created on : 29-may-2017, 10:23:19
    Author     : Cesar Aguirre Vega
    --%>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <sf:form cssClass="form-inline" id="tareaFormBusq" name="tareaFormBusq" commandName="tareaBusqueda">

    <div class="panel panel-default">
        <div class="panel-body">        
            <sf:hidden path="tare_estado"  value="FINALIZADA"/> 
            <!--<div class="form-group">
                <label for="tare_codigo">Codigo:</label>       
                <sf:input  path="tare_codigo" cssClass="form-control" type="text" size="10"/> 
            </div>
            <div class="form-group">
                <label for="tare_descripcion">Descripci&oacute;n:</label>       
                <sf:input path="tare_descripcion" type="text" cssClass="form-control" />
            </div>    
            <div class="form-group">
                <label for="tare_fechainicio">Inicio:</label>       
                <sf:input path="tare_fechainicio" type="text" cssClass="form-control" />
            </div>      
            <div class="form-group">
                <label for="tare_fechafin">Fin:</label>       
                <sf:input path="tare_fechafin" type="text" cssClass="form-control" />
            </div>              
            <button type="button" onclick="javascript:filtrarTarea('div-lis-tar-fin');" class="btn btn-default">Filtrar</button>  
            <button type="reset" class="btn btn-default">Limpiar</button> -->
            <div class="row">
                <div class="col col-sm-3 text-center">Codigo</div>
                <div class="col col-sm-3 text-center">Descripci&oacute;n</div>
                <div class="col col-sm-3 text-center">Inicio</div>
                <div class="col col-sm-3 text-center">Fin</div>
            </div>  

            <div class="row">
                <div class="col col-sm-3 text-center"> <sf:input  path="tare_codigo" cssClass="form-control" type="text" size="10"/> </div>
                <div class="col col-sm-3 text-center"> <sf:input path="tare_descripcion" type="text" cssClass="form-control" /></div>
                <div class="col col-sm-3 text-center"> <sf:input path="tare_fechainicio" type="text" cssClass="form-control" /></div>
                <div class="col col-sm-3 text-center"> <sf:input path="tare_fechafin" type="text" cssClass="form-control" /></div>
            </div> 
            <hr>
            <div class="row">
                <div class="col col-sm-6 text-right"><button type="button" onclick="javascript:filtrarTarea('div-lis-tar-fin');" class="btn btn-default">Filtrar</button> </div>
                <div class="col col-sm-6 text-left">
                   <button type="reset" class="btn btn-default">Limpiar</button>
               </div>
           </div>
       </div>

   </div>
</sf:form>

<div id="div-lis-tar-fin" class="panel panel-default" >
    <div class="panel-body"> 
        <table class="table table-striped">
            <tr>
                <th>Nro</th>
                <th>Descripci&oacute;n</th>
                <th>Tiempo</th>
                <th>Fecha Inicio</th>
                <th>Fecha Fin</th>
            </tr>
            <c:if test="${not empty listaTareasFinalizadas}">
            <c:forEach items="${listaTareasFinalizadas}" var="t" >
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
    <c:if test="${empty listaTareasFinalizadas}">
    <tr>
        <td colspan="4" style="text-align: center">No hay tareas finalizadas</td>
    </tr>
</c:if>
</table>

</div>
</div>



<script type="text/javascript">
    $(function(){
        $("#tare_fechainicio").datepicker();
        $("#tare_fechafin").datepicker();
    });
</script>