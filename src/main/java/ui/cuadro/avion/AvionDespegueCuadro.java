package ui.cuadro.avion;

import Interfaces.Posicionable;
import backend.Avion;
import java.awt.Color;

/**
 *
 * @author Kenny
 */
public class AvionDespegueCuadro extends AvionCuadro {
    
    public AvionDespegueCuadro(Avion avion) {
        super(avion);
    }
    
    @Override
    public void posicionarElementos(int ancho, int alto) {
        super.posicionarElementos(ancho, alto);
        setBackground(Color.GREEN);
    }
    
    @Override
    public void actualizarElementos() {
    }
    
}
