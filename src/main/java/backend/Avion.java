/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import backend.estructuras.lista.Lista;
import backend.estructuras.lista.ListaException;
import backend.instalaciones.EstacionControl;

import java.util.Random;

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

    public void solicitarPistaAterrizaje() {

        combustibleActual = combustible;
        int porcentajeContactarEstacion = 95;
        int porcentajeAnterior = 100;
//        mostrarCombustible();

        while (combustibleActual >= 0) {
            try {
                porcentajeGasolina = (combustibleActual * 100 / combustible);
                mostrarCombustible();
                if (porcentajeAnterior != porcentajeGasolina) {
                    porcentajeAnterior = porcentajeGasolina;
                    if (porcentajeGasolina == 25) {
                        JOptionPane.showMessageDialog(null,"El avion con id " + ID + " le queda 25% de combustible", "Emergencia!", JOptionPane.WARNING_MESSAGE);
                        cuadro.alertar();
                    }
//                    mostrarCombustible();
                }
                Thread.sleep(Avion.tiempoGastoCombustible);

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            combustibleActual--;

            if (porcentajeGasolina <= porcentajeContactarEstacion && porcentajeContactarEstacion != 0 && estacionControl == null) {

                contactarEstacion();
                porcentajeContactarEstacion -= 5;
            }

        }
        explotar();
    }

    public void mostrarCombustible() {
//        System.out.println("COMBUSTIBLE: " + combustibleActual + "," + porcentajeGasolina + "%");
        cuadro.actualizarElementos();
    }

    public void contactarEstacion() {
        String idEstacion = JOptionPane.showInputDialog("El avion con id " + ID + " esta intentando contactar con una estación de control, si alguna estación está libre, por favor ingresar su id");
        try{
        if(idEstacion != null || idEstacion.equals("")) {
            int idEstacionNumero = Integer.parseInt(idEstacion);
            System.out.println(idEstacionNumero);
            if (motor.contactarEstacion(this, idEstacionNumero)) {
                cuadro.desplegarEstacionContacto();
                cuadro.actualizarElementos();
            }
        }

        }catch(Exception e){

        }
    }

    public void setEstacionControl(EstacionControl estacionControl) {
        this.estacionControl = estacionControl;
    }


    public void explotar() {
        cuadro.borrarAvion();
        cuadro = null;
        try {
            motor.getAviones().borrarElemento(this);
            estacionControl.eliminarAvion(this);
            JOptionPane.showMessageDialog(null,"El avion con id " + ID + " ha explotado");
        } catch (ListaException e) {
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
    
    
}



/*101,pequeño,1000
102,grande,4000
103,mediano,2500
104,mediano,1500
105,pequeño,100
106,grande,500
107,mediano,600
108,grande,3000*/
