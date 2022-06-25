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

public class Lista<T> implements Serializable {

    private Nodo<T> inicio;
    private Nodo<T> ultimo;
    private int longitud = 0;

    public void agregar(T contenido) {
        if (esVacia()) {
            inicio = new Nodo<>(contenido);
            ultimo = inicio;
        } else {
            Nodo<T> nuevo = new Nodo<>(contenido);
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
        longitud++;
    }

    public boolean esVacia() {
        return inicio == null;
    }

    public int obtenerLongitud() {
        return longitud;
    }

    public int obtenerIndice(T contenido) {
        int indice = 0;
        Nodo<T> actual = inicio;
        for (int i = 0; i < longitud; i++) {
            if (actual.getContenido().equals(contenido))
                return indice;
            Nodo<T> siguiente = actual.getSiguiente();
            actual = siguiente;
            indice++;
        }
        return -1;
    }

    public void eliminarPorIndice(int indice) throws ListaException {
        if (indice >= longitud || indice < 0) {
            throw new ListaException("Indice fuera de rango");
        }

        if (indice == 0) {
            inicio = inicio.getSiguiente();
        longitud--;
        } else if (indice == longitud - 1) {
            eliminarUltimo();
        } else {
            Nodo<T> anterior = encontrarPorIndice(indice - 1);
            Nodo<T> siguiente = anterior.getSiguiente().getSiguiente();
            anterior.setSiguiente(siguiente);
        longitud--;
        }

    }

    public void eliminarUltimo() throws ListaException {
        if (esVacia()) {
            throw new ListaException("La lista esta vacia!");
        } else if (longitud == 1) {
            inicio = null;
            ultimo = null;
        } else {
            Nodo<T> nuevoUltimo = encontrarPorIndice(longitud - 2);
            nuevoUltimo.setSiguiente(null);
            ultimo = nuevoUltimo;
        }
        longitud--;
    }

    public T obtenerElemento(int indice) throws ListaException {
        return encontrarPorIndice(indice).getContenido();
    }

    public Nodo<T> encontrarPorIndice(int indice) throws ListaException {
        if (indice >= longitud || indice < 0) {
            throw new ListaException("Indice fuera de rango");
        }

        Nodo<T> actual = inicio;
        for (int i = 0; i < indice; i++) {
            Nodo<T> siguiente = actual.getSiguiente();
            actual = siguiente;
        }

        return actual;
    }
}
