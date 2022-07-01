/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.cuadro.instalacion;

import Interfaces.Posicionable;
import backend.instalaciones.EstacionMantenimiento;
import backend.instalaciones.InstalacionConEspera;
import java.awt.Color;


/**
 *
 * @author Kenny
 */
public class EstacionMantenimientoCuadro extends InstalacionCuadro implements Posicionable {

    public EstacionMantenimientoCuadro(InstalacionConEspera instalacionEspera) {
        super("/imagenes/estacionMantenimiento.png");
        this.instalacionEspera = instalacionEspera;
    }

    @Override
    public void posicionarElementos(int ancho, int alto) {
        super.posicionarElementos(ancho, alto);
        setBackground(new Color(250, 250, 60));

    }
    
    
       @Override
    public void desplegarTextoTiempo() {
        tiempoLabel.setFont(fuente);
        tiempoLabel.setText((instalacionEspera.getAvionActivo() != null) ? "Tiempo restante de mantenimiento: " + ((EstacionMantenimiento) instalacionEspera).getTiempoFinalActual(): "Tiempo de mantenimiento: " + EstacionMantenimiento.getTiempoMantenimiento() / 1000 + "s");
    }

    @Override
    public void desplegarInfoAvion() {
        super.desplegarInfoAvion();
        infoAvion.setText((instalacionEspera.getAvionActivo() != null) ? "Avion en mantenimiento con id: " + instalacionEspera.getAvionActivo().getID() : "Estación de mantenimiento vacía");
    }

    @Override
    public void ponerToolTips() {
        super.ponerToolTips();
        toolTipTexto += " - " + ((EstacionMantenimiento) instalacionEspera).getTiempoFinalActual() + " en mantenimiento";
    }


}
