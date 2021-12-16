
package Modelo;


public class clienteDto {
    
    private long cedula;
    private String direccion;
    private String correo;
    private String nombre;
    private long telefono;

    public clienteDto(long cedula, String direccion, String correo, String nombre, long telefono) {
        this.cedula = cedula;
        this.direccion = direccion;
        this.correo = correo;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public clienteDto(long cedula) {
        this.cedula = cedula;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
    
    public String imprimir(){
    
       String mensaje="\nCedula: "+getCedula()+
               "\nDireccion: "+getDireccion()+
               "\nCorreo: "+getCorreo()+
               "\nNombre: "+getNombre()+
               "\nTelefono: "+getTelefono()+"\n";
        return mensaje;
    }    
    
    
}
