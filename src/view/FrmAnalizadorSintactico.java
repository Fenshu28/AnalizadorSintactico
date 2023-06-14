package view;

import com.formdev.flatlaf.intellijthemes.FlatGrayIJTheme;
import controller.ASDPcontroller;
import entity.Regla;
import entity.TablaAnalisis;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmAnalizadorSintactico extends javax.swing.JFrame {

    private final ASDPcontroller controlador;
    private final DefaultTableModel modelo;
    private List<Regla> reglas;
    private TablaAnalisis tabla;
    private String expresion;
    private boolean isPrimero = true;
    private JButton btnArchivos;

    public FrmAnalizadorSintactico() {
        this.controlador = new ASDPcontroller();
        this.expresion = "";
        initComponents();
        btnArchivos = hacerBoton();
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
        txtResultado = new javax.swing.JEditorPane();
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

        txtResultado.setEditable(false);
        txtResultado.setBackground(new java.awt.Color(255, 255, 255));
        txtResultado.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(txtResultado);

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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        if (!txtEntrada.getText().equals("")) {
            expresion = getRecurso();
            reglas = new ArrayList<>();
            controlador.guardarReglas(modelo, reglas);

            /**
             * Inicicia el análisis con el texto que se introdujo en el
             * txtEntrada
             */
            txtResultado.setText("Iniciando el análisis\n");
            if (isPrimero) {
                tabla = new TablaAnalisis(reglas);

                FrmTablaAnalisis tablaAnalisisFrm = new FrmTablaAnalisis(
                        FrmAnalizadorSintactico.this, this,
                        true);
                tablaAnalisisFrm.setTabla(tabla);
                tablaAnalisisFrm.setVisible(true);
                isPrimero = false;
            } else {
                controlador.crearAnalisis(tabla, reglas, expresion);
            }
            
            txtResultado.setText(controlador.getResultados());
//            txtResultado.setText( "La cadena:\n" + expresion + "\n es aceptada."
//                + "\n------------------------------");
        } else {
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
        if (btnModo.isSelected()) {
            btnModo.setText("Archivo");
            txtEntrada.putClientProperty("JTextField.trailingComponent",
                    btnArchivos);
            txtEntrada.setEditable(false);
        } else {
            btnModo.setText("Texto");
            txtEntrada.putClientProperty("JTextField.trailingComponent",
                    null);
            txtEntrada.setEditable(true);
        }
    }//GEN-LAST:event_btnModoActionPerformed

    public static void main(String args[]) {
        try {
//            UIManager.setLookAndFeel(new FlatMacLightLaf());
            FlatGrayIJTheme.setup();
            FrmAnalizadorSintactico.setDefaultLookAndFeelDecorated(
                    true);
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

    /**
     * Inicia el analicis sintactico, este método permite llamar el análisis
     * desde otros formularios.
     */
    public void iniciarAnalisis() {
        controlador.crearAnalisis(tabla, reglas, expresion);
    }

    /**
     * Obtiene el nombre del componente.
     *
     * @param txt El texto del componente.
     */
    private void setVal(JButton txt) {
        expresion = txtRegla.getText();
        expresion += txt.getText();

        txtRegla.setText(expresion);
    }

    /**
     * Obtiene la caedena que va a análizar segun el modo.
     *
     * @return La cadena a análizar.
     */
    private String getRecurso() {
        if (btnModo.isSelected()) {
            return controlador.cargarArchivo(txtEntrada.getText());
        } else {
            return txtEntrada.getText();
        }
    }
    
    /**
     * Construye el botón para elegir el archivo.
     * @return 
     * El botón ya construido, con su evento de hacer click.
     */
    private JButton hacerBoton() {
        JButton temp = new JButton("...");

        temp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int seleccion = fileChooser.showOpenDialog(FrmAnalizadorSintactico.this);
                if (seleccion == JFileChooser.APPROVE_OPTION) {
                    txtEntrada.setText(fileChooser.getSelectedFile().getAbsolutePath());
                }
            }
        });

        return temp;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAlfa;
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btnEpsilon;
    private javax.swing.JButton btnFinCadena;
    private javax.swing.JToggleButton btnModo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlSimbolos;
    private javax.swing.JTable tblReglas;
    private javax.swing.JTextField txtEntrada;
    private javax.swing.JTextField txtRegla;
    private javax.swing.JEditorPane txtResultado;
    // End of variables declaration//GEN-END:variables
}
