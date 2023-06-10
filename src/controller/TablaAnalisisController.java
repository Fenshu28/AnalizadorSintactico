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
    public void setReglasATablas(TablaAnalisis tabla, 
            DefaultTableModel modeloTabla){
        int valor;
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            for (int j = 0; j < modeloTabla.getColumnCount(); j++) {
                valor = (int) modeloTabla.getValueAt(j, j);
                if(valor > 0){
                    tabla.setValorAt(i, j,
                            (int) modeloTabla.getValueAt(j, j));
                }
            }
        }
    }
}
