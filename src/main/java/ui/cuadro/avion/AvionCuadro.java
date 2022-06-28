/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.cuadro.avion;

import Interfaces.Posicionable;
import backend.Avion;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.cuadro.Cuadro;

/**
 * @author Kenny
 */
public class AvionCuadro extends Cuadro implements Posicionable {

    protected JLabel cantidadPasajeros;
    protected JLabel galonesCombustible;
    private JLabel estacionContacto;
    protected Avion avion;

    public AvionCuadro(Avion avion) {
        super("/imagenes/avion.png");
        this.avion = avion;
        cantidadPasajeros = new JLabel();
        galonesCombustible = new JLabel();
        estacionContacto = new JLabel();

    }

    @Override
    public void posicionarElementos(int ancho, int alto) {
        try {

            ponerFuente(alto, 12, 150);
            iniciarCuadro(ancho, alto);

            // desplegando información

            desplegarTextoID(avion.getID());
            desplegarTextoCantidadPasajeros();
            desplegarTextoCombustible();
            desplegarEstacionContacto();

            // añadiendo componentes del cuadro
            JPanel textos = new JPanel();
            textos.setLayout(new BoxLayout(textos, BoxLayout.Y_AXIS));

            textos.add(galonesCombustible);
            textos.add(ID);
            textos.add(estacionContacto);
            textos.add(cantidadPasajeros);

            Dimension tamaño = textos.getPreferredSize();
            textos.setBounds(3, 3, tamaño.width, tamaño.height);
            textos.setOpaque(false);

            add(textos);
            add(imagen);
            imagen.setBounds(1, tamaño.height + 1, ancho, alto - tamaño.height);
            cambiarTamaño();

            ponerToolTips();
            setToolTipText(toolTipTexto);
        } catch(NullPointerException exception){
            iniciarCuadro(ancho, alto);
        }

    }

    public void desplegarTextoCantidadPasajeros() {
        cantidadPasajeros.setFont(fuente);
        cantidadPasajeros.setText("Pasajeros: " + avion.getCantidadPasejeros() + " - " + avion.getTipo());
    }

    public void desplegarTextoCombustible() {
        galonesCombustible.setFont(fuente);
        galonesCombustible.setText("Combustible: " + avion.getCombustibleActual() + ", " + Math.round(avion.getPorcentajeGasolina() * 100) + "%");
    }


    public void ponerToolTips() {
        super.ponerToolTips(avion.getID());
        toolTipTexto += avion.getTipo() + " - gas: " + avion.getCombustibleActual();
        toolTipTexto += (avion.getEstacionControl() == null) ? " - sin contactar" : " - contactando " + avion.getEstacionControl().getID();
    }

    @Override
    public void actualizarElementos() {
    }

    public void desplegarEstacionContacto() {
        estacionContacto.setFont(fuente);
        String texto = (avion.getEstacionControl() == null) ? "Sin estación contactada" : "Estación ID: " + avion.getEstacionControl().getID() + " contactada";
        estacionContacto.setText(texto);
    }
}
