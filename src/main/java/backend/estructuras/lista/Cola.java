/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.estructuras.lista;

/**
 * @author Kenny
 */
public class Cola<T> {

    private T[] arreglo;
    private int indiceMaximo;

    public Cola(int tamaño) {
        this.arreglo = (T[]) new Object[tamaño];
        indiceMaximo = -1;
    }

    public void encolarElemento(T elemento) throws EstructuraException {
        if (esLlena()) {
            throw new EstructuraException("La cola está llena");
        } else {
            indiceMaximo++;
            arreglo[indiceMaximo] = elemento;
        }
    }

    public T desencolar() throws EstructuraException {
        if (esVacia()) {
            throw new EstructuraException("La cola está vacia");
        } else {
            T primerElemento = arreglo[0];
            actualizarOrden(0);

            return primerElemento;
        }
    }

    public T inicioCola() throws EstructuraException {
        if (esVacia()) {
            throw new EstructuraException("La cola esta vacía");
        } else {
            return arreglo[0];
        }
    }

    public void actualizarOrden(int inicio) {
        for (int i = inicio; i < arreglo.length - 1; i++) {
            if (arreglo[i] != null){
                arreglo[i] = arreglo[i + 1];
                arreglo[i+1] = null;
            }
        }
        if (inicio >= 0 && inicio < arreglo.length - 1) indiceMaximo--;
    }

    public boolean esLlena() {
        return indiceMaximo == arreglo.length - 1;
    }

    public boolean esVacia() {
        return indiceMaximo == -1;
    }

    public int obtenerIndiceElemento(T elemento) throws EstructuraException {
        if (esVacia()) {
            throw new EstructuraException("La cola está vacia");
        } else {
            T actual = arreglo[0];
            for (int i = 0; i < arreglo.length; i++) {
                if (actual.equals(elemento))
                    return i;
                actual = arreglo[i + 1];
            }
            return -1;
        }
    }

    public int getIndiceMaximo() {
        return indiceMaximo;
    }
}
