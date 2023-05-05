package ej5;
import java.util.Date;
public class Turno {
	private int codigo;
	private Date date= new Date();
	private String fecha;
	private Paciente paciente;
	private String doctor;
	private boolean finalizado;
	
	public Turno(Paciente paciente,String doctor) {
		this.finalizado=false;
		this.fecha=date.toString();
		setPaciente(paciente);
		setDoctor(doctor);
		this.codigo=date.getMonth();
	}
	
	public Paciente getPaciente() {
		return this.paciente;
	}
	
	private void setPaciente(Paciente paciente) {
		this.paciente=paciente;
	}
	
	public String getDoctor() {
		return this.doctor;
	}
	
	private void setDoctor(String doctor) {
		this.doctor=doctor;
	}
	
	public String getFecha() {
		return this.fecha;
	}
	
	public void finalizarTurno() {
		this.finalizado=true;
	}
}
