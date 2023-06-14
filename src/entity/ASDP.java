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
    private String resultado;

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
        resultado = "";
        Simbolo A = new Simbolo(reglas);
        Simbolo a = new Simbolo(reglas);
        
        pila = new PilaSimbolos();
        
        pila.push('$');
        pila.push(reglas.get(0).getNoTerminal().charAt(0));
        
        a.setSimbolo(getToken());//Primer simbolo del preanalisis
                    
        while (A.getSimbolo() != '$') {
            A.setSimbolo(pila.getCima());
            
            if (A.esTerminal() || A.getSimbolo() == '$') {
                if (A.getSimbolo() == a.getSimbolo()) {
                    pila.pop();
                    resultado += "      Emparejar " + a.getSimbolo()+"\n";
                    a.setSimbolo(getToken());//Siguiente simbolo del preanalisis
                } else {
                    //ErrorSintactico();
                    resultado += "Error de sintaxis. no se puede "
                            + "realizar la reducción.\n";
                    break;
                }
            } else {
                iReglaAct = tabla.getReglaAt(A.getSimbolo(),
                        a.getSimbolo());
                if (iReglaAct > 0) { 
                    pila.pop();
                    resultado += "Reducción: " + 
                            reglas.get(iReglaAct-1).toString() + "\n";
                    iReglaAct--;
                    for (int i = reglas.get(iReglaAct).getProduccion().length()-1; i >= 0; i--) {
                        if(reglas.get(iReglaAct).getProduccion().charAt(i) != ' ' &&
                                reglas.get(iReglaAct).getProduccion().charAt(i) != 'ε')
                            pila.push(reglas.get(iReglaAct).getProduccion().charAt(i));
                    }
                }else {
                    //ErrorSintactico;
                    resultado += "Error de sintaxis. no se puede "+
                            "realizar la reducción.\n";
                    break;
                }
            }
        }
    }
    
    private char getToken(){
        return pilaLexico.pop();
    }

    public void setPila(PilaSimbolos pila) {
        this.pila = pila;
    }
    
    public void setReglas(List<Regla> reglas) {
        this.reglas = reglas;
    }    

    public String getResultado() {
        return resultado;
    }
}
