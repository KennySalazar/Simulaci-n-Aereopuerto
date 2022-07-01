/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.instalaciones;

import backend.Avion;
import backend.MotorSimulacion;
import backend.estructuras.lista.Lista;
import backend.estructuras.lista.EstructuraException;
import backend.hilos.HiloEstacionDesabordaje;
import javax.swing.JOptionPane;

/**
 * @author Kenny
 */
public class EstacionDesabordaje extends InstalacionConEspera {

    private static int tiempoDesabordar;
    private int pasajerosDesabordados;
    private MotorSimulacion motor;

    public EstacionDesabordaje(int ID, int cantidad) {
        super(ID, cantidad);
        tiempoFaltante = "0s";
    }

    public void setMotor(MotorSimulacion motor) {
        this.motor = motor;
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

    public void siguienteEnCola() throws EstructuraException {
        try {
            avionActivo = avionesEnEspera.desencolar();
            motor.estacionDisponible();
            cuadro.actualizarElementos();
            crearHilo();
        } catch (NullPointerException ex) {
        }
    }

    public void terminarDesabordaje(boolean esperando) {
        if (!esperando) {
            JOptionPane.showMessageDialog(null, "El avion con id: " + avionActivo.getID() + " terminó su desabordaje");
        }
        EstacionMantenimiento estacionMantenimiento = motor.encontrarEstacionMantenimiento(this);
        if (estacionMantenimiento != null) {
            JOptionPane.showMessageDialog(null, "El avion con id: " + avionActivo.getID() + " será enviado a la estacion de mantenimiento con id: " + estacionMantenimiento.getID());
            estacionMantenimiento.agregarAColaAvion(avionActivo);
            try {
                siguienteEnCola();
            } catch (EstructuraException e) {
                System.out.println("Ya no hay aviones en cola");
                avionActivo = null;
                cuadro.actualizarElementos();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio en ninguna estación de mantenimiento, cuando se desocupe alguna el avión con id: " + avionActivo.getID() + " será enviado hacia allá.");
        }

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

/*
1,3
        2,3
        3,3
 */
