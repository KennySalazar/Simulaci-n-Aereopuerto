/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.cuadro.instalacion;

import Interfaces.Posicionable;
import backend.instalaciones.InstalacionConEspera;
import backend.instalaciones.PistaAterrizaje;
import java.awt.Color;

/**
 *
 * @author Kenny
 */
public class PistaAterrizajeCuadro extends InstalacionCuadro {

    public PistaAterrizajeCuadro(InstalacionConEspera instalacionEspera) {
        super("/imagenes/pistaAterrizaje.png");
        this.instalacionEspera = instalacionEspera;

    }

    @Override
    public void posicionarElementos(int ancho, int alto) {
        super.posicionarElementos(ancho, alto);
        setBackground(Color.LIGHT_GRAY);

    }

    @Override
    public void actualizarElementos() {
    }

}
