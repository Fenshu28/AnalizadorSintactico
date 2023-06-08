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
    private TablaAnalisis tabla;
    private String resLexico;
    private List<Regla> reglas;
    private int iReglaAct;

    public ASDP() {
    }
    
    public ASDP(String resLexico) {
        this.resLexico = resLexico;
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
        pila.push('S');
        
        while (A.getSimbolo() != '$') {
            A.setSimbolo(pila.getCima());
            //a = analex();//Siguiente simbolo del preanalisis
            if (A.esTerminal() || A.getSimbolo() == '$') {
                if (A.getSimbolo() == a.getSimbolo()) {
                    pila.pop();
                    //a = analex(); //Siguiente simbolo del preanalisis
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
                    for (int i = reglas.get(iReglaAct).getProduccion().length(); i > 0; i--) {
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

    public void setPila(PilaSimbolos pila) {
        this.pila = pila;
    }

    public void setResLexico(String resLexico) {
        this.resLexico = resLexico;
    }

    public void setReglas(List<Regla> reglas) {
        this.reglas = reglas;
    }
    
    
    
}
