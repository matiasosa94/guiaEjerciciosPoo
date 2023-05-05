package ej11;

public class Electrodomestico {
	private final String[] colores= {"gris","blanco","negro","rojo","azul"};
	private final char[] consumo= {'a','b','c','d','e','f'};
	private String color;
	private char consumoEnergetico;
	private String nombre;
	private double precioBase;
	private double peso;
	
	public Electrodomestico() {
		setColor("blanco");
		setConsumoEnergetico('F');
		setPrecioBase(100);
		setPeso(5);
		setNombre("pepe");
	}
	
	public Electrodomestico(double precio,double peso) {
		setColor("blanco");
		setConsumoEnergetico('F');
		setPrecioBase(precio);
		setPeso(peso);
		setNombre("pepe");
	}
	public Electrodomestico(double precio,double peso,String color,String nombre,char consumo) {
		setColor(color);
		setConsumoEnergetico(consumo);
		setPrecioBase(precio);
		setPeso(peso);
		setNombre(nombre);
	}

	private String getColor() {
		return color;
	}

	private void setColor(String color) {
		this.comprobarColor(color);
	}

	private char getConsumoEnergetico() {
		return consumoEnergetico;
	}

	private void setConsumoEnergetico(char consumoEnergetico) {
		this.comprobarConsumoEnergetico(consumoEnergetico);
	}

	private String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private double getPrecioBase() {
		return precioBase;
	}

	private void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	private double getPeso() {
		return peso;
	}

	private void setPeso(double peso) {
		this.peso = peso;
	}
	
	private void comprobarConsumoEnergetico(char consumo) {
		this.consumoEnergetico=this.consumo[5];
		for(int i=0;i<this.consumo.length;i++) {
			if(Character.toString(this.consumo[i]).equalsIgnoreCase(Character.toString(consumo))) {
				this.consumoEnergetico=consumo;
			};
		}
	}
	
	private void comprobarColor(String color) {
		this.color=this.colores[1];
		for(int i=0;i<this.colores.length;i++) {
			if(this.colores[i].equalsIgnoreCase(color)) {
				this.color=color;
			};
		}
	}
	
	public double precioFinal() {
		double precioFinal=0;
		switch (this.consumoEnergetico) {
		case 'a':precioFinal=500;break;
		case 'b':precioFinal=450;break;
		case 'c':precioFinal=300;break;
		case 'd':precioFinal=250;break;
		case 'e':precioFinal=200;break;
		case 'f':precioFinal=150;break;
		}
		
		if(this.peso<=19) {
			precioFinal=+700;
		} else if(this.peso>=20 && this.peso<=49) {
			precioFinal=+400;
		} else if(this.peso>=50 && this.peso<=79) {
			precioFinal=+200;
		} else {
			precioFinal=+500;
		}
		
		return precioFinal;
	}

}
