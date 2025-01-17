/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import backend.Avion;
import backend.MotorSimulacion;
import backend.estructuras.lista.Lista;
import backend.estructuras.lista.EstructuraException;
import backend.instalaciones.EstacionControl;
import backend.instalaciones.EstacionDesabordaje;
import backend.instalaciones.EstacionMantenimiento;
import backend.instalaciones.PistaAterrizaje;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.*;

/**
 * @author Kenny
 */
public class CargarArchivos extends javax.swing.JFrame {

    private Principal principal;
    private MotorSimulacion motor;

    public CargarArchivos(Principal principal) {

        this.motor = principal.getMotor();
        this.principal = principal;

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtonAvion = new javax.swing.JButton();
        jButtonEstacionControl = new javax.swing.JButton();
        jButtonMantenimiento = new javax.swing.JButton();
        jButtonAterrizaje = new javax.swing.JButton();
        jButtonDesabordaje = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        aceptarJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel1.setText("Carga de Archivos");
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jButtonAvion.setText("Cargar Datos");
        jButtonAvion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAvionActionPerformed(evt);
            }
        });

        jButtonEstacionControl.setText("Cargar Datos");
        jButtonEstacionControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEstacionControlActionPerformed(evt);
            }
        });

        jButtonMantenimiento.setText("Cargar Datos");
        jButtonMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMantenimientoActionPerformed(evt);
            }
        });

        jButtonAterrizaje.setText("Cargar Datos");
        jButtonAterrizaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAterrizajeActionPerformed(evt);
            }
        });

        jButtonDesabordaje.setText("Cargar Datos");
        jButtonDesabordaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDesabordajeActionPerformed(evt);
            }
        });

        jLabel2.setText("Estación de Control");

        jLabel3.setText("Aviones");

        jLabel4.setText("Pista de Atarrezaje");

        jLabel5.setText("Estación de Desabordaje");

        jLabel6.setText("Estación de Mantenimiento");

        aceptarJButton.setText("Aceptar");
        aceptarJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(29, 29, 29))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButtonEstacionControl)
                                .addComponent(jButtonAvion)
                                .addComponent(jButtonAterrizaje))
                            .addComponent(jButtonDesabordaje)
                            .addComponent(jButtonMantenimiento)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel1)))
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(aceptarJButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButtonAvion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEstacionControl)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jButtonAterrizaje))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDesabordaje)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jButtonMantenimiento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(aceptarJButton)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAvionActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonAvionActionPerformed

        Lista<String> lineas = leerArchivo();
        Avion avion = new Avion(0, "", 0);
        avion.crearLista(lineas, motor.getAviones());
        if (lineas.obtenerLongitud() > 0) {
            JOptionPane.showMessageDialog(this, "Se ha cargado correctamente el archivo");
        }

    }//GEN-LAST:event_jButtonAvionActionPerformed

    private void jButtonEstacionControlActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonEstacionControlActionPerformed
        Lista<String> lineas = leerArchivo();
        EstacionControl estacionControl = new EstacionControl(0, 0);
        estacionControl.crearLista(lineas, motor.getEstacionesControl());
        if (lineas.obtenerLongitud() > 0) {
            JOptionPane.showMessageDialog(this, "Se ha cargado correctamente el archivo");
        }
    }//GEN-LAST:event_jButtonEstacionControlActionPerformed

    private void jButtonAterrizajeActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonAterrizajeActionPerformed
        Lista<String> lineas = leerArchivo();
        PistaAterrizaje pistaA = new PistaAterrizaje(0, 0);
        pistaA.crearLista(lineas, motor.getPistasAterrizaje());
        if (lineas.obtenerLongitud() > 0) {
            JOptionPane.showMessageDialog(this, "Se ha cargado correctamente el archivo");
        }

    }//GEN-LAST:event_jButtonAterrizajeActionPerformed

    private void jButtonDesabordajeActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonDesabordajeActionPerformed
        Lista<String> lineas = leerArchivo();
        EstacionDesabordaje estacionDesabordaje = new EstacionDesabordaje(0, 0);
        estacionDesabordaje.crearLista(lineas, motor.getEstacionesDesabordaje());
        if (lineas.obtenerLongitud() > 0) {
            JOptionPane.showMessageDialog(this, "Se ha cargado correctamente el archivo");
        }

    }//GEN-LAST:event_jButtonDesabordajeActionPerformed

    private void jButtonMantenimientoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonMantenimientoActionPerformed
        Lista<String> lineas = leerArchivo();
        EstacionMantenimiento estacionMan = new EstacionMantenimiento(0, 0);
        estacionMan.crearLista(lineas, motor.getEstacionesMantenimiento());
        if (lineas.obtenerLongitud() > 0) {
            JOptionPane.showMessageDialog(this, "Se ha cargado correctamente el archivo");
        }

    }//GEN-LAST:event_jButtonMantenimientoActionPerformed

    private void aceptarJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarJButtonActionPerformed
        if (esValidoCargaDatos()) {
            JOptionPane.showMessageDialog(this, "Archivos cargados correctamente");
            dispose();
            principal.abrirConfiguracion();
        } else {
            JOptionPane.showMessageDialog(this, "Algún archivo no se cargó o hay algún archivo vacío");
        }

    }//GEN-LAST:event_aceptarJButtonActionPerformed

    public boolean esValidoCargaDatos() {
        return (motor.getAviones().obtenerLongitud() > 0
                && motor.getEstacionesControl().obtenerLongitud() > 0
                && motor.getPistasAterrizaje().obtenerLongitud() > 0
                && motor.getEstacionesDesabordaje().obtenerLongitud() > 0
                && motor.getEstacionesMantenimiento().obtenerLongitud() > 0);
    }

    public Lista<String> cargarDatos(String path) {
        Lista<String> lineas = new Lista<>();
        try {
            FileReader fileR = new FileReader(path);
            BufferedReader bufferedR = new BufferedReader(fileR);
            String lineaTxt = bufferedR.readLine();
            while (lineaTxt != null) {
                lineas.agregar(lineaTxt);
                lineaTxt = bufferedR.readLine();

            }

        } catch (Exception e) {
        }
        return lineas;
    }

    public Lista<String> leerArchivo() {
        Lista<String> lineas = new Lista<>();
        JFileChooser fileCh = new JFileChooser();
        int respuesta = fileCh.showOpenDialog(this);
        if (respuesta == 0) {
            lineas = cargarDatos(fileCh.getSelectedFile().getAbsolutePath());
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo cargar correctamente el archivo");
        }
        return lineas;
    }


    /*public void crearListas(Lista lista, Class c) {
        Lista<String> lineas = leerArchivo();
        for (int i = 0; i < lineas.obtenerLongitud(); i++) {
            try {
                String[] separador = lineas.obtenerElemento(i).split(",");

                Instalacion estacion = null;
                if (EstacionControl.class.equals(c)) {
                    estacion = new EstacionControl(Integer.parseInt(separador[0]), Integer.parseInt(separador[1]));
                } else if (EstacionMantenimiento.class.equals(c)) {
                    estacion = new EstacionMantenimiento(Integer.parseInt(separador[0]), Integer.parseInt(separador[1]));
                } else  if (EstacionDesabordaje.class.equals(c)){
                    estacion = new EstacionDesabordaje(Integer.parseInt(separador[0]), Integer.parseInt(separador[1]));
                }else if(PistaAterrizaje.class.equals(c)){
                    estacion = new PistaAterrizaje(Integer.parseInt(separador[0]), Integer.parseInt(separador[1]));
                }

                lista.agregar(estacion);

            } catch (ListaException ex) {

            }
        }
        if (lineas.obtenerLongitud() > 0) {
            JOptionPane.showMessageDialog(this, "Se ha cargado correctamente el archivo");
        }
    }
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarJButton;
    private javax.swing.JButton jButtonAterrizaje;
    private javax.swing.JButton jButtonAvion;
    private javax.swing.JButton jButtonDesabordaje;
    private javax.swing.JButton jButtonEstacionControl;
    private javax.swing.JButton jButtonMantenimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
