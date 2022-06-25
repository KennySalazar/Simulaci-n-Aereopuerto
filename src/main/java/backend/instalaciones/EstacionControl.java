/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.instalaciones;

import backend.Avion;
import backend.estructuras.lista.Lista;

/**
 *
 * @author Kenny
 */
public class EstacionControl extends Instalacion {
    private Lista<Avion>avionesContactados;
   

    public EstacionControl(int ID, int cantidad) {
        super(ID, cantidad);
        avionesContactados = new Lista<Avion>();
    }



}
