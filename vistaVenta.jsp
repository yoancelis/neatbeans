
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%!
           String codigo="",cedula_cliente="",cedula_usuario="",iva="",total="",valor=""; 
        %>
    <body>
        <h1>Ventas</h1>
        
        <%
        if(request.getParameter("men")!=null){
        String mensaje=request.getParameter("men");
        out.print("<script>alert('"+mensaje+"')</script>");
        codigo="";cedula_cliente="";cedula_usuario="";iva="";total="";valor=""; 
        }
        
        if(request.getParameter("codigo")!=null){
            codigo=request.getParameter("codigo");
            cedula_cliente=request.getParameter("cedula_cliente");
            cedula_usuario=request.getParameter("cedula_usuario");
            iva=request.getParameter("iva");
            total=request.getParameter("total");
            valor=request.getParameter("valor");
            }
        %>
        
        <form action="Venta" method="post">
        <div><label>Codigo:            </label><input type="text"     name="codigo"          value="<%=codigo%>"          required/></div>
        <div><label>Cedula Cliente:    </label><input type="text"     name="cedula_cliente"  value="<%=cedula_cliente%>"  required/></div>
        <div><label>Cedula Usuario:    </label><input type="text"     name="cedula_usuario"  value="<%=cedula_usuario%>"  required/></div>
        <div><label>Iva:               </label><input type="text"     name="iva"             value="<%=iva%>"             required/></div>
        <div><label>Total:             </label><input type="text"     name="total"           value="<%=total%>"           required/></div>
        <div><label>Valor:             </label><input type="text"     name="valor"           value="<%=valor%>"         required/></div>
        <div><input type="submit" name="registrar"  value="Registrar"  required/>
             <input type="submit" name="actualizar" value="Actualizar" required/>
             <input type="submit" name="eliminar"   value="Eliminar" required/>
        </div>
        </form>
        <hr>
        <form action="Venta" method="post">
        <div><label>Codigo:</label><input type="text" name="codigo" required/>
        <input type="submit" name="consultar" value="Consultar" required/></div>
        </from>
        
    </body>
    
</html>
