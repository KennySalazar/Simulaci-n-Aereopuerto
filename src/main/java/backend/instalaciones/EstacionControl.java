/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.instalaciones;

import backend.Avion;
import backend.estructuras.lista.Lista;
import backend.estructuras.lista.ListaException;

/**
 *
 * @author Kenny
 */
public class EstacionControl extends Instalacion {
    private Lista<Avion>avionesContactados;
   
   

    public EstacionControl(int ID, int cantidad) {
        super(ID, cantidad);
        avionesContactados = new Lista<Avion>();
        
    }

    public Lista<Avion> getAvionesContactados() {
        return avionesContactados;
    }
    
    @Override
    public void crearLista(Lista lineas, Lista elementos){
          for (int i = 0; i < lineas.obtenerLongitud(); i++) {
            try {
                String[] separador = ((String)lineas.obtenerElemento(i)).split(",");
                EstacionControl estacionC = new EstacionControl(Integer.parseInt(separador[0]), Integer.parseInt(separador[1]));
                elementos.agregar(estacionC);

            } catch (ListaException ex) {

            }
        }
          
    }
    
}
