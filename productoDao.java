
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class productoDao {
    
       
    Conexion cnn= new Conexion();
    PreparedStatement ps=null;
    ResultSet res=null;
    Connection con=null;
    
    public ArrayList<productoDto> listarProducto(){
    
    productoDto pro=null;
    ArrayList<productoDto> lista= new ArrayList<>();
    
    try{
    con=cnn.Conecta();    
    String sql="select * from Productos;";
    ps=con.prepareStatement(sql);
    res=ps.executeQuery();
    while(res.next()){
    pro= new productoDto(res.getLong(1),res.getDouble(2),
    res.getString(3),res.getString(4),res.getDouble(5),res.getDouble(6));
    lista.add(pro);
    }
    con.close();
    }catch(SQLException ex){
    System.out.println ("error al consultar los productos: "+ex);
    }
    return lista;
    }
    
    public productoDto buscarProducto( long codigo){
    
    productoDto pro = null;
    try{ 
    con=cnn.Conecta();    
    String sql="select * from productos where codigo_producto=?;";
    ps=con.prepareStatement(sql);
    ps.setLong(1, codigo);
    res=ps.executeQuery();
    while(res.next()){
    pro= new productoDto(res.getLong(1),res.getDouble(2),
    res.getString(3),res.getString(4),res.getDouble(5),res.getDouble(6));
    }
    con.close();
    }catch(SQLException ex){
    System.out.println("Error al consultar producto: "+ex);
    }
    return pro;
    }
    
    public boolean insertaProducto(productoDto pro){
    
    boolean resultado=false;

    if(buscarProducto(pro.getCodigo()) ==null ){
    try{
    con=cnn.Conecta();
    String sql=("insert into productos value (?,?,?,?,?,?);");
    ps=con.prepareStatement(sql);
    ps.setLong(1, pro.getCodigo());
    ps.setDouble(2, pro.getIva());
    ps.setString(3, pro.getNit());
    ps.setString(4, pro.getNombre());
    ps.setDouble(5, pro.getPrecio_compra());
    ps.setDouble(6, pro.getPrecio_venta());
    
    resultado=ps.executeUpdate()>0;
    con.close();
    }catch(SQLException ex){
    System.out.println("Error al insertar producto"+ex);
    }
    }else resultado=false;
    return resultado;
    
    } 
    
    public boolean actualizaProducto(productoDto pro){
    
    boolean resultado=false;

    try{
    con=cnn.Conecta();
    String sql=("update productos set iva_compra=?,nit_proveedor=?,nombre_producto=?,precio_compra=?,precio_venta=? where codigo_producto=?;");
    ps=con.prepareStatement(sql);
    ps.setDouble(1, pro.getIva());
    ps.setString(2, pro.getNit());
    ps.setString(3, pro.getNombre());
    ps.setDouble(4, pro.getPrecio_compra());
    ps.setDouble(5, pro.getPrecio_venta());
    ps.setLong(6, pro.getCodigo());
    resultado=ps.executeUpdate()>0;
    con.close();
    }catch(SQLException ex){
    System.out.println("Error al actualizar producto"+ex);
    
    return resultado;
    
    }
    return false;
    } 
    
    public boolean eliminarProducto (long codigo){
    
    boolean resultado=false;
    try{
    con=cnn.Conecta();    
    String sql="delete from productos where codigo_producto=?;";
    ps=con.prepareStatement(sql);
    ps.setLong(1, codigo);
    resultado=ps.executeUpdate()>0;
    con.close();
    }catch(SQLException ex){
    System.out.println("Error al eliminar el producto"+ex);
    }
    return resultado;        
    }
    
}
