package parcialVuelo;

public class Pasajero {
	
	private int dni;
	private int telefono;
	
	public Pasajero(int dni, int telefono) {
		setDni(dni);
		setTelefono(telefono);
	}
	
	public int getDni() {
		return this.dni;
	}
	
	private void setDni(int dni) {
		this.dni=dni;
	}
	
	public int getTelefono() {
		return this.telefono;
	}
	
	private void setTelefono(int telefono) {
		this.telefono=telefono;
	}
	
	public boolean mismoDni(int dni) {
		return this.dni==dni;
	}

	@Override
	public String toString() {
		return "Pasajero [dni=" + dni + ", telefono=" + telefono + "]";
	}
	
	
}