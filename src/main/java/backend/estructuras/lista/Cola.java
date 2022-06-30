/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.estructuras.lista;

import javax.print.attribute.standard.MediaSize;

/**
 *
 * @author Kenny
 */
public class Cola<T> {
    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int tamaño;
    
    public Cola(){
        inicio = null;
        fin = null;
        tamaño = 0;
    }
    
    public boolean estaVacia(){
        return inicio == null;
    }
    
    public void insertarElemento(T elemento){
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        if(estaVacia()){
            inicio = nuevoNodo;
        } else{
            fin.setSiguiente(nuevoNodo);
        }
        fin = nuevoNodo;
        tamaño++;
    }
    
    public T eleminarElemento(){
        T quitarElemento = inicio.getContenido();
        inicio = inicio.getSiguiente();
        tamaño--;
        return quitarElemento;
    }
    
    public Nodo<T> inicioCola(){
        return (Nodo<T>) inicio.getContenido();
    }
    
    public int LongitudCola(){
        return tamaño;
        
    }
    
}
