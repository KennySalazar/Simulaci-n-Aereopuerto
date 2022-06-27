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
public class AvionVolandoCuadro extends AvionCuadro {

    public AvionVolandoCuadro(Avion avion) {
        super(avion);

    }

    @Override
    public void posicionarElementos(int ancho, int alto) {
        super.posicionarElementos(ancho, alto);
        setBackground(new Color(73, 189, 224));
    }

    @Override
    public void actualizarElementos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
