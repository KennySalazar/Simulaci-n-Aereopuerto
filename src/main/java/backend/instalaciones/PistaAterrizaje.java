/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.instalaciones;

import backend.Avion;
import backend.MotorSimulacion;
import backend.estructuras.lista.Lista;
import backend.estructuras.lista.EstructuraException;
import backend.hilos.HiloPistaAterrizaje;

import javax.swing.*;

/**
 * @author Kenny
 */
public class PistaAterrizaje extends InstalacionConEspera {

    private int tiempoActual;
    private static int tiempoAterrizaje;
    private MotorSimulacion motor;

    public PistaAterrizaje(int ID, int cantidad) {
        super(ID, cantidad);
    }

    public static void setTiempoAterrizaje(int nuevoTiempoAterrizaje) {
        tiempoAterrizaje = nuevoTiempoAterrizaje / 1000;
    }

    public void setMotor(MotorSimulacion motor) {
        this.motor = motor;
    }

    @Override
    public void crearLista(Lista lineas, Lista elementos) {
        for (int i = 0; i < lineas.obtenerLongitud(); i++) {
            try {
                String[] separador = ((String) lineas.obtenerElemento(i)).split(",");
                PistaAterrizaje pistaAterrizaje = new PistaAterrizaje(Integer.parseInt(separador[0]), Integer.parseInt(separador[1]));
                elementos.agregar(pistaAterrizaje);

            } catch (EstructuraException ex) {

            }
        }
    }

    public void crearHilo() {
        motor.nuevoLog("Pista aterrizaje", "El avión con id: " + avionActivo.getID()+" empezará a aterrizar en  la pista de aterrizaje co id " + ID);
        HiloPistaAterrizaje hilo = new HiloPistaAterrizaje(avionActivo, this);
        hilo.start();
    }

    public void aterrizarHecho(boolean esperando) {
        if (!esperando) {
            avionActivo.aterrizar();
            JOptionPane.showMessageDialog(null, "El avion con id: " + avionActivo.getID() + " terminó su aterrizaje");
        }
        EstacionDesabordaje estacionDesabordaje = motor.encontrarEstacionDesabordaje(this);
        if (estacionDesabordaje != null) {
            JOptionPane.showMessageDialog(null, "El avion con id: " + avionActivo.getID() + " será enviado a la estacion de desabordaje con id: " + estacionDesabordaje.getID());
            estacionDesabordaje.agregarAColaAvion(avionActivo);
            try {
                siguienteEnCola();
            } catch (EstructuraException e) {
               
                avionActivo = null;
                cuadro.actualizarElementos();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio en ninguna estación de desabordaje, cuando se desocupe alguna el avión con id: " + avionActivo.getID() + " será enviado hacia allá.");
        }
    }

    public void siguienteEnCola() throws EstructuraException {
        motor.actualizarCombobox();
        avionActivo = avionesEnEspera.desencolar();
        cuadro.actualizarElementos();
        crearHilo();
    }

    public void mostrarTiempoAterrizaje() {
        tiempoFaltante = tiempoActual + "s";
        cuadro.actualizarElementos();
    }

    public void agregarAColaAvion(Avion avion, EstacionControl estacion) {
        try {
            if (avionesEnEspera.esVacia() && avionActivo == null) {
                avionActivo = avion;
                avion.contactarPista(this);
                estacion.eliminarAvion(avion);
                crearHilo();
            } else if (!avionesEnEspera.esLlena()) {
                motor.nuevoLog("Pista aterrizaje", "El avión con id: " + avion.getID()+" fue agregado a la cola de la pista de aterrizaje con id: " + ID);
                avionesEnEspera.encolarElemento(avion);
                cuadro.actualizarElementos();
                avion.contactarPista(this);
                estacion.eliminarAvion(avion);
            } else {
                JOptionPane.showMessageDialog(null, "La cola de la pista con id: " + ID + " está llena");
            }
        } catch (Exception e) {

        }
    }


    public void eliminarAvion(Avion avion) {
        try {
            int indice = avionesEnEspera.obtenerIndiceElemento(avion);
            avionesEnEspera.actualizarOrden(indice);
            cuadro.actualizarElementos();
            motor.actualizarCombobox();
    
        } catch (Exception e) {
           
        }
    }

    public void setTiempoActual(int tiempoActual) {
        this.tiempoActual = tiempoActual;
    }

    public static int getTiempoAterrizaje() {
        return PistaAterrizaje.tiempoAterrizaje;
    }

    public int getTiempoActual() {
        return tiempoActual;
    }
}
