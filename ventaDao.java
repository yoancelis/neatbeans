
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ventaDao {
 
    Conexion cnn= new Conexion();
    PreparedStatement ps=null;
    ResultSet res=null;
    Connection con=null;
    
    public ArrayList<ventaDto> listarVentas(){
    
    ventaDto ven=null;
    ArrayList<ventaDto> lista= new ArrayList<>();
    
    try{
    con=cnn.Conecta();    
    String sql="select * from Ventas;";
    ps=con.prepareStatement(sql);
    res=ps.executeQuery();
    while(res.next()){
    ven= new ventaDto(res.getLong(1),res.getLong(2),
    res.getLong(3),res.getDouble(4),res.getDouble(5),
    res.getDouble(6));
    lista.add(ven);
    }
    con.close();
    }catch(SQLException ex){
    System.out.println ("error al consultar las ventas: "+ex);
    }
    return lista;
    }
    
    public ventaDto buscarVenta(long codigo){
    
    ventaDto ven = null;
    try{ 
    con=cnn.Conecta();    
    String sql="select * from ventas where codigo_venta=?;";
    ps=con.prepareStatement(sql);
    ps.setLong(1, codigo);
    res=ps.executeQuery();
    while(res.next()){
    ven= new ventaDto(res.getLong(1),res.getLong(2),
    res.getLong(3),res.getDouble(4),res.getDouble(5),
    res.getDouble(6));
    }
    con.close();
    }catch(SQLException ex){
    System.out.println("Error al consultar venta: "+ex);
    }
    return ven;
    }
    
    public boolean insertaVenta(ventaDto ven){
    
    boolean resultado=false;

    if(buscarVenta(ven.getCodigo()) ==null ){
    try{
    con=cnn.Conecta();
    String sql=("insert into ventas value (?,?,?,?,?,?);");
    ps=con.prepareStatement(sql);
    ps.setLong(1, ven.getCodigo());
    ps.setLong(2, ven.getCedula_cliente());
    ps.setLong(3, ven.getCedula_usuario());
    ps.setDouble(4, ven.getIva());
    ps.setDouble(5, ven.getTotal());
    ps.setDouble(6, ven.getValor());
    
    resultado=ps.executeUpdate()>0;
    con.close();
    }catch(SQLException ex){
    System.out.println("Error al insertar venta"+ex);
    }
    }else resultado=false;
    return resultado;
    
    } 
    
    public boolean actualizaVenta(ventaDto ven){
    
    boolean resultado=false;

    try{
    con=cnn.Conecta();
    String sql=("update ventas set cedula_cliente=?,cedula_usuario=?,iva_venta=?,total_venta=?,valor_venta=? where codigo_venta=?;");
    ps=con.prepareStatement(sql);
    ps.setLong(1, ven.getCedula_cliente());
    ps.setLong(2, ven.getCedula_usuario());
    ps.setDouble(3, ven.getIva());
    ps.setDouble(4, ven.getTotal());
    ps.setDouble(5, ven.getValor());
    ps.setLong(6, ven.getCodigo());
    resultado=ps.executeUpdate()>0;
    con.close();
    }catch(SQLException ex){
    System.out.println("Error al actualizar venta "+ex);
    
    return resultado;
    
    }
    return false;
    } 
    
    public boolean eliminarVenta (long codigo){
    
    boolean resultado=false;
    try{
    con=cnn.Conecta();    
    String sql="delete from ventas where codigo_venta=?;";
    ps=con.prepareStatement(sql);
    ps.setLong(1, codigo);
    resultado=ps.executeUpdate()>0;
    con.close();
    }catch(SQLException ex){
    System.out.println("Error al eliminar la venta "+ex);
    }
    return resultado;        
    }
            
    
}
