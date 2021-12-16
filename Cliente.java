
package Controlador;

import Modelo.clienteDao;
import Modelo.clienteDto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Cliente", urlPatterns = {"/Cliente"})
public class Cliente extends HttpServlet {

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        clienteDto cliDto=null;
        clienteDao cliDao=new clienteDao();
        
        if(request.getParameter("registrar") !=null){
            long ced,telefono;
            String direccion,correo,nombre;
            ced=Long.parseLong(request.getParameter("cedula"));
            direccion=request.getParameter("direccion");
            correo=request.getParameter("correo");
            nombre=request.getParameter("nombre");
            telefono=Long.parseLong(request.getParameter("telefono"));
            cliDto= new clienteDto(ced,direccion,correo,nombre,telefono);
            
            if(cliDao.insertaCliente(cliDto)){
            response.sendRedirect("vistaCliente.jsp?men=Cliente registrado exitosamente.");
            }else{
            response.sendRedirect("vistaCliente.jsp?men=Cliente no registrado.");
            }
        }
        
        if(request.getParameter("consultar") !=null){
        
        long ced=Long.parseLong(request.getParameter("cedula"));
        cliDto=cliDao.buscarCliente(ced);
        if(cliDto !=null){
        long telefono;
        String direccion,correo,nombre;;
        direccion=cliDto.getDireccion();
        correo=cliDto.getCorreo();
        nombre=cliDto.getNombre();
        telefono=cliDto.getTelefono();
        response.sendRedirect("vistaCliente.jsp?ced="+ced+"&direccion="+direccion+"&correo="+correo+"&nombre="+nombre+"&telefono="+telefono);
        }else{
        response.sendRedirect("vistaCliente.jsp?men=Cliente no encontrado.");
        }
        }
    
        if(request.getParameter("actualizar") !=null){
        long ced,telefono;
        String direccion,correo,nombre;
            ced=Long.parseLong(request.getParameter("cedula"));
            direccion=request.getParameter("direccion");
            correo=request.getParameter("correo");
            nombre=request.getParameter("nombre");
            telefono=Long.parseLong(request.getParameter("telefono"));
            cliDto= new clienteDto(ced,direccion,correo,nombre,telefono);
            
            if(cliDao.actualizaCliente(cliDto)){
            response.sendRedirect("vistaCliente.jsp?men=Datos no actualizados.");
            }else{
            response.sendRedirect("vistaCliente.jsp?men=Datos actualizados exitosamente.");
            }
        }
       
        if(request.getParameter("eliminar") !=null){
        long cedula=Long.parseLong(request.getParameter("cedula"));
        cliDto=cliDao.buscarCliente(cedula);
        if(cliDto!=null){
        if(cliDao.eliminarCliente(cedula)){
        response.sendRedirect("vistaCliente.jsp?men=Usuario eliminado");
        }else{
        response.sendRedirect("vistaCliente.jsp?men=Usuario no se elimino");    
        }  
       }
       }
    }
}
    
        
    
    
    

