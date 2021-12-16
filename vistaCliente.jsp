
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
        <%!
           String cedula="",direccion="",correo="",nombre="",telefono=""; 
        %>
    
        <h1>Clientes</h1>
        
        <%
        if(request.getParameter("men")!=null){
        String mensaje=request.getParameter("men");
        out.print("<script>alert('"+mensaje+"')</script>");
        cedula="";direccion="";correo="";nombre="";telefono=""; 
        }
        
        if(request.getParameter("ced")!=null){
            cedula=request.getParameter("ced");
            direccion=request.getParameter("direccion");
            correo=request.getParameter("correo");
            nombre=request.getParameter("nombre");
            telefono=request.getParameter("telefono");
            }
        %>
        
         <form action="Cliente" method="post">
        <div><label>Cedula:   </label><input type="text"  name="cedula"    value="<%=cedula%>"    required/></div>
        <div><label>Direccion:</label><input type="text"  name="direccion" value="<%=direccion%>" required/></div>
        <div><label>Correo:   </label><input type="email" name="correo"    value="<%=correo%>"    required/></div>
        <div><label>Nombre:   </label><input type="text"  name="nombre"    value="<%=nombre%>"    required/></div>
        <div><label>Telefono: </label><input type="text"  name="telefono"  value="<%=telefono%>"  required/></div>
        <div><input type="submit" name="registrar"  value="Registrar"  required/>
             <input type="submit" name="actualizar" value="Actualizar" required/>
             <input type="submit" name="eliminar"   value="Eliminar" required/>
        </div>
        </form>
        <hr>
        <form action="Cliente" method="post">
        <div><label>Cedula:</label><input type="text" name="cedula" required/>
        <input type="submit" name="consultar" value="Consultar" required/></div>
        </from>
        
     </body>
</html>









