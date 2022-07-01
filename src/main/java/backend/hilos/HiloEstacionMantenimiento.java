/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.hilos;

import backend.instalaciones.EstacionMantenimiento;

/**
 *
 * @author Kenny
 */
public class HiloEstacionMantenimiento extends Thread{
    EstacionMantenimiento estacionMantenimiento;

    public HiloEstacionMantenimiento(EstacionMantenimiento estacionMantenimiento) {
        this.estacionMantenimiento = estacionMantenimiento;
    }

    @Override
    public void run() {
        mostrarMantenimiento();
    }
    
        public void mostrarMantenimiento() {
        estacionMantenimiento.calcularTiempo();
        while (estacionMantenimiento.getTiempoFinalActual() >= 0) {

            try {
                estacionMantenimiento.getCuadro().actualizarElementos();
                System.out.println("TIEMPO " + estacionMantenimiento.getTiempoFinalActual());
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            estacionMantenimiento.setTiempoFinalActual(estacionMantenimiento.getTiempoFinalActual() - 1);
        }
        estacionMantenimiento.terminarMantenimiento();
    }
    
    
    
}
