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
    private List<String> noTerminales;
    private int tabla[][]; // Ahora solo acepta el conjunto de predicción. por eso esta en int
    
    public TablaAnalisis(List<Regla> reglas){
        this.reglas = reglas;
        splitNoTerminales();
        splitTerminales();
        tabla = new int[noTerminales.size()][terminales.size()];
        
        System.out.println("Terminales: ");
        for (String terminal : terminales) {
            System.out.println("->" + terminal);
        }
        System.out.println("No terminales: ");
        for (String noTerminal : noTerminales) {
            System.out.println("->" + noTerminal);
        }
    }

    public void setReglas(List<Regla> reglas) {
        this.reglas = reglas;
    }
    
    private void splitNoTerminales(){
        noTerminales = new ArrayList<>();
        for (Regla regla : reglas) {
            if(!noTerminales.contains(regla.getNoTerminal()))
                noTerminales.add(regla.getNoTerminal());
        }
    }
    
    private void splitTerminales(){
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
        
        terminales.add("$");
    }
    
    public int getReglaAt(char noTerminal,char terminal){
        int i=0,j=0;
        for (String noTerminalList : noTerminales) {
            if(noTerminalList.equals(String.valueOf(noTerminal)))
                break;
            i++;
        }
        for (String TerminalList : terminales) {
            if(TerminalList.equals(String.valueOf(terminal)))
                break;
            j++;
        }
        
        return tabla[i][j];
    }
    
    public void setValorAt(int fila, int columna,int valor){
        tabla[fila][columna] = valor;
    }
    
    public int getSizeTerminales(){
        return terminales.size();
    }
    
    public int getSizeNoTerminales(){
        return noTerminales.size();
    }

    public List<String> getTerminales() {
        return terminales;
    }

    public List<String> getNoTerminales() {
        return noTerminales;
    }
    
}
