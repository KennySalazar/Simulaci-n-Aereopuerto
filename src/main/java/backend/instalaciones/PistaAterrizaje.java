/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.instalaciones;

import backend.estructuras.lista.Lista;
import backend.estructuras.lista.ListaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.cuadro.instalacion.InstalacionCuadro;

/**
 *
 * @author Kenny
 */
public class PistaAterrizaje extends InstalacionConEspera {

    private static int tiempoAterrizaje;
    
    private String ocupados;
    private int tiempoAterrizajeActual;

    public PistaAterrizaje(int ID, int cantidad) {
        super(ID, cantidad);
        tiempoFaltante = (tiempoAterrizaje/1000) + "s";
       
    }

    @Override
    public void run() {
        mostrarAterrizaje();
    }

    public static void setTiempoAterrizaje(int nuevoTiempoAterrizaje) {
        tiempoAterrizaje = nuevoTiempoAterrizaje / 1000;
        
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
    
    public void mostrarAterrizaje(){
        tiempoAterrizajeActual = tiempoAterrizaje;
        while(tiempoAterrizajeActual > 0){
            
            try {
                mostrarTiempoAterrizaje();
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
               ex.printStackTrace();
            }
            tiempoAterrizajeActual--;
        }
        aterrizarHecho();
    }
    
    public void aterrizarHecho(){
        System.out.println("EL AVION ATERRIZO.");
    }
    
    public void mostrarTiempoAterrizaje(){
        System.out.println("El tiempo faltante para aterrizar: " + tiempoAterrizajeActual + "s");
    }
}
