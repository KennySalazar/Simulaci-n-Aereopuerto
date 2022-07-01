/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.cuadro;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 *
 * @author Kenny
 */
public class Cuadro extends JPanel {
    // se puede hacer abstracto
    
    protected JLabel ID;
    protected JLabel imagen;
    protected final String PATH;
    private ImageIcon icon;
    protected Font fuente;
    protected String toolTipTexto;

    public Cuadro(String path) {
        PATH = path;
        ID = new JLabel();
        imagen = new JLabel();
        icon = new ImageIcon(getClass().getResource(PATH));

    }

    public void desplegarTextoID(int id) {
        ID.setFont(fuente);
        ID.setText("ID: " + id);
    }

    public void cambiarTamaño(){
        Image nuevaImagen = icon.getImage();
        int tamañoMenor =(imagen.getHeight()>imagen.getWidth())? (imagen.getWidth()):imagen.getHeight(); 
        Image imagenNuevoTamaño = nuevaImagen.getScaledInstance(tamañoMenor,tamañoMenor,Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado =  new ImageIcon(imagenNuevoTamaño);
        imagen.setIcon(iconoEscalado);
    }

    public void ponerToolTips(int id) {
        toolTipTexto = "" + id + " - ";
    }

    public void ponerFuente(int alto, int proporcion1, int proporcion2){
        int tamañoFuente = Math.round((alto * proporcion1) / proporcion2);
        fuente = new Font(Font.DIALOG,Font.BOLD, tamañoFuente);
    }

    public void iniciarCuadro(int ancho , int alto){
        // Iniciando cuadro
        setPreferredSize(new Dimension( ancho,alto));
//        Border border = BorderFactory.createLineBorder(new Color(75, 75, 75),1);
//        setBorder(border);
        setLayout(null);    }
    
}
