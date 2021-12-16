
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <%!
           String codigo="",cantidad="",codigo_producto="",codigo_venta="",valor_venta="",valor_iva="",valor_total=""; 
        %>
         
    <body>
        <h1>Detalles de la venta</h1>
        
        <%
        if(request.getParameter("men")!=null){
        String mensaje=request.getParameter("men");
        out.print("<script>alert('"+mensaje+"')</script>");
        codigo="";cantidad="";codigo_producto="";codigo_venta="";valor_venta="";valor_iva="";valor_total=""; 
        }
        
        if(request.getParameter("codigo")!=null){
            codigo=request.getParameter("codigo");
            cantidad=request.getParameter("cantidad");
            codigo_producto=request.getParameter("codigo_producto");
            codigo_venta=request.getParameter("codigo_venta");
            valor_venta=request.getParameter("valor_venta");
            valor_iva=request.getParameter("valor_iva");
            valor_total=request.getParameter("valor_total");
            }
        %>
        
        <form action="Detaventa" method="post">
        <div><label>Codigo:            </label><input type="text"     name="codigo"           value="<%=codigo%>"           required/></div>
        <div><label>Cantidad:          </label><input type="text"     name="cantidad"         value="<%=cantidad%>"         required/></div>
        <div><label>Codigo Producto:   </label><input type="text"     name="codigo_producto"  value="<%=codigo_producto%>"  required/></div>
        <div><label>Codigo Venta:      </label><input type="text"     name="codigo_venta"     value="<%=codigo_venta%>"     required/></div>
        <div><label>Valor Venta:       </label><input type="text"     name="valor_venta"      value="<%=valor_venta%>"      required/></div>
        <div><label>Valor Iva:         </label><input type="text"     name="valor_iva"        value="<%=valor_iva%>"        required/></div>
        <div><label>Valor Total:       </label><input type="text"     name="valor_total"      value="<%=valor_total%>"      required/></div>
        <div><input type="submit" name="registrar"  value="Registrar"  required/>
             <input type="submit" name="actualizar" value="Actualizar" required/>
             <input type="submit" name="eliminar"   value="Eliminar" required/>
        </div>
        </form>
        <hr>
        <form action="Detaventa" method="post">
        <div><label>Codigo:</label><input type="text" name="codigo" required/>
        <input type="submit" name="consultar" value="Consultar" required/></div>
        </from>
    </body>
</html>
