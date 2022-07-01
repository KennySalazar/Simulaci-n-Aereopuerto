/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author Kenny
 */
public class Log {

    private String titulo;
    private String contenido;

    public Log(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }

    public String getTitulo() {
        return titulo;
    }
}
