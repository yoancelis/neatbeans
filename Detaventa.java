
package Controlador;

import Modelo.detaventaDao;
import Modelo.detaventaDto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Detaventa", urlPatterns = {"/Detaventa"})
public class Detaventa extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        detaventaDto detaDto=null;
        detaventaDao detaDao=new detaventaDao();
       
        if(request.getParameter("registrar") !=null){
            long codigo,cantidad,codigo_producto,codigo_venta;
            double valor_venta,valor_iva,valor_total;
            codigo=Long.parseLong(request.getParameter("codigo"));
            cantidad=Long.parseLong(request.getParameter("cantidad"));
            codigo_producto=Long.parseLong(request.getParameter("codigo_producto"));
            codigo_venta=Long.parseLong(request.getParameter("codigo_venta"));
            valor_venta=Double.parseDouble(request.getParameter("valor_venta"));
            valor_iva=Double.parseDouble(request.getParameter("valor_iva"));
            valor_total=Double.parseDouble(request.getParameter("valor_total"));
          
            detaDto= new detaventaDto(codigo,cantidad,codigo_producto,codigo_venta,valor_venta,valor_iva,valor_total);
            
            if(detaDao.insertaDetalleventa(detaDto)){
            response.sendRedirect("vistaDetaventa.jsp?men=Detalle de venta registrado exitosamente.");
            }else{
            response.sendRedirect("vistaDetaventa.jsp?men=Detalle de venta no registrado.");
            }
        }
        
        if(request.getParameter("consultar") !=null){
        
        long codigo=Long.parseLong(request.getParameter("codigo"));
        detaDto=detaDao.buscarDetalleventa(codigo);
        if(detaDto !=null){
        long cantidad,codigo_producto,codigo_venta;
        double valor_venta,valor_iva,valor_total;    
        cantidad=detaDto.getCantidad();
        codigo_producto=detaDto.getCodigo_producto();
        codigo_venta=detaDto.getCodigo_venta();
        valor_venta=detaDto.getValor_venta();
        valor_iva=detaDto.getValor_iva();
        valor_total=detaDto.getValor_total();
        response.sendRedirect("vistaDetaventa.jsp?codigo="+codigo+"&cantidad="+cantidad+"&codigo_producto="+codigo_producto+
                "&codigo_venta="+codigo_venta+"&valor_venta="+valor_venta+"&valor_iva="+valor_iva+"&valor_total="+valor_total);
        }else{
        response.sendRedirect("vistaDetaventa.jsp?men=Detalle de venta no encontrado.");
        }
        }
    
        if(request.getParameter("actualizar") !=null){
            long codigo,cantidad,codigo_producto,codigo_venta;
            double valor_venta,valor_iva,valor_total;
            codigo=Long.parseLong(request.getParameter("codigo"));
            cantidad=Long.parseLong(request.getParameter("cantidad"));
            codigo_producto=Long.parseLong(request.getParameter("codigo_producto"));
            codigo_venta=Long.parseLong(request.getParameter("codigo_venta"));
            valor_venta=Double.parseDouble(request.getParameter("valor_venta"));
            valor_iva=Double.parseDouble(request.getParameter("valor_iva"));
            valor_total=Double.parseDouble(request.getParameter("valor_total"));
            
            detaDto= new detaventaDto(codigo,cantidad,codigo_producto,codigo_venta,valor_venta,valor_iva,valor_total);
            
            if(detaDao.actualizaDetalleventa(detaDto)){
            response.sendRedirect("vistaDetaventa.jsp?men=Detalle de venta no actualizada.");
            }else{
            response.sendRedirect("vistaDetaventa.jsp?men=Detalle de venta actualizada exitosamente.");
            }
        }
        
        if(request.getParameter("eliminar") !=null){
        long codigo=Long.parseLong(request.getParameter("codigo"));
        detaDto=detaDao.buscarDetalleventa(codigo);
        if(detaDto!=null){
        if(detaDao.eliminarDetalleventa(codigo)){
        response.sendRedirect("vistaDetaventa.jsp?men=Detalle de venta eliminado");
        }else{
        response.sendRedirect("vistaDetaventa.jsp?men=Detalle de venta no se elimino");    
        }  
      }
      
    }
    
    }
    
    
}




