
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class clienteDao {
    
    Conexion cnn= new Conexion();
    PreparedStatement ps=null;
    ResultSet res=null;
    Connection con=null;
    
    public ArrayList<clienteDto> listarClientes(){
    
    clienteDto cli=null;
    ArrayList<clienteDto> lista= new ArrayList<>();
    
    try{
    con=cnn.Conecta();    
    String sql="select * from clientes;";
    ps=con.prepareStatement(sql);
    res=ps.executeQuery();
    while(res.next()){
    cli= new clienteDto(res.getLong(1),res.getString(2),
    res.getString(3),res.getString(4),res.getLong(5));
    lista.add(cli);
    }
    con.close();
    }catch(SQLException ex){
    System.out.println ("error al consultar los clientes: "+ex);
    }
    return lista;
    }
    
    public clienteDto buscarCliente( long cedula){
    
    clienteDto cli = null;
    try{ 
    con=cnn.Conecta();    
    String sql="select * from clientes where cedula_cliente=?;";
    ps=con.prepareStatement(sql);
    ps.setLong(1, cedula);
    res=ps.executeQuery();
    while(res.next()){
    cli= new clienteDto(res.getLong(1),res.getString(2),
    res.getString(3),res.getString(4),res.getLong(5));
    }
    con.close();
    }catch(SQLException ex){
    System.out.println("Error al consulatar cliente: "+ex);
    }
    return cli;
    }
    
    public boolean insertaCliente(clienteDto cli){
    
    boolean resultado=false;

    if(buscarCliente(cli.getCedula()) ==null ){
    try{
    con=cnn.Conecta();
    String sql=("insert into clientes value(?,?,?,?,?);");
    ps=con.prepareStatement(sql);
    ps.setLong(1, cli.getCedula());
    ps.setString(2, cli.getDireccion());
    ps.setString(3, cli.getCorreo());
    ps.setString(4, cli.getNombre());
    ps.setLong(5, cli.getTelefono());
    
    resultado=ps.executeUpdate()>0;
    con.close();
    }catch(SQLException ex){
    System.out.println("Error al insertar cliente"+ex);
    }
    }else resultado=false;
    return resultado;
    
    } 
    
    public boolean actualizaCliente(clienteDto cli){
    
    boolean resultado=false;

    try{
    con=cnn.Conecta();
    String sql=("update clientes set direccion_cliente=?,email_cliente=?,nombre_cliente=?,telefono_cliente=? where cedula_cliente=?;");
    ps=con.prepareStatement(sql);
    ps.setString(1, cli.getDireccion());
    ps.setString(2, cli.getCorreo());
    ps.setString(3, cli.getNombre());
    ps.setLong(4, cli.getTelefono());
    ps.setLong(5, cli.getCedula());
    resultado=ps.executeUpdate()>0;
    con.close();
    }catch(SQLException ex){
    System.out.println("Error al actualizar cliente "+ex);
    
    return resultado;
    
    }
    return false;
    } 
    
    public boolean eliminarCliente (long cedula){
    
    boolean resultado=false;
    try{
    con=cnn.Conecta();    
    String sql="delete from clientes where cedula_cliente=?;";
    ps=con.prepareStatement(sql);
    ps.setLong(1, cedula);
    resultado=ps.executeUpdate()>0;
    con.close();
    }catch(SQLException ex){
    System.out.println("Error al eliminar el cliente "+ex);
    }
    return resultado;        
    }
            
    
}
