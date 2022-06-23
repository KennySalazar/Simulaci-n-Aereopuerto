/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.cuadro.avion;

import backend.Avion;
import javax.swing.JLabel;
import ui.cuadro.Cuadro;

/**
 *
 * @author Kenny
 */
public abstract class AvionCuadro extends Cuadro {
    private JLabel cantidadPasajeros;
    private JLabel galonesCombustible;
    private Avion avion;

    public AvionCuadro(Avion avion) {
        this.avion = avion;
        cantidadPasajeros = new JLabel();
        galonesCombustible  = new JLabel();
    }
    
   
    
    
}
