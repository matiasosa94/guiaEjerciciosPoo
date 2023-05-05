package parcialVuelo;

public class Asiento {
	private final static double PRECIO_TURISTA = 50000;
	private final static double PRECIO_BUSINESS = 100000;
	private final static double PRECIO_PRIMERA = 150000;
	
	private Pasajero pasajero;
	private Tipo tipo;
	private double precio;
	private String fila;
	private int numero;
	
	public Asiento(Pasajero pasajero, Tipo tipo, String fila, int numero) {
		this.pasajero=pasajero;
		setTipo(tipo);
		setPrecio();
		setFila(fila);
		setNumero(numero);
	}
	
	public Pasajero getPasajero() {
		return this.pasajero;
	}
	
	public Tipo getTipo() {
		return this.tipo;
	}
	
	private void setTipo(Tipo tipo) {
		this.tipo=tipo;
	}
	
	private void setPrecio() {
		if(this.tipo==Tipo.TURISTA) {
			this.precio=PRECIO_TURISTA;
		}else if(this.tipo==Tipo.BUSINESS) {
			this.precio=PRECIO_BUSINESS;
		}else if(this.tipo==Tipo.PRIMERA) {
			this.precio=PRECIO_PRIMERA;
		}
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	public String getFila() {
		return this.fila;
	}
	
	private void setFila(String fila) {
		this.fila=fila;
	}
	
	
	public int getNumero() {
		return this.numero;
	}
	
	private void setNumero(int numero) {
		this.numero=numero;
	}
	
	public boolean asientoCorrecto(String fila, int numero) {
		return (this.fila==fila && this.numero==numero);
	}
	
	public boolean pasajeroExiste(int dni) {
		return this.pasajero.mismoDni(dni);
	}

	@Override
	public String toString() {
		return "Asiento [pasajero=" + pasajero + ", tipo=" + tipo + ", precio=" + precio + ", fila=" + fila
				+ ", numero=" + numero + "]";
	}
	
	

}
