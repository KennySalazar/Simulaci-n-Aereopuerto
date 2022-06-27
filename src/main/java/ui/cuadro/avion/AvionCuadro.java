/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.cuadro.avion;

import backend.Avion;
import javax.swing.JLabel;
import ui.cuadro.Cuadro;

/**
 *
 * @author Kenny
 */
public abstract class AvionCuadro extends Cuadro {
    protected JLabel cantidadPasajeros;
    protected JLabel galonesCombustible;
    protected Avion avion;

    public AvionCuadro(Avion avion) {
        super("/imagenes/avion.png");
        this.avion = avion;
        cantidadPasajeros = new JLabel();
        galonesCombustible  = new JLabel();

    }
    
   public void desplegarTextoCantidadPasajeros() {
        cantidadPasajeros.setFont(fuente);
        cantidadPasajeros.setText("Pasajeros: " + avion.getCantidadPasejeros());
   }

   public void desplegarTextoCombustible() {
        galonesCombustible.setFont(fuente);
        galonesCombustible.setText("Combustible: " + avion.getCombustibleActual() + ", " + Math.round(avion.getPorcentajeGasolina() * 100) + "%");
   }

    public void ponerToolTips() {
        super.ponerToolTips(avion.getID());
        toolTipTexto += avion.getTipo() + " - gas: " + avion.getCombustibleActual();
    }
}
