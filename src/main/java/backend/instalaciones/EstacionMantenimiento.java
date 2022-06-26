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
public class EstacionMantenimiento extends InstalacionConEspera{
    private static int tiempoMantenimiento;
    
    public EstacionMantenimiento(int ID, int cantidad) {
        super(ID, cantidad);
    }

     @Override
    public void run() {
        
    }
    public static void setTiempoMantenimiento(int nuevoTiempoMantenimiento){
        tiempoMantenimiento = nuevoTiempoMantenimiento;
        
    }
     @Override
    public void crearLista(Lista lineas, Lista elementos){
          for (int i = 0; i < lineas.obtenerLongitud(); i++) {
            try {
                String[] separador = ((String)lineas.obtenerElemento(i)).split(",");
                EstacionMantenimiento estacionM = new EstacionMantenimiento(Integer.parseInt(separador[0]), Integer.parseInt(separador[1]));
                elementos.agregar(estacionM);

            } catch (ListaException ex) {

            }
        }
        
        
    }
    
}
