package com.utp.sistema.ventas.model;

/**
 *
 * @author 
 */
public class Usuario extends Persona{
    private int idUsuario;
    private int idRol;
    private String password;
    private byte estado;

    public Usuario() {
    }

    public Usuario(int idUsuario, int idRol, String password, byte estado) {
        this.idUsuario = idUsuario;
        this.idRol = idRol;
        this.password = password;
        this.estado = estado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getEstado() {
        return estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "\n Usuario{" 
                + "\n idUsuario=" + idUsuario + ""
                + "\n idRol=" + idRol + ""                
                + "\n Nombres=" + this.getNombres()+ ""
                + "\n Apellidos=" + this.getApellidos() + ""
                + "\n tipo_documento=" + this.getTipo_documento() + ""
                + "\n num_documento=" + this.getNum_documento() + ""
                + "\n dirección=" + this.getDireccion() + ""
                + "\n telefono=" + this.getTelefono() + ""                
                + "\n email=" + this.getEmail() +""
                + "\n password=" + password + ""
                + "\n estado=" + estado +'}';
    }

 
    
}
