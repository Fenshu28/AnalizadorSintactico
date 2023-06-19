/** ***************************************************
 * Autor: Cristopher Alexis Zarate Valencia           *
 * Fecha de creación: 14 jun 2023                     *
 * Fecha de actualización: 14 jun 2023                *
 * Descripción: Frame para las capturar las expresiones
 * regulares.
 **************************************************** */

package view;

import entity.Token;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmExpresiones extends javax.swing.JDialog {
    private final DefaultTableModel modelo;
    private final FrmAnalizadorSintactico frmAnalisador;
    
    public FrmExpresiones(FrmAnalizadorSintactico frmAnalisador,
            java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        modelo = (DefaultTableModel) tblExpresiones.getModel();
        this.frmAnalisador = frmAnalisador;
        establecerTabla();
        if(!this.frmAnalisador.getControlador().getListToken().isEmpty()){
            llenarTabla();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAceptar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblExpresiones = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tokens");

        btnAceptar.setText("Aceptar");
        btnAceptar.setToolTipText("");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jLabel1.setText("Ingresa el token y las expresiones regulares de cada terminal:");

        tblExpresiones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Terminal", "Token", "Expresión regular"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblExpresiones.getTableHeader().setReorderingAllowed(false);
        tblExpresiones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblExpresionesKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblExpresiones);
        if (tblExpresiones.getColumnModel().getColumnCount() > 0) {
            tblExpresiones.getColumnModel().getColumn(0).setResizable(false);
            tblExpresiones.getColumnModel().getColumn(0).setPreferredWidth(15);
            tblExpresiones.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAceptar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAceptar)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        makeTokens();
        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void tblExpresionesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblExpresionesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            modelo.removeRow(tblExpresiones.getSelectedRow());
        }
    }//GEN-LAST:event_tblExpresionesKeyPressed
    /**
     * Crea las filas dependiendo de los terminales que existan.
     */
    private void establecerTabla(){
        Object[] fila = new Object[3];
        for (String terminal : frmAnalisador.getTabla().getTerminales()) {
            if(!terminal.equals("$")){
                fila[0] = terminal;
                modelo.addRow(fila);
            }            
        }
    }
    
    /**
     * Obtiene los tokens y su patron para almacenarlos en una lista de tokens.
     */
    private void makeTokens(){
        frmAnalisador.getControlador().setListToken(new ArrayList<>());
        
        String nombre="",regex="";
        if(isCompletos()){
            for (int i = 0; i < modelo.getRowCount();i++) {
                for(int j = 1; j < modelo.getColumnCount(); j++){
                    if(j==1)
                        nombre = String.valueOf(modelo.getValueAt(i, 
                                j));
                    else
                        regex = String.valueOf(modelo.getValueAt(i, 
                                j));
                }
                frmAnalisador.getControlador().getListToken().add(
                        new Token(nombre, regex));
            }
            
            frmAnalisador.getControlador().getListToken().add(
                    new Token("$","\\$"));
        }else{
            JOptionPane.showMessageDialog(this, 
                    "Asigna todos los tokens y sus expresiones.",
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Verifica que todos los recuadros de la tabla esten completos.
     * @return 
     * {@code true} - Si todos los campos estan rellenados. <br>
     * {@code false} - Si algun campo esta vacío.
     */
    private boolean isCompletos(){
        for(int i = 0; i < modelo.getRowCount(); i++){
            for(int j=1; j< modelo.getColumnCount(); j++){
                if(modelo.getValueAt(j, j) == null){
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Si ya fue llenada la tabla antes la carga.
     */
    private void llenarTabla(){
        for(int i = 0; i < modelo.getRowCount(); i++){
            for(int j=1; j< modelo.getColumnCount(); j++){
                if(j==1)
                    modelo.setValueAt(
                            frmAnalisador.getControlador().getListToken().
                                    get(i).getNombre(),i, 1);
                else
                    modelo.setValueAt(
                            frmAnalisador.getControlador().getListToken().
                                    get(i).getRegex(),i, 2);
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblExpresiones;
    // End of variables declaration//GEN-END:variables
}
