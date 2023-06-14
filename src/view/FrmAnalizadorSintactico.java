package view;

import com.formdev.flatlaf.intellijthemes.FlatGrayIJTheme;
import controller.ASDPcontroller;
import entity.Regla;
import entity.TablaAnalisis;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmAnalizadorSintactico extends javax.swing.JFrame {
    private final ASDPcontroller controlador = new ASDPcontroller();
    private final DefaultTableModel modelo;
    private List<Regla> reglas;
    private TablaAnalisis tabla;
    private String expresion;

    public FrmAnalizadorSintactico() {
        this.expresion = "";
        initComponents();
        modelo = (DefaultTableModel) tblReglas.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReglas = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtEntrada = new javax.swing.JTextField();
        btnAnalizar = new javax.swing.JButton();
        txtRegla = new javax.swing.JTextField();
        pnlSimbolos = new javax.swing.JPanel();
        btnFinCadena = new javax.swing.JButton();
        btnEpsilon = new javax.swing.JButton();
        btnAlfa = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jLabel3 = new javax.swing.JLabel();
        btnModo = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analizador sintáctico desendente predictivo");
        setResizable(false);

        jLabel1.setText("Ingresa las reglas:");

        tblReglas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"S ::=  A B"},
                {"A ::=  a"},
                {"A ::=  ε"},
                {"B ::=  b C d"},
                {"C ::=  c"},
                {"C ::= ε"}
            },
            new String [] {
                "Regla"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblReglas);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel2.setText("Ingresa la cadena:");

        txtEntrada.setText("abcd");

        btnAnalizar.setText("Analizar");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        pnlSimbolos.setBorder(javax.swing.BorderFactory.createTitledBorder("Símbolos"));
        pnlSimbolos.setName(""); // NOI18N

        btnFinCadena.setText("$");
        btnFinCadena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinCadenaActionPerformed(evt);
            }
        });
        pnlSimbolos.add(btnFinCadena);

        btnEpsilon.setText("ε");
        btnEpsilon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEpsilonActionPerformed(evt);
            }
        });
        pnlSimbolos.add(btnEpsilon);

        btnAlfa.setText("α");
        btnAlfa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlfaActionPerformed(evt);
            }
        });
        pnlSimbolos.add(btnAlfa);

        jScrollPane2.setViewportView(jEditorPane1);

        jLabel3.setText("Modo");

        btnModo.setText("Texto");
        btnModo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                    .addComponent(pnlSimbolos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtRegla)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtEntrada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnalizar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModo)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(txtRegla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSimbolos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnModo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnalizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        if(!txtEntrada.getText().equals("")){
            expresion = txtEntrada.getText();
            reglas = new ArrayList<>();
            controlador.guardarReglas(modelo, reglas);
            tabla = new TablaAnalisis(reglas);            

            /**
             * Inicicia el análisis con el texto que se introdujo en el txtEntrada
             */
            FrmTablaAnalisis tablaAnalisisFrm = new FrmTablaAnalisis(
                    FrmAnalizadorSintactico.this,this, true);
            tablaAnalisisFrm.setTabla(tabla);
            tablaAnalisisFrm.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this,
                    "Ingrea un texo para análisar.", "Advertencia", 
                    JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_btnAnalizarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Object fila[] = new Object[1];
        fila[0] = txtRegla.getText();
        modelo.addRow(fila);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnFinCadenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinCadenaActionPerformed
        setVal((JButton) evt.getSource());
    }//GEN-LAST:event_btnFinCadenaActionPerformed

    private void btnEpsilonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEpsilonActionPerformed
        setVal((JButton) evt.getSource());
    }//GEN-LAST:event_btnEpsilonActionPerformed

    private void btnAlfaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlfaActionPerformed
        setVal((JButton) evt.getSource());
    }//GEN-LAST:event_btnAlfaActionPerformed

    private void btnModoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModoActionPerformed
        if(btnModo.isSelected()){
            btnModo.setText("Archivo");
            txtEntrada.putClientProperty("JTextField.trailingComponent",
                    new JButton("..."));
        }else{
            btnModo.setText("Texto");
            txtEntrada.putClientProperty("JTextField.trailingComponent", 
                    null);
        }
    }//GEN-LAST:event_btnModoActionPerformed

    public static void main(String args[]) {
        try {
//            UIManager.setLookAndFeel(new FlatMacLightLaf());
            FlatGrayIJTheme.setup();
            FrmAnalizadorSintactico.setDefaultLookAndFeelDecorated( 
                    true );
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmAnalizadorSintactico().setVisible(true);
            }
        });
    }

    public void iniciarAnalisis(){
        controlador.crearAnalisis(tabla, reglas, expresion);
    }
    
    private void setVal(JButton txt) {
        expresion = txtRegla.getText();
        expresion += txt.getText();

        txtRegla.setText(expresion);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAlfa;
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btnEpsilon;
    private javax.swing.JButton btnFinCadena;
    private javax.swing.JToggleButton btnModo;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlSimbolos;
    private javax.swing.JTable tblReglas;
    private javax.swing.JTextField txtEntrada;
    private javax.swing.JTextField txtRegla;
    // End of variables declaration//GEN-END:variables
}
