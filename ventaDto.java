
package Modelo;


public class ventaDto {
    
    private long codigo;
    private long cedula_cliente;
    private long cedula_usuario;
    private double iva;
    private double total;
    private double valor;

    public ventaDto(long codigo, long cedula_cliente, long cedula_usuario, double iva, double total, double valor) {
        this.codigo = codigo;
        this.cedula_cliente = cedula_cliente;
        this.cedula_usuario = cedula_usuario;
        this.iva = iva;
        this.total = total;
        this.valor = valor;
    }

    public ventaDto(long codigo) {
        this.codigo = codigo;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public long getCedula_cliente() {
        return cedula_cliente;
    }

    public void setCedula_cliente(long cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }

    public long getCedula_usuario() {
        return cedula_usuario;
    }

    public void setCedula_usuario(long cedula_usuario) {
        this.cedula_usuario = cedula_usuario;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public String imprimir(){
        
    String mensaje=
               "\nCodigo: "+getCodigo()+
               "\nCedula_cliente: "+getCedula_cliente()+
               "\nCedula_usuario: "+getCedula_usuario()+
               "\nIva: "+getIva()+
               "\nTotal: "+getTotal()+
               "\nValor: "+getValor()+"\n";
               
        return mensaje;
    }
}
   
