/** ***************************************************
 * Autor: Cristopher Alexis Zarate Valencia           *
 * Fecha de creación: 31 may 2023                     *
 * Fecha de actualización: 31 may 2023                *
 * Descripción: Clase para un ASDP (Analizador 
 * sintactico desendente predictivo).
 **************************************************** */


package entity;

import java.util.List;

public class ASDP {
    private PilaSimbolos pila;
    private PilaSimbolos pilaLexico;
    private TablaAnalisis tabla;
    private List<Regla> reglas;
    private int iReglaAct;

    public ASDP() {
    }
    
    public ASDP(String resLexico) {
        pilaLexico = new PilaSimbolos();
        pilaLexico.fillPila(resLexico);        
    }

    public void setTablaAnalisis(TablaAnalisis tabla) {
        //Aquí se llenaria la tabla de analisis
        this.tabla = tabla;
    }

    public void analizar() {
        Simbolo A = new Simbolo(reglas);
        Simbolo a = new Simbolo(reglas);
        
        pila = new PilaSimbolos();
        
        pila.push('$');
        pila.push(reglas.get(0).getNoTerminal().charAt(0));
        
        a.setSimbolo(getToken());//Siguiente simbolo del preanalisis
                    
        while (A.getSimbolo() != '$') {
            A.setSimbolo(pila.getCima());
            
            if (A.esTerminal() || A.getSimbolo() == '$') {
                if (A.getSimbolo() == a.getSimbolo()) {
                    pila.pop();
                    System.out.println("        Emparejar " + a.getSimbolo());
                    a.setSimbolo(getToken());//Siguiente simbolo del preanalisis
                } else {
                    //ErrorSintactico();
                    System.out.println("Error de sintaxis. no se puede "
                            + "realizar la reducción.");
                    break;
                }
            } else {
                iReglaAct = tabla.getReglaAt(A.getSimbolo(),
                        a.getSimbolo());
                if (iReglaAct > 0) { 
                    pila.pop();
                    System.out.println("Reducción a: " + reglas.get(iReglaAct-1).toString());
                    iReglaAct--;
                    for (int i = reglas.get(iReglaAct).getProduccion().length()-1; i >= 0; i--) {
                        if(reglas.get(iReglaAct).getProduccion().charAt(i) != ' ')
                            pila.push(reglas.get(iReglaAct).getProduccion().charAt(i));
                    }
                }else {
                    //ErrorSintactico;
                    System.out.println("Error de sintaxis. no se puede "+
                            "realizar la reducción.");
                }
            }
        }
    }
    
    private char getToken(){
//        if(resLexico != null){
            return pilaLexico.pop();
//        }else{
//            return 5;
//        }        
    }

    public void setPila(PilaSimbolos pila) {
        this.pila = pila;
    }
    
    public void setReglas(List<Regla> reglas) {
        this.reglas = reglas;
    }    
}
