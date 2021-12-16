
package Controlador;

import Modelo.usuarioDao;
import Modelo.usuarioDto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Usuario", urlPatterns = {"/Usuario"})
public class Usuario extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        usuarioDto usuDto=null;
        usuarioDao usuDao=new usuarioDao();
        
        
        if(request.getParameter("registrar") !=null){
            long ced;
            String correo,nombre,pass,usuario;
            ced=Long.parseLong(request.getParameter("cedula"));
            correo=request.getParameter("correo");
            nombre=request.getParameter("nombre");
            pass=request.getParameter("pass");
            usuario=request.getParameter("usuario");
            usuDto= new usuarioDto(ced,correo,nombre,pass,usuario);
            
            if(usuDao.insertaUsuario(usuDto)){
            response.sendRedirect("vistaUsuario.jsp?men=Usuario registrado exitosamente.");
            }else{
            response.sendRedirect("vistaUsuario.jsp?men=Usuario no registrado.");
            }
        }
        
        if(request.getParameter("consultar") !=null){
        
        long ced=Long.parseLong(request.getParameter("cedula"));
        usuDto=usuDao.buscarUsuario(ced);
        if(usuDto !=null){
        String correo,nombre,pass,usuario;
        correo=usuDto.getCorreo();
        nombre=usuDto.getNombre();
        pass=usuDto.getPassword();
        usuario=usuDto.getUsuario();
        response.sendRedirect("vistaUsuario.jsp?ced="+ced+"&correo="+correo+"&nom="+nombre+"&pass="+pass+"&usu="+usuario);
        }else{
        response.sendRedirect("vistaUsuario.jsp?men=Usuario no encontrado.");
        }
        }
    
        if(request.getParameter("actualizar") !=null){
            long ced;
            String correo,nombre,pass,usuario;
            ced=Long.parseLong(request.getParameter("cedula"));
            correo=request.getParameter("correo");
            nombre=request.getParameter("nombre");
            pass=request.getParameter("pass");
            usuario=request.getParameter("usuario");
            usuDto= new usuarioDto(ced,correo,nombre,pass,usuario);
            
            if(usuDao.actualizaUsuario(usuDto)){
            response.sendRedirect("vistaUsuario.jsp?men=Datos no actualizados.");
            }else{
            response.sendRedirect("vistaUsuario.jsp?men=Datos actualizados exitosamente.");
            }
        }
        
        if(request.getParameter("aceptar") !=null){
        String password=request.getParameter("password");
        usuDto=usuDao.buscarUsulogin(password);
        if(usuDto !=null){
        String usuario;
        password=request.getParameter("password");
        usuario=request.getParameter("usuario");
        response.sendRedirect("login.jsp?password="+password+"&usuario="+usuario);
        }else{
        response.sendRedirect("login.jsp?men=Usuario encontrado");
        }
        }
        
    if(request.getParameter("eliminar") !=null){
      long cedula=Long.parseLong(request.getParameter("cedula"));
      usuDto=usuDao.buscarUsuario(cedula);
      if(usuDto!=null){
        if(usuDao.eliminarUsuario(cedula)){
        response.sendRedirect("vistaUsuario.jsp?men=Usuario eliminado");
        }else{
        response.sendRedirect("vistaUsuario.jsp?men=Usuario no se elimino");    
        }  
      }
      
    }
    }
    
    
}
       

        













