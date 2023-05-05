package ej10;

public class Password {

	private int longitud;
	private String contraseña;
	private int vueltas=0;

	public Password() {
		this.longitud = 8;
		generarPassword();
	}

	public Password(int longitud) {
		setLongitud(longitud);
		generarPassword();
	}

	private int getLongitud() {
		return longitud;
	}

	private void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public String getContraseña() {
		return contraseña;
	}

	private boolean esFuerte(String contraseña) {
		boolean fuerte = false;
		String[] letras = contraseña.split("");
		int numeros = 0;
		int minusculas = 0;
		int mayusculas = 0;
		for (int i = 0; i < letras.length; i++) {
			if (esNumero(letras[i])) {
				numeros++;
			} else if (esMayuscula(letras[i])) {
				mayusculas++;
			} else if (esMinuscula(letras[i])) {
				minusculas++;
			}
		}
		if ((numeros >= 5) && (minusculas >= 1) && (mayusculas >= 2)) {
			fuerte = true;
		}

		return fuerte;
	}

	private boolean esNumero(String a) {

		try {
			Integer.parseInt(a);
		} catch (NumberFormatException ex) {
			return false;
		}
		return true;
	}

	private boolean esMayuscula(String a) {
		String primo = a;
		if (primo.toUpperCase().equals(a)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean esMinuscula(String a) {
		String primo = a;
		if (primo.toLowerCase().equals(a)) {
			return true;
		} else {
			return false;
		}
	}

	private void generarPassword() {
		String opciones = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String contra = "";
		System.out.println(esFuerte(contra));
		 while(esFuerte(contra)==false &&(contra.length()!=this.longitud)) {
			 for (int i = 0; i < this.longitud; i++) {
					int opcion = (int) (Math.random() * 62);
					contra = contra + String.valueOf(opciones.charAt(opcion));
					
				}
			 if(!esFuerte(contra)) {
				 contra="";			 
			 }
			 this.vueltas++;
		 }
		
		 System.out.println(esFuerte(contra));
		

		this.contraseña = contra;
	}
	
	public int vueltas() {
		return this.vueltas;
	}

}
