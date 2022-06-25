/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import backend.instalaciones.EstacionControl;
import enums.TipoAvion;
import java.util.Random;
import ui.cuadro.avion.AvionCuadro;

/**
 *
 * @author Kenny
 */
public class Avion extends Thread{
    private int ID;
    private String tipo;
    private int combustible;
    private int combustibleActual;
    private EstacionControl estacionControl;
    private AvionCuadro cuadro;
    private int cantidadPasejeros;
    Random rd = new Random();

    private static int tiempoDespegue;
    private static int tiempoGastoCombustible;
    
    public Avion(int ID, String tipo, int combustible) {
        this.ID = ID;
        this.tipo = tipo;
        this.combustible = combustible;
        if(tipo.equalsIgnoreCase("pequeño")){
            cantidadPasejeros = rd.nextInt(5) + 5;
        } else if(tipo.equalsIgnoreCase("mediano")){
            cantidadPasejeros = rd.nextInt(10) + 15;
        } else if(tipo.equalsIgnoreCase("grande")){
            cantidadPasejeros = rd.nextInt(10) + 30;
        }else{
            cantidadPasejeros = rd.nextInt(5) + 5;
        }
            
    }

    public static void setTiempoGastoCombustible(int nuevoTiempoGastoCombustible) {
        tiempoGastoCombustible = nuevoTiempoGastoCombustible;
    }

    @Override
    public void run() {
        //LOGICA DE COMO VAYA PERDIENDO LOS GALONES DE GASOLINE, ASI VAYA SOLICITANDO COMUNICARSE CON LA EC
    }
    
   

    public int getCantidadPasejeros() {
        return cantidadPasejeros;
    }
     public static void setTiempoDespegue(int nuevoTiempoDespegue) {
        tiempoDespegue = nuevoTiempoDespegue;
    }
}
