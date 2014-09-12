/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.Serializable;

/**
 *
 * @author user2
 */
public class Cliente implements Serializable{
    private String cliente;
    private String apellido;
    private int DNI;
    private int permiso;
    private int caducpermiso;
    private int cantidadpasa;
    private int cantidaddias;
    private int telefono;
    private String movil;

    
    public Cliente(String cliente, String apellido , int DNI,  int permiso, int caducpermiso, int cantidadpasa , int cantidaddias, int telefono , String movil) {
        this.cliente = cliente;
        this.apellido = apellido;
        this.DNI = DNI;
        this.permiso = permiso;
        this.caducpermiso = caducpermiso;
        this.cantidadpasa = cantidadpasa;
        this.cantidaddias = cantidaddias;
        this.telefono = telefono;
        this.movil = movil;
  
    
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getCaducpermiso() {
        return caducpermiso;
    }

    public void setCaducpermiso(int caducpermiso) {
        this.caducpermiso = caducpermiso;
    }

    public int getCantidadpasa() {
        return cantidadpasa;
    }

    public void setCantidadpasa(int cantidadpasa) {
        this.cantidadpasa = cantidadpasa;
    }

    public int getCantidaddias() {
        return cantidaddias;
    }

    public void setCantidaddias(int cantidaddias) {
        this.cantidaddias = cantidaddias;
    }

    
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }


    public int getPermiso() {
        return permiso;
    }

    public void setPermiso(int permiso) {
        this.permiso = permiso;
    }




    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public  String getMovil() {
        return movil;
    }

    public String setMovil(String movil) {
        this.movil = movil;
        return movil;
    }

    @Override
    public String toString() {
        return "Cliente{" + "cliente=" + cliente + ", apellido=" + apellido + ", DNI=" + DNI + ", permiso=" + permiso + ", caducpermiso=" + caducpermiso + ", cantidadpasa=" + cantidadpasa + ", cantidaddias=" + cantidaddias + ", telefono=" + telefono + ", movil=" + movil + '}';
    }







    

    
    
    
    
    
}
