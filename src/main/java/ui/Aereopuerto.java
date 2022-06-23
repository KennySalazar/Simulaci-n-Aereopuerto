/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import backend.estructuras.lista.Lista;
import backend.instalaciones.EstacionControl;
import ui.cuadro.avion.AvionDespegueCuadro;
import ui.cuadro.avion.AvionVolandoCuadro;
import ui.cuadro.instalacion.EstacionDesbordajeCuadro;
import ui.cuadro.instalacion.EstacionMantenimientoCuadro;
import ui.cuadro.instalacion.PistaAterrizajeCuadro;

/**
 *
 * @author Kenny
 */
public class Aereopuerto {
    private Lista<AvionDespegueCuadro> avionesDespegue;
    private Lista<AvionVolandoCuadro> avionesVolando;
    private Lista<EstacionControl > estacionesControl;
    private Lista<EstacionDesbordajeCuadro > estacionesDesbordaje;
    private Lista<EstacionMantenimientoCuadro> estacionesMantenimiento;
    private Lista<PistaAterrizajeCuadro > pistasAterrizaje;
    
}
