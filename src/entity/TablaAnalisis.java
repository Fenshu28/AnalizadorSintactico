/** ***************************************************
 * Autor: Cristopher Alexis Zarate Valencia          *
 * Fecha de creación: 31 may 2023                     *
 * Fecha de actualización: 31 may 2023                *
 * Descripción: Clase para la tabla de análisis 
 *      sintactico.
 **************************************************** */

package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TablaAnalisis {
    private List<Regla> reglas;
    private List<String> terminales; 
        
    public TablaAnalisis(List<Regla> reglas){
        this.reglas = reglas;
    }

    public void setReglas(List<Regla> reglas) {
        this.reglas = reglas;
    }
    
    public void splitTerminales(){
        boolean existe = false;
        terminales = new ArrayList<>();
        String regex = "[a-zA-Z]+|[αε$]";
        String encontrado = "";
        Pattern patron = Pattern.compile(regex);
        
        
        for (Regla regla : reglas) {
            Matcher coincidencia = patron.matcher(regla.produccion);
            
            while(coincidencia.find()){
                existe = false;
                encontrado = coincidencia.group();
                
                for (Regla regla1 : reglas) {
                    if(encontrado.equals(regla1.getNoTerminal())){
                        existe = true;
                        break;
                    }
                }
                
                if(!existe && !terminales.contains(encontrado))
                    terminales.add(encontrado);
            }
        }
        
        for (String terminal : terminales) {
            System.out.println("->" + terminal);
        }
    }
    
    
}
