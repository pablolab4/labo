/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import academia.controller.GestorDB;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import models.Alumno;
import models.Curso;

/**
 *
 * @author Pablo
 */
public class AltaAlumno extends javax.swing.JFrame {
    
    GestorDB gestor = new GestorDB();

    public AltaAlumno() {
        initComponents();
        
        ArrayList<Curso> lstCurso = gestor.getAllCursos();
        DefaultComboBoxModel modeloCursos = new DefaultComboBoxModel();
        for (Curso curso : lstCurso) {
            modeloCursos.addElement(curso);
        }
        
        cbxCurso.setModel(modeloCursos);
        cbxCurso.setSelectedIndex(-1);
    }
    
    private boolean validation(){
        if (txtNombreAlumno.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "El campo Nombre está vacío");
            txtNombreAlumno.requestFocus();
            return false;
        }
        
        if (txtCuotasPagas.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "El Cuotas pagas está vacío");
            txtNombreAlumno.requestFocus();
            return false;
        }
        
        if (txtNota.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "El Nota está vacío");
            txtNombreAlumno.requestFocus();
            return false;
        }
        
        
        if(cbxCurso.getSelectedIndex() < 0){
            JOptionPane.showMessageDialog(null, "Seleccione un curso");
            cbxCurso.requestFocus();
            return false;
        }
        
        String cuotas = txtCuotasPagas.getText();
        String nota = txtNota.getText();
        try {
            int cuotasPagas = Integer.parseInt(cuotas);
            int notaAlumno = Integer.parseInt(nota);
            
            if(cuotasPagas <= 0){
                JOptionPane.showMessageDialog(null, "La Cantidad de cuotas debe ser mayor o igual a 0");
                txtCuotasPagas.requestFocus();
                return false;
            }
            
            if(notaAlumno <= 0){
                JOptionPane.showMessageDialog(null, "La Nota debe ser mayor o igual a 0");
                txtNota.requestFocus();
                return false;
            }
        }
        catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "El campo Cuotas Pagas debe ser un número");
            txtCuotasPagas.requestFocus();
        }
        return true;
    }
    
    private void cleanForm(){
        txtNombreAlumno.setText("");
        txtCuotasPagas.setText("");
        txtNota.setText("");
        cbxCurso.setSelectedIndex(-1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxCurso = new javax.swing.JComboBox<>();
        txtNota = new javax.swing.JTextField();
        txtCuotasPagas = new javax.swing.JTextField();
        txtNombreAlumno = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre Alumno:");

        jLabel2.setText("Cuotas Pagas:");

        jLabel3.setText("Nota:");

        jLabel4.setText("Curso:");

        txtCuotasPagas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCuotasPagasActionPerformed(evt);
            }
        });

        txtNombreAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreAlumnoActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnReportes.setText("Reportes");
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNota))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCuotasPagas))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreAlumno))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCuotasPagas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReportes)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(validation()){
            String nombreAlumno = txtNombreAlumno.getText();
            int cuotasPagas = Integer.parseInt(txtCuotasPagas.getText());
            int nota = Integer.parseInt(txtNota.getText());
            Curso curso = (Curso)cbxCurso.getSelectedItem();

            Alumno a = new Alumno();
            a.setNombre(nombreAlumno);
            a.setCuotasPagas(cuotasPagas);
            a.setNota(nota);
            a.setCurso(curso);

            gestor.addAlumno(a);
            cleanForm();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtNombreAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreAlumnoActionPerformed

    private void txtCuotasPagasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCuotasPagasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCuotasPagasActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        Reportes repo = new Reportes();
        
        repo.setTitle("Reportes");
        repo.setVisible(true);
    }//GEN-LAST:event_btnReportesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AltaAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltaAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltaAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltaAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltaAlumno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnReportes;
    private javax.swing.JComboBox<String> cbxCurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtCuotasPagas;
    private javax.swing.JTextField txtNombreAlumno;
    private javax.swing.JTextField txtNota;
    // End of variables declaration//GEN-END:variables
}
