package ej4;
import java.util.Scanner;

public  class CalculadoraFracciones {

	private int numerador=-1;
	private int denominador=-1;
	
	public CalculadoraFracciones() {
		
	}
	
	private int getNumerador() {
		return numerador;
	}

	private void setNumerador(int numerador) {
		this.numerador = numerador;
	}

	private int getDenominador() {
		return denominador;
	}

	private void setDenominador(int denominador) {
		this.denominador = denominador;
	}

	private int maximoComunDivisor(int num1,int num2) {

	    int a = Math.max(num1, num2);
	    int b = Math.min(num1, num2);
	 
	    int resultado = 0;
	    do {
	        resultado = b;
	        b = a % b;
	        a = resultado;
	    } while (b != 0);
	 
	    return resultado;
	}
	
	private int minimoComunMultiplo(int num1, int num2) {
	    int a = Math.max(num1, num2);
	    int b = Math.min(num1, num2);
	 
	    int resultado = (a / maximoComunDivisor(num1, num2)) * b;
	     
	    return resultado;
	 
	}
	
	private void reset() {
		setNumerador(-1);
		setDenominador(-1);
	}
	
	/*private void simplificar(int numerador, int denominador) {
		this.numerador=numerador/this.maximoComunDivisor(numerador, denominador);
		this.denominador=denominador/this.maximoComunDivisor(numerador, denominador);
	}*/
	
	private void sumar(int numerador, int denominador) {
		if(this.denominador==denominador) {
			int suma=this.numerador+numerador;
			this.numerador=suma;
			System.out.println("Resultado de la suma: "+suma+'/'+this.denominador);
		} else {
			int denominadorComun=this.minimoComunMultiplo(this.denominador, denominador);
			int num1= this.numerador*(denominadorComun/this.denominador);
			int num2= numerador*(denominadorComun/denominador);
			this.numerador=num1+num2;
			this.denominador=denominadorComun;
			System.out.println("Resultado de la suma: "+this.numerador+'/'+this.denominador);
		}
	}
	
	private void restar(int numerador, int denominador) {
		if(this.denominador==denominador) {
			int resta=this.numerador-numerador;
			this.numerador=resta;
			System.out.println("Resultado de la resta: "+this.numerador+'/'+this.denominador);
		} else {
			int denominadorComun=this.minimoComunMultiplo(this.denominador, denominador);
			int num1= this.numerador*(denominadorComun/this.denominador);
			int num2= numerador*(denominadorComun/denominador);
			this.numerador=Math.max(num1, num2)-Math.min(num1,num2);
			this.denominador=denominadorComun;
			
			System.out.println("Resultado de la resta: "+this.numerador+'/'+this.denominador);
		}
	}
	
	private void dividir(int numerador, int denominador) {
		this.denominador=this.denominador*numerador;
		this.numerador=this.numerador*denominador;
		
		System.out.println("Resultado de la division: "+this.numerador+'/'+this.denominador);
	}
	
	private void multiplicar(int numerador, int denominador) {
		this.denominador=this.denominador*denominador;
		this.numerador=this.numerador*numerador;
		
		System.out.println("Resultado de la multiplicacion: "+this.numerador+'/'+this.denominador);
	}
	
	public void operar() {
		int numerador;
		int denominador;
		boolean fin=false;
		Scanner sc = new Scanner(System.in);
		do {
		if(this.numerador==-1 && this.denominador==-1) {
			System.out.println("Ingrese un numerador");
			setNumerador(Integer.parseInt(sc.nextLine()));
			System.out.println("Ingrese un denominador");
			setDenominador(Integer.parseInt(sc.nextLine()));
		}
		
		System.out.println("Ingrese otro numerador");
		numerador= Integer.parseInt(sc.nextLine());
		System.out.println("Ingrese otro denominador");
		denominador= Integer.parseInt(sc.nextLine());
		System.out.println("Que operacion desea realizar: suma,resta,multiplicacion,division o exit para terminar.");
		char operacion = sc.nextLine().toLowerCase().charAt(0);
		switch(operacion) {
		case 's':this.sumar(numerador, denominador);break;
		case 'r':this.restar(numerador, denominador);break;
		case 'm':this.multiplicar(numerador, denominador);break;
		case 'd':this.dividir(numerador, denominador);break;
		case 'e':sc.close();fin=true;break;
		default: System.out.println("No ingreso una opcion valida");break;
			}
		}while(!fin);
		this.reset();
	}
	

}
