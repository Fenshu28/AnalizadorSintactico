/*****************************************************
 * Autor: Cristopher Alexis Zarate Valencia          *
 * Fecha de creación: 10 jun 2023                        *
 * Fecha de actualización: 10 jun 2023                   *
 * Descripción: Clase para controlar el módulo de la 
 * tabla de análisis.
 *****************************************************/

package controller;

import entity.TablaAnalisis;
import javax.swing.table.DefaultTableModel;

public class TablaAnalisisController {
    public static boolean activo;
    /**
     * Rellena la tabla con los valores ingresados en la tabla de la ventana
     * @param tabla
     * Es el objeto Tabla de análisis donde tendremos alamcenada la tabla de 
     * análisis.
     * @param modeloTabla 
     * Es el modelo de la tabla que tiene el análisis.
     */
    public void setReglasATablas(TablaAnalisis tabla, 
            DefaultTableModel modeloTabla){
        int valor;
        for (int i = 1; i < modeloTabla.getRowCount(); i++) {
            for (int j = 1; j < modeloTabla.getColumnCount(); j++) {
                if(!String.valueOf(modeloTabla.getValueAt(i, j)).equals("")){
                    valor = Integer.parseInt(modeloTabla.getValueAt(i, j).toString());
                    tabla.setValorAt(i-1, j-1,valor);
                }else{
                    tabla.setValorAt(i-1, j-1,-1);
                }
            }
        }
    }
}
