
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class detaventaDao {

    Conexion cnn= new Conexion();
    PreparedStatement ps=null;
    ResultSet res=null;
    Connection con=null;
    
    public ArrayList<detaventaDto> listarDetalleventa(){
    
    detaventaDto deta=null;
    ArrayList<detaventaDto> lista= new ArrayList<>();
    
    try{
    con=cnn.Conecta();    
    String sql="select * from detalle_ventas;";
    ps=con.prepareStatement(sql);
    res=ps.executeQuery();
    while(res.next()){
    deta= new detaventaDto(res.getLong(1),res.getLong(2),
    res.getLong(3),res.getLong(4),res.getDouble(5),
    res.getDouble(6),res.getDouble(7));
    lista.add(deta);
    }
    con.close();
    }catch(SQLException ex){
    System.out.println ("error al consultar los detalles de la venta: "+ex);
    }
    return lista;
    }
    
    public detaventaDto buscarDetalleventa(long codigo){
    
    detaventaDto deta = null;
    try{ 
    con=cnn.Conecta();    
    String sql="select * from detalle_ventas where codigo_detalle=?;";
    ps=con.prepareStatement(sql);
    ps.setLong(1, codigo);
    res=ps.executeQuery();
    while(res.next()){
    deta= new detaventaDto(res.getLong(1),res.getLong(2),
    res.getLong(3),res.getLong(4),res.getDouble(5),
    res.getDouble(6),res.getDouble(7));
    }
    con.close();
    }catch(SQLException ex){
    System.out.println("Error al consultar detalle de venta: "+ex);
    }
    return deta;
    }
    
    public boolean insertaDetalleventa(detaventaDto deta){
    
    boolean resultado=false;

    if(buscarDetalleventa(deta.getCodigo()) ==null ){
    try{
    con=cnn.Conecta();
    String sql=("insert into detalle_ventas value (?,?,?,?,?,?,?);");
    ps=con.prepareStatement(sql);
    ps.setLong(1, deta.getCodigo());
    ps.setLong(2, deta.getCantidad());
    ps.setLong(3, deta.getCodigo_producto());
    ps.setLong(4, deta.getCodigo_venta());
    ps.setDouble(5, deta.getValor_venta());
    ps.setDouble(6, deta.getValor_iva());
    ps.setDouble(7, deta.getValor_total());
    
    resultado=ps.executeUpdate()>0;
    con.close();
    }catch(SQLException ex){
    System.out.println("Error al insertar detalle de venta"+ex);
    }
    }else resultado=false;
    return resultado;
    
    } 
    
    public boolean actualizaDetalleventa(detaventaDto deta){
    
    boolean resultado=false;

    try{
    con=cnn.Conecta();
    String sql=("update detalle_ventas set cantidad_producto=?,codigo_producto=?,codigo_venta=?,valor_venta=?, valor_iva=?,valor_total=? where codigo_detalle=?;");
    ps=con.prepareStatement(sql);
    ps.setLong(1, deta.getCantidad());
    ps.setLong(2, deta.getCodigo_producto());
    ps.setLong(3, deta.getCodigo_venta());
    ps.setDouble(4, deta.getValor_venta());
    ps.setDouble(5, deta.getValor_iva());
    ps.setDouble(6, deta.getValor_total());
    ps.setLong(7, deta.getCodigo());
    resultado=ps.executeUpdate()>0;
    con.close();
    }catch(SQLException ex){
    System.out.println("Error al actualizar detalle de venta"+ex);
    
    return resultado;
    
    }
    return false;
    } 
    
    public boolean eliminarDetalleventa (long codigo){
    
    boolean resultado=false;
    try{
    con=cnn.Conecta();    
    String sql="delete from detalle_ventas where codigo_detalle=?;";
    ps=con.prepareStatement(sql);
    ps.setLong(1, codigo);
    resultado=ps.executeUpdate()>0;
    con.close();
    }catch(SQLException ex){
    System.out.println("Error al eliminar el detalle de la venta"+ex);
    }
    return resultado;        
    }
            
    
}
