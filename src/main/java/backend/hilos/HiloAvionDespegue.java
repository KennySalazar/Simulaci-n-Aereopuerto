package backend.hilos;

import backend.Avion;

public class HiloAvionDespegue extends Thread {

    private Avion avion;

    public HiloAvionDespegue(Avion avion) {
        this.avion = avion;
    }

    @Override
    public void run() {
        if (avion.getEstado().equals("Despegando...")) {
            while (avion.getTiempoDespegueActual() >= 0) {
                try {
                    avion.setEstado("Despegando en: " + avion.getTiempoDespegueActual() / 1000 + "s");
                    avion.getCuadro().actualizarElementos();
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                   
                }
                avion.disminuirTiempoActual();
            }
            avion.getMotor().enviarAVuelo(avion);
        } else {
            avion.setCombustibleActual(avion.getCombustible());

            while (avion.getEstacionControl() == null) {
                try {
                    avion.getCuadro().actualizarElementos();
                    Thread.sleep(7000);
                    avion.contactarEstacion();

                } catch (InterruptedException ex) {
                  
                } catch (NullPointerException e) {

                }

            }

        }

    }
}
