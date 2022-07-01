/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.instalaciones;

import backend.Avion;
import backend.estructuras.lista.Lista;
import ui.cuadro.instalacion.InstalacionCuadro;

/**
 * @author Kenny
 */
public abstract class Instalacion extends Thread {
    protected String ocupados;
    protected int ID;
    protected int cantidad;
    protected InstalacionCuadro cuadro;
    protected Avion avionActivo;


    public Instalacion(int ID, int cantidad) {
        this.ID = ID;
        this.cantidad = cantidad;
        armarTexto(0);
    }

    public void armarTexto(int cantidadContactados) {
        ocupados = cantidadContactados + "/" + cantidad;
    }

    public int getID() {
        return ID;
    }

    public InstalacionCuadro getCuadro() {
        return cuadro;
    }

    public String getOcupados() {
        return ocupados;
    }

    public void setCuadro(InstalacionCuadro cuadro) {
        this.cuadro = cuadro;
    }

    public Avion getAvionActivo() {
        return avionActivo;
    }

    @Override
    public void run() {

    }

    public void setAvionActivo(Avion avionActivo) {
        this.avionActivo = avionActivo;
    }

    public abstract void crearLista(Lista lineas, Lista elementos);
}
