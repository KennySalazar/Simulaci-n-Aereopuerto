/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.instalaciones;

import backend.Avion;
import backend.estructuras.Cola;
import ui.cuadro.instalacion.InstalacionCuadro;

/**
 *
 * @author Kenny
 */
public class InstalacionConEspera extends Instalacion {
   protected Cola<Avion> avionesEnEspera;
   
    public InstalacionConEspera(int ID, int cantidad, InstalacionCuadro cuadro) {
        super(ID, cantidad, cuadro);
        avionesEnEspera = new Cola<Avion>();
    }
    
}
