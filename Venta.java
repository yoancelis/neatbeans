
package Controlador;

import Modelo.ventaDao;
import Modelo.ventaDto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Venta", urlPatterns = {"/Venta"})
public class Venta extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ventaDto venDto=null;
        ventaDao venDao=new ventaDao();

        
        if(request.getParameter("registrar") !=null){
            long codigo,cedula_cliente,cedula_usuario;
            double valor,total,iva;
            codigo=Long.parseLong(request.getParameter("codigo"));
            cedula_cliente=Long.parseLong(request.getParameter("cedula_cliente"));
            cedula_usuario=Long.parseLong(request.getParameter("cedula_usuario"));
            valor=Double.parseDouble(request.getParameter("valor"));
            total=Double.parseDouble(request.getParameter("total"));
            iva=Double.parseDouble(request.getParameter("iva"));
            venDto= new ventaDto(codigo,cedula_cliente,cedula_usuario,valor,total,iva);
            
            if(venDao.insertaVenta(venDto)){
            response.sendRedirect("vistaVenta.jsp?men=Venta registrada exitosamente.");
            }else{
            response.sendRedirect("vistaVenta.jsp?men=Venta no registrado.");
            }
        }
        
        if(request.getParameter("consultar") !=null){
        
        long codigo=Long.parseLong(request.getParameter("codigo"));
        venDto=venDao.buscarVenta(codigo);
        if(venDto !=null){
        long cedula_cliente,cedula_usuario;
        double valor,total,iva;
        cedula_cliente=venDto.getCedula_cliente();
        cedula_usuario=venDto.getCedula_usuario();
        valor=venDto.getValor();
        total=venDto.getTotal();
        iva=venDto.getIva();
        response.sendRedirect("vistaVenta.jsp?codigo="+codigo+"&cedula_cliente="+cedula_cliente+"&cedula_usuario="+cedula_usuario+
                "&valor="+valor+"&total="+total+"&iva="+iva);
        }else{
        response.sendRedirect("vistaVenta.jsp?men=Venta no encontrada.");
        }
        }
    
        if(request.getParameter("actualizar") !=null){
            long codigo,cedula_cliente,cedula_usuario;
            double valor,total,iva;
            codigo=Long.parseLong(request.getParameter("codigo"));
            cedula_cliente=Long.parseLong(request.getParameter("cedula_cliente"));
            cedula_usuario=Long.parseLong(request.getParameter("cedula_usuario"));
            valor=Double.parseDouble(request.getParameter("valor"));
            total=Double.parseDouble(request.getParameter("total"));
            iva=Double.parseDouble(request.getParameter("iva"));
            venDto= new ventaDto(codigo,cedula_cliente,cedula_usuario,valor,total,iva);
            
            if(venDao.actualizaVenta(venDto)){
            response.sendRedirect("vistaVenta.jsp?men=Venta no actualizada.");
            }else{
            response.sendRedirect("vistaVenta.jsp?men=Venta actualizada exitosamente.");
            }
        } 
        
        if(request.getParameter("eliminar") !=null){
        long codigo=Long.parseLong(request.getParameter("codigo"));
        venDto=venDao.buscarVenta(codigo);
        if(venDto!=null){
        if(venDao.eliminarVenta(codigo)){
        response.sendRedirect("vistaVenta.jsp?men=Venta eliminada");
        }else{
        response.sendRedirect("vistaVenta.jsp?men=La Venta no se elimino");    
        }  
      }
      
    }    
        
    }

    
}
        
