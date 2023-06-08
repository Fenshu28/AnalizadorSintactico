package analizadores_lexicos;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Analizador4 {
	// Tokens
	final static String ERROR = "ERROR";
	final static String ESPACIO = "ESP";
	final static String NUMCIENT = "NUMERO";
	
	// Variables de control
		static int contList = 0;
		static int charActual;
		static String estado = new String();
		
		 // Varibles de almacenamiento
		static List<Integer> caracteres = new ArrayList<>();
		static String Lexema = new String();
	
		static boolean esNumero(char c) {
			if(charActual >= 48 && charActual <= 57) // Sí encuetra un dígito
				return true;
			else
				return false;
		}
		
		static boolean esEspacio(char c) {
			if(charActual == 32 || charActual == '\r' || charActual == '\n') // Sí encuetra un espacio o salto de linea
				return true;
			else
				return false;
		}
		
		static int getCaracter() {
			int c = caracteres.get(contList);
			
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
				
				charFile = rd.read();
				do {
					caracteres.add(charFile);
				}while((charFile = rd.read()) != -1);
				
				caracteres.add(32);
//				caracteres.add(charFile);
				caracteres.add(03);
				
				rd.close();
			} catch (Exception e) {
				System.out.println("Error " + e.getMessage());
			}		
		}
		
		public static void main(String[] args) {
			loadFile("src/archivos/test4.txt");
			
			for(int c : caracteres) {
				System.out.print((char)c);
			}
			
			System.out.println("");
			
			do {
				estado = estado0();
				
				if(!estado.equals("ESP"))
					System.out.println("Token encontrado: " + estado + ", Con el lexema: " + Lexema);
			}while(contList < caracteres.size()-1);
		}
		
		static String estado0() {
			charActual = getCaracter();
			
			Lexema = "";
			
			if(charActual == '+' || charActual == '-' || esNumero((char)charActual)) {
				Lexema += (char)charActual;
				return estado2();
			}else if(esEspacio((char)charActual)) {		
				return ESPACIO;
			}else
				return ERROR;
		}
		static String estado2() {
			charActual = getCaracter();
			
			if(esNumero((char)charActual)) {
				Lexema += (char)charActual;
				return estado2();
			}else if(charActual=='.') {
				Lexema += (char)charActual;
				return estado3();
			}else if(charActual=='E') {
				Lexema += (char)charActual;
				return estado5();
			}
//			else if(charActual!='.' || charActual=='E' || esNumero((char)charActual)) {
//				Lexema += (char)charActual;
//				return estado8();
//			}
			else
				return estado8();
		}
		static String estado3() {
			charActual = getCaracter();
			
			if(esNumero((char)charActual)) {
				Lexema += (char)charActual;
				return estado4();
			}else
				return ERROR;
		}
		static String estado4() {
			charActual = getCaracter();
			
			if(esNumero((char)charActual)) {
				Lexema += (char)charActual;
				return estado4();
			}else if(charActual=='E') {
				Lexema += (char)charActual;
				return estado5();
			}else
				return estado9();
		}
		static String estado5() {
			charActual = getCaracter();
			
			if(esNumero((char)charActual)) {
				Lexema += (char)charActual;
				return estado7();
			}else if(charActual=='+' || charActual=='-') {
				Lexema += (char)charActual;
				return estado6();
			}else
				return ERROR;
		}
		static String estado6() {
			charActual = getCaracter();
			
			if(esNumero((char)charActual)) {
				Lexema += (char)charActual;
				return estado7();
			}else
				return ERROR;
		}
		static String estado7() {
			charActual = getCaracter();
			
			if(esNumero((char)charActual)) {
				Lexema += (char)charActual;
				return estado7();
			}else
				return estado10();
		}
		static String estado8() {		
			if(esEspacio((char)charActual)) {
				return NUMCIENT;
			}else
				return ERROR;
		}
		static String estado9() {
			if(esEspacio((char)charActual)) {
				return NUMCIENT;
			}else
				return ERROR;
		}
		static String estado10() {
			if(esEspacio((char)charActual)) {
				return NUMCIENT;
			}else
				return ERROR;
		}
		
		
}
