/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import backend.Avion;
import backend.MotorSimulacion;
import backend.estructuras.lista.Lista;
import backend.estructuras.lista.ListaException;
import backend.instalaciones.*;
import ui.cuadro.avion.AvionCuadro;
import ui.cuadro.avion.AvionVolandoCuadro;

import javax.swing.*;

/**
 * @author Kenny
 */
public class Principal extends javax.swing.JFrame {

    MotorSimulacion motor;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxAvionesContactados = new javax.swing.JComboBox<>();
        jComboBoxEstacionC = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxPistaA = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        IniciarSimulacion = new javax.swing.JMenu();
        JMenuAcciones = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        JMenuConfig = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 573, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 434, Short.MAX_VALUE)
        );

        jButton1.setText("Autorizar aterrizaje del avión");
        jButton1.setEnabled(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Control del Aeropuerto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 2, 12))); // NOI18N

        jLabel1.setText("Estación De Control");

        jLabel2.setText("Pistas de Atarrizaje");

        jComboBoxAvionesContactados.setEnabled(false);

        jComboBoxEstacionC.setEnabled(false);
        jComboBoxEstacionC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEstacionCActionPerformed(evt);
            }
        });

        jLabel3.setText("Aviones Contactados");

        jComboBoxPistaA.setEnabled(false);
        jComboBoxPistaA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPistaAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jComboBoxPistaA, 0, 177, Short.MAX_VALUE)
                                        .addComponent(jComboBoxEstacionC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBoxAvionesContactados, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jComboBoxEstacionC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBoxAvionesContactados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jComboBoxPistaA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(22, Short.MAX_VALUE))
        );

        IniciarSimulacion.setText("Iniciar Simulación ");
        IniciarSimulacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IniciarSimulacionMouseClicked(evt);
            }
        });
        jMenuBar1.add(IniciarSimulacion);

        JMenuAcciones.setText("Acciones");
        JMenuAcciones.setEnabled(false);

        jMenuItem2.setText("Pausar");
        JMenuAcciones.add(jMenuItem2);

        jMenuItem3.setText("Reanudar");
        JMenuAcciones.add(jMenuItem3);

        jMenuItem4.setText("Guardar");
        JMenuAcciones.add(jMenuItem4);

        jMenuBar1.add(JMenuAcciones);

        JMenuConfig.setText("Configuración");
        JMenuConfig.setEnabled(false);
        JMenuConfig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JMenuConfigMouseClicked(evt);
            }
        });
        jMenuBar1.add(JMenuConfig);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(21, 21, 21)
                                                                .addComponent(jButton1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jSeparator2))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JMenuConfigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JMenuConfigMouseClicked
        abrirConfiguracion();
    }//GEN-LAST:event_JMenuConfigMouseClicked

    private void IniciarSimulacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IniciarSimulacionMouseClicked

        motor = new MotorSimulacion(new Lista<>(), new Lista<>(), new Lista<>(), new Lista<>(), new Lista<>());
        CargarArchivos cargarArhivo = new CargarArchivos(this);
        cargarArhivo.setVisible(true);
        cargarArhivo.setLocationRelativeTo(this);
        setEnabled(false);

    }//GEN-LAST:event_IniciarSimulacionMouseClicked

    private void jComboBoxPistaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPistaAActionPerformed

    }//GEN-LAST:event_jComboBoxPistaAActionPerformed

    private void jComboBoxEstacionCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEstacionCActionPerformed

    }//GEN-LAST:event_jComboBoxEstacionCActionPerformed

    public void abrirConfiguracion() {
        Configuracion configuracion = new Configuracion(this);
        configuracion.setLocationRelativeTo(this);
        configuracion.setVisible(true);
    }

    public void mostrarAereopuerto() {
        motor.iniciarSimulacion();
        try {
            mostrarComboBoxInstalacion(jComboBoxEstacionC, motor.getEstacionesControl(), "A. Contactados: ");
            mostrarComboBoxInstalacion(jComboBoxPistaA, motor.getPistasAterrizaje(), "A. en Cola: ");
            mostrarAvionesSegunEstacionSeleccionada();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void mostrarAvionesSegunEstacionSeleccionada() throws ListaException {
        int selectedIndex = jComboBoxEstacionC.getSelectedIndex();
        EstacionControl estacion = motor.getEstacionesControl().obtenerElemento(selectedIndex);
        mostrarComboBoxAviones(estacion);
    }

    public void mostrarComboBoxInstalacion(JComboBox combo, Lista lista, String textoEspecifico) throws ListaException {
        combo.setEnabled(true);

        for (int i = 0; i < lista.obtenerLongitud(); i++) {
            String id = "ID: " + ((Instalacion) lista.obtenerElemento(i)).getID();
            String ocupados = ", " + textoEspecifico + ((Instalacion) lista.obtenerElemento(i)).getOcupados();

            String texto = id + ocupados;
            combo.addItem(texto);
        }

    }

    public void mostrarComboBoxAviones(EstacionControl estacionControl) throws ListaException {
        jComboBoxAvionesContactados.setEnabled(true);
        for (int i = 0; i < estacionControl.getAvionesContactados().obtenerLongitud(); i++) {
            Avion avionContactado = estacionControl.getAvionesContactados().obtenerElemento(i);
            String texto = "ID: " + avionContactado.getID() + " - " + avionContactado.getTipo();
            jComboBoxAvionesContactados.addItem(texto);
        }
    }

    public MotorSimulacion getMotor() {
        return motor;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu IniciarSimulacion;
    private javax.swing.JMenu JMenuAcciones;
    private javax.swing.JMenu JMenuConfig;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxAvionesContactados;
    private javax.swing.JComboBox<String> jComboBoxEstacionC;
    private javax.swing.JComboBox<String> jComboBoxPistaA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables

}
