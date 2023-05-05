package ej4bis;

public class Fraccion{
	
	private int numerador;
	private int denominador;
	
	public Fraccion() {
	}
	public Fraccion(int numerador, int denominador) {
		setNumerador(numerador);
		setDenominador(denominador);
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
	
	public Fraccion sumar(Fraccion fraccion) {
		Fraccion resultado=new Fraccion();
		
		if(this.denominador == fraccion.getDenominador()) {
			resultado.setNumerador(this.numerador+fraccion.getNumerador());
			resultado.setDenominador(this.denominador);
		} else {
			int numerador1=0;
			int numerador2=0;
			
			resultado.setDenominador(this.minimoComunMultiplo(this.denominador,fraccion.getDenominador()));
			
			if(this.denominador==resultado.getDenominador()) {
				numerador1=this.numerador;
			} else { 
				numerador1=this.numerador*resultado.getDenominador();
			}
			
			
			if(fraccion.getDenominador()==resultado.getDenominador()) {
				numerador2=fraccion.getNumerador();
			} else { 
				numerador2=fraccion.getNumerador()*resultado.getDenominador();
			}
			
			
			
			resultado.setNumerador(numerador1+numerador2);;
		}
		
		return resultado;
		
	}
	
	public Fraccion restar(Fraccion fraccion) {
		Fraccion resultado=new Fraccion();
		
		if(this.denominador == fraccion.getDenominador()) {
			resultado.setNumerador(this.numerador-fraccion.getNumerador());
			resultado.setDenominador(this.denominador);
		} else {
			int numerador1=0;
			int numerador2=0;
			
			resultado.setDenominador(this.minimoComunMultiplo(this.denominador,fraccion.getDenominador()));
			
			if(this.denominador==resultado.getDenominador()) {
				numerador1=this.numerador;
			} else { 
				numerador1=this.numerador*resultado.getDenominador();
			}
			
			
			if(fraccion.getDenominador()==resultado.getDenominador()) {
				numerador2=fraccion.getNumerador();
			} else { 
				numerador2=fraccion.getNumerador()*resultado.getDenominador();
			}
			
			
			
			resultado.setNumerador(numerador1-numerador2);;
		}
		
		return resultado;
	}
	
	private Fraccion multiplicar(Fraccion fraccion) {
		Fraccion resultado = new Fraccion();
		resultado.setNumerador(this.numerador*fraccion.getNumerador());
		resultado.setDenominador(this.denominador*fraccion.getDenominador());
		return resultado;
	}
	
	private void simplificar() {
		if(this.numerador>1 && this.denominador>3) {
			if(this.denominador%2==0) {
				
			}
		}
	}
	
	private int minimoComunMultiplo(int num1, int num2) {
		int minimoComunMultiplo=0;
		if(num1%num2==0) {
			minimoComunMultiplo=num1;
		} else if(num2%num1==0) {
			minimoComunMultiplo=num2;
		} else {
			minimoComunMultiplo=num1*num2;
		}
		return minimoComunMultiplo;
	}
	
	private int maximoComunDivisor(int num1, int num2) {
		int a= Math.max(num1, num2);
		int b= Math.min(num1, num2);
		
		int resultado = 0;
		do {
			resultado=b;
			b=a%b;
			a=resultado;
			
		}while(b!=0);
		return resultado;
	}
	@Override
	public String toString() {
		return "Fraccion " + numerador + "/" + denominador + "";
	}
	
	

}

