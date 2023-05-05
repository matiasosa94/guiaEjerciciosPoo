package parcialVuelo;

public class Test {

	public static void main(String[] args) {
		Vuelo vuelo = new Vuelo("AA3313",180);
		
		System.out.println(vuelo.reservarAsiento(11111111, 1234567890, "A", 1, Tipo.PRIMERA));
		System.out.println(vuelo.reservarAsiento(22222222, 1234567891, "F", 6, Tipo.TURISTA));
		System.out.println(vuelo.reservarAsiento(33333333, 1234567892, "A", 2, Tipo.PRIMERA));
		System.out.println(vuelo.reservarAsiento(44444444, 1234567894, "F", 5, Tipo.TURISTA));
		System.out.println(vuelo.reservarAsiento(55555555, 1234567895, "A", 1, Tipo.PRIMERA));
		
		vuelo.mostrarMontoRecaudadoPorTipoPasaje(Tipo.PRIMERA);
		vuelo.mostrarMontoRecaudadoPorTipoPasaje(Tipo.BUSINESS);
		vuelo.mostrarMontoRecaudadoPorTipoPasaje(Tipo.TURISTA);
	}

}
