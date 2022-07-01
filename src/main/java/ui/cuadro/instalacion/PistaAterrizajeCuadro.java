/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.cuadro.instalacion;

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
        setBackground(new Color(212, 212, 203));

    }

    @Override
    public void ponerToolTips() {
        super.ponerToolTips();
        toolTipTexto +=  " - " + instalacionEspera.getTiempoFaltante();
    }

    @Override
    public void desplegarTextoTiempo() {
        tiempoLabel.setFont(fuente);
        tiempoLabel.setText((instalacionEspera.getAvionActivo() != null) ? "Tiempo faltante: " + instalacionEspera.getTiempoFaltante() : "Tiempo en aterrizar: " + PistaAterrizaje.getTiempoAterrizaje() + "s");
    }

    @Override
    public void desplegarInfoAvion() {
        super.desplegarInfoAvion();
        infoAvion.setText((instalacionEspera.getAvionActivo() != null) ? "Avion aterrizando con id: " + instalacionEspera.getAvionActivo().getID() : "Pista vacía");
    }
}
