/*****************************************************
 * Autor: Cristopher Alexis Zarate Valencia          *
 * Fecha de creación: 9 jun 2023                        *
 * Fecha de actualización: 9 jun 2023                   *
 * Descripción: Clase para 
 *****************************************************/

package util;

import javax.swing.table.DefaultTableModel;


public class ModeloTabla extends DefaultTableModel {

    public ModeloTabla() {
    }

    public ModeloTabla(int rowCount, int columnCount) {
        super(rowCount, columnCount);
    }
    
    public boolean isCellEditable(int fila, int columna){
        if(columna == 0 || fila == 0)
            return false;
        return true;
    }
}
