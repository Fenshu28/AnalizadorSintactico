/** ***************************************************
 * Autor: Cristopher Alexis Zarate Valencia           *
 * Fecha de creación: 31 may 2023                     *
 * Fecha de actualización: 31 may 2023                *
 * Descripción: Clase para una Pila.
 **************************************************** */

package entity;

import java.util.ArrayList;
import java.util.List;


public class PilaSimbolos {
    private List<String> pila;
    private int tope;
    
    public PilaSimbolos(){
        this.pila = new ArrayList<>();        
        tope = -1;
    }

    public String pop(){
        if(tope>-1){
            String temp;
            temp = pila.get(tope);
            pila.remove(tope);
            tope--;
        
            return temp;    
        }else
            return "-";       
    }

    public void push(String item) {
        tope ++;
        this.pila.add(item);
    }

    public String getCima() {
        return pila.get(tope);
    }    
    
    public void fillPila(String texto){
        push("$");
        for(int i = texto.length()-1; i >= 0; i--){
            push(String.valueOf(texto.charAt(i)));
        }        
    }

    @Override
    public String toString() {
        return pila.toString();
    }
}
