
<%@page import="Modelo.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
        <%!
           String cedula="",correo="",nombre="",pass="",usuario=""; 
        %>
    <body>
        <h1>Usuarios</h1>
        
        <%
        if(request.getParameter("men")!=null){
        String mensaje=request.getParameter("men");
        out.print("<script>alert('"+mensaje+"')</script>");
        cedula="";correo="";nombre="";pass="";usuario=""; 
        }
        
        if(request.getParameter("ced")!=null){
            cedula=request.getParameter("ced");
            correo=request.getParameter("correo");
            nombre=request.getParameter("nom");
            pass=request.getParameter("pass");
            usuario=request.getParameter("usu");
            }
        %>
        
        <form action="Usuario" method="post">
        <div><label>Cedula:    </label><input type="text"     name="cedula"  value="<%=cedula%>"  required/></div>
        <div><label>Correo:    </label><input type="email"    name="correo"  value="<%=correo%>"  required/></div>
        <div><label>Nombre:    </label><input type="text"     name="nombre"  value="<%=nombre%>"  required/></div>
        <div><label>Contraseña:</label><input type="password" name="pass"    value="<%=pass%>"    required/></div>
        <div><label>Usuario:   </label><input type="text"     name="usuario" value="<%=usuario%>" required/></div>
        <div><input type="submit" name="registrar"  value="Registrar"  required/>
             <input type="submit" name="actualizar" value="Actualizar" required/>
             <input type="submit" name="eliminar"   value="Eliminar" required/>
        </div>
        </form>
        <hr>
        <form action="Usuario" method="post">
        <div><label>Cedula:</label><input type="text" name="cedula" required/>
        <input type="submit" name="consultar" value="Consultar" required/></div>
        </from>
        </from>
    </body>
</html>








