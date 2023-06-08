/** ***************************************************
 * Autor: Cristopher Alexis Zarate Valencia          *
 * Fecha de creación: 31 may 2023                     *
 * Fecha de actualización: 31 may 2023                *
 * Descripción: Clase para los simbolos del ASDP.
 **************************************************** */

package analizadores_lexicos;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Analizador1 {
    // Atributos de la clase

    private List<String> tokens;

    // Toekns
    final static String ERROR = "ERROR";
    final static String ESPACIO = "ESP";
    final static String IDENTIFICADOR = "IDENTIFICADOR";
    final static String SUMA = "SUMAR";
    final static String MULTIPLICAR = "MULTIPLICAR";
    final static String NUMERO = "NUMERO";

    // Variables de control
    static private int contList = 0;
    static private char charActual;
    static private String estado = new String();

    // Varibles de almacenamiento
    static private List<Character> caracteres = new ArrayList<>();
    static private String Lexema = new String();

    public void Analizar(String file) {
        // "src/archivos/test1.txt"
        loadFile(file);

        do {
            estado = estado1();

            if (!estado.equals("ESP")) {
                tokens.add(estado);
                System.out.println("Token encontrado: " + estado + ", Con el lexema: " + Lexema);
            }
        } while (contList < caracteres.size() - 1);
    }

    static boolean esLetra(char c) {
        if ((charActual >= 65 && charActual <= 90) || (charActual >= 97 && charActual <= 122)) // Sí encuetra una letra
        {
            return true;
        } else {
            return false;
        }
    }

    static boolean esNumero(char c) {
        if (charActual >= 48 && charActual <= 57) // Sí encuetra un dígito
        {
            return true;
        } else {
            return false;
        }
    }

    static boolean esEspacio(char c) {
        if (charActual == 32 || charActual == '\r' || charActual == '\n') // Sí encuetra un espacio o salto de linea
        {
            return true;
        } else {
            return false;
        }
    }

    static String estado1() {
        charActual = getCaracter();
        Lexema = "";

        if (esLetra(charActual)) {
            Lexema += charActual;
            return estado4();
        } else if (esNumero(charActual)) {
            Lexema += charActual;
            return estado6();
        } else if (charActual == '+') {
            Lexema += charActual;
            return estado2();
        } else if (charActual == '*') {
            Lexema += charActual;
            return estado3();
        } else if (esEspacio(charActual)) {
            return ESPACIO;
        } else {
            return ERROR;
        }
    }

    static String estado2() {
        charActual = getCaracter();

        if (esEspacio(charActual)) {
            return SUMA;
        } else {
            return ERROR;
        }
    }

    static String estado3() {
        charActual = getCaracter();

        if (esEspacio(charActual)) {
            return MULTIPLICAR;
        } else {
            return ERROR;
        }
    }

    static String estado4() {
        charActual = getCaracter();

        if (esLetra(charActual)) {
            Lexema += charActual;
            return estado4();
        } else if (!esLetra(charActual)) {
            Lexema += charActual;
            return estado5();
        } else {
            return ERROR;
        }
    }

    static String estado5() {
        //charActual = getCaracter();

        if (esEspacio(charActual)) {
            return IDENTIFICADOR;
        } else {
            return ERROR;
        }
    }

    static String estado6() {
        charActual = getCaracter();

        if (esNumero(charActual)) {
            Lexema += charActual;
            return estado6();
        } else if (!esNumero(charActual)) {
            Lexema += charActual;
            return estado7();
        } else {
            return ERROR;
        }
    }

    static String estado7() {
        //charActual = getCaracter();

        if (esEspacio(charActual)) {
            return NUMERO;
        } else {
            return ERROR;
        }
    }

    static char getCaracter() {
        char c = caracteres.get(contList);

        contList++;

        return c;
    }

    static void loadFile(String ruta) {
        File archivo = new File(ruta);
        FileReader rd = null;
        int charFile;

        try {
            rd = new FileReader(archivo);
            System.out.println("Archivo abierto.");

            while ((charFile = rd.read()) != -1) {
                caracteres.add((char) charFile);
            }

            caracteres.add('\0');

            rd.close();
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
