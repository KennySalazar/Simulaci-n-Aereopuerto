/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.instalaciones;

import backend.Avion;
import backend.MotorSimulacion;
import backend.estructuras.lista.Lista;
import backend.estructuras.lista.EstructuraException;
import backend.hilos.HiloEstacionMantenimiento;
import javax.swing.JOptionPane;

/**
 *
 * @author Kenny
 */
public class EstacionMantenimiento extends InstalacionConEspera {

    private static int tiempoMantenimiento;
    private int tiempoFinal;
    private int tiempoFinalActual;
    private MotorSimulacion motor;

    public EstacionMantenimiento(int ID, int cantidad) {
        super(ID, cantidad);
        tiempoFaltante = "0s";
    }

    public void setMotor(MotorSimulacion motor) {
        this.motor = motor;
    }

    public void calcularTiempo() {
        tiempoFinal = Math.round((avionActivo.getCantidadPasejeros() * EstacionMantenimiento.tiempoMantenimiento) / 1000);
        tiempoFaltante = tiempoFinal + "s";
        tiempoFinalActual = tiempoFinal;
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

    public void crearHilo() {
        HiloEstacionMantenimiento hilo = new HiloEstacionMantenimiento(this);
        hilo.start();
    }

    public void agregarAColaAvion(Avion avion) {
        try {
            if (avionesEnEspera.esVacia() && avionActivo == null) {
                avionActivo = avion;
                avion.contactarEstacionMantenimiento(this);
                crearHilo();
            } else if (!avionesEnEspera.esLlena()) {
                avionesEnEspera.encolarElemento(avion);
                cuadro.actualizarElementos();
                avion.contactarEstacionMantenimiento(this);
            }
        } catch (Exception e) {
        }
    }
    
    public void siguienteEnCola() throws EstructuraException {
        try {
            avionActivo = avionesEnEspera.desencolar();
            motor.estacionMantenimientoDisponible();
            cuadro.actualizarElementos();
            crearHilo();
        } catch (NullPointerException ex) {
        }
    }

    public void terminarMantenimiento() {
           JOptionPane.showMessageDialog(null, "El avion con id: " + avionActivo.getID() + " a terminado su mantenimiento, sera enviado a zona de despegue");
           motor.enviarAvionADespegue(avionActivo);
           try {
            siguienteEnCola();
        } catch (EstructuraException e) {
            System.out.println("Ya no hay aviones en cola");
            avionActivo = null;
            cuadro.actualizarElementos();
        }
    }

    public static int getTiempoMantenimiento() {
        return tiempoMantenimiento;
    }

    public int getTiempoFinalActual() {
        return tiempoFinalActual;
    }

    public void setTiempoFinalActual(int tiempoFinalActual) {
        this.tiempoFinalActual = tiempoFinalActual;
    }

}
