
package Modelo;


public class detaventaDto {
    
    private long codigo;
    private long cantidad;
    private long codigo_producto;
    private long codigo_venta;
    private double valor_venta;
    private double valor_iva;
    private double valor_total;

    public detaventaDto(long codigo, long cantidad, long codigo_producto, long codigo_venta, double valor_venta, double valor_iva, double valor_total) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.codigo_producto = codigo_producto;
        this.codigo_venta = codigo_venta;
        this.valor_venta = valor_venta;
        this.valor_iva = valor_iva;
        this.valor_total = valor_total;
    }

    public detaventaDto(long codigo) {
        this.codigo = codigo;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public long getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(long codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public long getCodigo_venta() {
        return codigo_venta;
    }

    public void setCodigo_venta(long codigo_venta) {
        this.codigo_venta = codigo_venta;
    }

    public double getValor_venta() {
        return valor_venta;
    }

    public void setValor_venta(double valor_venta) {
        this.valor_venta = valor_venta;
    }

    public double getValor_iva() {
        return valor_iva;
    }

    public void setValor_iva(double valor_iva) {
        this.valor_iva = valor_iva;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }
    
    public String imprimir(){
    
       String mensaje="\nCodigo: "+getCodigo()+
               "\nCantidad: "+getCantidad()+
               "\nCodigo_producto: "+getCodigo_producto()+
               "\nCodigo_venta: "+getCodigo_venta()+
               "\nValor_venta: "+getValor_venta()+
               "\nValor_iva: "+getValor_iva()+
               "\nValor_total: "+getValor_total()+"\n";
        return mensaje;
    } 




    
}
