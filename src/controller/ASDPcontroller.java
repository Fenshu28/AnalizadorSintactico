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
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ASDPcontroller {
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
    
    public void crearAnalisis(TablaAnalisis tabla,List<Regla> reglas){
        ASDP analisis = new ASDP();
        analisis.setReglas(reglas);
        analisis.setTablaAnalisis(tabla);
        
    }
    
    public void crearAnalisis(TablaAnalisis tabla,List<Regla> reglas,String lexico){
        ASDP analisis = new ASDP(lexico);
        analisis.setReglas(reglas);
        analisis.setTablaAnalisis(tabla);
        
    }
}
