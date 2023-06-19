/** ***************************************************
 * Autor: Cristopher Alexis Zarate Valencia          *
 * Fecha de creación: 31 may 2023                     *
 * Fecha de actualización: 31 may 2023                *
 * Descripción: Clase para los simbolos del ASDP.
 **************************************************** */

package entity;

import java.util.List;

public class Simbolo {   
    private String simbolo;
    private List<Regla> reglas;

    public Simbolo() {
        this.simbolo = "L";
    }
       
    public Simbolo(List<Regla> reglas){
        this.reglas = reglas;
        this.simbolo = "L";
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
    
    public boolean esTerminal(){
        boolean encontrado = true;
        
        for (Regla regla : reglas) {
            if(regla.getNoTerminal().equals(this.simbolo)){
                encontrado = false;
                break;
            }
                
        }
        
        return encontrado;
    }
    
}
