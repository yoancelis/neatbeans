

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="WEB-INF/css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
     <%!
           String usuario="",pass=""; 
        %>
    <body>
        
    <litle>Bienvenidos a Tienda Generica</litle>
            
        <%
        if(request.getParameter("men")!=null){
        String mensaje=request.getParameter("men");
        out.print("<script>alert('"+mensaje+"')</script>");
        usuario="";pass=""; 
        }
        
        if(request.getParameter("pass")!=null){
            pass=request.getParameter("pass");
            usuario=request.getParameter("usu");
            }
        %>
        
        <form action="Usuario" method="post">
        <div><label>Usuario:   </label><input type="text"     name="usuario" value="<%=usuario%>" required/></div>
        <div><label>Contraseña:</label><input type="password" name="pass"    value="<%=pass%>"    required/></div>
        <div><input type="submit" name="aceptar"  value="Aceptar"  required/>
        <input type="submit" name="cancelar" value="Cancelar" required/></div>
        </div>
        </from> 
    </body>
</html>
