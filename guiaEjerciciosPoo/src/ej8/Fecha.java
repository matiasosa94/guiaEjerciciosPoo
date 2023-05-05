package ej8;
import java.util.Scanner;
public class Fecha {
	
	private int dia;
	private int mes;
	private int año;
	private int[] cantidadDias= {31,29,31,30,31,30,31,31,30,31,30,31};
	private int[] bisiestos= {1904,1908,1912,1916,1920,1924,1928,1932,1936,1940,1944,1948,1952,/*13*/
									1956,1960,1964,1968,1972,1976,1980,1984,1988,1992,1996,2004,/*12*/
										2008,2012,2016,2020,2024,2028,2032,2036,2040,2044,2048};/*11*/
	public Fecha() {
		this.dia=1;
		this.mes=1;
		this.año=1996;
		
	}
	
	public void leer(Scanner sc) {
		
		System.out.println("Bonjour pedazo de soquetes");
		this.año=this.pedirAño(sc);
		this.mes=this.pedirMes(sc);
		this.dia=this.pedirDia(sc);
		System.out.println("Fecha determinada");
		this.getFecha();
		
	}
	private int pedirDia(Scanner sc) {
		boolean fallo=false;
		int dia=0;
		do {
		try {
			System.out.println("Ingrese el dia(del 01 al "+this.getCantidad(this.mes)+")");
			 dia=Integer.parseInt(sc.nextLine());
			while(dia<=0 || dia>this.getCantidad(this.mes)) {
				System.out.println("Ingrese el dia(del 01 al "+this.getCantidad(this.mes)+")");
				dia=Integer.parseInt(sc.nextLine());
			}
			if(dia>0 && dia< this.getCantidad(this.mes)) {
				fallo=false;
			}
		} catch(Exception e) {
			System.out.println(e);
			fallo=true;
		}
		}while(fallo);
		return dia;
	}
	private int pedirMes(Scanner sc) {
		
		boolean fallo=false;
		int m=0;
		do {
		try {
			System.out.println("Ingrese mes(del 01 al 12)");
			 m=Integer.parseInt(sc.nextLine());
			while(m<=0 || m>12) {
				System.out.println("Ingrese mes(del 01 al 12)");
				m=Integer.parseInt(sc.nextLine());
			}
			if(m>0 && m < 13) {
				fallo=false;
			}
		} catch(Exception e) {
			System.out.println(e);
			fallo=true;
		}
		}while(fallo);
		return m;
	}
	private int pedirAño(Scanner sc) {
		boolean fallo=false;
		int año=0;
		do {
		try {
			
			System.out.println("Ingrese el año(del 1900 al 2050)");
			 año=Integer.parseInt(sc.nextLine());
			while(año<1900 || año>2050) {
				System.out.println("Ingrese el año(del 1900 al 2050)");
				año=Integer.parseInt(sc.nextLine());
			}
			if(año>1899 && año<2051) {
				fallo=false;
			}
		} catch(Exception e) {
			System.out.println(e);
			fallo=true;
		}
		}while(fallo);
		
		return año;
	}
	
	private int getCantidad(int mes) {
		return (this.esBisiesto() && cantidadDias[mes-1]==29)?30:cantidadDias[mes-1];
	}
	
	public void getFecha() {
		System.out.println(this.dia+"/"+this.mes+"/"+this.año);
	}
	
	private boolean esBisiesto() {
		boolean bisiesto=false;
		for(int año:bisiestos) {
			if(this.año==año) {
				bisiesto=true;
			}
		}
		return bisiesto;
	}
	private boolean esBisiesto(int anno) {
		boolean bisiesto=false;
		for(int año:bisiestos) {
			if(anno==año) {
				bisiesto=true;
			}
		}
		return bisiesto;
	}
	
	public String zeller() {
		String d=" ";
		int h,K,J;
		int dia = this.dia;
		int mes=this.mes;
		int año = this.año;
		if(mes<=2) {
			mes=mes+12;
			año=año-1;
		}else {
			mes=mes-2;
		}
		K=año%100;
		J=año/100;
		
		h=((700+((26*mes-2)/10)+dia+K+(K/4)+((J/4)+5*J))%7);
		switch(h) {
		case 0:d="Domingo";break;
		case 1:d="Lunes";break;
		case 2:d="Martes";break;
		case 3:d="Miercoles";break;
		case 4:d="Jueves";break;
		case 5:d="Viernes";break;
		case 6:d="Sabado";break;
		}
		return d;
	}
	
	public int diasTranscurridos() {
		int cantidad=0;
		int añosNetos=(this.año-1900)*365;
		int mesesNetos=0;
		for(int i=0;i<this.mes-1;i++) {
			mesesNetos=mesesNetos+this.cantidadDias[i];
			
		}
		/*if(this.esBisiesto()&& this.mes>2) {
			mesesNetos++;
		}*/
		int diasBisiestos=0;
		for(int año:bisiestos) {
			if(this.esBisiesto(año) && año<this.año) {
				diasBisiestos++;
			}
		}
		System.out.println(diasBisiestos);
		System.out.println(añosNetos);
		System.out.println(mesesNetos);
		cantidad=(this.dia-1)+añosNetos+mesesNetos+diasBisiestos;
		System.out.println("Han transcurrido "+ (cantidad)+" dias desde el 01/01/1900 a la fecha");
		return cantidad;
	}
	
	public void menorIgualMayor(Fecha fecha) {
		int total1=this.dia+this.mes+this.año;
		int total2=fecha.dia+fecha.mes+fecha.año;
		if(total1>total2) {
			System.out.println("Es posterior");
		} else if(total1<total2) {
			System.out.println("Es anterior");
		} else if(total1==total2) {
			if(this.año==fecha.año) {
			if(this.mes>fecha.mes) {
				System.out.println("Es posterior");
			} else if(this.mes==fecha.mes){
				System.out.println("Es la misma fecha");
			} else if(this.mes<fecha.mes) {
				System.out.println("Es anterior");
			}
			}
		}
	}
	private boolean esPosterior(Fecha fecha) {
		boolean posterior=false;
		if(fecha.diasTranscurridos()<this.diasTranscurridos()) {
			posterior=true;
		}
		return posterior;
	}
	
	public int diasEntre(Fecha fecha) {
	
		if(this.esPosterior(fecha)) {
			return this.diasTranscurridos()-fecha.diasTranscurridos();
		} else {
			return fecha.diasTranscurridos()-this.diasTranscurridos();
		}
	}
	

}
