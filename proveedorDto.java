
package Modelo;


public class proveedorDto {

    private String nit;
    private String ciudad;
    private String nombre;
    private String telefono;

    public proveedorDto(String nit, String ciudad, String nombre, String telefono) {
        this.nit = nit;
        this.ciudad = ciudad;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public proveedorDto(String nit) {
        this.nit = nit;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
      public String imprimir(){
    
       String mensaje="\nnit: "+getNit()+
               "\nciudad: "+getCiudad()+
               "\nnombre: "+getNombre()+
               "\ntelefono: "+getTelefono()+"\n";
        return mensaje;
    } 
    
}
