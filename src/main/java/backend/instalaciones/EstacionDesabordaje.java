/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.instalaciones;

import backend.Avion;
import ui.cuadro.instalacion.InstalacionCuadro;

/**
 *
 * @author Kenny
 */
public class EstacionDesabordaje extends InstalacionConEspera {

    private static int tiempoDesabordar;
    private int tiempoFinal;
    private Avion avionDesabordando;

    public void setAvionDesabordando(Avion avionDesabordando) {
        this.avionDesabordando = avionDesabordando;
        tiempoFinal = avionDesabordando.getCantidadPasejeros() * tiempoDesabordar;
    }

    public EstacionDesabordaje(int ID, int cantidad) {
        super(ID, cantidad);
    }

    @Override
    public void run() {

    }

    public static void setTiempoDesabordar(int tiempoDesabordo) {
        tiempoDesabordar = tiempoDesabordo;

    }

}
