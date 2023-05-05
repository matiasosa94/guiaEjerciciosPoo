package ej2;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Libro libro=new Libro("El eternauta","nestor",500,"123541254852");
		Libro libro2=new Libro("El asereje","nestor",520,"123541264852");
		System.out.println(libro);
		System.out.println(libro2);
		if(libro.getNroPaginas()>libro2.getNroPaginas()) {
			System.out.println(libro.getTitulo()+" tiene mas paginas");
		} else {
			System.out.println(libro2.getTitulo()+" tiene mas paginas");
		}
	}

}
