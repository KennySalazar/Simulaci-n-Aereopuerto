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
public class PistaAterrizaje extends InstalacionConEspera {

    private static int tiempoAterrizaje;
    private String ocupados;

    public PistaAterrizaje(int ID, int cantidad) {
        super(ID, cantidad);
    }

    @Override
    public void run() {

    }

    public static void setTiempoAterrizaje(int nuevoTiempoAterrizaje) {
        tiempoAterrizaje = nuevoTiempoAterrizaje;
    }
}
