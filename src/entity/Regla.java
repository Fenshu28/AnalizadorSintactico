/*****************************************************
 * Autor: Cristopher Alexis Zarate Valencia          *
 * Fecha de creación: 1 jun 2023                     *
 * Fecha de actualización: 1 jun 2023                *
 * Descripción: Clase para las reglas de la gramatica.
 *****************************************************/

package entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Regla {
    String noTerminal;
    String produccion;
    
    public Regla(String regla){
        splitRegla(regla);
    }

    public void setRegla(String regla){
        splitRegla(regla);
    }
    
    public String getRelga(){
        return noTerminal + "->" + produccion;
    }

    public String getNoTerminal() {
        return noTerminal;
    }

    public void setNoTerminal(String noTerminal) {
        this.noTerminal = noTerminal;
    }

    public String getProduccion() {
        return produccion;
    }

    public void setProduccion(String produccion) {
        this.produccion = produccion;
    }
    
    private void splitRegla(String regla){
        String regex = "[a-zA-Z]+|[αε$]";
        String encontrado = "";
        Pattern patron = Pattern.compile(regex);
        Matcher coincidencia = patron.matcher(regla);
        
        try {
            coincidencia.find();
            setNoTerminal(coincidencia.group());
            
//            System.out.println(getNoTerminal());
            
            while(coincidencia.find()){
                encontrado += coincidencia.group() + " ";
            }           
            
            setProduccion(encontrado);        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        
    }

    @Override
    public String toString() {
        return getNoTerminal() + "::=" + getProduccion();
    }
    
    
}
