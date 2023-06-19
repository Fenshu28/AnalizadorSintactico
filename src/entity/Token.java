/*****************************************************
 * Autor: Cristopher Alexis Zarate Valencia          *
 * Fecha de creación: 15 jun 2023                        *
 * Fecha de actualización: 15 jun 2023                   *
 * Descripción: Clase para un Token
 *****************************************************/

package entity;

import java.util.regex.Pattern;

public class Token {
    private final String nombre;
    private final Pattern pattern;

    public Token (String nombre, String regexPattern) {
        this.nombre = nombre;
        this.pattern = Pattern.compile( regexPattern);
    }

    public String getNombre() {
        return nombre;
    }

    public Pattern getPattern() { //"^" +
        return Pattern.compile( pattern.pattern());
    }
    
    public String getRegex(){
        return pattern.pattern();
    }
}
