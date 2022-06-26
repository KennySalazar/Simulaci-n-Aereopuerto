/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.instalaciones;

import backend.estructuras.lista.Lista;
import backend.estructuras.lista.ListaException;
import ui.cuadro.instalacion.InstalacionCuadro;

/**
 *
 * @author Kenny
 */
public class PistaAterrizaje extends InstalacionConEspera {

    private static int tiempoAterrizaje;
    private String ocupados;

    public PistaAterrizaje(int ID, int cantidad) {
        super(ID, cantidad);
    }

    @Override
    public void run() {

    }

    public static void setTiempoAterrizaje(int nuevoTiempoAterrizaje) {
        tiempoAterrizaje = nuevoTiempoAterrizaje;
    }
     @Override
    public void crearLista(Lista lineas, Lista elementos){
          for (int i = 0; i < lineas.obtenerLongitud(); i++) {
            try {
                String[] separador = ((String)lineas.obtenerElemento(i)).split(",");
                PistaAterrizaje pistaAterrizaje = new PistaAterrizaje(Integer.parseInt(separador[0]), Integer.parseInt(separador[1]));
                elementos.agregar(pistaAterrizaje);

            } catch (ListaException ex) {

            }
        }
        
        
    }
}
