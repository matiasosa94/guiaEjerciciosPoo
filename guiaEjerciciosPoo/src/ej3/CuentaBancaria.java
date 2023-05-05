package ej3;

public class CuentaBancaria {
		
	private long numeroCuenta;
	private long dni;
	private double saldoActual;
	final static double interesAnual=0.03;
	
	
	public CuentaBancaria() {
		numeroCuenta=0;
		dni=0;
		saldoActual=0;
	}
	
	public CuentaBancaria(long numeroCuenta, long dni, double saldoActual) {
		setNumeroCuenta(numeroCuenta);
		setDni(dni);
		setSaldoActual(saldoActual);
	}

	public long getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(long numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public double getSaldoActual() {
		return saldoActual;
	}

	public void setSaldoActual(double saldoActual) {
		this.saldoActual = saldoActual;
	}
	
	private boolean haySaldo(double monto) {
		return (this.saldoActual>=monto)?true:false;
	}
	
	public double retirarSaldo(double monto) {
		double retiro=0;
		if(haySaldo(monto)) {
			retiro=monto;
			this.saldoActual-=monto;
		}
		return retiro;
	}
	
	public void ingresarSaldo(double monto) {
		if(monto>0) {
			this.saldoActual+=monto;
			System.out.println("Saldo actualizado: $"+this.saldoActual);
		} else {
			System.out.println("Elija un monto mayor a cero");
		}
	}
	
	public void actualizarSaldo() {
		double monto=(this.saldoActual*this.interesAnual)/365;
		this.saldoActual+=monto;
		System.out.println("interes: $" +monto+" nuevo saldo: $"+this.saldoActual);
	}
	
	
}
