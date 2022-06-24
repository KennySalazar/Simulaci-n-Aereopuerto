/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.estructuras.lista;

/**
 *
 * @author Kenny
 */
import java.io.Serializable;

public class Nodo<T> implements Serializable {
    private T contenido;
    private Nodo<T> siguiente;

    public Nodo(T contenido) {
        this.contenido = contenido;
    }

    public T getContenido() {
        return contenido;
    }

    public void setContenido(T nuevoContenido) {
        contenido = nuevoContenido;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

}

