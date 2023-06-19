/** ***************************************************
 * Autor: Cristopher Alexis Zarate Valencia           *
 * Fecha de creación: 31 may 2023                     *
 * Fecha de actualización: 31 may 2023                *
 * Descripción: Clase para un ASDP (Analizador 
 * sintactico desendente predictivo).
 **************************************************** */


package entity;

import analizadores_lexicos.AnalizadorLexico;
import java.util.List;

public class ASDP {
    private PilaSimbolos pila;
    private PilaSimbolos pilaLexico;
    private AnalizadorLexico analiadorLexico;
    private TablaAnalisis tabla;
    private List<Regla> reglas;
    private int iReglaAct;
    private String resultado;
    private String expresion;

    public ASDP() {
    }
    
    public ASDP(String expresion,List<Token> listToken) {
        pilaLexico = new PilaSimbolos();
        pilaLexico.fillPila(expresion);
        this.expresion = expresion;
        analiadorLexico = new AnalizadorLexico(listToken,this.expresion);
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
        
        pila.push("$");
        pila.push(reglas.get(0).getNoTerminal());
        
        a.setSimbolo(analiadorLexico.getToken());//Primer simbolo del preanalisis
                    
        while (!A.getSimbolo().equals("$")) {
            A.setSimbolo(pila.getCima());
            
            if (A.esTerminal() || A.getSimbolo().equals("$")) {
                if (A.getSimbolo().equals(a.getSimbolo())) {
                    pila.pop();
                    resultado += "      Emparejar " + a.getSimbolo()+"\n";
                    a.setSimbolo(analiadorLexico.getToken());//Siguiente simbolo del preanalisis
                } else {
                    //ErrorSintactico();
                    if(a.getSimbolo().equals("ERROR"))
                        resultado += "Error de lexico. no se puede "
                            + "realizar la reducción.\n";
                    else                        
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
                            pila.push(String.valueOf(
                                    reglas.get(iReglaAct).getProduccion().charAt(i)));
                    }
                }else {
                    //ErrorSintactico;
                    resultado += "Error de sintaxis. no se puede "+
                            "realizar la reducción.\n";
                    break;
                }
            }
        }
        if(!resultado.contains("Error")){
            resultado += "La cadena :\n "+ expresion +
                            "\nFue aceptada..\n";
        }
    }
    
//    private String getToken(){
//        return pilaLexico.pop();
//    }

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
