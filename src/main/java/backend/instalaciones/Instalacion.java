/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.instalaciones;

import ui.cuadro.instalacion.InstalacionCuadro;

/**
 *
 * @author Kenny
 */
public abstract class Instalacion extends Thread {
    protected String ocupados;
    protected int ID;
    protected int cantidad;
    protected InstalacionCuadro cuadro;

    public Instalacion(int ID, int cantidad) {
        this.ID = ID;
        this.cantidad = cantidad;
        armarTexto(0);
    }
    
     public void armarTexto(int cantidadContactados){
        ocupados = cantidadContactados + "/" + cantidad;
    }

    public int getID() {
        return ID;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getOcupados() {
        return ocupados;
    }

    
    
    
    
}
