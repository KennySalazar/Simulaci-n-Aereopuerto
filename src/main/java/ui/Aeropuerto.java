package ui;

import backend.MotorSimulacion;
import backend.estructuras.lista.Lista;
import backend.estructuras.lista.EstructuraException;
import ui.cuadro.EstacionControlCuadro;
import ui.cuadro.avion.AvionDespegueCuadro;
import ui.cuadro.avion.AvionVolandoCuadro;
import ui.cuadro.instalacion.EstacionDesbordajeCuadro;
import ui.cuadro.instalacion.EstacionMantenimientoCuadro;
import ui.cuadro.instalacion.PistaAterrizajeCuadro;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 *
 * @author Kenny
 */
public class Aeropuerto extends JPanel {

    private Lista<AvionDespegueCuadro> avionesDespegue;
    private Lista<AvionVolandoCuadro> avionesVolando;
    private Lista<EstacionControlCuadro> estacionesControl;
    private Lista<EstacionDesbordajeCuadro> estacionesDesbordaje;
    private Lista<EstacionMantenimientoCuadro> estacionesMantenimiento;
    private Lista<PistaAterrizajeCuadro> pistasAterrizaje;
    private int anchoCuadro;
    private int altoCuadro;
    private MotorSimulacion motor;
    private int mayorLongitud;
    
    public Aeropuerto(MotorSimulacion motor) {
        this.avionesDespegue = new Lista();
        this.avionesVolando = new Lista();
        this.estacionesControl = new Lista();
        this.estacionesDesbordaje = new Lista();
        this.estacionesMantenimiento = new Lista();
        this.pistasAterrizaje = new Lista();
        this.motor = motor;
    }
    
    public void obtenerMayorLongitud() {
        mayorLongitud = motor.getAviones().obtenerLongitud();
        setMayorLongitud(motor.getEstacionesControl().obtenerLongitud());
        setMayorLongitud(motor.getPistasAterrizaje().obtenerLongitud());
        setMayorLongitud(motor.getEstacionesMantenimiento().obtenerLongitud());
        setMayorLongitud(motor.getEstacionesDesabordaje().obtenerLongitud());
    }
    
    public void setMayorLongitud(int longitud) {
        if (longitud > mayorLongitud) {
            mayorLongitud = longitud;
        }
    }
    
    public void iniciarAereopuerto() {
        obtenerMayorLongitud();
        setLayout(new GridLayout(6, mayorLongitud));
        anchoCuadro = Math.round(getWidth() / mayorLongitud);
        altoCuadro = Math.round(getHeight() / 6);
        desplegarAvionesVolando();
        desplegarEstacionesControl();
        desplegarPistasAterrizaje();
        desplegarEstacionesDesabordaje();
        desplegarEstacionMantenimiento();
        desplegarAvionesDespegue();
        Border border = BorderFactory.createTitledBorder("Aereopuerto");
        setBorder(border);
    }
    
    public void desplegarAvionesVolando() {
        for (int i = 0; i < mayorLongitud; i++) {
            try {
                AvionVolandoCuadro avionVolandoCuadro = new AvionVolandoCuadro(motor.getAviones().obtenerElemento(i));
                avionVolandoCuadro.posicionarElementos(anchoCuadro, altoCuadro);
                add(avionVolandoCuadro);
                avionesVolando.agregar(avionVolandoCuadro);
                motor.getAviones().obtenerElemento(i).setCuadro(avionVolandoCuadro);
            } catch (EstructuraException e) {
                JPanel panel = new JPanel();
                add(panel);
                panel.setOpaque(false);
            }
        }
    }
    
    public void desplegarEstacionesControl() {
        for (int i = 0; i < mayorLongitud; i++) {
            try {
                EstacionControlCuadro estacionControlCuadro = new EstacionControlCuadro(motor.getEstacionesControl().obtenerElemento(i));
                estacionControlCuadro.posicionarElementos(anchoCuadro, altoCuadro);
                add(estacionControlCuadro);
                estacionesControl.agregar(estacionControlCuadro);
                motor.getEstacionesControl().obtenerElemento(i).setCuadro(estacionControlCuadro);
            } catch (EstructuraException e) {
                JPanel panel = new JPanel();
                add(panel);
                panel.setOpaque(false);
            }
        }
    }
    
    public void desplegarPistasAterrizaje() {
        for (int i = 0; i < mayorLongitud; i++) {
            try {
                PistaAterrizajeCuadro pistaCuadro = new PistaAterrizajeCuadro(motor.getPistasAterrizaje().obtenerElemento(i));
                motor.getPistasAterrizaje().obtenerElemento(i).setMotor(motor);
                pistaCuadro.posicionarElementos(anchoCuadro, altoCuadro);
                add(pistaCuadro);
                pistasAterrizaje.agregar(pistaCuadro);
                motor.getPistasAterrizaje().obtenerElemento(i).setCuadro(pistaCuadro);
            } catch (EstructuraException e) {
                JPanel panel = new JPanel();
                add(panel);
                panel.setOpaque(false);
            }
        }
        motor.crearPistasEspera();
    }
    
    public void desplegarEstacionesDesabordaje() {
        for (int i = 0; i < mayorLongitud; i++) {
            try {
                EstacionDesbordajeCuadro desabordajeCuadro = new EstacionDesbordajeCuadro(motor.getEstacionesDesabordaje().obtenerElemento(i));
                desabordajeCuadro.posicionarElementos(anchoCuadro, altoCuadro);
                add(desabordajeCuadro);
                estacionesDesbordaje.agregar(desabordajeCuadro);
                motor.getEstacionesDesabordaje().obtenerElemento(i).setCuadro(desabordajeCuadro);
                motor.getEstacionesDesabordaje().obtenerElemento(i).setMotor(motor);
            } catch (EstructuraException e) {
                JPanel panel = new JPanel();
                add(panel);
                panel.setOpaque(false);
            }
        }
        motor.crearEstacionDesabordajeEspera();
    }
    
    public void desplegarEstacionMantenimiento() {
        for (int i = 0; i < mayorLongitud; i++) {
            try {
                EstacionMantenimientoCuadro mantenimiento = new EstacionMantenimientoCuadro(motor.getEstacionesMantenimiento().obtenerElemento(i));
                mantenimiento.posicionarElementos(anchoCuadro, altoCuadro);
                add(mantenimiento);
                estacionesMantenimiento.agregar(mantenimiento);
                motor.getEstacionesMantenimiento().obtenerElemento(i).setCuadro(mantenimiento);
                motor.getEstacionesMantenimiento().obtenerElemento(i).setMotor(motor);
            } catch (EstructuraException e) {
                JPanel panel = new JPanel();
                add(panel);
                panel.setOpaque(false);
            }
        }
    }
    
    public void desplegarAvionesDespegue() {
        for (int i = 0; i < motor.getAviones().obtenerLongitud(); i++) {
            AvionDespegueCuadro avion = new AvionDespegueCuadro(null);
            avion.posicionarElementos(anchoCuadro, altoCuadro);
            add(avion);
            avionesDespegue.agregar(avion);
        }
    }
}
