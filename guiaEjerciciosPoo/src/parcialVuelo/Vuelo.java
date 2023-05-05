package parcialVuelo;

import java.util.ArrayList;
public class Vuelo {
	
	private String numeroVuelo;
	private int cantidadAsientos;
	private ArrayList<Asiento> asientosReservados;
	private double totalRecaudado;
	
	public Vuelo(String numeroVuelo, int cantidadAsientos) {
		setNumeroVuelo(numeroVuelo);
		setAsientos(cantidadAsientos);
		asientosReservados = new ArrayList<>();
		setTotalRecaudado(0);
	}
	
	public String getNumeroVuelo() {
		return this.numeroVuelo;
	}
	
	private void setNumeroVuelo(String numeroVuelo) {
		this.numeroVuelo=numeroVuelo;
	}
	
	public int getCantidadAsientos() {
		return this.cantidadAsientos;
	}
	
	private void setAsientos(int cantidadAsientos) {
		this.cantidadAsientos=cantidadAsientos;
	}
	
	public double getTotalRecaudado() {
		return this.totalRecaudado;
	}
	
	private void setTotalRecaudado(double totalRecaudado) {
		this.totalRecaudado+=totalRecaudado;
	}
	
	private Asiento buscarAsientoReservado(String fila, int numero) {
		Asiento asientoBuscado=null;
		int i =0;
		
		while(i<asientosReservados.size() && !asientosReservados.get(i).asientoCorrecto(fila, numero)) {
			i++;
		}
		
		if(i<asientosReservados.size()) {
			asientoBuscado = asientosReservados.get(i);
		}
		
		return asientoBuscado;
	}
	
	private boolean verDistanciamiento(String fila, int numero) {
		boolean distanciamientoIzqOK = false;
		boolean distanciamientoDerOK = false;
		if(numero == 6 || buscarAsientoReservado(fila, numero + 1)==null) {
			distanciamientoDerOK = true;
		}
		
		if(numero == 1|| buscarAsientoReservado(fila,numero-1)==null) {
			distanciamientoIzqOK = true;
		}
		return distanciamientoIzqOK && distanciamientoDerOK;
	}
	
	public ResultadoReserva reservarAsiento(int dni, int telefono, String fila,int numero, Tipo tipo) {
		ResultadoReserva resultado = ResultadoReserva.ERROR_AVION_COMPLETO;
		
		if(asientosReservados.size()<this.cantidadAsientos) {
			if(buscarPasajero(dni)==null && buscarAsientoReservado(fila, numero) == null) {
				if(verDistanciamiento(fila,numero)) {
					Pasajero pasajero = new Pasajero(dni, telefono);
					Asiento asiento = new Asiento(pasajero,tipo,fila,numero);
					this.setTotalRecaudado(asiento.getPrecio());
					asientosReservados.add(asiento);
					resultado = ResultadoReserva.RESERVA_CONFIRMADA;
				}else {
					resultado = ResultadoReserva.ERROR_ASIENTO_CONTINUO_OCUPADO;
				}
			}else {
				resultado = ResultadoReserva.ERROR_YA_TIENE_UN_PASAJE;
			}
		}
		return resultado;
	}
	
	private Pasajero buscarPasajero (int dni) {
		Pasajero pasajeroBuscado = null;
		int i=0;
		while(i<asientosReservados.size() && !asientosReservados.get(i).pasajeroExiste(dni)) {
			i++;
		}
		
		if(i<asientosReservados.size()) {
			pasajeroBuscado = asientosReservados.get(i).getPasajero();
		}
		return pasajeroBuscado;
	}
	
	private double obtenerMontoRecaudadoPorTipoPasaje(Tipo tipo) {
		double recaudadoTotal=0;
		for(Asiento a:asientosReservados) {
			if(a.getTipo()==tipo) {
				recaudadoTotal+=a.getPrecio();
			}
		}
		return recaudadoTotal;
	}
	
	public void mostrarMontoRecaudadoPorTipoPasaje(Tipo tipo) {
		
		if(asientosReservados.size()>0) {
			double montoClase = obtenerMontoRecaudadoPorTipoPasaje(tipo);
			if(montoClase>0) {
				System.out.println("El monto acumulado hasta el momento en la clase "+tipo+" es: $"+montoClase);
			}else {
				System.out.println("No hay asientos reservados tipo "+tipo);
			}
		}else {
			System.out.println("No hay asientos reservados en el vuelo");
		}
	}
	
	
}
