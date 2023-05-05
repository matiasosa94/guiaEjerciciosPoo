package ej8;
import java.util.Scanner;
public class Test {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	Fecha date = new Fecha();
		
	date.leer(sc);
	System.out.println(date.zeller());
	date.diasTranscurridos();
	Fecha seop = new Fecha();
	seop.leer(sc);
	System.out.println(seop.zeller());
	seop.diasTranscurridos();
	date.menorIgualMayor(seop);	
	}

}
