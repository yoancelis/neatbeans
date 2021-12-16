
package Modelo;


public class productoDto {

    private long codigo;
    private double iva;
    private String nit;
    private String nombre;
    private double precio_compra;
    private double precio_venta;

    public productoDto(long codigo, double iva, String nit, String nombre, double precio_compra, double precio_venta) {
        this.codigo = codigo;
        this.iva = iva;
        this.nit = nit;
        this.nombre = nombre;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
    }

    public productoDto(long codigo) {
        this.codigo = codigo;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }
    
    public String imprimir(){
    
       String mensaje="\nCodigo: "+getCodigo()+
               "\nIva: "+getIva()+
               "\nNit: "+getNit()+
               "\nNombre: "+getNombre()+
               "\nPrecio_compra: "+getPrecio_compra()+
               "\nPrecio_venta: "+getPrecio_venta()+"\n";
        return mensaje;
    } 
    
    
}
