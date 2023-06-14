
package view;

import com.formdev.flatlaf.intellijthemes.FlatGrayIJTheme;
import controller.TablaAnalisisController;
import entity.TablaAnalisis;
import java.awt.Frame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.ModeloTabla;

public class FrmTablaAnalisis extends javax.swing.JDialog {
    private TablaAnalisisController controlador = new TablaAnalisisController();
    private FrmAnalizadorSintactico ventAnalisis;
    private DefaultTableModel modeloT;
    private TablaAnalisis tabla;
    private boolean estado = false;

    public FrmTablaAnalisis(FrmAnalizadorSintactico ventAnalisis, Frame owner, boolean modal) {
        super(owner, modal);
        initComponents();
        this.ventAnalisis = ventAnalisis;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAceptar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAnalisis = new org.jdesktop.swingx.JXTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Tabla de análisis");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

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
        /**
         * Llenamos el objeto tabla de análisis con los datos del JTable.
         */
        if(validCampos()){
            controlador.setReglasATablas(tabla, modeloT);
            ventAnalisis.iniciarAnalisis();  
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, 
                    "Completa la tabla.", "Advertencia", 
                    JOptionPane.WARNING_MESSAGE);
        }
             
    }//GEN-LAST:event_btnAceptarActionPerformed
    
    /**
     * Crea las filas y columas para la tabla de analisis y recupera su modelo
     * para poder manipular sus datos.
     * @param tabla 
     * Es el objeto que almacena la tabla de análisis que usara el analisador.
     */
    public void setTabla(TablaAnalisis tabla){
        this.tabla = tabla;
        tblAnalisis.setModel(new ModeloTabla(0,
                tabla.getSizeTerminales()+1));
        modeloT = (DefaultTableModel) tblAnalisis.getModel();
        hacerTabla();
    }
    
    /**
     * Establece el nombre las filas y columnas, terminales y no terminales.
     */
    private void hacerTabla(){
        int i = 0,j=0;
        Object fila[];
        modeloT.setRowCount(0);
        
        for (i=0;i<=tabla.getSizeNoTerminales();i++) {
            j = 0;            
            fila = new Object[tabla.getSizeTerminales()+1];
            if(i == 0){
                fila[0] = "/";//new JLabel("/"); 
                for (String terminal : tabla.getTerminales()) {
                    if(!terminal.equals("ε")){
                        fila[j+1] = terminal; //new JLabel(terminal);
                        j++;
                    }
                }               
            }else{
                fila[0] = tabla.getNoTerminales().get(i-1); //new JLabel(noTerminal);
                
                for (j=0;j<tabla.getSizeTerminales();j++) {
                    fila[j+1] = "";
                }
            }
            
            modeloT.addRow(fila);
        }
    }
    
    /**
     * Valida que la tabla tenga almenos una regla.
     * @return
     * Si la tabla esta vacia regres falso, pero si al menos tiene un elemento,
     * retorna verdadero.  
     */
    private boolean validCampos(){
        int count = 0;
        int filas =modeloT.getRowCount();
        int columnas =modeloT.getColumnCount();
        for(int i = 1; i<filas;i++){
            for(int j = 1;j<columnas;j++){
                if(modeloT.getValueAt(i, j).equals("")){
                    count++;
                }
            }
        }
        
        return count != ((filas-1)*(columnas-1));
    }

    public static void main(String args[]) {
        try {
//            UIManager.setLookAndFeel(new FlatMacLightLaf());
            FlatGrayIJTheme.setup();
            FrmTablaAnalisis.setDefaultLookAndFeelDecorated( true );
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXTable tblAnalisis;
    // End of variables declaration//GEN-END:variables
}
