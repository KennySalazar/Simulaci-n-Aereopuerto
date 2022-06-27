/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.instalaciones;

import backend.Avion;
import backend.estructuras.lista.Lista;
import backend.estructuras.lista.ListaException;
import ui.cuadro.instalacion.InstalacionCuadro;

/**
 *
 * @author Kenny
 */
public class EstacionDesabordaje extends InstalacionConEspera {

    private static int tiempoDesabordar;
    private int tiempoFinal;
    private Avion avionDesabordando;

    public void setAvionDesabordando(Avion avionDesabordando) {
        this.avionDesabordando = avionDesabordando;
        tiempoFinal = avionDesabordando.getCantidadPasejeros() * tiempoDesabordar;
        tiempoFaltante = tiempoFinal + "s";
    }

    public EstacionDesabordaje(int ID, int cantidad) {
        super(ID, cantidad);
    }

    @Override
    public void run() {

    }

    public static void setTiempoDesabordar(int tiempoDesabordo) {
        tiempoDesabordar = tiempoDesabordo;

    }
    
     @Override
    public void crearLista(Lista lineas, Lista elementos){
          for (int i = 0; i < lineas.obtenerLongitud(); i++) {
            try {
                String[] separador = ((String)lineas.obtenerElemento(i)).split(",");
                EstacionDesabordaje estacionD = new EstacionDesabordaje(Integer.parseInt(separador[0]), Integer.parseInt(separador[1]));
                elementos.agregar(estacionD);

            } catch (ListaException ex) {

            }
        }
        
        
    }

}
