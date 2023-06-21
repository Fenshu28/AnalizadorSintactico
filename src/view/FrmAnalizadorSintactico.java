package view;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;
import controller.ASDPcontroller;
import controller.TablaAnalisisController;
import entity.Regla;
import entity.TablaAnalisis;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
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
    private final JButton btnArchivos;
//    private String regex = "";
//    private List<Token> listToken;

    public FrmAnalizadorSintactico() {
        this.controlador = new ASDPcontroller();
        this.expresion = "";
        this.reglas = new ArrayList<>();

        initComponents();
        btnArchivos = hacerBoton();
        modelo = (DefaultTableModel) tblReglas.getModel();
        ImageIcon icono = new ImageIcon("src/images/logo_30.png");

        // Establecer el icono de la ventana
        setIconImage(icono.getImage());

        FrmTablaAnalisis.setDefaultLookAndFeelDecorated(true);
        FrmExpresiones.setDefaultLookAndFeelDecorated(true);
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
        flatMenuBar1 = new com.formdev.flatlaf.extras.components.FlatMenuBar();
        btnInicio = new javax.swing.JMenu();
        opcAcercade = new com.formdev.flatlaf.extras.components.FlatMenuItem();
        btnOpc = new javax.swing.JMenu();
        opcExpReg = new com.formdev.flatlaf.extras.components.FlatMenuItem();
        opcTabAnalisis = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ASDP");
        setResizable(false);

        jLabel1.setText("Ingresa las reglas:");

        tblReglas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        tblReglas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblReglasKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblReglas);

        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("Agrega regla a la lista.");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel2.setText("Ingresa la cadena:");

        btnAnalizar.setText("Analizar");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        txtRegla.setToolTipText("Escribe tu regral, para indicar la producción puedes utilizar: \"->\" o \"::=\".");

        pnlSimbolos.setBorder(javax.swing.BorderFactory.createTitledBorder("Símbolos"));
        pnlSimbolos.setToolTipText("Elige simbolos de dificíl acceso.");
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
        txtResultado.setContentType("html");
        txtResultado.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(txtResultado);

        jLabel3.setText("Modo");

        btnModo.setText("Texto");
        btnModo.setToolTipText("Cambia el modo de entrada (texto plano o archivo).");
        btnModo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModoActionPerformed(evt);
            }
        });

        btnInicio.setText("Inicio");

        opcAcercade.setText("Acerca de");
        opcAcercade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcAcercadeActionPerformed(evt);
            }
        });
        btnInicio.add(opcAcercade);

        flatMenuBar1.add(btnInicio);

        btnOpc.setText("Opciones");

        opcExpReg.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        opcExpReg.setText("Expresión regular");
        opcExpReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcExpRegActionPerformed(evt);
            }
        });
        btnOpc.add(opcExpReg);

        opcTabAnalisis.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        opcTabAnalisis.setText("Tabla de análisis");
        opcTabAnalisis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcTabAnalisisActionPerformed(evt);
            }
        });
        btnOpc.add(opcTabAnalisis);

        flatMenuBar1.add(btnOpc);

        setJMenuBar(flatMenuBar1);

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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModo))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public TablaAnalisis getTabla() {
        return tabla;
    }

    public void setTabla(TablaAnalisis tabla) {
        this.tabla = tabla;
    }

    public ASDPcontroller getControlador() {
        return controlador;
    }

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        if (!txtEntrada.getText().equals("") && !controlador.getListToken().isEmpty()) {
            expresion = getRecurso();

            if (iniciarParametros()) {
                /**
                 * Inicicia el análisis con el texto que se introdujo en el
                 * txtEntrada
                 */
                txtResultado.setText("Iniciando el análisis...\n");
                controlador.crearAnalisis(tabla, reglas, expresion);

                txtResultado.setText(controlador.getResultados());
            } else {
                JOptionPane.showMessageDialog(this,
                        "Escribe las reglas o verifica que los datos esten"
                        + " correctos.", "Error al establecer expresiones.",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Ingrea un texo para análizar y su expresión regular"
                    + " en Editar->Expresión regular (ctrl+E).",
                    "Advertencia",
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

    private void opcAcercadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcAcercadeActionPerformed
        
    }//GEN-LAST:event_opcAcercadeActionPerformed

    private void opcExpRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcExpRegActionPerformed
        if (iniciarParametros() && !isPrimero) {
            FrmExpresiones frmExp = new FrmExpresiones(
                    FrmAnalizadorSintactico.this, this, true);
            frmExp.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Escribe las reglas o verifica que los datos esten"
                    + " correctos.", "Error al establecer expresiones.",
                    JOptionPane.ERROR_MESSAGE);
            
            // Abre la tabla de análisis.
            FrmTablaAnalisis tablaAnalisisFrm = new FrmTablaAnalisis(this,
                    true);
            tablaAnalisisFrm.setTabla(tabla);
            tablaAnalisisFrm.setVisible(true);
            isPrimero = false;
        }
    }//GEN-LAST:event_opcExpRegActionPerformed

    private void tblReglasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblReglasKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            modelo.removeRow(tblReglas.getSelectedRow());
        }
    }//GEN-LAST:event_tblReglasKeyPressed

    private void opcTabAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcTabAnalisisActionPerformed
        if (iniciarParametros()) {
            FrmTablaAnalisis tablaAnalisisFrm = new FrmTablaAnalisis(this,
                    true);
            tablaAnalisisFrm.setTabla(tabla);
            tablaAnalisisFrm.setVisible(true);
            
            isPrimero = false;
        }else{
            JOptionPane.showMessageDialog(this,
                    "Escribe las reglas o verifica que los datos esten"
                    + " correctos.", "Error al establecer expresiones.",
                    JOptionPane.ERROR_MESSAGE);
            opcExpRegActionPerformed(evt);
        }
    }//GEN-LAST:event_opcTabAnalisisActionPerformed

    public static void main(String args[]) {
        try {
//            UIManager.setLookAndFeel(new FlatMacLightLaf());
            FlatAtomOneDarkIJTheme.setup();
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
     * Inicializa las reglas y la tabla de análisis.
     *
     * @return {@code true} - si no hubo errores al crearlos.<br> {@code false}
     * - si hubo algún error al crearlos.
     */
    public boolean iniciarParametros() {
        if (modelo.getRowCount() > reglas.size()) {
            try {
                reglas = new ArrayList<>();
                controlador.guardarReglas(modelo, reglas);
                tabla = new TablaAnalisis(reglas);

                return true;
            } catch (Exception e) {
                return false;
            }
        }else if(tabla != null){
            return true;
        }else {
            return false;
        }
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
     *
     * @return El botón ya construido, con su evento de hacer click.
     */
    private JButton hacerBoton() {
        JButton temp = new JButton("...");

        temp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser("src/archivos");
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
    private javax.swing.JMenu btnInicio;
    private javax.swing.JToggleButton btnModo;
    private javax.swing.JMenu btnOpc;
    private com.formdev.flatlaf.extras.components.FlatMenuBar flatMenuBar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.formdev.flatlaf.extras.components.FlatMenuItem opcAcercade;
    private com.formdev.flatlaf.extras.components.FlatMenuItem opcExpReg;
    private javax.swing.JMenuItem opcTabAnalisis;
    private javax.swing.JPanel pnlSimbolos;
    private javax.swing.JTable tblReglas;
    private javax.swing.JTextField txtEntrada;
    private javax.swing.JTextField txtRegla;
    private javax.swing.JEditorPane txtResultado;
    // End of variables declaration//GEN-END:variables
}
