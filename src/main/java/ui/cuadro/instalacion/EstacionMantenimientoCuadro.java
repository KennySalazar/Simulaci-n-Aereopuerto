/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.cuadro.instalacion;

import Interfaces.Posicionable;
import backend.instalaciones.InstalacionConEspera;

/**
 *
 * @author Kenny
 */
public class EstacionMantenimientoCuadro extends InstalacionCuadro implements Posicionable {

    public EstacionMantenimientoCuadro(InstalacionConEspera instalacionEspera) {
        super("/imagenes/estacionMantenimiento.png");
        this.instalacionEspera = instalacionEspera;
    }



}
