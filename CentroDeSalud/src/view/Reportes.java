package view;

import controller.GestorDB;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.DTO.VisitaDTO;


public class Reportes extends javax.swing.JFrame {
    String promedio;
    GestorDB gestorDB = new GestorDB();
    
    public Reportes() {
        initComponents();
    }
    
    public Reportes(String promedio){
        initComponents();
        this.promedio = promedio;
        cargarListadoCantidadVisitas();
        lblPromedio.setText(promedio);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCantidadVisitas = new javax.swing.JTable();
        lblPromedio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblCantidadVisitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Paciente", "Cantidad Visitas"
            }
        ));
        jScrollPane1.setViewportView(tblCantidadVisitas);

        lblPromedio.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        lblPromedio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPromedio, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(lblPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPromedio;
    private javax.swing.JTable tblCantidadVisitas;
    // End of variables declaration//GEN-END:variables

    private void cargarListadoCantidadVisitas(){
        ArrayList<VisitaDTO> listaVisitaDTO = gestorDB.getCantidadVisitasPaciente();
        DefaultTableModel modeloTabla = new DefaultTableModel();
        Object[] columnasListado = new Object[]{"Paciente","Cantidad Visitas"};
        modeloTabla.setColumnIdentifiers(columnasListado);
        for (VisitaDTO v : listaVisitaDTO){
            modeloTabla.addRow(new Object[]{
                v.getNombrePaciente(),v.getCantidadVisitas()
            });
        }
        tblCantidadVisitas.setModel(modeloTabla);
    }

}
