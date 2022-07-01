/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.instalaciones;

import backend.Avion;
import backend.estructuras.lista.Lista;
import backend.estructuras.lista.EstructuraException;
import backend.hilos.HiloEstacionDesabordaje;
import backend.hilos.HiloPistaAterrizaje;

import javax.swing.*;

/**
 *
 * @author Kenny
 */
public class EstacionDesabordaje extends InstalacionConEspera {

    private static int tiempoDesabordar;
    private int tiempoFinal;
    private int tiempoFinalActual;
    private int pasajerosDesabordados;

    public EstacionDesabordaje(int ID, int cantidad) {
        super(ID, cantidad);
        tiempoFaltante = "0s";
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

            } catch (EstructuraException ex) {

            }
        }

    }



    public void crearHilo() {
        pasajerosDesabordados = avionActivo.getCantidadPasejeros();
        HiloEstacionDesabordaje hilo = new HiloEstacionDesabordaje(this);
        hilo.start();
    }

    public void agregarAColaAvion(Avion avion) {
        try {
            if (avionesEnEspera.esVacia() && avionActivo == null) {
                avionActivo = avion;
                avion.contactarEstacionDesabordaje(this);
                crearHilo();
            } else if (!avionesEnEspera.esLlena()) {
                avionesEnEspera.encolarElemento(avion);
                cuadro.actualizarElementos();
                avion.contactarEstacionDesabordaje(this);
            }
        } catch (Exception e) {
        }
    }

    public void mostrarTiempoDesabordaje() {
        System.out.println("Pasajeros desabordando: " + pasajerosDesabordados);
    }

    public void siguienteEnCola() throws EstructuraException {
        avionActivo = avionesEnEspera.desencolar();
//        cuadro.actualizarElementos();
        crearHilo();
    }

    public void terminarDesabordaje() {
//        if (motor.encontrarEstacionMantenimiento() != null) {
            try {
                siguienteEnCola();
            } catch (EstructuraException e) {
                System.out.println("Ya no hay aviones en cola");
                avionActivo = null;
//                cuadro.actualizarElementos();
            }
//        }else {
//            JOptionPane.showMessageDialog(null, "No hay espacion en ninguna estación de mantenimiento, cuando se desocupe alguna será enviado hacia allá.");
//        }
    }

    public int getPasajerosDesabordados() {
        return pasajerosDesabordados;
    }

    public void setPasajerosDesabordados(int pasajerosDesabordados) {
        this.pasajerosDesabordados = pasajerosDesabordados;
    }

    public static int getTiempoDesabordar() {
        return EstacionDesabordaje.tiempoDesabordar;
    }

}
