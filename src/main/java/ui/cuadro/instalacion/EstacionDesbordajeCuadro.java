/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.cuadro.instalacion;

import Interfaces.Posicionable;
import backend.Avion;
import backend.instalaciones.InstalacionConEspera;

/**
 *
 * @author Kenny
 */
public class EstacionDesbordajeCuadro extends InstalacionCuadro{


    public EstacionDesbordajeCuadro(InstalacionConEspera instalacionEspera) {
        super("/imagenes/estacionDesabordaje.png");
        this.instalacionEspera = instalacionEspera;
    }

    
}
