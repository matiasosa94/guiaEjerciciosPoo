package ej3;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		CuentaBancaria cuenta = new CuentaBancaria(3543216,38389643,525000);
		
		
		cuenta.actualizarSaldo();
		cuenta.retirarSaldo(500000);
		cuenta.actualizarSaldo();
		cuenta.ingresarSaldo(5050);
		cuenta.actualizarSaldo();
		
		
	}

}
