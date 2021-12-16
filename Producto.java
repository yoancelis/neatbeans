
package Controlador;

import Modelo.productoDao;
import Modelo.productoDto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Producto", urlPatterns = {"/Producto"})
public class Producto extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        productoDto proDto=null;
        productoDao proDao=new productoDao();
    
        if(request.getParameter("registrar") !=null){
            long codigo;
            double  iva,precio_compra,precio_venta;
            String nit,nombre;
            
            codigo=Long.parseLong(request.getParameter("codigo"));
            iva=Double.parseDouble(request.getParameter("iva"));
            nit=request.getParameter("nit");
            nombre=request.getParameter("nombre");
            precio_compra=Double.parseDouble(request.getParameter("precio_compra"));
            precio_venta=Double.parseDouble(request.getParameter("precio_venta"));
            proDto= new productoDto(codigo,iva,nit,nombre,precio_compra,precio_venta);
            
            if(proDao.insertaProducto(proDto)){
            response.sendRedirect("vistaProducto.jsp?men=Producto registrado exitosamente.");
            }else{
            response.sendRedirect("vistaProducto.jsp?men= Producto no registrado.");
            }
        }
        
        if(request.getParameter("consultar") !=null){
        
        long codigo=Long.parseLong(request.getParameter("codigo"));
        proDto=proDao.buscarProducto(codigo);
        if(proDto !=null){
        double  iva,precio_compra,precio_venta;
        String nit,nombre;
        iva=proDto.getIva();
        nit=proDto.getNit();
        nombre=proDto.getNombre();
        precio_compra=proDto.getPrecio_compra();
        precio_venta=proDto.getPrecio_venta();
        response.sendRedirect("vistaProducto.jsp?codigo="+codigo+"&iva="+iva+"&nit="+nit+"&nombre="+nombre+
                "&precio_compra="+precio_compra+"&precio_venta="+precio_venta);
        }else{
        response.sendRedirect("vistaProducto.jsp?men=Producto no encontrado.");
        }
        }
    
        if(request.getParameter("actualizar") !=null){
            long codigo;
            double  iva,precio_compra,precio_venta;
            String nit,nombre;
            codigo=Long.parseLong(request.getParameter("codigo"));
            iva=Double.parseDouble(request.getParameter("iva"));
            nit=request.getParameter("nit");
            nombre=request.getParameter("nombre");
            precio_compra=Double.parseDouble(request.getParameter("precio_compra"));
            precio_venta=Double.parseDouble(request.getParameter("precio_venta"));
            proDto= new productoDto(codigo,iva,nit,nombre,precio_compra,precio_venta);
            
            if(proDao.actualizaProducto(proDto)){
            response.sendRedirect("vistaProducto.jsp?men=Producto no actualizado.");
            }else{
            response.sendRedirect("vistaProducto.jsp?men=Producto actualizado exitosamente.");
            }
        }
    
        if(request.getParameter("eliminar") !=null){
        long codigo=Long.parseLong(request.getParameter("codigo"));
        proDto=proDao.buscarProducto(codigo);
        if(proDto!=null){
        if(proDao.eliminarProducto(codigo)){
        response.sendRedirect("vistaProducto.jsp?men=Producto eliminado");
        }else{
        response.sendRedirect("vistaProducto.jsp?men=Producto no se elimino");    
        }  
      }
        
    }
    }
}
