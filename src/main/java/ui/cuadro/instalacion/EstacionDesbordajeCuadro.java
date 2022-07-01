/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.cuadro.instalacion;

import Interfaces.Posicionable;
import backend.Avion;
import backend.instalaciones.EstacionDesabordaje;
import backend.instalaciones.InstalacionConEspera;

import java.awt.Color;

/**
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
        setBackground(new Color(245, 81, 86));
        ID.setForeground(Color.white);
        avionesEnEspera.setForeground(Color.white);
        tiempoLabel.setForeground(Color.white);
        infoAvion.setForeground(Color.white);
    }

    @Override
    public void desplegarTextoTiempo() {
        tiempoLabel.setFont(fuente);
        tiempoLabel.setText((instalacionEspera.getAvionActivo() != null) ? "Pasajeros desabordando: " + ((EstacionDesabordaje) instalacionEspera).getPasajerosDesabordados() : "Tiempo por pasajero: " + EstacionDesabordaje.getTiempoDesabordar() / 1000 + "s");
    }

    @Override
    public void desplegarInfoAvion() {
        super.desplegarInfoAvion();
        infoAvion.setText((instalacionEspera.getAvionActivo() != null) ? "Avion desabordando con id: " + instalacionEspera.getAvionActivo().getID() : "Estación de desabordaje vacía");
    }

    @Override
    public void ponerToolTips() {
        super.ponerToolTips();
        toolTipTexto += " - " + ((EstacionDesabordaje) instalacionEspera).getPasajerosDesabordados() + " desabordando";
    }
}
