/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import backend.estructuras.lista.Lista;
import backend.instalaciones.*;

/**
 *
 * @author Kenny
 */
public class MotorSimulacion {

    private Lista<Avion> aviones;
    private Lista<EstacionControl> estacionesControl;
    private Lista<PistaAterrizaje> pistasAterrizaje;
    private Lista<EstacionDesabordaje> estacionesDesabordaje;
    private Lista<EstacionMantenimiento> estacionesMantenimiento;
    private Lista <Log> logs;

    public MotorSimulacion(Lista<Avion> aviones, Lista<EstacionControl> estacionesControl, Lista<PistaAterrizaje> pistasAterrizaje, Lista<EstacionDesabordaje> estacionesDesabordaje, Lista<EstacionMantenimiento> estacionesMantenimiento) {
        this.aviones = aviones;
        this.estacionesControl = estacionesControl;
        this.pistasAterrizaje = pistasAterrizaje;
        this.estacionesDesabordaje = estacionesDesabordaje;
        this.estacionesMantenimiento = estacionesMantenimiento;
    }
    
    public void iniciarSimulacion(){
        
    }
}
