/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.cuadro.instalacion;

import Interfaces.Posicionable;
import backend.instalaciones.Instalacion;
import backend.instalaciones.InstalacionConEspera;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ui.cuadro.Cuadro;

/**
 *
 * @author Kenny
 */
public class InstalacionCuadro extends Cuadro implements Posicionable {

    private JLabel avionesEnEspera;
    private JLabel tiempoPorAvion;

    protected InstalacionConEspera instalacionEspera;

    public InstalacionCuadro(String path) {
        super(path);
        avionesEnEspera = new JLabel();
        tiempoPorAvion = new JLabel();

    }

    @Override
    public void posicionarElementos(int ancho, int alto) {
        ponerFuente(alto, 12, 150);
        iniciarCuadro(ancho, alto);

        desplegarTextoID(instalacionEspera.getID());
        desplegarTextoAvionesEnEspera();
        desplegarTextoTiempoFaltante();

        JPanel textos = new JPanel();
        textos.setLayout(new BoxLayout(textos, BoxLayout.Y_AXIS));
        textos.add(ID);
        textos.add(avionesEnEspera);
        textos.add(tiempoPorAvion);

        Dimension tamaño = textos.getPreferredSize();
        textos.setBounds(3, 3, tamaño.width, tamaño.height);
        textos.setOpaque(false);

        add(textos);
        add(imagen);
        imagen.setBounds(1, tamaño.height + 1, ancho, alto - tamaño.height);
        cambiarTamaño();

        ponerToolTips();
        setToolTipText(toolTipTexto);
    }

    @Override
    public void actualizarElementos() {
    }

    public void ponerToolTips() {
        super.ponerToolTips(instalacionEspera.getID());
        toolTipTexto += instalacionEspera.getOcupados() + " - " + instalacionEspera.getTiempoFaltante();
    }

    public void desplegarTextoAvionesEnEspera() {
        avionesEnEspera.setFont(fuente);
        avionesEnEspera.setText("Aviones en Cola: " + instalacionEspera.getOcupados());

    }

    public void desplegarTextoTiempoFaltante() {
        tiempoPorAvion.setFont(fuente);
        tiempoPorAvion.setText("Tiempo por avión: " + instalacionEspera.getTiempoFaltante());
    }
}
