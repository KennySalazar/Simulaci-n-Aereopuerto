/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import backend.estructuras.lista.Lista;
import backend.estructuras.lista.EstructuraException;
import backend.hilos.HiloAvionDespegue;
import backend.hilos.HiloAvionVolando;
import backend.instalaciones.EstacionControl;

import java.util.Random;

import backend.instalaciones.EstacionDesabordaje;
import backend.instalaciones.EstacionMantenimiento;
import backend.instalaciones.PistaAterrizaje;
import ui.cuadro.avion.AvionCuadro;

import javax.swing.*;

/**
 * @author Kenny
 */
public class Avion  {

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
    private HiloAvionVolando hiloActual;
    private int tiempoDespegueActual;
    Random rd = new Random();

    private static int tiempoDespegue;
    private static int tiempoGastoCombustible;

    public Avion(int ID, String tipo, int combustible) {
        this.ID = ID;
        this.tipo = tipo;
        this.combustible = combustible;
        if (tipo.equalsIgnoreCase("pequeño")||tipo.equalsIgnoreCase("pequenio") ) {
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


    public void mostrarCombustible() {
        cuadro.actualizarElementos();
    }

    public void contactarEstacion() {
        String idEstacion = JOptionPane.showInputDialog("El avion con id " + ID + " esta intentando contactar con una estación de control, si alguna estación está libre, por favor ingresar su id");
        try {
            if (idEstacion != null || idEstacion.equals("")) {
                int idEstacionNumero = Integer.parseInt(idEstacion);
                if (motor.contactarEstacion(this, idEstacionNumero)) {
                    motor.nuevoLog("Avion", "El avion con id " + ID + " contactó con la estación con id " + idEstacionNumero);
                    cuadro.desplegarEstacionContacto();
                    cuadro.actualizarElementos();
                }
            }

        } catch (Exception e) {

        }
    }

    public void comenzarDespegue() {
        motor.nuevoLog("Despegue", "El avión con id " + ID + " empezó su despegue");
        setEstado("Despegando...");
        crearHiloAvionDespegue();
    }

    public void crearHiloAvionVolando() {
        hiloActual = new HiloAvionVolando(this);
        hiloActual.start();
    }

    public void crearHiloAvionDespegue() {
        tiempoDespegueActual = Avion.tiempoDespegue;
        HiloAvionDespegue hilo = new HiloAvionDespegue(this);
        hilo.start();
    }

    public void setEstacionControl(EstacionControl estacionControl) {
        this.estacionControl = estacionControl;
    }


    public void explotar() {
        borrarCuadro();
        motor.nuevoLog("Avion", "El avion con id " + ID + " explotó");
        try {
            motor.getAviones().borrarElemento(this);
            if (estacionControl != null) estacionControl.eliminarAvion(this);
            if (pista != null) pista.eliminarAvion(this);
            JOptionPane.showMessageDialog(null, "El avion con id " + ID + " ha explotado");
        } catch (EstructuraException e) {
           
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
        motor.nuevoLog("Avion", "El avion con id " + ID + " contactó con la pista con id " + pista.getID());
    }

    public void aterrizar() {
        pista.getCuadro().actualizarElementos();
        motor.nuevoLog("Avion", "El avion con id " + ID + " aterrizó");
        hiloActual.interrupt();
    }

    public void borrarCuadro() {
        cuadro.borrarAvion();
        cuadro = null;
    }

    public void contactarEstacionDesabordaje(EstacionDesabordaje estacionDesabordaje) {

    }
    
    public void contactarEstacionMantenimiento(EstacionMantenimiento estacionMantenimiento) {
        
    }

    public int getCombustible() {
        return combustible;
    }

    public void setCombustibleActual(int combustibleActual) {
        this.combustibleActual = combustibleActual;
    }

    public void setPorcentajeGasolina(int porcentajeGasolina) {
        this.porcentajeGasolina = porcentajeGasolina;
    }

    public AvionCuadro getCuadro() {
            return cuadro;
    }

    public static int getTiempoGastoCombustible(){
        return Avion.tiempoGastoCombustible;
    }

    public PistaAterrizaje getPista() {
            return pista;
    }

    public void setTiempoDespegueActual(int tiempoDespegueActual) {
            this.tiempoDespegueActual = tiempoDespegueActual;
    }

    public int getTiempoDespegueActual() {
        return tiempoDespegueActual;
    }

    public static int getTiempoDespegue() {
        return Avion.getTiempoDespegue();
    }

    public MotorSimulacion getMotor() {
        return motor;
    }

    public void disminuirTiempoActual() {
        tiempoDespegueActual-=1000;
    }

    public void setPista(PistaAterrizaje pista) {
        this.pista = pista;
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
