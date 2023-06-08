package analizadores_lexicos;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Analizador2 {
	// Tokens
	final static String ERROR = "error";
	final static String ESPACIO = "espacio";
	final static String AND = "AND";
	final static String OR = "OR";
	final static String X = "X";
	final static String Y = "Y";
	final static String Z = "Z";
	
	// Variables de control
	static int contList = 0;
	static char charActual;
	static String estado = new String();
	
	 // Varibles de almacenamiento
	static List<Character> caracteres = new ArrayList<>();
	static String Lexema = new String();
	
	public static void main(String[] args) {
		loadFile("src/archivos/test2.txt");
		
		for(Character c : caracteres) {
			System.out.print(c);
		}
		
		System.out.println("");
		
		do {
			estado = estado1();
			
			if(!estado.equals("espacio"))
				System.out.println("Token encontrado: " + estado + ", Con el lexema: " + Lexema);
		}while(contList < caracteres.size()-1);
	}
	
	static String estado1() {
		charActual = getCaracter();
		Lexema = "";
		
		if(charActual == 'a' || charActual == 'A') {
			Lexema += charActual;
			return estado3();
		}else if(charActual == 'o' || charActual == 'O') {
			Lexema += charActual;
			return estado2();
		}else if(charActual == 'x' || charActual == 'X') {
			Lexema += charActual;
			return estado7();
		}else if(charActual == 'y' || charActual == 'Y') {
			Lexema += charActual;
			return estado8();
		}else if(charActual == 'z' || charActual == 'Z') {
			Lexema += charActual;
			return estado9();
		}else if(charActual == 32 || charActual == '\r' || charActual == '\n') {
			return ESPACIO;
		}else {
			return ERROR;
		}
	}
	
	static String estado2() {
		charActual = getCaracter();
		
		if(charActual == 'r' || charActual == 'R') {
			Lexema += charActual;
			return estado4();
		}else
			return ERROR;
	}
	
	static String estado3() {
		charActual = getCaracter();
		
		if(charActual == 'n' || charActual == 'N') {
			Lexema += charActual;
			return estado5();
		}else
			return ERROR;		
	}
	
	static String estado4() {
		charActual = getCaracter();

		if(charActual == ' ' || charActual == '\n' || charActual == '\r')
			return OR;
		else
			return ERROR;
	}
	
	static String estado5() {
		charActual = getCaracter();
		
		if(charActual == 'd' || charActual == 'D') {
			Lexema += charActual;
			return estado6();
		}else
			return ERROR;
	}
	
	static String estado6() {
		charActual = getCaracter();
		
		if(charActual == ' ' || charActual == '\n' || charActual == '\r') {
			return AND;
		}else
			return ERROR;
	}
	
	static String estado7() {
		charActual = getCaracter();
		
		if(charActual == ' ' || charActual == '\n' || charActual == '\r') {
			return X;
		}else			
			return ERROR;
	}
	
	static String estado8() {
		charActual = getCaracter();
		
		if(charActual == ' ' || charActual == '\n' || charActual == '\r') {
			return Y;
		}else
			return ERROR;
	}
	
	static String estado9()	{
		charActual = getCaracter();
		
		if(charActual == ' ' || charActual == '\n' || charActual == '\r') {
			return Z;
		}else
			return ERROR;
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
			
			while((charFile = rd.read()) != -1) {
				caracteres.add((char) charFile);
			}			
			
			caracteres.add('\0');
			
			rd.close();
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}		
	}
	
}
