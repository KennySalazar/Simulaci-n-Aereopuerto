package backend.hilos;

import backend.instalaciones.EstacionDesabordaje;

public class HiloEstacionDesabordaje extends Thread{
    EstacionDesabordaje estacion;

    public HiloEstacionDesabordaje(EstacionDesabordaje estacion) {
        this.estacion = estacion;
    }

    @Override
    public void run() {
        mostrarDesabordaje();
    }

    public void mostrarDesabordaje() {
        while (estacion.getPasajerosDesabordados() > 0) {

            try {
                estacion.mostrarTiempoDesabordaje();
                Thread.sleep(estacion.getTiempoDesabordar());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            estacion.setPasajerosDesabordados(estacion.getPasajerosDesabordados() - 1);
        }
        estacion.terminarDesabordaje();
    }

}
