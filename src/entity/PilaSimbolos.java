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
    private List<Character> pila;
    private int tope;
    
    public PilaSimbolos(){
        this.pila = new ArrayList<>();        
    }

    public char pop(){
        char temp;
        
        temp = pila.get(tope);
        pila.remove(tope);
        tope--;
        
        return temp;
        
    }

    public void push(char item) {
        tope ++;
        this.pila.add(item);
    }

    public char getCima() {
        return pila.get(tope);
    }    
}