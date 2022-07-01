/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.instalaciones;

import backend.Avion;
import backend.estructuras.lista.Lista;
import backend.estructuras.lista.EstructuraException;

/**
 *
 * @author Kenny
 */
public class EstacionMantenimiento extends InstalacionConEspera {

    private static int tiempoMantenimiento;
    private int tiempoFinal;
    private int tiempoFinalActual;
    public EstacionMantenimiento(int ID, int cantidad) {
        super(ID, cantidad);
        tiempoFaltante = "0s";
    }

    public void calcularTiempo() {
        avionActivo = new Avion(11, "pequeño", 3);//DEBEMOS QUITAR EST
        tiempoFinal = (avionActivo.getCantidadPasejeros() * EstacionMantenimiento.tiempoMantenimiento)/1000;
        tiempoFaltante = tiempoFinal + "s";
        tiempoFinalActual = tiempoFinal;
    }

    @Override
    public void run() {
        mostrarMantenimiento();
    }

    public static void setTiempoMantenimiento(int nuevoTiempoMantenimiento) {
        tiempoMantenimiento = nuevoTiempoMantenimiento;

    }

    @Override
    public void crearLista(Lista lineas, Lista elementos) {
        for (int i = 0; i < lineas.obtenerLongitud(); i++) {
            try {
                String[] separador = ((String) lineas.obtenerElemento(i)).split(",");
                EstacionMantenimiento estacionM = new EstacionMantenimiento(Integer.parseInt(separador[0]), Integer.parseInt(separador[1]));
                elementos.agregar(estacionM);

            } catch (EstructuraException ex) {

            }
        }

    }

    public void mostrarMantenimiento() {
        calcularTiempo();
        while (tiempoFinalActual > 0) {

            try {
                mostrarTiempoMantenimiento();
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            tiempoFinalActual--;
        }
        terminarMantenimiento();
    }

    public void mostrarTiempoMantenimiento() {
        System.out.println("El tiempo faltante para el mantenimiento es de: " + tiempoFinalActual + "s");
    }

    public void terminarMantenimiento() {
        System.out.println("MANTENIMIENTO TERMINADO");
    }

}
