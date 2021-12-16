
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class usuarioDao {
    
    Conexion cnn= new Conexion();
    PreparedStatement ps=null;
    ResultSet res=null;
    Connection con=null;
    
    public ArrayList<usuarioDto> listarUsuarios(){
    
    usuarioDto usu=null;
    ArrayList<usuarioDto> lista= new ArrayList<>();
    
    try{
    con=cnn.Conecta();    
    String sql="select * from usuarios;";
    ps=con.prepareStatement(sql);
    res=ps.executeQuery();
    while(res.next()){
    usu= new usuarioDto(res.getLong(1),res.getString(2),
    res.getString(3),res.getString(4),res.getString(5));
    lista.add(usu);
    }
    con.close();
    }catch(SQLException ex){
    System.out.println ("error al consultar los usuarios: "+ex);
    }
    return lista;
    }
    
    public usuarioDto buscarUsuario( long cedula){
    
    usuarioDto usu = null;
    try{ 
    con=cnn.Conecta();    
    String sql="select * from usuarios where cedula_usuario=?;";
    ps=con.prepareStatement(sql);
    ps.setLong(1, cedula);
    res=ps.executeQuery();
    while(res.next()){
    usu= new usuarioDto(res.getLong(1),res.getString(2),
    res.getString(3),res.getString(4),res.getString(5));
    }
    con.close();
    }catch(SQLException ex){
    System.out.println("Error al consultar usuario: "+ex);
    }
    return usu;
    }
    
    public boolean insertaUsuario(usuarioDto usu){
    
    boolean resultado=false;

    if(buscarUsuario(usu.getCedula()) ==null ){
    try{
    con=cnn.Conecta();
    String sql=("insert into usuarios value(?,?,?,?,?);");
    ps=con.prepareStatement(sql);
    ps.setLong(1, usu.getCedula());
    ps.setString(2, usu.getCorreo());
    ps.setString(3, usu.getNombre());
    ps.setString(4, usu.getPassword());
    ps.setString(5, usu.getUsuario());
    
    resultado=ps.executeUpdate()>0;
    con.close();
    }catch(SQLException ex){
    System.out.println("Error al insertar usuario "+ex);
    }
    }else resultado=false;
    return resultado;
    
    } 
    
    public boolean actualizaUsuario(usuarioDto usu){
    
    boolean resultado=false;

    try{
    con=cnn.Conecta();
    String sql=("update usuarios set email_usuario=?,nombre_usuario=?,password_usuario=?,usuario=? where cedula_usuario=?;");
    ps=con.prepareStatement(sql);
    ps.setString(1, usu.getCorreo());
    ps.setString(2, usu.getNombre());
    ps.setString(3, usu.getPassword());
    ps.setString(4, usu.getUsuario());
    ps.setLong(5, usu.getCedula());
    resultado=ps.executeUpdate()>0;
    con.close();
    }catch(SQLException ex){
    System.out.println("Error al actualizar usuario "+ex);
    
    return resultado;
    
    }
    return false;
    } 
    
    public boolean eliminarUsuario (long cedula){
    
    boolean resultado=false;
    try{
    con=cnn.Conecta();    
    String sql="delete from usuarios where cedula_usuario=?;";
    ps=con.prepareStatement(sql);
    ps.setLong(1, cedula);
    resultado=ps.executeUpdate()>0;
    con.close();
    }catch(SQLException ex){
    System.out.println("Error al eliminar el usuario "+ex);
    }
    return resultado;        
    }
    
    
    public usuarioDto buscarUsulogin(String password){
    
    usuarioDto usu = null;
    try{ 
    con=cnn.Conecta();    
    String sql="select * from usuarios where password_usuario=?;";
    ps=con.prepareStatement(sql);
    ps.setString(1, password);
    res=ps.executeQuery();
    while(res.next()){
    usu= new usuarioDto(res.getString(1),res.getString(2));
    }
    con.close();
    }catch(SQLException ex){
    System.out.println("Error al consultar usuario: "+ex);
    }
    return usu;
    }
            
}















