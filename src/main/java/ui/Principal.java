/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import backend.Avion;
import backend.MotorSimulacion;
import backend.estructuras.lista.Lista;
import backend.estructuras.lista.EstructuraException;
import backend.instalaciones.*;

import javax.swing.*;

/**
 * @author Kenny
 */
public class Principal extends javax.swing.JFrame {

    MotorSimulacion motor;
    Aeropuerto aereopuerto;

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

        jPanelAereopuerto = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxAvionesContactados = new javax.swing.JComboBox<>();
        jComboBoxEstacionC = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxPistaA = new javax.swing.JComboBox<>();
        jButtonAterrizar = new javax.swing.JButton();
        jButtonDespegar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        IniciarSimulacion = new javax.swing.JMenu();
        JMenuAcciones = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        JMenuConfig = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanelAereopuertoLayout = new javax.swing.GroupLayout(jPanelAereopuerto);
        jPanelAereopuerto.setLayout(jPanelAereopuertoLayout);
        jPanelAereopuertoLayout.setHorizontalGroup(
            jPanelAereopuertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 881, Short.MAX_VALUE)
        );
        jPanelAereopuertoLayout.setVerticalGroup(
            jPanelAereopuertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 624, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Control del Aeropuerto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 2, 12))); // NOI18N

        jLabel1.setText("Estación De Control");

        jLabel2.setText("Pistas de Atarrizaje");

        jComboBoxAvionesContactados.setEnabled(false);
        jComboBoxAvionesContactados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAvionesContactadosActionPerformed(evt);
            }
        });

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

        jButtonAterrizar.setText("Autorizar aterrizaje del avión");
        jButtonAterrizar.setEnabled(false);
        jButtonAterrizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAterrizarActionPerformed(evt);
            }
        });

        jButtonDespegar.setText("Autorizar despegue del avión");
        jButtonDespegar.setEnabled(false);
        jButtonDespegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDespegarActionPerformed(evt);
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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAterrizar)
                    .addComponent(jButtonDespegar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addComponent(jButtonAterrizar)
                .addGap(18, 18, 18)
                .addComponent(jButtonDespegar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Representación de colores en cuadros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 2, 12))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Zona de vuelo");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel5.setBackground(new java.awt.Color(167, 245, 108));
        jLabel5.setOpaque(true);
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 18, 16));

        jLabel6.setText("Estación de Control");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 60, -1, 19));

        jLabel8.setText("Zona de Despegue");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, 19));

        jLabel9.setBackground(new java.awt.Color(30, 229, 232));
        jLabel9.setOpaque(true);
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 18, 16));

        jLabel7.setBackground(new java.awt.Color(252, 170, 126));
        jLabel7.setOpaque(true);
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 18, 16));

        jLabel10.setText("Pista de Aterrizaje");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 19));

        jLabel11.setBackground(new java.awt.Color(212, 212, 203));
        jLabel11.setOpaque(true);
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 18, 16));

        jLabel12.setText("Estación de Desabordaje");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 19));

        jLabel13.setBackground(new java.awt.Color(245, 81, 86));
        jLabel13.setOpaque(true);
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 18, 16));

        jLabel14.setText("Estación de Mantenimiento");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 19));

        jLabel15.setBackground(new java.awt.Color(250, 250, 60));
        jLabel15.setOpaque(true);
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 18, 16));

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
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelAereopuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addComponent(jSeparator2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelAereopuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JMenuConfigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JMenuConfigMouseClicked
        abrirConfiguracion();
    }//GEN-LAST:event_JMenuConfigMouseClicked

    private void IniciarSimulacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IniciarSimulacionMouseClicked

        motor = new MotorSimulacion(new Lista<>(), new Lista<>(), new Lista<>(), new Lista<>(), new Lista<>(), this);
        CargarArchivos cargarArhivo = new CargarArchivos(this);
        cargarArhivo.setVisible(true);
        cargarArhivo.setLocationRelativeTo(this);
        setEnabled(false);

    }//GEN-LAST:event_IniciarSimulacionMouseClicked

    private void jComboBoxPistaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPistaAActionPerformed

    }//GEN-LAST:event_jComboBoxPistaAActionPerformed

    private void jComboBoxEstacionCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEstacionCActionPerformed
        try {
            mostrarAvionesSegunEstacionSeleccionada();
        } catch (EstructuraException ex) {

        }
    }//GEN-LAST:event_jComboBoxEstacionCActionPerformed

    private void jComboBoxAvionesContactadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAvionesContactadosActionPerformed
        habilitarBotones();
    }//GEN-LAST:event_jComboBoxAvionesContactadosActionPerformed

    public void habilitarBotones() {
        try{
            int selectedIndexEstacion = jComboBoxEstacionC.getSelectedIndex();
            EstacionControl estacion = motor.getEstacionesControl().obtenerElemento(selectedIndexEstacion);
            int selectedIndexAvion = jComboBoxAvionesContactados.getSelectedIndex();
            Avion avion = estacion.getAvionesContactados().obtenerElemento(selectedIndexAvion);
            if(avion.getEstado().equals("Esperando despegue...")){
                jButtonDespegar.setEnabled(true);
                jButtonAterrizar.setEnabled(false);
            }else {
                jButtonDespegar.setEnabled(false);
                jButtonAterrizar.setEnabled(true);
            }
        } catch (EstructuraException ex) {
        }
    }
    
    private void jButtonAterrizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAterrizarActionPerformed
        autorizarAterrizaje();
    }//GEN-LAST:event_jButtonAterrizarActionPerformed

    private void jButtonDespegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDespegarActionPerformed
        autorizarDespegue();
    }//GEN-LAST:event_jButtonDespegarActionPerformed

    public void autorizarDespegue() {
        try {
            int selectedIndexEstacion = jComboBoxEstacionC.getSelectedIndex();
            EstacionControl estacion = motor.getEstacionesControl().obtenerElemento(selectedIndexEstacion);
            int selectedIndexAvion = jComboBoxAvionesContactados.getSelectedIndex();
            Avion avion = estacion.getAvionesContactados().obtenerElemento(selectedIndexAvion);

            avion.comenzarDespegue();
            estacion.eliminarAvion(avion);

        } catch (EstructuraException ex) {
            JOptionPane.showMessageDialog(this, "Esta estación aún no tiene aviones contactados");
        }

    }

    public void autorizarAterrizaje() {
        try {
            int selectedIndexEstacion = jComboBoxEstacionC.getSelectedIndex();
            EstacionControl estacion = motor.getEstacionesControl().obtenerElemento(selectedIndexEstacion);
            int selectedIndexAvion = jComboBoxAvionesContactados.getSelectedIndex();
            Avion avion = estacion.getAvionesContactados().obtenerElemento(selectedIndexAvion);
            int selectedIndexPista = jComboBoxPistaA.getSelectedIndex();
            PistaAterrizaje pista = motor.getPistasAterrizaje().obtenerElemento(selectedIndexPista);

            pista.agregarAColaAvion(avion, estacion);

        } catch (EstructuraException ex) {
            JOptionPane.showMessageDialog(this, "Esta estación aún no tiene aviones contactados");
        }
    }

    public void abrirConfiguracion() {
        Configuracion configuracion = new Configuracion(this);
        configuracion.setLocationRelativeTo(this);
        configuracion.setVisible(true);
    }



    public void mostrarComboBox() {
        try {
            mostrarComboBoxInstalacion(jComboBoxEstacionC, motor.getEstacionesControl(), "A. Contactados: ");
            mostrarComboBoxInstalacion(jComboBoxPistaA, motor.getPistasAterrizaje(), "A. en Cola: ");
            mostrarAvionesSegunEstacionSeleccionada();
            
            habilitarBotones();

        } catch (Exception e) {
           
        }
    }

    public void mostrarAereopuerto() {
        mostrarComboBox();
        jButtonAterrizar.setEnabled(true);

        aereopuerto = new Aeropuerto(motor);
        motor.setAeropuerto(aereopuerto);
        aereopuerto.setBounds(0, 0, jPanelAereopuerto.getWidth(), jPanelAereopuerto.getHeight());
        jPanelAereopuerto.add(aereopuerto);
        aereopuerto.iniciarAereopuerto();

        motor.iniciarSimulacion();

    }

    public void mostrarAvionesSegunEstacionSeleccionada() throws EstructuraException {

        int selectedIndex = jComboBoxEstacionC.getSelectedIndex();
        EstacionControl estacion = motor.getEstacionesControl().obtenerElemento(selectedIndex);
        mostrarComboBoxAviones(estacion);
    }

    public void mostrarComboBoxInstalacion(JComboBox combo, Lista lista, String textoEspecifico) throws EstructuraException {
        combo.setEnabled(true);
        combo.removeAllItems();

        for (int i = 0; i < lista.obtenerLongitud(); i++) {
            String id = "ID: " + ((Instalacion) lista.obtenerElemento(i)).getID();
            String ocupados = ", " + textoEspecifico + ((Instalacion) lista.obtenerElemento(i)).getOcupados();

            String texto = id + ocupados;
            combo.addItem(texto);
        }

    }

    public void mostrarComboBoxAviones(EstacionControl estacionControl) throws EstructuraException {
        jComboBoxAvionesContactados.setEnabled(true);
        jComboBoxAvionesContactados.removeAllItems();
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
    private javax.swing.JButton jButtonAterrizar;
    private javax.swing.JButton jButtonDespegar;
    private javax.swing.JComboBox<String> jComboBoxAvionesContactados;
    private javax.swing.JComboBox<String> jComboBoxEstacionC;
    private javax.swing.JComboBox<String> jComboBoxPistaA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelAereopuerto;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables

}
