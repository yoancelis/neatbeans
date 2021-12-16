 
package Controlador;

import Modelo.proveedorDao;
import Modelo.proveedorDto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Proveedor", urlPatterns = {"/Proveedor"})
public class Proveedor extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        proveedorDto proDto=null;
        proveedorDao proDao=new proveedorDao();
        
        if(request.getParameter("registrar") !=null){
            String nit,ciudad,nombre,telefono;
            nit=request.getParameter("nit");
            ciudad=request.getParameter("ciudad");
            nombre=request.getParameter("nombre");
            telefono=request.getParameter("telefono");
            proDto= new proveedorDto(nit,ciudad,nombre,telefono);
            
            if(proDao.insertaProveedor(proDto)){
            response.sendRedirect("vistaProveedor.jsp?men=Proveedor registrado exitosamente.");
            }else{
            response.sendRedirect("vistaProveedor.jsp?men=Proveedor no registrado.");
            }
        }
        
        if(request.getParameter("consultar") !=null){
        
        String nit=(request.getParameter("nit"));
        proDto=proDao.buscarProveedor(nit);
        if(proDto !=null){
        String ciudad,nombre,telefono;
        ciudad=proDto.getCiudad();
        nombre=proDto.getNombre();
        telefono=proDto.getTelefono();
        response.sendRedirect("vistaProveedor.jsp?nit="+nit+"&ciudad="+ciudad+"&nom="+nombre+"&telefono="+telefono);
        }else{
        response.sendRedirect("vistaProveedor.jsp?men=Proveedor no encontrado.");
        }
        }
    
        if(request.getParameter("actualizar") !=null){
            String nit,ciudad,nombre,telefono;
            nit=request.getParameter("nit");
            ciudad=request.getParameter("ciudad");
            nombre=request.getParameter("nombre");
            telefono=request.getParameter("telefono");
            proDto= new proveedorDto(nit,ciudad,nombre,telefono);
            
            if(!proDao.actualizaProveedor(proDto)){
                response.sendRedirect("vistaProveedor.jsp?men=Proveedor actualizado exitosamente.");
            }else{
                response.sendRedirect("vistaProveedor.jsp?men=Proveedor no actualizado.");
            }
        }
        
        if(request.getParameter("eliminar") !=null){
        String nit=(request.getParameter("nit"));
        proDto=proDao.buscarProveedor(nit);
        if(proDto!=null){
        if(proDao.eliminarProveedor(nit)){
        response.sendRedirect("vistaProveedor.jsp?men=Proveedor eliminado");
        }else{
        response.sendRedirect("vistaProveedor.jsp?men=Proveedor no se elimino");    
        }  
      }
      
    }
    
    }
    
    
}
       
