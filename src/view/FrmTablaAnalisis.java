
package view;

import com.formdev.flatlaf.intellijthemes.FlatGrayIJTheme;
import controller.TablaAnalisisController;
import entity.TablaAnalisis;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import util.ModeloTabla;

public class FrmTablaAnalisis extends javax.swing.JFrame {
    TablaAnalisisController controlador = new TablaAnalisisController();
    DefaultTableModel modeloT;
    TablaAnalisis tabla;
        
    public FrmTablaAnalisis() {
        initComponents();
        tblAnalisis.putClientProperty( 	"JXTable.showHorizontalLines", true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAceptar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAnalisis = new org.jdesktop.swingx.JXTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tabla de análisis");
        setResizable(false);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        tblAnalisis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblAnalisis.setShowGrid(false);
        tblAnalisis.setTableHeader(null);
        jScrollPane2.setViewportView(tblAnalisis);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(0, 498, Short.MAX_VALUE)
                        .addComponent(btnAceptar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAceptar)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        controlador.setReglasATablas(tabla, modeloT);
    }//GEN-LAST:event_btnAceptarActionPerformed
    
    public void setTabla(TablaAnalisis tabla){
        this.tabla = tabla;
        tblAnalisis.setModel(new ModeloTabla(0,
                tabla.getSizeTerminales()));
        modeloT = (DefaultTableModel) tblAnalisis.getModel();
        hacerTabla(tabla);
    }
    
    private void hacerTabla(TablaAnalisis tabla){
        int i = 0,j=0;
        Object fila[];
        modeloT.setRowCount(0);
        
        for (String noTerminal : tabla.getNoTerminales()) {
            j = 0;
            fila = new Object[tabla.getSizeTerminales()+1];
            if(i == 0){
                fila[0] = "/";//new JLabel("/"); 
                for (String terminal : tabla.getTerminales()) {
                    fila[j+1] = terminal; //new JLabel(terminal);
                    j++;
                }               
            }else{
                fila[0] = noTerminal; //new JLabel(noTerminal);
                
                for (String terminal : tabla.getTerminales()) {
                    fila[j+1] = "";
                    j++;
                }
            }
            
            modeloT.addRow(fila);;
            i++;
        }
    }
    
    public static void main(String args[]) {
        try {
//            UIManager.setLookAndFeel(new FlatMacLightLaf());
            FlatGrayIJTheme.setup();
            FrmTablaAnalisis.setDefaultLookAndFeelDecorated( true );
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTablaAnalisis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXTable tblAnalisis;
    // End of variables declaration//GEN-END:variables
}
