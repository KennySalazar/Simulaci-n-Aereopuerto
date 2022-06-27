/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.cuadro.instalacion;

import Interfaces.Posicionable;
import backend.Avion;
import backend.instalaciones.InstalacionConEspera;
import java.awt.Color;

/**
 *
 * @author Kenny
 */
public class EstacionDesbordajeCuadro extends InstalacionCuadro {

    public EstacionDesbordajeCuadro(InstalacionConEspera instalacionEspera) {
        super("/imagenes/estacionDesabordaje.png");
        this.instalacionEspera = instalacionEspera;
    }

    @Override
    public void posicionarElementos(int ancho, int alto) {
        super.posicionarElementos(ancho, alto);
        setBackground(Color.red);
    }

    @Override
    public void actualizarElementos() {
    }

}
