/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import backend.estructuras.lista.Lista;
import backend.estructuras.lista.EstructuraException;
import backend.instalaciones.EstacionControl;

import java.util.Random;

import backend.instalaciones.EstacionDesabordaje;
import backend.instalaciones.PistaAterrizaje;
import ui.cuadro.avion.AvionCuadro;

import javax.swing.*;

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
    private String estado;
    private MotorSimulacion motor;
    private PistaAterrizaje pista;
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
        estado = "Volando..";
    }

    public static void setTiempoGastoCombustible(int nuevoTiempoGastoCombustible) {
        tiempoGastoCombustible = nuevoTiempoGastoCombustible;
    }

    @Override
    public void run() {

        solicitarEstacionControl();
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

            } catch (EstructuraException ex) {

            }
        }

    }

    public void setCuadro(AvionCuadro cuadro) {
        this.cuadro = cuadro;
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

    public void solicitarEstacionControl() {

        combustibleActual = combustible;
        int porcentajeContactarEstacion = 95;
        int porcentajeAnterior = 100;

        while (combustibleActual >= 0 && !Thread.currentThread().isInterrupted()) {
            try {
                porcentajeGasolina = (combustibleActual * 100 / combustible);
                mostrarCombustible();
                if (porcentajeAnterior != porcentajeGasolina) {
                    porcentajeAnterior = porcentajeGasolina;
                    if (porcentajeGasolina == 25) {
                        JOptionPane.showMessageDialog(null, "El avion con id " + ID + " le queda 25% de combustible", "Emergencia!", JOptionPane.WARNING_MESSAGE);
                        cuadro.alertar();
                    }
                }
                Thread.sleep(Avion.tiempoGastoCombustible);

            } catch (InterruptedException ex) {
                System.out.println("hilo interrumpido");
            } catch (NullPointerException e) {

            }
            combustibleActual--;

            if (porcentajeGasolina <= porcentajeContactarEstacion && porcentajeContactarEstacion != 0 && estacionControl == null) {
                if (pista == null) {
                    contactarEstacion();
                    porcentajeContactarEstacion -= 5;
                }
            }

        }
        if(cuadro != null) explotar();
    }

    public void mostrarCombustible() {
        cuadro.actualizarElementos();
    }

    public void contactarEstacion() {
        String idEstacion = JOptionPane.showInputDialog("El avion con id " + ID + " esta intentando contactar con una estación de control, si alguna estación está libre, por favor ingresar su id");
        try {
            if (idEstacion != null || idEstacion.equals("")) {
                int idEstacionNumero = Integer.parseInt(idEstacion);
                System.out.println(idEstacionNumero);
                if (motor.contactarEstacion(this, idEstacionNumero)) {
                    cuadro.desplegarEstacionContacto();
                    cuadro.actualizarElementos();
                }
            }

        } catch (Exception e) {

        }
    }

    public void setEstacionControl(EstacionControl estacionControl) {
        this.estacionControl = estacionControl;
    }


    public void explotar() {
        borrarCuadro();
        try {
            motor.getAviones().borrarElemento(this);
            if (estacionControl != null) estacionControl.eliminarAvion(this);
            if (pista != null) pista.eliminarAvion(this);
            JOptionPane.showMessageDialog(null, "El avion con id " + ID + " ha explotado");
        } catch (EstructuraException e) {
            e.printStackTrace();
        }
    }

    public void setMotor(MotorSimulacion motor) {
        this.motor = motor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    public void contactarPista(PistaAterrizaje pista) {
        this.pista = pista;
        estacionControl = null;
        JOptionPane.showMessageDialog(null, "El avion con id " + ID + " fue enviado a la pista de aterrizaje con id: " + pista.getID());
        setEstado("Esperando aterrizaje...");
        cuadro.actualizarElementos();
    }

    public void aterrizar() {
        JOptionPane.showMessageDialog(null, "El avion con id: " + ID +  " terminó su aterrizaje y será enviado al desabordaje: ");
        pista.getCuadro().actualizarElementos();
        interrupt();
    }

    public void borrarCuadro() {
        cuadro.borrarAvion();
        cuadro = null;
    }

    public void contactarEstacionDesabordaje(EstacionDesabordaje estacionDesabordaje) {

    }
}



/*101,pequeño,1000
102,grande,4000
103,mediano,2500
104,mediano,1500
105,pequeño,100
106,grande,500
107,mediano,600
108,grande,3000*/
