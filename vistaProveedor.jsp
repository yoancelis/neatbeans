
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
        <%!
           String nit="",ciudad="",nombre="",telefono=""; 
        %>
    <body>
        <h1>Proveedores</h1>
        
        <%
        if(request.getParameter("men")!=null){
        String mensaje=request.getParameter("men");
        out.print("<script>alert('"+mensaje+"')</script>");
        nit="";ciudad="";nombre="";telefono=""; 
        }
        
        if(request.getParameter("nit")!=null){
            nit=request.getParameter("nit");
            ciudad=request.getParameter("ciudad");
            nombre=request.getParameter("nom");
            telefono=request.getParameter("telefono");
            }
        %>
        
        <form action="Proveedor" method="post">
        <div><label>Nit:      </label><input type="text"  name="nit"      value="<%=nit%>"      required/></div>
        <div><label>Ciudad:   </label><input type="text"  name="ciudad"   value="<%=ciudad%>"   required/></div>
        <div><label>Nombre:   </label><input type="text"  name="nombre"   value="<%=nombre%>"   required/></div>
        <div><label>Telefono: </label><input type="text"  name="telefono" value="<%=telefono%>" required/></div>
        <div><input type="submit" name="registrar"  value="Registrar"  required/>
             <input type="submit" name="actualizar" value="Actualizar" required/>
             <input type="submit" name="eliminar"   value="Eliminar" required/>
        </div>
        </form>
        <hr>
        <form action="Proveedor" method="post">
        <div><label>Nit:</label><input type="text" name="nit" required/>
        <input type="submit" name="consultar" value="Consultar" required/></div>
        </from>
    </body>
