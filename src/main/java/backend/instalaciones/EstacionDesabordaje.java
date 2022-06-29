/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.instalaciones;

import backend.Avion;
import backend.estructuras.lista.Lista;
import backend.estructuras.lista.ListaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.cuadro.instalacion.InstalacionCuadro;

/**
 *
 * @author Kenny
 */
public class EstacionDesabordaje extends InstalacionConEspera {

    private static int tiempoDesabordar;

    private int tiempoFinal;
    private int tiempoFinalActual;

    public EstacionDesabordaje(int ID, int cantidad) {
        super(ID, cantidad);
        tiempoFaltante = "0s";
    }

    public void calcularTiempo() {
        avionActivo = new Avion(11, "pequeño", 3);
        tiempoFinal = (avionActivo.getCantidadPasejeros() * EstacionDesabordaje.tiempoDesabordar) / 1000;
        tiempoFaltante = tiempoFinal + "s";
        tiempoFinalActual = tiempoFinal;
    }

    @Override
    public void run() {
        mostrarDesabordaje();
    }

    public static void setTiempoDesabordar(int tiempoDesabordo) {
        tiempoDesabordar = tiempoDesabordo;

    }

    @Override
    public void crearLista(Lista lineas, Lista elementos) {
        for (int i = 0; i < lineas.obtenerLongitud(); i++) {
            try {
                String[] separador = ((String) lineas.obtenerElemento(i)).split(",");
                EstacionDesabordaje estacionD = new EstacionDesabordaje(Integer.parseInt(separador[0]), Integer.parseInt(separador[1]));
                elementos.agregar(estacionD);

            } catch (ListaException ex) {

            }
        }

    }

    public void mostrarDesabordaje() {
        calcularTiempo();
        while (tiempoFinalActual > 0) {

            try {
                mostrarTiempoDesabordaje();
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            tiempoFinalActual--;
        }
        terminarDesabordaje();
    }

    public void mostrarTiempoDesabordaje() {
        System.out.println("TIEMPO FALTANTE: " + tiempoFinalActual + "s");
    }

    public void terminarDesabordaje() {
        System.out.println("EL DESABORDAJE TERMINO");
    }
}
