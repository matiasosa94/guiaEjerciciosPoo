package ej5;
import java.util.ArrayList;
public class Paciente {
	private String nombre;
	private int dni;
	private int edad;
	private int numeroHistoria;
	private ArrayList<Turno> turnos;
	private int consultas;
	
	public Paciente(String nombre,int dni,int edad,int numeroHistoria) {
		setNombre(nombre);
		setDni(dni);
		setEdad(edad);
		setNumeroHistoria(numeroHistoria);
		this.turnos=new ArrayList<Turno>();
		this.consultas=0;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	private void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public int getDni() {
		return this.dni;
	}
	
	private void setDni(int dni) {
		this.dni=dni;
	}
	
	public int getEdad() {
		return this.edad;
	}
	
	private void setEdad(int edad) {
		this.edad=edad;
	}
	
	public int getNumeroHistoria() {
		return this.numeroHistoria;
	}
	
	private void setNumeroHistoria(int numeroHistoria) {
		this.numeroHistoria=numeroHistoria;
		
	}
	
	public Turno getTurno(int indice) {
		return this.turnos.get(indice);
	}
	
	public void setTurno(Turno turno) {
		this.turnos.add(turno);
	}
	
	public boolean mismoNumeroHistoria(int numero) {
		return (this.numeroHistoria==numero)?true:false;
		
	}
	public boolean mismoNombre(String nombre) {
		return (this.nombre.equals(nombre))?true:false;
		
	}
	
	
	
}
