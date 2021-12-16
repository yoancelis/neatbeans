

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
      <%!
           String codigo="",iva="",nit="",nombre="",precio_compra="",precio_venta=""; 
        %>
        
    <body>
        <h1>Productos</h1>
        
        <%
        if(request.getParameter("men")!=null){
        String mensaje=request.getParameter("men");
        out.print("<script>alert('"+mensaje+"')</script>");
        codigo="";iva="";nit="";nombre="";precio_compra="";precio_venta="";
        }
        
        if(request.getParameter("codigo")!=null){
            codigo=request.getParameter("codigo");
            iva=request.getParameter("iva");
            nit=request.getParameter("nit");
            nombre=request.getParameter("nombre");
            precio_compra=request.getParameter("precio_compra");
            precio_venta=request.getParameter("precio_venta");
            }
        %>
        
        <form action="Producto" method="post">
        <div><label>Codigo:         </label><input type="text"  name="codigo"        value="<%=codigo%>"        required/></div>
        <div><label>Iva:            </label><input type="text"  name="iva"           value="<%=iva%>"           required/></div>
        <div><label>Nit Proveedor:  </label><input type="text"  name="nit"           value="<%=nit%>"           required/></div>
        <div><label>Nombre:         </label><input type="text"  name="nombre"        value="<%=nombre%>"        required/></div>
        <div><label>Precio compra:  </label><input type="text"  name="precio_compra" value="<%=precio_compra%>" required/></div>
        <div><label>Precio venta:   </label><input type="text"  name="precio_venta"  value="<%=precio_venta%>"  required/></div>
        <div><input type="submit" name="registrar"  value="Registrar"  required/>
             <input type="submit" name="actualizar" value="Actualizar" required/>
             <input type="submit" name="eliminar"   value="Eliminar" required/>
        </div>
        </form>
        <hr>
        <form action="Producto" method="post">
        <div><label>Codigo: </label><input type="text" name="codigo" required/>
        <input type="submit" name="consultar" value="Consultar" required/></div>
        </from>
    </body>
</html>
