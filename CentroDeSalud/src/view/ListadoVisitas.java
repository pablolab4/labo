/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GestorDB;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.DTO.VisitaDTO;

/**
 *
 * @author Pablo
 */
public class ListadoVisitas extends javax.swing.JFrame {

    GestorDB gestorDB = new GestorDB();
    public ListadoVisitas() {
        initComponents();
        cargarListadoVisitas();
        
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblVisitas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblVisitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Paciente", "Visitante", "Recepcionista", "Duracion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblVisitas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListadoVisitas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVisitas;
    // End of variables declaration//GEN-END:variables
private void cargarListadoVisitas(){
        ArrayList<VisitaDTO> listaVisitaDTO = gestorDB.getAllVisitas();
        DefaultTableModel modeloTabla = new DefaultTableModel();
        Object[] columnasListado = new Object[]{"Paciente","Visita","Recepcionista","Duracion"};
        modeloTabla.setColumnIdentifiers(columnasListado);
        for (VisitaDTO v : listaVisitaDTO){
            modeloTabla.addRow(new Object[]{
                v.getNombrePaciente(),v.getNombreVisita(),v.getNombreRecepcionista(),v.getDuracionVisita()
            });
        }
        tblVisitas.setModel(modeloTabla);
    }

}
