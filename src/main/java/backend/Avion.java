/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import backend.estructuras.lista.Lista;
import backend.estructuras.lista.ListaException;
import backend.instalaciones.EstacionControl;
import enums.TipoAvion;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import ui.cuadro.avion.AvionCuadro;

/**
 * @author Kenny
 */
public class Avion extends Thread {

    private int ID;
    private String tipo;
    private int combustible;
    private int combustibleActual;
    private EstacionControl estacionControl;
    private AvionCuadro cuadro;
    private int cantidadPasejeros;
    private int porcentajeGasolina;
    Random rd = new Random();

    private static int tiempoDespegue;
    private static int tiempoGastoCombustible;

    public Avion(int ID, String tipo, int combustible) {
        this.ID = ID;
        this.tipo = tipo;
        this.combustible = combustible;
        if (tipo.equalsIgnoreCase("pequeño")) {
            cantidadPasejeros = rd.nextInt(5) + 5;
        } else if (tipo.equalsIgnoreCase("mediano")) {
            cantidadPasejeros = rd.nextInt(10) + 15;
        } else if (tipo.equalsIgnoreCase("grande")) {
            cantidadPasejeros = rd.nextInt(10) + 30;
        } else {
            cantidadPasejeros = rd.nextInt(5) + 5;
        }
        porcentajeGasolina = 100;
        combustibleActual = combustible;
    }

    public static void setTiempoGastoCombustible(int nuevoTiempoGastoCombustible) {
        tiempoGastoCombustible = nuevoTiempoGastoCombustible;
    }

    @Override
    public void run() {

        //LOGICA DE COMO VAYA PERDIENDO LOS GALONES DE GASOLINE, ASI VAYA SOLICITANDO COMUNICARSE CON LA EC
        solicitarPistaAterrizaje();
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidadPasejeros() {
        return cantidadPasejeros;
    }

    public static void setTiempoDespegue(int nuevoTiempoDespegue) {
        tiempoDespegue = nuevoTiempoDespegue;
    }

    public int getID() {
        return ID;
    }

    public void crearLista(Lista lineas, Lista elementos) {
        for (int i = 0; i < lineas.obtenerLongitud(); i++) {
            try {
                String[] separador = ((String) lineas.obtenerElemento(i)).split(",");
                Avion avion = new Avion(Integer.parseInt(separador[0]), separador[1], Integer.parseInt(separador[2]));
                elementos.agregar(avion);

            } catch (ListaException ex) {

            }
        }

    }

    public double getPorcentajeGasolina() {
        return porcentajeGasolina;
    }

    public int getCombustibleActual() {
        return combustibleActual;
    }

    public EstacionControl getEstacionControl() {
        return estacionControl;
    }

    public void solicitarPistaAterrizaje() {

        combustibleActual = combustible;

        int porcentajeContactarEstacion = 95;
        while (combustibleActual > 0) {
            try {
                porcentajeGasolina = (combustibleActual * 100 / combustible);
                mostrarCombustible();
                Thread.sleep(Avion.tiempoGastoCombustible);

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            combustibleActual--;

            if (porcentajeGasolina <= porcentajeContactarEstacion && porcentajeContactarEstacion != 0) {
                
                contactarEstacion();
                porcentajeContactarEstacion -= 5;
            }
            
        }
        explotar();
    }

    public void mostrarCombustible() {
        System.out.println("COMBUSTIBLE: " + combustibleActual + "," + porcentajeGasolina + "%");
    }

    public void contactarEstacion() {
        System.out.println("CONTACTANDO ESTACION........");
    }

    public void explotar() {
        System.out.println("TE HAS QUEDADO SIN COMBUSTIBLE");
    }

}
