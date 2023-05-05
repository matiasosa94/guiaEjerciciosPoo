package ej1;

public class Persona {
	private String nombre;
	private String dni;
	private int edad;
	private char sexo;
	private int peso;
	private double altura;
	private static final int pesoBajo= -1;
	private static final int pesoMedio=0;
	private static final int pesoAlto=1;
	public Persona() {
		this.nombre="pordefecto";
		this.edad=99;
		this.sexo='m';
		this.peso=10;
		this.altura=4.5;
	}
	public Persona(String nombre, int edad, char sexo) {
		setNombre(nombre);
		setEdad(edad);
		setSexo(sexo);
		this.peso=10;
		this.altura=1.75;
	}
	
	public Persona(String nombre, int edad, char sexo,int peso, double altura) {
		setNombre(nombre);
		setEdad(edad);
		setSexo(sexo);
		setPeso(peso);
		setAltura(altura);
	}
	@SuppressWarnings("unused")
	private String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@SuppressWarnings("unused")
	private String getDni() {
		return dni;
	}

	private void setDni(String dni) {
		this.dni = dni;
	}
	@SuppressWarnings("unused")
	private int getEdad() {
		return edad;
	}

	private void setEdad(int edad) {
		this.edad = edad;
	}
	@SuppressWarnings("unused")
	private char getSexo() {
		return sexo;
	}

	private void setSexo(char sexo) {
		this.sexo=this.comprobarSexo(sexo);
		
	}
	@SuppressWarnings("unused")
	private int getPeso() {
		return peso;
	}

	private void setPeso(int peso) {
		this.peso = peso;
	}

	@SuppressWarnings("unused")
	private double getAltura() {
		return altura;
	}

	private void setAltura(double altura) {
		this.altura = altura;
	}
	
	public int calcularMc() {
		
		double resultado=this.peso/(this.altura*this.altura);
		if(resultado>25) {
			return pesoAlto;
		} else if(resultado<=25 && resultado>=20) {
			return pesoMedio;
		} else  {
			return pesoBajo;
		}
	}
	
	
	public boolean esMayorDeEdad() {
		return (this.edad>=21)? true:false;
	}
	
	private char comprobarSexo(char sexo) {
		return (sexo=='h' || sexo=='H' || sexo=='M' || sexo=='m')? sexo: 'h';
	}
	
	public void generarDni() {
		String a="";
		for(int i =0;i<8;i++) {
			int numero=(int)(Math.random()*9);
			a=a+Integer.toString(numero);
		}
		setDni(a);
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", dni=" + dni + ", edad=" + edad + ", sexo=" + sexo + ", peso=" + peso
				+ ", altura=" + altura + "]";
	}
	
	
	
}
