/** ***************************************************
 * Autor: Cristopher Alexis Zarate Valencia          *
 * Fecha de creación: 14 jun 2023                        *
 * Fecha de actualización: 14 jun 2023                   *
 * Descripción: Clase para el análizador léxico.
 **************************************************** */
package analizadores_lexicos;

import entity.Token;
import java.util.List;
import java.util.regex.Matcher;

public class AnalizadorLexico {

    private final List<Token> listToken;
    private final String sourceCode;
    private String token;
    private String remainingSourceCode;

    public AnalizadorLexico( List<Token> listToken,String sourceCode) {
        this.listToken = listToken;
        this.sourceCode = sourceCode;
        remainingSourceCode = this.sourceCode + "$";
    }
    
    public String getToken() {        
        Token matchedDefinition = null;
        int longestMatchLength = 0;

        for (Token definition : listToken) {
            Matcher matcher = definition.getPattern().matcher(remainingSourceCode);
            if (matcher.lookingAt() && matcher.end() > longestMatchLength) {
                matchedDefinition = definition;
                longestMatchLength = matcher.end();
                break;
            }
        }

        if (matchedDefinition != null) {
            String lexeme = remainingSourceCode.substring(0, longestMatchLength);
            token = matchedDefinition.getNombre();
            remainingSourceCode = remainingSourceCode.substring(longestMatchLength);
        } else {
            // Manejar cualquier carácter no reconocido
            if(remainingSourceCode.length()!=0)
                token = "ERROR";
//            remainingSourceCode = remainingSourceCode.substring(1);
        }

        return token;
    }
}
