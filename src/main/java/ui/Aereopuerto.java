package ui;

import backend.MotorSimulacion;
import backend.estructuras.lista.Lista;
import backend.estructuras.lista.ListaException;
import backend.instalaciones.EstacionControl;
import ui.cuadro.avion.AvionDespegueCuadro;
import ui.cuadro.avion.AvionVolandoCuadro;
import ui.cuadro.instalacion.EstacionDesbordajeCuadro;
import ui.cuadro.instalacion.EstacionMantenimientoCuadro;
import ui.cuadro.instalacion.PistaAterrizajeCuadro;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Kenny
 */
public class Aereopuerto extends JPanel {
    private Lista<AvionDespegueCuadro> avionesDespegue;
    private Lista<AvionVolandoCuadro> avionesVolando;
    private Lista<EstacionControl > estacionesControl;
    private Lista<EstacionDesbordajeCuadro > estacionesDesbordaje;
    private Lista<EstacionMantenimientoCuadro> estacionesMantenimiento;
    private Lista<PistaAterrizajeCuadro > pistasAterrizaje;
    private int anchoCuadro;
    private int altoCuadro;
    MotorSimulacion motor;

    public Aereopuerto(MotorSimulacion motor) {
        this.avionesDespegue = new Lista();
        this.avionesVolando = new Lista();
        this.estacionesControl = new Lista();
        this.estacionesDesbordaje = new Lista();
        this.estacionesMantenimiento = new Lista();
        this.pistasAterrizaje = new Lista();
        this.motor = motor;
    }

    public void iniciarAereopuerto() {
        setLayout(new GridLayout(motor.getAviones().obtenerLongitud(), 6));
        anchoCuadro = Math.round(getWidth() / 6);
        altoCuadro = Math.round(getHeight() / motor.getAviones().obtenerLongitud());
        desplegarAvionesVolando();
    }

    public void desplegarAvionesVolando() {
        for (int i = 0; i < motor.getAviones().obtenerLongitud(); i++) {
            try {
                AvionVolandoCuadro avionVolandoCuadro = new AvionVolandoCuadro(motor.getAviones().obtenerElemento(i));
                avionVolandoCuadro.posicionarElementos(anchoCuadro, altoCuadro);
                add(avionVolandoCuadro);
            } catch (ListaException e) {
                e.printStackTrace();
            }
        }
    }
}

