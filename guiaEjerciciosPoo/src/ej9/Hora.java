package ej9;

public class Hora {
	
	private int hora;
	private int minuto;
	private int segundo;
	
	public Hora(int hora, int minuto, int segundo) {
		setHora(hora);
		setMinuto(minuto);
		setSegundo(segundo);
		valida();
	}

	private int getHora() {
		return hora;
	}

	private void setHora(int hora) {
		this.hora = hora;
	}

	private int getMinuto() {
		return minuto;
	}

	private void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	private int getSegundo() {
		return segundo;
	}

	private void setSegundo(int segundo) {
		this.segundo = segundo;
	}
	
	private void valida() {
		if(this.hora<0 || this.hora > 24) {
			this.hora=8;
		}
		if(this.minuto<0 || this.minuto>=60) {
			this.minuto=0;
		}
		if(this.segundo<0 || this.segundo>=60) {
			this.segundo=0;
		}

	}
	
	public void print() {
		String hora=Integer.toString(this.hora);
		String minuto=Integer.toString(this.minuto);
		String segundo=Integer.toString(this.segundo);
		
		if(hora.length()==1)hora="0"+hora;
		if(minuto.length()==1)minuto="0"+minuto;
		if(segundo.length()==1)segundo="0"+segundo;
		System.out.println(hora+":"+minuto+":"+segundo);
	}
	
	public int aSegundos() {
		int segundosHoras=this.hora*3600;
		int segundosMinutos=this.minuto*60;
		int segundosSegundos=this.segundo;
		int totalSegundos=segundosHoras+segundosMinutos+segundosSegundos;
		return totalSegundos;
	};
	
	public int segundosDesde(Hora hora) {
		if(this.aSegundos()>hora.aSegundos()) {
			return this.aSegundos()-hora.aSegundos(); 
		}else {
			return hora.aSegundos()-this.aSegundos();
		}
	}
	
	public void siguiente() {
		this.segundo++;
		print();
	}
	public void anterior() {
		this.segundo--;
		print();
	}
	
	public void esIgual(Hora hora) {
		if (this.hora==hora.hora && this.minuto==hora.minuto && this.segundo==hora.segundo) {
			System.out.println("son iguales");
		}else{
			System.out.println("no son iguales");
		}
	}
	
	public void menorMayor(Hora hora) {
		if(this.aSegundos()>hora.aSegundos()) {
			System.out.println("Es mayor");
		}else {
			System.out.println("Es menor");
		}
	}

}
