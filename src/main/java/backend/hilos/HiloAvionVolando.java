package backend.hilos;

import backend.Avion;

import javax.swing.*;

public class HiloAvionVolando extends Thread {
    private Avion avion;

    public HiloAvionVolando(Avion avion) {
        this.avion = avion;
    }

    @Override
    public void run() {
        solicitarEstacionControl();
    }

    public void solicitarEstacionControl() {

        avion.setCombustibleActual(avion.getCombustible());
        int porcentajeContactarEstacion = 95;
        int porcentajeAnterior = 100;

        while (avion.getCombustibleActual() >= 0 && !Thread.currentThread().isInterrupted()) {
            try {
                avion.setPorcentajeGasolina(Math.round(avion.getCombustibleActual() * 100 / avion.getCombustible()));
                avion.mostrarCombustible();
                if (porcentajeAnterior != avion.getPorcentajeGasolina()) {
                    porcentajeAnterior = (int) avion.getPorcentajeGasolina();
                    if (avion.getPorcentajeGasolina() == 25) {
                        JOptionPane.showMessageDialog(null, "El avion con id " + avion.getID() + " le queda 25% de combustible", "Emergencia!", JOptionPane.WARNING_MESSAGE);
                        avion.getCuadro().alertar();
                    }
                }
                Thread.sleep(Avion.getTiempoGastoCombustible());

            } catch (InterruptedException ex) {
            
            } catch (NullPointerException e) {

            }
            avion.setCombustibleActual(avion.getCombustibleActual() -1);

            if (avion.getPorcentajeGasolina() <= porcentajeContactarEstacion && porcentajeContactarEstacion != 0 && avion.getEstacionControl() == null) {
                if (avion.getPista() == null) {
                    avion.contactarEstacion();
                    porcentajeContactarEstacion -= 5;
                }
            }

        }
        if (avion.getCuadro() != null) avion.explotar();
    }
}
