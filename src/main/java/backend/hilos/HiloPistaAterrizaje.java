package backend.hilos;

import backend.Avion;
import backend.instalaciones.PistaAterrizaje;

public class HiloPistaAterrizaje extends Thread{

    private Avion avion;
    private PistaAterrizaje pista;

    public HiloPistaAterrizaje(Avion avion, PistaAterrizaje pista) {
        this.avion = avion;
        this.pista = pista;
    }

    @Override
    public void run() {
        mostrarAterrizaje();
    }

    public void mostrarAterrizaje() {
        avion.borrarCuadro();
        pista.setTiempoActual(PistaAterrizaje.getTiempoAterrizaje());
        while (pista.getTiempoActual() >= 0) {

            try {
                pista.mostrarTiempoAterrizaje();
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("hilo interrumpido");
            }
            pista.setTiempoActual(pista.getTiempoActual() - 1);
        }
        pista.aterrizarHecho(false);
    }
}
