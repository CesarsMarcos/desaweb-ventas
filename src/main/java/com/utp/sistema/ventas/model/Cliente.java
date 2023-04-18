package com.utp.sistema.ventas.model;

/**
 *
 * @author 
 */
public class Cliente extends Persona{
    private int idCliente;
    private String tipo_cliente;

    public Cliente() {
    }

    public Cliente(int idCliente, String tipo_cliente) {
        this.idCliente = idCliente;
        this.tipo_cliente = tipo_cliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getTipo_cliente() {
        return tipo_cliente;
    }

    public void setTipo_cliente(String tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
    }



    @Override
    public String toString() {
        return "\n Cliente{" 
                + "\n idCliente=" + idCliente + ""
                + "\n tipo_cliente=" + tipo_cliente + ""
                + "\n Nombres=" + this.getNombres()+ ""
                + "\n Apellidos=" + this.getApellidos() + ""
                + "\n tipo_documento=" + this.getTipo_documento() + ""
                + "\n num_documento=" + this.getNum_documento() + ""
                + "\n dirección=" + this.getDireccion() + ""
                + "\n telefono=" + this.getTelefono() + ""                
                + "\n email=" + this.getEmail() + '}';
    }

  
    
}
