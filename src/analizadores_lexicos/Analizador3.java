package analizadores_lexicos;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Analizador3 {
	// Tokens
	final static String ERROR = "ERROR";
	final static String ESPACIO = "ESP";
	final static String PTOCOMA = "PTOCOMA";
	final static String EOF = "EOF";
	final static String IDENTIFICADOR = "IDENTIFICADOR";
	final static String NUMERO = "NUMERO";
	final static String ASIGNAR = "ASIGNAR";
	final static String COMA = "COMA";
	final static String RESTA = "RESTAR";
	final static String MULTIPLICAR = "MULTIPLICAR";
	final static String DIVIDIR = "DIVIDIR";
	final static String ENTERO = "ENTERO";
	final static String STRING = "STRING";
	final static String BOOLEAN = "BOOLEAN";
	final static String IF = "IF";
	final static String THEN = "THEN";
	final static String SUMA = "SUMA";
	final static String DOUBLE = "DOUBLE";
	
	// Variables de control
	static int contList = 0;
	static int charActual;
	static String estado = new String();
	
	 // Varibles de almacenamiento
	static List<Integer> caracteres = new ArrayList<>();
	static String Lexema = new String();

	static boolean esLetra(char c) {
		if((charActual >= 65 && charActual <= 90) || (charActual >= 97 && charActual <= 122)) // Sí encuetra una letra
			return true;
		else
			return false;	
	}
	
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
			caracteres.add(charFile);
			caracteres.add(03);
			
			rd.close();
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}		
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		loadFile("src/archivos/test3.txt");
		
		for(int c : caracteres) {
			System.out.print((char)c);
		}
		
		System.out.println("");
		
		do {
			estado = estado1();
			
			if(!estado.equals("ESP"))
				System.out.println("Token encontrado: " + estado + ", Con el lexema: " + Lexema);
		}while(contList < caracteres.size()-1);
	}
	
	static String estado1() {
		charActual = getCaracter();
		
		Lexema = "";
		
		if(charActual == ';') {
			Lexema += (char)charActual;
			return estado2();
		}else if(charActual == -1){
			Lexema += "eof";
			return estado3();
		}else if(charActual=='=') {
			Lexema += (char)charActual;
			return estado8();
		}else if(esNumero((char)charActual)) {
			Lexema += (char)charActual;
			return estado6();
		}else if(charActual==',') {
			Lexema += (char)charActual;
			return estado9();
		}else if(charActual=='+') {
			Lexema += (char)charActual;
			return estado39();
		}else if(charActual=='-') {
			Lexema += (char)charActual;
			return estado10();
		}else if(charActual=='*') {
			Lexema += (char)charActual;
			return estado11();
		}else if(charActual=='/') {
			Lexema += (char)charActual;
			return estado12();
		}else if(charActual=='i') {
			Lexema += (char)charActual;
			return estado13();
		}else if(charActual=='S') {
			Lexema += (char)charActual;
			return estado17();
		}else if(charActual=='b') {
			Lexema += (char)charActual;
			return estado24();
		}else if(charActual=='d') {
			Lexema += (char)charActual;
			return estado40();
		}else if(charActual=='t') {
			Lexema += (char)charActual;
			return estado34();
		}else if(esLetra((char) charActual)) {
			Lexema += (char)charActual;
			return estado4();
		}else if(esEspacio((char) charActual)) {
			return ESPACIO;
		}else		
			return ERROR;
	}
	
	static String estado2() {
		charActual = getCaracter();

		if(esEspacio((char) charActual))
			return PTOCOMA;
		else
			return ERROR;
	}
	
	static String estado3() {
			return EOF;
	}
	static String estado4() {
		charActual = getCaracter();
		
		if(esLetra((char)charActual)) {
			Lexema += (char)charActual;
			return estado4();
		}else if(!esLetra((char)charActual)) {
			return estado5();
		}else
			return ERROR;
	}
	static String estado5() {
		if(esEspacio((char) charActual))
			return IDENTIFICADOR;
		else
			return ERROR;
	}
	static String estado6() {
		charActual = getCaracter();
		
		if(esNumero((char)charActual)) {
			Lexema += (char)charActual;
			return estado6();
		}else if(!esNumero((char)charActual)) {
			return estado7();
		}else
			return ERROR;
	}
	static String estado7() {
		if(esEspacio((char) charActual))
			return NUMERO;
		else
			return ERROR;
	}
	static String estado8() {
		charActual = getCaracter();

		if(esEspacio((char) charActual))
			return ASIGNAR;
		else
			return ERROR;
	}
	static String estado9() {
		charActual = getCaracter();

		if(esEspacio((char) charActual))
			return COMA;
		else
			return ERROR;
	}
	static String estado10() {
		charActual = getCaracter();

		if(esEspacio((char) charActual))
			return RESTA;
		else
			return ERROR;
	}
	static String estado11() {
		charActual = getCaracter();

		if(esEspacio((char) charActual))
			return MULTIPLICAR;
		else
			return ERROR;
	}
	static String estado12() {
		charActual = getCaracter();

		if(esEspacio((char) charActual))
			return DIVIDIR;
		else
			return ERROR;
	}
	static String estado13() {
		charActual = getCaracter();
		
		if(charActual=='n') {
			return estado14();
		}else if(charActual=='f') {
			return estado32();
		}else			
			return ERROR;
	}
	static String estado14() {
		charActual = getCaracter();
		
		if(charActual=='t') {
			return estado15();
		}else			
			return ERROR;
	}
	static String estado15() {
		charActual = getCaracter();
		
		if(esEspacio((char) charActual))
			return estado16();
		else
			return ERROR;
	}
	static String estado16() {
		if(esEspacio((char) charActual))
			return ENTERO;
		else
			return ERROR;
	}
	
	static String estado17() {
		charActual = getCaracter();
		
		if(charActual=='t')
			return estado18();
		else if(esEspacio((char) charActual))
			return estado5();
		else
			return ERROR;
	}
	static String estado18() {
		charActual = getCaracter();
		
		if(charActual=='r')
			return estado19();
		else if(esEspacio((char) charActual))
			return estado5();
		else
			return ERROR;
	}
	static String estado19() {
		charActual = getCaracter();
		
		if(charActual=='i')
			return estado20();
		else if(esEspacio((char) charActual))
			return estado5();
		else
			return ERROR;
	}
	static String estado20() {
		charActual = getCaracter();
		
		if(charActual=='n')
			return estado21();
		else if(esEspacio((char) charActual))
			return estado5();
		else
			return ERROR;
	}
	static String estado21() {
		charActual = getCaracter();
		
		if(charActual=='g')
			return estado22();
		else if(esEspacio((char) charActual))
			return estado5();
		else
			return ERROR;
	}
	static String estado22() {
		charActual = getCaracter();
		
		if(esEspacio((char) charActual))
			return estado23();
		else
			return ERROR;
	}
	static String estado23() {
		if(esEspacio((char) charActual))
			return STRING;
		else
			return ERROR;
	}
	static String estado24() {
		charActual = getCaracter();
		
		if(charActual=='o')
			return estado24();
		else if(esEspacio((char) charActual))
			return estado5();
		else
			return ERROR;
	}
	static String estado25() {
		charActual = getCaracter();
		
		if(charActual=='o')
			return estado26();
		else if(esEspacio((char) charActual))
			return estado5();
		else
			return ERROR;
	}
	static String estado26() {
		charActual = getCaracter();
		
		if(charActual=='l')
			return estado27();
		else if(esEspacio((char) charActual))
			return estado5();
		else
			return ERROR;
	}
	static String estado27() {
		charActual = getCaracter();
		
		if(charActual=='e')
			return estado28();
		else if(esEspacio((char) charActual))
			return estado5();
		else
			return ERROR;
	}
	static String estado28() {
		charActual = getCaracter();
		
		if(charActual=='a')
			return estado29();
		else if(esEspacio((char) charActual))
			return estado5();
		else
			return ERROR;
	}
	static String estado29() {
		charActual = getCaracter();
		
		if(charActual=='n')
			return estado30();
		else if(esEspacio((char) charActual))
			return estado5();
		else
			return ERROR;
	}
	static String estado30() {
		charActual = getCaracter();
		
		if(esEspacio((char) charActual))
			return estado31();
		else
			return ERROR;
	}
	static String estado31() {
		if(esEspacio((char) charActual))
			return BOOLEAN;
		else
			return ERROR;
	}
	static String estado32() {
		charActual = getCaracter();
		
		if(esEspacio((char) charActual))
			return estado33();
		else
			return ERROR;
	}
	static String estado33() {
		charActual = getCaracter();

		if(esEspacio((char) charActual))
			return IF;
		else
			return ERROR;
	}
	static String estado34() {
		charActual = getCaracter();
		
		if(charActual=='h')
			return estado35();
		else if(esEspacio((char) charActual))
			return estado5();
		else
			return ERROR;
	}
	static String estado35() {
		charActual = getCaracter();
		
		if(charActual=='e')
			return estado36();
		else if(esEspacio((char) charActual))
			return estado5();
		else
			return ERROR;
	}
	static String estado36() {
		charActual = getCaracter();
		
		if(charActual=='n')
			return estado37();
		else if(esEspacio((char) charActual))
			return estado5();
		else
			return ERROR;
	}
	static String estado37() {
		charActual = getCaracter();
		
		if(esEspacio((char) charActual))
			return estado38();
		else
			return ERROR;
	}
	static String estado38() {
		charActual = getCaracter();

		if(esEspacio((char) charActual))
			return THEN;
		else
			return ERROR;
	}
	static String estado39() {
		charActual = getCaracter();

		if(esEspacio((char) charActual))
			return SUMA;
		else
			return ERROR;
	}
	static String estado40() {
		charActual = getCaracter();
		
		if(charActual=='o')
			return estado41();
		else if(esEspacio((char) charActual))
			return estado5();
		else
			return ERROR;
	}
	static String estado41() {
		charActual = getCaracter();
		
		if(charActual=='u')
			return estado42();
		else
			return ERROR;
	}
	static String estado42() {
		charActual = getCaracter();
		
		if(charActual=='b')
			return estado43();
		else
			return ERROR;
	}
	static String estado43() {
		charActual = getCaracter();
		
		if(charActual=='l')
			return estado44();
		else
			return ERROR;
	}
	static String estado44() {
		charActual = getCaracter();
		
		if(charActual=='e')
			return estado45();
		else
			return ERROR;
	}
	static String estado45() {
		charActual = getCaracter();
		
		if(charActual=='f')
			return estado46();
		else
			return ERROR;
	}
	static String estado46() {
		charActual = getCaracter();

		if(esEspacio((char) charActual))
			return DOUBLE;
		else
			return ERROR;
	}
}