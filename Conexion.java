
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    
    private String bd="TiendaGenerica";
    private String url="jdbc:mysql://localhost:3306/"+bd;
    private String user="root";
    private String pass="008ac674";
    
    Connection conec=null; 
    
    
    public Connection Conecta() { //metodo para realizar conexion a la BD
    
    try{
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    conec=DriverManager.getConnection(url,user,pass); 
    //JOptionPane.showMessageDialog(null,"Conexion exitosa");
    //System.out.println("Conexion exitosa");
    
    }catch(Exception e){
    System.out.println("Error al conectarse: "+e);
    //JOptionPane.showMessageDialog(null,"Error al conectarse; "+e);
    }    
                
    return conec;
    }
    
}
