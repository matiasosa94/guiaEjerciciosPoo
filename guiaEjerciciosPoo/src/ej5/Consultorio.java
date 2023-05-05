package ej5;
import java.util.ArrayList;
import java.util.Scanner;
public class Consultorio {
	private String doctor;
	private ArrayList<Turno> turnos=null;
	private ArrayList<Paciente> pacientes=null;
	
	public Consultorio() {
		this.turnos=new ArrayList<Turno>();
		this.pacientes=new ArrayList<Paciente>();
		setDoctor("Dr. Nanuelas");
	}
	
	private void setTurno(Turno turno) {
		this.turnos.add(turno);
	}
	
	private void setPaciente(Paciente paciente) {
		this.pacientes.add(paciente);
	}
	private void setDoctor(String doctor) {
		this.doctor=doctor;
	}
	
	public Paciente getPaciente(String nombre) {
		
		int indice=0;
		while(indice<this.pacientes.size() && !this.pacientes.get(indice).mismoNombre(nombre)) {
			indice++;
		}
		
		return (indice<this.pacientes.size())? this.pacientes.get(indice):null;
	}
	
	public Paciente getPaciente(int numeroHistoria) {
		
		int indice=0;
		while(indice<this.pacientes.size() && !this.pacientes.get(indice).mismoNumeroHistoria(numeroHistoria)) {
			indice++;
		}
		
		return (indice<this.pacientes.size())? this.pacientes.get(indice):null;
	}
	
	public void asignarTurno(int numeroHistoria) {
	
	if(this.getPaciente(numeroHistoria)==null) {
		/*pido datos para crear paciente y luego lo agrego a la lista y luego creo el turno*/
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Hay que crear el legajo del paciente");
		System.out.println("Ingrese el nombre");
		String nombre = sc.nextLine();
		System.out.println("Ingrese el dni");
		int dni = Integer.parseInt(sc.nextLine());
		String dniS=Integer.toString(dni);
		System.out.println("Ingrese la edad");
		int edad=Integer.parseInt(sc.nextLine());
		String edadS=Integer.toString(edad);
		String numHis=dniS+edadS;
		int numeroHistoriaNuevo=Integer.parseInt(numHis);
		Paciente paciente = new Paciente(nombre,dni,edad,numeroHistoriaNuevo);
		Turno turno=new Turno(paciente,this.doctor);
		paciente.setTurno(turno);
		setPaciente(paciente);
		setTurno(turno);
		
		sc.close();
		
	} else {
		/*creo el turno*/
		Turno turno = new Turno(this.getPaciente(numeroHistoria),this.doctor);
		setTurno(turno);
	}
	}
	
	
}
