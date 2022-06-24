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
public class Instalacion {
    
    protected int ID;
    protected int cantidad;
    protected InstalacionCuadro cuadro;

    public Instalacion(int ID, int cantidad) {
        this.ID = ID;
        this.cantidad = cantidad;
        
    }
    
    
    
    
}
