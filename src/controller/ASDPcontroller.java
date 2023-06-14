/*****************************************************
 * Autor: Cristopher Alexis Zarate Valencia          *
 * Fecha de creación: 7 jun 2023                     *
 * Fecha de actualización: 7 jun 2023                *
 * Descripción: Clase para controlar el comportamiento
 * del ASDP.
 *****************************************************/

package controller;

import entity.ASDP;
import entity.Regla;
import entity.TablaAnalisis;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ASDPcontroller {
    private ASDP analisis;
    /**
     * Almacena las reglas que el usuario ingreso en una lista.
     * @param modelo
     * El modelo de la tabla que tiene las reglas, en crudo.
     * @param reglas 
     * La lista donde se almacenarán las reglas ya procesadas.
     */
    public void guardarReglas(DefaultTableModel modelo, List<Regla> reglas){
        int contFila = modelo.getRowCount();
        
        for (int i = 0; i<contFila;i++) {
            try {
                if(modelo.getValueAt(i, 0) != null){
                    Regla regla = new Regla(modelo.getValueAt(i, 
                            0).toString());
                    reglas.add(regla);
                    System.out.println(regla.toString());
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, 
                            "Error: " + e.getMessage());
            }            
        }
    }
    
    /**
     * Comienza el análisis sintactico a partir de algunos parametros:
     * @param tabla
     * Es el objeto Tabla de análisis en donde tendremos almacenada la tabla de 
     * análisis.
     * @param reglas
     * Es la lista de reglas ya procesadas.
     * @param lexico 
     * Es el conjunto de letras que vá a analisar o el archivo de donde sacara
     * el análisis.
     */
    public void crearAnalisis(TablaAnalisis tabla,List<Regla> reglas,String lexico){
        analisis = new ASDP(lexico);
        analisis.setReglas(reglas);
                
        analisis.setTablaAnalisis(tabla); 
               
        analisis.analizar();
    }
    
    public String cargarArchivo(String ruta){
        File archivo = new File(ruta);
        FileReader rd = null;
        int charFile;
        String caracteres = "";

        try {
            rd = new FileReader(archivo);
            System.out.println("Archivo abierto.");

            while ((charFile = rd.read()) != -1) {
                caracteres += charFile;
            }

            caracteres +='$';

            rd.close();
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        
        return caracteres;
    }
    
    public String getResultados(){
        return analisis.getResultado();
    }
}
