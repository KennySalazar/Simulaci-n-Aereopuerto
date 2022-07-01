/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import backend.estructuras.lista.Lista;
import backend.estructuras.lista.EstructuraException;
import backend.instalaciones.*;
import ui.Principal;

import javax.swing.*;

/**
 * @author Kenny
 */
public class MotorSimulacion {

    private Lista<Avion> aviones;
    private Lista<EstacionControl> estacionesControl;
    private Lista<PistaAterrizaje> pistasAterrizaje;
    private Lista<EstacionDesabordaje> estacionesDesabordaje;
    private Lista<EstacionMantenimiento> estacionesMantenimiento;
    private Lista<Log> logs;
    private Principal principal;

    public MotorSimulacion(Lista<Avion> aviones, Lista<EstacionControl> estacionesControl, Lista<PistaAterrizaje> pistasAterrizaje, Lista<EstacionDesabordaje> estacionesDesabordaje, Lista<EstacionMantenimiento> estacionesMantenimiento, Principal principal) {
        this.aviones = aviones;
        this.estacionesControl = estacionesControl;
        this.pistasAterrizaje = pistasAterrizaje;
        this.estacionesDesabordaje = estacionesDesabordaje;
        this.estacionesMantenimiento = estacionesMantenimiento;
        this.principal = principal;
    }

    public void iniciarSimulacion() {
        for (int i = 0; i < aviones.obtenerLongitud(); i++) {
            try {
                aviones.obtenerElemento(i).setMotor(this);
                aviones.obtenerElemento(i).start();
            } catch (Exception e) {
            }

        }
    }

    public Lista<Avion> getAviones() {
        return aviones;
    }

    public Lista<EstacionControl> getEstacionesControl() {
        return estacionesControl;
    }

    public Lista<PistaAterrizaje> getPistasAterrizaje() {
        return pistasAterrizaje;
    }

    public Lista<EstacionDesabordaje> getEstacionesDesabordaje() {
        return estacionesDesabordaje;
    }

    public Lista<EstacionMantenimiento> getEstacionesMantenimiento() {
        return estacionesMantenimiento;
    }

    public Lista<Log> getLogs() {
        return logs;
    }

    public boolean contactarEstacion(Avion avion, int idEstacionNumero) {
        int indice = buscarPorId(idEstacionNumero, estacionesControl);
        try {
            EstacionControl estacion = estacionesControl.obtenerElemento(indice);
            estacion.setMotor(this);
            estacion.contactarAvion(avion);
            avion.setEstacionControl(estacion);
            return true;
        } catch (EstructuraException e) {
            JOptionPane.showMessageDialog(null, "No existe ninguna estación de control con ese id", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Esa estacion de control no puede contactar más aviones", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    public int buscarPorId(int id, Lista lista) {

        for (int i = 0; i < lista.obtenerLongitud(); i++) {

            try {
                if (lista.obtenerElemento(i) instanceof Avion) {
                    if (((Avion) lista.obtenerElemento(i)).getID() == id) {
                        return i;
                    }
                    ;
                } else if (lista.obtenerElemento(i) instanceof EstacionControl) {
                    if (((EstacionControl) lista.obtenerElemento(i)).getID() == id) {
                        return i;
                    }
                    ;
                }
            } catch (EstructuraException e) {
                e.printStackTrace();
            }
        }

        return -1;

    }

    public void autorizarAterrizaje(Avion avion, PistaAterrizaje pista) {

    }

    public void actualizarCombobox() {
        principal.mostrarComboBox();
    }

    public EstacionDesabordaje encontrarEstacionDesabordaje() {
        for (int i = 0; i < estacionesDesabordaje.obtenerLongitud(); i++) {
            try {
                EstacionDesabordaje estacion = estacionesDesabordaje.obtenerElemento(i);
                if (!estacion.getAvionesEnEspera().esLlena()) return estacion;
            } catch (EstructuraException e) {
            }
        }
        return null;
    }
}
