package ui.cuadro;

import backend.Avion;
import backend.instalaciones.EstacionControl;
import backend.instalaciones.EstacionDesabordaje;
import backend.instalaciones.EstacionMantenimiento;
import backend.instalaciones.PistaAterrizaje;
import ui.cuadro.avion.AvionVolandoCuadro;

import javax.swing.*;
import java.awt.*;
import ui.cuadro.avion.AvionCuadro;
import ui.cuadro.avion.AvionDespegueCuadro;
import ui.cuadro.instalacion.EstacionDesbordajeCuadro;
import ui.cuadro.instalacion.EstacionMantenimientoCuadro;
import ui.cuadro.instalacion.PistaAterrizajeCuadro;

public class PruebaFrame {

    public static void main(String[] args) {

        // crear frame
        JFrame jf = new JFrame("prueba");
        jf.setSize(500,500);
        jf.setLayout(new FlowLayout(FlowLayout.CENTER));
        jf.setVisible(true);


        // CUADRO AVION VOLANDO
        Avion a = new Avion(1, "grande", 500);
        AvionVolandoCuadro avc = new AvionVolandoCuadro(a);
        avc.posicionarElementos(250,250);
        jf.add(avc);

        jf.revalidate();
        jf.repaint();
        
        Avion b = new Avion(2, "mediano", 400);
        AvionDespegueCuadro adc = new AvionDespegueCuadro(b);
        adc.posicionarElementos(250,250);
        jf.add(adc);

        jf.revalidate();
        jf.repaint();
        
        
        PistaAterrizaje pA = new PistaAterrizaje(22, 6);
        PistaAterrizajeCuadro pac = new PistaAterrizajeCuadro(pA);
        pac.posicionarElementos(250, 250);
       
        jf.add(pac);
        jf.revalidate();
        jf.repaint();
        
        EstacionDesabordaje ed= new EstacionDesabordaje(11, 6);
        EstacionDesbordajeCuadro edc = new EstacionDesbordajeCuadro(ed);
        edc.posicionarElementos(250, 250);
       
        jf.add(edc);
        jf.revalidate();
        jf.repaint();
        
        EstacionMantenimiento em = new EstacionMantenimiento(23, 5);
        EstacionMantenimientoCuadro emc = new EstacionMantenimientoCuadro(em);
        emc.posicionarElementos(250, 250);
       
        jf.add(emc);
        jf.revalidate();
        jf.repaint();
        
        EstacionControl ec = new EstacionControl(1, 4);
        EstacionControlCuadro ecc = new EstacionControlCuadro(ec);
        ecc.posicionarElementos(250, 250);
       
        jf.add(ecc);
        jf.revalidate();
        jf.repaint();
        

    }

}
