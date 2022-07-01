/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import backend.estructuras.lista.Cola;
import backend.estructuras.lista.Lista;
import backend.estructuras.lista.EstructuraException;
import backend.instalaciones.*;
import ui.Aeropuerto;
import ui.Principal;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Kenny
 */
public class MotorSimulacion {

    private Lista<Avion> aviones;
    private Lista<EstacionControl> estacionesControl;
    private Lista<PistaAterrizaje> pistasAterrizaje;
    private Lista<EstacionDesabordaje> estacionesDesabordaje;
    private Lista<EstacionMantenimiento> estacionesMantenimiento;
    private Cola<PistaAterrizaje> pistasEnEspera;
    private Cola<EstacionDesabordaje> estacionEnEspera;
    private Lista<Log> logs;
    private Principal principal;
    private String path;
    private Aeropuerto aeropuerto;

    public MotorSimulacion(Lista<Avion> aviones, Lista<EstacionControl> estacionesControl, Lista<PistaAterrizaje> pistasAterrizaje, Lista<EstacionDesabordaje> estacionesDesabordaje, Lista<EstacionMantenimiento> estacionesMantenimiento, Principal principal) {
        this.aviones = aviones;
        this.estacionesControl = estacionesControl;
        this.pistasAterrizaje = pistasAterrizaje;
        this.estacionesDesabordaje = estacionesDesabordaje;
        this.estacionesMantenimiento = estacionesMantenimiento;
        this.principal = principal;
        this.logs = new Lista<>();
    }

    public void iniciarSimulacion() {
        for (int i = 0; i < aviones.obtenerLongitud(); i++) {
            try {
                aviones.obtenerElemento(i).setMotor(this);
                aviones.obtenerElemento(i).crearHiloAvionVolando();
            } catch (Exception e) {
            }

        }
    }

    public void conseguirPath() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona donde guardar el archivo de logs");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int respuesta = fileChooser.showOpenDialog(null);
        if (respuesta == 0) {
            path = fileChooser.getSelectedFile().getAbsolutePath();
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo cargar correctamente el archivo");
        }
    }

    public void nuevoLog(String titulo, String contenido) {
        Log log = new Log(titulo, contenido);
        logs.agregar(log);
        actualizarHtml();
    }

    public void actualizarHtml() {
        try {
            FileWriter htmlEscribidor = new FileWriter(path + "/logs.html");
            htmlEscribidor.write("<h1>Logs de la simulación de aviones</h1>");
            htmlEscribidor.write("<ul>");
            for (int i = 0; i < logs.obtenerLongitud(); i++) {
                Log log = logs.obtenerElemento(i);
                htmlEscribidor.write("<li><strong>"+log.getTitulo()+"</strong>   "+log.getContenido()+"</li>");
            }
            htmlEscribidor.write("</ul>");
            htmlEscribidor.close();
        } catch (IOException e) {
        } catch (EstructuraException e) {
        }
    }

    public Lista<Avion> getAviones() {
        return aviones;
    }

    public Lista<EstacionControl> getEstacionesControl() {
        return estacionesControl;
    }

    public Lista<PistaAterrizaje> getPistasAterrizaje() {
        return pistasAterrizaje;
    }

    public Lista<EstacionDesabordaje> getEstacionesDesabordaje() {
        return estacionesDesabordaje;
    }

    public Lista<EstacionMantenimiento> getEstacionesMantenimiento() {
        return estacionesMantenimiento;
    }



    public Lista<Log> getLogs() {
        return logs;
    }

    public boolean contactarEstacion(Avion avion, int idEstacionNumero) {
        int indice = buscarPorId(idEstacionNumero, estacionesControl);
        try {
            EstacionControl estacion = estacionesControl.obtenerElemento(indice);
            estacion.setMotor(this);
            estacion.contactarAvion(avion);
            avion.setEstacionControl(estacion);
            return true;
        } catch (EstructuraException e) {
            JOptionPane.showMessageDialog(null, "No existe ninguna estación de control con ese id", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Esa estacion de control no puede contactar más aviones", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    public int buscarPorId(int id, Lista lista) {

        for (int i = 0; i < lista.obtenerLongitud(); i++) {

            try {
                if (lista.obtenerElemento(i) instanceof Avion) {
                    if (((Avion) lista.obtenerElemento(i)).getID() == id) {
                        return i;
                    }
                    ;
                } else if (lista.obtenerElemento(i) instanceof EstacionControl) {
                    if (((EstacionControl) lista.obtenerElemento(i)).getID() == id) {
                        return i;
                    }
                    ;
                }
            } catch (EstructuraException e) {
            
            }
        }

        return -1;

    }

    public void actualizarCombobox() {
        principal.mostrarComboBox();
    }

    public EstacionDesabordaje encontrarEstacionDesabordaje(PistaAterrizaje pista) {
        for (int i = 0; i < estacionesDesabordaje.obtenerLongitud(); i++) {
            try {
                EstacionDesabordaje estacion = estacionesDesabordaje.obtenerElemento(i);
                if (!estacion.getAvionesEnEspera().esLlena()) return estacion;
            } catch (EstructuraException e) {
            }
        }
        try {
            pistasEnEspera.encolarElemento(pista);
        } catch (EstructuraException e) {
        }
        return null;
    }
    public EstacionMantenimiento encontrarEstacionMantenimiento(EstacionDesabordaje estacionD){
         for (int i = 0; i < estacionesMantenimiento.obtenerLongitud(); i++) {
            try {
                EstacionMantenimiento estacionMan = estacionesMantenimiento.obtenerElemento(i);
                if (!estacionMan.getAvionesEnEspera().esLlena()) return estacionMan;
            } catch (EstructuraException e) {
            }
        }
        try {
            estacionEnEspera.encolarElemento(estacionD);
        } catch (EstructuraException e) {
        }
        return null;
    }

    public void estacionDisponible() {
        try {
            PistaAterrizaje pistaEsperando = pistasEnEspera.desencolar();
            pistaEsperando.aterrizarHecho(true);
        } catch (EstructuraException e) {
        }
    }
    
     public void estacionMantenimientoDisponible() {
        try {
            EstacionDesabordaje estacionEsperando = estacionEnEspera.desencolar();
            estacionEsperando.terminarDesabordaje(true);
        } catch (EstructuraException e) {
        }
    }

    public void crearPistasEspera() {
        this.pistasEnEspera = new Cola<>(pistasAterrizaje.obtenerLongitud());
    }
    
    public void crearEstacionDesabordajeEspera(){
        this.estacionEnEspera = new Cola<>(estacionesDesabordaje.obtenerLongitud());
    }

    public void setAeropuerto(Aeropuerto aeropuerto) {
        this.aeropuerto = aeropuerto;
    }

    public Aeropuerto getAeropuerto() {
        return aeropuerto;
    }

    public void enviarAVuelo(Avion avion) {
        avion.borrarCuadro();
        avion.setEstado("Volando...");
        aeropuerto.enviarAVuelo(avion);
    }
}
