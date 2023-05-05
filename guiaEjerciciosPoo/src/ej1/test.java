package ej1;
import java.util.Scanner;
public class test {

	public static void main(String[] args) {
		@SuppressWarnings({  "resource" })
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese su nombre");
		String nombre=sc.nextLine();
		System.out.println("Ingrese su edad");
		int edad = Integer.parseInt(sc.nextLine());
		System.out.println("Ingrese su sexo");
		char sexo = sc.nextLine().charAt(0);
		System.out.println("Ingrese su peso");
		int peso = Integer.parseInt(sc.nextLine());
		System.out.println("Ingrese su altura");
		double altura = Double.parseDouble(sc.nextLine());
		
		Persona persona = new Persona(nombre,edad,sexo,peso,altura);
		Persona persona1 = new Persona();
		Persona persona2 = new Persona(nombre,edad,sexo);
		persona.generarDni();
		persona1.generarDni();
		persona2.generarDni();
		
		System.out.println(persona);
		System.out.println(persona1);
		System.out.println(persona2);
		
		System.out.println(persona.calcularMc()+"   "+persona.esMayorDeEdad());
		System.out.println(persona1.calcularMc()+"   "+persona1.esMayorDeEdad());
		System.out.println(persona2.calcularMc()+"   "+persona2.esMayorDeEdad());
		
		
	}

}
