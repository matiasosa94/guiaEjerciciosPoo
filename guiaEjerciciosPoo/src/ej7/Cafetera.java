package ej7;

public class Cafetera {
	private double capacidadMaxima;
	private double cantidadActual;
	
	public Cafetera() {
		this.capacidadMaxima=1000;
		this.cantidadActual=0;
	}
	public Cafetera(double capacidadMaxima) {
		this.capacidadMaxima=capacidadMaxima;
		this.cantidadActual=0;
	}
	
	public Cafetera(double capacidadMaxima,double capacidadActual) {
		this.capacidadMaxima=capacidadMaxima;
		this.cantidadActual=capacidadActual;	
		}
	
	public void llenarCafetera() {
		this.cantidadActual=this.capacidadMaxima;
	}
	
	public void servirTaza(double cantidad) {
		if(this.cantidadActual>=cantidad) {
			this.cantidadActual-=cantidad;
		} else {
			cantidad=this.cantidadActual;
			this.cantidadActual=0;
		}
		System.out.println("Se sirvieron "+cantidad+"- cantidad restante: "+this.cantidadActual);
	}
	
	public void vaciarCafetera() {
		this.cantidadActual=0;
	}
	
	public void agregarCafetera(int cantidad) {
		if((this.cantidadActual+cantidad)>this.capacidadMaxima) {
			System.out.println("Exceso de carga de "+(this.capacidadMaxima-(this.cantidadActual+cantidad))+"cc");
		} else {
			this.cantidadActual+=cantidad;
			System.out.println("Carga exitosa\n"+"Carga Actual: "+this.cantidadActual+"cc");
		}
	}

}
