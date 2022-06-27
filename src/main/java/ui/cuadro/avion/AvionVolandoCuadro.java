/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.cuadro.avion;

import Interfaces.Posicionable;
import backend.Avion;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 *
 * @author Kenny
 */
public class AvionVolandoCuadro extends AvionCuadro implements Posicionable{

    private JLabel estacionContacto;

    public AvionVolandoCuadro(Avion avion) {
        super(avion);
        estacionContacto = new JLabel();
    }

    @Override
    public void posicionarElementos(int ancho, int alto) {

        ponerFuente(alto,12,150);
        iniciarCuadro(ancho, alto);

        // desplegando información
        setBackground(new Color(73, 189, 224));
        desplegarTextoID(avion.getID());
        desplegarTextoCantidadPasajeros();
        desplegarTextoCombustible();
        desplegarEstacionContacto();

        // añadiendo componentes del cuadro
        JPanel textos = new JPanel();
        textos.setLayout(new BoxLayout(textos,BoxLayout.Y_AXIS));

        textos.add(galonesCombustible);
        textos.add(ID);
        textos.add(estacionContacto);
        textos.add(cantidadPasajeros);

        Dimension tamaño = textos.getPreferredSize();
        textos.setBounds(3,3,tamaño.width,tamaño.height);
        textos.setOpaque(false);

        add(textos);
        add(imagen);
        imagen.setBounds(1,tamaño.height + 1,ancho,alto-tamaño.height);
        cambiarTamaño();

        ponerToolTips();
        setToolTipText(toolTipTexto);

    }

    public void desplegarEstacionContacto () {
        estacionContacto.setFont(fuente);
        String texto = (avion.getEstacionControl() == null) ? "Sin estación contactada" : "Estación ID: " + avion.getEstacionControl().getID()+" contactada";
        estacionContacto.setText(texto);
    }


    @Override
    public void actualizarElementos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void ponerToolTips() {
        super.ponerToolTips();
        toolTipTexto += (avion.getEstacionControl() == null) ? " - sin contactar" : " - contactando " + avion.getEstacionControl().getID();
    }
}
